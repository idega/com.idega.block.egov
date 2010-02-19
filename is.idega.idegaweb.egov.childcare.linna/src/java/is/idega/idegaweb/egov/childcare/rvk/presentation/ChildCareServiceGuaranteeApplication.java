/*
 * $Id$
 * Created on Aug 27, 2008
 * 
 * Copyright (C) 2008 Idega Software hf. All Rights Reserved.
 * 
 * This software is the proprietary information of Idega hf. Use is subject to
 * license terms.
 */
package is.idega.idegaweb.egov.childcare.rvk.presentation;

import is.idega.idegaweb.egov.application.presentation.ApplicationForm;
import is.idega.idegaweb.egov.childcare.rvk.business.BankAccountVerification;
import is.idega.idegaweb.egov.childcare.rvk.business.ChildCareConstants;
import is.idega.idegaweb.egov.childcare.rvk.business.ChildCareRVKService;
import is.idega.idegaweb.egov.childcare.rvk.business.ChildCareSession;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.BankAccount;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.CaretakerOfTheMonth;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.ChildAndDaycareApplicationState;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareApplication;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareProvider;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareType;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.Guardian;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.MonthlyPaymentAssignment;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.PaymentPrediction;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.PaymentPredictionDetail;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.RequestedDaycareProvider;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.ServiceGuaranteeApplication;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.WhoTakesCareOfChildForThisGuardian;

import java.rmi.RemoteException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.ejb.FinderException;

import org.apache.axis.types.UnsignedByte;

import com.idega.block.web2.business.Web2Business;
import com.idega.business.IBOLookup;
import com.idega.business.IBOLookupException;
import com.idega.business.IBORuntimeException;
import com.idega.core.builder.data.ICPage;
import com.idega.core.location.business.AddressBusiness;
import com.idega.event.IWPageEventListener;
import com.idega.idegaweb.IWApplicationContext;
import com.idega.idegaweb.IWException;
import com.idega.idegaweb.IWResourceBundle;
import com.idega.idegaweb.IWUserContext;
import com.idega.presentation.IWContext;
import com.idega.presentation.Layer;
import com.idega.presentation.Span;
import com.idega.presentation.Table2;
import com.idega.presentation.TableCell2;
import com.idega.presentation.TableRow;
import com.idega.presentation.TableRowGroup;
import com.idega.presentation.text.Heading1;
import com.idega.presentation.text.Link;
import com.idega.presentation.text.Paragraph;
import com.idega.presentation.text.Text;
import com.idega.presentation.ui.CheckBox;
import com.idega.presentation.ui.DropdownMenu;
import com.idega.presentation.ui.Form;
import com.idega.presentation.ui.HiddenInput;
import com.idega.presentation.ui.Label;
import com.idega.presentation.ui.RadioButton;
import com.idega.presentation.ui.TextInput;
import com.idega.user.business.UserBusiness;
import com.idega.user.business.UserSession;
import com.idega.user.data.User;
import com.idega.util.CoreConstants;
import com.idega.util.IWCalendar;
import com.idega.util.IWTimestamp;
import com.idega.util.PresentationUtil;
import com.idega.util.text.Name;

public class ChildCareServiceGuaranteeApplication extends ApplicationForm implements IWPageEventListener {

	protected static final int ACTION_PHASE_1 = 1;
	protected static final int ACTION_PHASE_2 = 2;
	protected static final int ACTION_OVERVIEW = 3;
	protected static final int ACTION_SAVE = 4;

	protected static final String PARAMETER_ACTION = "prm_action";
	protected static final String PARAMETER_BACK = "prm_back";
	protected static final String PARAMETER_CHILD = "prm_child";
	protected static final String PARAMETER_MONTH = "prm_month";
	protected static final String PARAMETER_BANK_NUMBER = "prm_bank_number";
	protected static final String PARAMETER_LEDGER = "prm_ledger";
	protected static final String PARAMETER_ACCOUNT_NUMBER = "prm_account_number";
	protected static final String PARAMETER_CUSTODIAN = "prm_custodian";
	protected static final String PARAMETER_CARETAKER_RECEIVER = "prm_caretaker_receiver";
	private static final String PARAMETER_AGREEMENT = "prm_agreement";
	private static final String PARAMETER_PROVIDER = "prm_provider";
	private static final String PARAMETER_TYPE = "prm_type";
	private static final String PARAMETER_NEEDS_CARE_CHOICE = "prm_needs_care_choice";
	private static final String PARAMETER_IGNORE_BANK_ACCOUNT = "prm_ignore_bank_account";
	
	private static final String PROPERTY_APPLICATION = "session_service_application";
	private static final String PROPERTY_PARENTS = "session_parents";

	private IWResourceBundle iwrb;
	private boolean iUseSessionUser = false;
	private String iSurveyURL;

	public boolean actionPerformed(IWContext iwc) throws IWException {
		if (iwc.isParameterSet(PARAMETER_CHILD)) {
			try {
				getChildCareSession(iwc).setChild(iwc.getParameter(PARAMETER_CHILD));
			}
			catch (RemoteException re) {
				throw new IBORuntimeException(re);
			}
		}
		return true;
	}

	@Override
	public String getCaseCode() {
		return ChildCareConstants.GUARANTEE_CASE_CODE_KEY;
	}

	@Override
	public String getBundleIdentifier() {
		return ChildCareConstants.IW_BUNDLE_IDENTIFIER;
	}

	@Override
	protected void present(IWContext iwc) {
		this.iwrb = getResourceBundle(iwc);
		PresentationUtil.addStyleSheetToHeader(iwc, getBundle(iwc).getVirtualPathWithFileNameString("style/childcare.css"));

		try {
			switch (parseAction(iwc)) {
				case ACTION_PHASE_1:
					showPhaseOne(iwc);
					break;

				case ACTION_PHASE_2:
					showPhaseTwo(iwc);
					break;

				case ACTION_OVERVIEW:
					showOverview(iwc);
					break;

				case ACTION_SAVE:
					save(iwc);
					break;
			}
		}
		catch (RemoteException re) {
			throw new IBORuntimeException(re);
		}
	}

	private int parseAction(IWContext iwc) {
		int action = ACTION_PHASE_1;
		if (iwc.isParameterSet(PARAMETER_ACTION)) {
			action = Integer.parseInt(iwc.getParameter(PARAMETER_ACTION));
		}

		return action;
	}

	protected Form createForm(IWContext iwc, int phase) {
		Form form = new Form();
		form.addParameter(PARAMETER_ACTION, phase);
		if (phase != ACTION_PHASE_1) {
			form.maintainParameter(PARAMETER_MONTH);
			form.maintainParameter(PARAMETER_NEEDS_CARE_CHOICE);
			
			String[] months = iwc.getParameterValues(PARAMETER_MONTH);
			if (months != null) {
				for (int i = 0; i < months.length; i++) {
					String month = months[i];
					form.maintainParameter(PARAMETER_MONTH + "_" + month);
				}
			}

			for (int a = 1; a <= 3; a++) {
				form.maintainParameter(PARAMETER_PROVIDER + "_" + a);
			}
		}
		if (phase != ACTION_PHASE_2) {
			form.maintainParameter(PARAMETER_BANK_NUMBER);
			form.maintainParameter(PARAMETER_LEDGER);
			form.maintainParameter(PARAMETER_ACCOUNT_NUMBER);
			form.maintainParameter(PARAMETER_CARETAKER_RECEIVER);
			form.maintainParameter(PARAMETER_CARETAKER_RECEIVER + "_pk");
			form.maintainParameter(PARAMETER_AGREEMENT);
		}
		return form;
	}

	private User getApplicant(IWContext iwc) throws RemoteException {
		return getChildCareSession(iwc).getChild();
	}

	private void showPhaseOne(IWContext iwc) throws RemoteException {
		PresentationUtil.addJavaScriptSourceLineToHeader(iwc, getWeb2Business(iwc).getBundleURIToJQueryLib());
		PresentationUtil.addJavaScriptSourceLineToHeader(iwc, getBundle(iwc).getResourcesVirtualPath() + "/js/guarantee.js");

		Form form = createForm(iwc, ACTION_PHASE_1);
		form.setEventListener(this.getClass());

		addErrors(iwc, form);

		form.add(getPhasesHeader(this.iwrb.getLocalizedString("service_guarantee.applicant", "Applicant"), ACTION_PHASE_1, ACTION_SAVE));

		User applicant = getApplicant(iwc);

		if (applicant != null) {
			boolean isChild = false;
			ChildAndDaycareApplicationState[] states = getChildCareService(iwc).getDaycareService().getChildrenAndDaycareApplicationState(getUser(iwc).getPersonalID());
			for (int i = 0; i < states.length; i++) {
				ChildAndDaycareApplicationState state = states[i];
				if (applicant.getPersonalID().equals(state.getPersonIdentificationNumber())) {
					isChild = true;
				}
			}
			if (!isChild) {
				applicant = null;
				getChildCareSession(iwc).setChild(null);
			}
		}
		
		Layer info = new Layer(Layer.DIV);
		info.setStyleClass("info");
		form.add(info);

		Heading1 heading = new Heading1(this.iwrb.getLocalizedString("select_child", "Select child"));
		info.add(heading);

		DropdownMenu chooser = getUserChooser(iwc, getUser(iwc), applicant, PARAMETER_CHILD, this.iwrb);
		chooser.setToSubmit();

		Layer formItem = new Layer(Layer.DIV);
		formItem.setStyleClass("formItem");
		Label label = new Label(this.iwrb.getLocalizedString("name", "Name"), chooser);
		formItem.add(label);
		formItem.add(chooser);
		info.add(formItem);

		Layer helpLayer = new Layer(Layer.DIV);
		helpLayer.setStyleClass("helperText");
		helpLayer.add(new Text(this.iwrb.getLocalizedString("select_child_helper_text", "Please select the child from the drop down list.")));
		info.add(helpLayer);

		boolean canApply = true;
		if (applicant != null) {
			heading = new Heading1(this.iwrb.getLocalizedString("application.service_guarantee_information", "Service guarantee information"));
			heading.setStyleClass("subHeader");
			heading.setStyleClass("topSubHeader");
			form.add(heading);
			
			IWTimestamp dateOfBirth = new IWTimestamp(applicant.getDateOfBirth());
			dateOfBirth.addYears(2);
			IWTimestamp stamp = new IWTimestamp();
			stamp.setDay(1);
			
			DaycareApplication application = getChildCareSession(iwc).getDaycareApplication(getUser(iwc).getPersonalID(), applicant.getPersonalID());
			
			if (canApply) {
				Layer section = new Layer(Layer.DIV);
				section.setStyleClass("formSection");
				form.add(section);

				Guardian[] parents = application.getGuardians();
				
				section.setStyleClass("tableSection");

				String text = null;
				if (parents.length > 1) {
					text = this.iwrb.getLocalizedString("application.service_guarantee_help", "Select who will get the payment for up to the next 12 months.");
				}
				else {
					text = this.iwrb.getLocalizedString("application.service_guarantee_single_help", "Select who will get the payment for up to the next 12 months.");
				}
				
				section.add(getAttentionLayer(text));
	
				Map rowMap = new HashMap();
				
				Table2 table = new Table2();
				table.setStyleClass("serviceGuaranteeTable");
				table.setCellpadding(0);
				table.setCellspacing(0);
				section.add(table);
				
				TableRowGroup group = table.createHeaderRowGroup();
				TableRow headerRow = group.createRow();
				
				TableCell2 cell = headerRow.createHeaderCell();
				cell.setStyleClass("paymentReceiver");
				cell.add(new Text(iwrb.getLocalizedString("payment_receiver", "Payment receiver")));
				
				group = table.createBodyRowGroup();

				List parentList = new ArrayList();
				for (int i = 0; i < parents.length; i++) {
					Guardian guardian = parents[i];
					User parent = null;
					try {
						parent = getUserBusiness(iwc).getUser(guardian.getPersonIdentificationNumber());
					}
					catch (FinderException fe) {
						log(fe);
					}
					parentList.add(parent);
					
					TableRow row = group.createRow();
					cell = row.createCell();
					cell.setStyleClass("paymentReceiver");
					cell.add(new Text(new Name(parent.getFirstName(), parent.getMiddleName(), parent.getLastName()).getName(iwc.getCurrentLocale())));
					
					rowMap.put(parent.getPrimaryKey().toString(), row);
				}
				iwc.setSessionAttribute(PROPERTY_PARENTS, parentList);

				ServiceGuaranteeApplication serviceGuarantee = getChildCareService(iwc).getDaycareService().getServiceGuaranteeApplication(getUser(iwc).getPersonalID(), applicant.getPersonalID());
				if (serviceGuarantee != null && serviceGuarantee.getDateOfFirstPotentialPayment() != null) {
					IWTimestamp firstPayment = new IWTimestamp(serviceGuarantee.getDateOfFirstPotentialPayment().getTime());
					if (firstPayment.isLaterThan(stamp)) {
						stamp = new IWTimestamp(firstPayment);
					}
				}
				
				IWCalendar cal = new IWCalendar();
				for (int i = 0; i < 13; i++) {
					boolean isSummerHoliday = stamp.getMonth() - 1 == Calendar.JULY;
					
					cell = headerRow.createHeaderCell();
					cell.setStyleClass("month");
					if (isSummerHoliday) {
						cell.setStyleClass("summerHoliday");
					}
					cell.add(new Text(cal.getMonthName(stamp.getMonth(), iwc.getCurrentLocale(), IWCalendar.SHORT) + " " + stamp.getYear()));
					
					String old = "";
					if (serviceGuarantee != null) {
						MonthlyPaymentAssignment[] paymentPlans = serviceGuarantee.getPaymentPlan();
						if (paymentPlans != null) {
							for (int j = 0; j < paymentPlans.length; j++) {
								MonthlyPaymentAssignment monthlyPaymentAssignment = paymentPlans[j];
								if (monthlyPaymentAssignment.getMonth().getValue().equals(cal.getMonthName(stamp.getMonth(), Locale.ENGLISH, IWCalendar.FULL)) && monthlyPaymentAssignment.getYear().intValue() == stamp.getYear()) {
									old = monthlyPaymentAssignment.getPersonIdentificationNumberOfRecipient();
								}
							}
						}
						iwc.setSessionAttribute(PROPERTY_APPLICATION, serviceGuarantee);
					}
					
					int count = 1;
					for (int j = 0; j < parents.length; j++) {
						Guardian guardian = parents[j];
						User parent = null;
						try {
							parent = getUserBusiness(iwc).getUser(guardian.getPersonIdentificationNumber());
						}
						catch (FinderException fe) {
							log(fe);
						}
						
						RadioButton button = new RadioButton(PARAMETER_MONTH + "_" + stamp.getDateString("yyyy-MM") + "-01");
						if (old != null && !iwc.isParameterSet(PARAMETER_MONTH + "_" + stamp.getDateString("yyyy-MM") + "-01") && !iwc.isParameterSetAsEmpty(PARAMETER_MONTH + "_" + stamp.getDateString("yyyy-MM") + "-01")) {
							if (old.equals(guardian.getPersonIdentificationNumber())) {
								button.setSelected(true);
							}
						}
						button.setStyleClass("matrixButton");
						button.setValue(guardian.getPersonIdentificationNumber());
						button.setDisabled(isSummerHoliday);
						button.keepStatusOnAction(true);
						
						TableRow row = (TableRow) rowMap.get(parent.getPrimaryKey().toString());
						cell = row.createCell();
						cell.setStyleClass("month");
						if (isSummerHoliday) {
							cell.setStyleClass("summerHoliday");
						}
						cell.add(button);
							
						count++;
					}
					
					form.add(new HiddenInput(PARAMETER_MONTH, stamp.getDateString("yyyy-MM") + "-01"));
						
					stamp.addMonths(1);
				}

				Layer clearLayer = new Layer(Layer.DIV);
				clearLayer.setStyleClass("Clear");
				section.add(clearLayer);
			}
			else {
				form.add(this.getStopLayer(iwrb.getLocalizedString("service_guarantee_error.cant_apply_for_child_subject", "Can't apply for service guarantee for child"), iwrb.getLocalizedString("service_guarantee_error.cant_apply_for_child_body", "It is not possible to apply for service guarantee for the selected child.  Only children with three or more applications and younger than two years old are applicable.")));
			}
			
			List publicProviders = new ArrayList();
			List privateProviders = new ArrayList();
			
			boolean showPrivate = false;
			RequestedDaycareProvider[] providers = application != null ? application.getRequestedDaycareProviders() : null;
			if (providers != null && providers.length > 0) {
				for (int i = 0; i < providers.length; i++) {
					RequestedDaycareProvider requestedDaycareProvider = providers[i];
					DaycareProvider daycareProvider = getChildCareSession(iwc).getProvider(requestedDaycareProvider.getDaycareProviderID());
					if (daycareProvider.getType().equals(DaycareType.PublicDaycare)) {
						publicProviders.add(requestedDaycareProvider);
					}
					else {
						privateProviders.add(requestedDaycareProvider);
						showPrivate = true;
					}
				}
			}
			else {
				showPrivate = true;
			}
			
			if (!publicProviders.isEmpty()) {
				heading = new Heading1(this.iwrb.getLocalizedString("application.chosen_provider_information", "Provider choice information"));
				heading.setStyleClass("subHeader");
				form.add(heading);
	
				Layer section = new Layer(Layer.DIV);
				section.setStyleClass("formSection");
				form.add(section);
	
				formItem = new Layer(Layer.DIV);
				label = new Label();
				Layer span = new Layer();
	
				int count = 1;
				Iterator iterator = publicProviders.iterator();
				while (iterator.hasNext()) {
					RequestedDaycareProvider school = (RequestedDaycareProvider) iterator.next();
					
					formItem = new Layer(Layer.DIV);
					formItem.setStyleClass("formItem");
					formItem.setStyleClass("providerOverviewItem");
					label = new Label();
					label.add(new Text(this.iwrb.getLocalizedString("application.school_" + count, "School choice nr. " + count++)));
					span = new Layer(Layer.SPAN);
					span.add(new Text(school.getName()));
					formItem.add(label);
					formItem.add(span);
					section.add(formItem);
				}
				
				Layer clearLayer = new Layer(Layer.DIV);
				clearLayer.setStyleClass("Clear");
				section.add(clearLayer);
			}
			
			if (showPrivate && publicProviders.isEmpty()) {
				form.addParameter(PARAMETER_NEEDS_CARE_CHOICE, Boolean.TRUE.toString());
				
				PresentationUtil.addJavaScriptSourceLineToHeader(iwc, CoreConstants.DWR_ENGINE_SCRIPT);
				PresentationUtil.addJavaScriptSourceLineToHeader(iwc, CoreConstants.DWR_UTIL_SCRIPT);
				PresentationUtil.addJavaScriptSourceLineToHeader(iwc, "/dwr/interface/ChildCareSession.js");
				PresentationUtil.addJavaScriptSourceLineToHeader(iwc, getBundle(iwc).getResourcesVirtualPath() + "/js/childcare.js");

				heading = new Heading1(this.iwrb.getLocalizedString("application.provider_information", "Child care provider information"));
				heading.setStyleClass("subHeader");
				form.add(heading);
		
				Layer section = new Layer(Layer.DIV);
				section.setStyleClass("formSection");
				form.add(section);
		
				helpLayer = new Layer(Layer.DIV);
				helpLayer.setStyleClass("helperText");
				helpLayer.add(new Text(this.iwrb.getLocalizedString("application.school_waiting_list_help", "Select the school/s you are currently waitlisted for.")));
				section.add(helpLayer);
		
				for (int a = 1; a <= 3; a++) {
					RequestedDaycareProvider providerChoice = privateProviders.size() >= a ? (RequestedDaycareProvider) privateProviders.get(a - 1) : null;
					Collection schools = null;
					
					DropdownMenu typeDropdown = new DropdownMenu(PARAMETER_TYPE + "_" + a);
					typeDropdown.setID(PARAMETER_TYPE + "_" + a);
					typeDropdown.setStyleClass("typeDropdown");
					typeDropdown.addMenuElementFirst("", this.iwrb.getLocalizedString("application.select_type", "Select type"));
					typeDropdown.addMenuElement(DaycareType._PrivateDaycare, this.iwrb.getLocalizedString("application.private_daycare", "Private daycare"));
					typeDropdown.addMenuElement(DaycareType._Nanny, this.iwrb.getLocalizedString("application.nanny", "Nanny"));
					
					Integer providerID = null;
					if (iwc.isParameterSet(PARAMETER_PROVIDER + "_" + a)) {
						providerID = new Integer(iwc.getParameter(PARAMETER_PROVIDER + "_" + a));
					}
					else if (providerChoice != null) {
						providerID = providerChoice.getDaycareProviderID();
					}
					
					if (providerID != null) {
						DaycareProvider provider = getChildCareSession(iwc).getProvider(providerID);
						typeDropdown.setSelectedElement(provider.getType().getValue());
	
						if (provider.getType().equals(DaycareType.PrivateDaycare)) {
							schools = getChildCareSession(iwc).getAllPrivateProviders();
						}
						else if (provider.getType().equals(DaycareType.Nanny)) {
							schools = getChildCareSession(iwc).getAllNannyProviders();
						}
					}
		
					DropdownMenu schoolDropdown = new DropdownMenu(PARAMETER_PROVIDER + "_" + a);
					schoolDropdown.setID(PARAMETER_PROVIDER + "_" + a);
					if (schools != null) {
						Iterator iterator2 = schools.iterator();
						while (iterator2.hasNext()) {
							DaycareProvider daycareProvider = (DaycareProvider) iterator2.next();
							schoolDropdown.addMenuElement(daycareProvider.getDaycareProviderID().toString(), daycareProvider.getName());
						}
					}
					schoolDropdown.setStyleClass("secondInput");
					if (providerID != null) {
						DaycareProvider provider = getChildCareSession(iwc).getProvider(providerID);
						schoolDropdown.setSelectedElement(provider.getDaycareProviderID().toString());
					}
		
					formItem = new Layer(Layer.DIV);
					formItem.setStyleClass("formItem");
					if (a == 1) {
						formItem.setStyleClass("required");
					}
					if (hasError(PARAMETER_PROVIDER + "_" + a)) {
						formItem.setStyleClass("hasError");
					}
					label = new Label(new Span(new Text(this.iwrb.getLocalizedString("application.provider_" + a, "Provider " + a))), typeDropdown);
					formItem.add(label);
					formItem.add(typeDropdown);
					formItem.add(schoolDropdown);
					section.add(formItem);
				}
			}
			
			Layer bottom = new Layer(Layer.DIV);
			bottom.setStyleClass("bottom");
			form.add(bottom);
			
			Link next = getButtonLink(this.iwrb.getLocalizedString("next", "Next"));
			if (getApplicant(iwc) != null && canApply) {
				next.setValueOnClick(PARAMETER_ACTION, String.valueOf(ACTION_PHASE_2));
				next.setToFormSubmit(form);
			}
			else {
				next.addParameter(PARAMETER_NO_USER, Boolean.TRUE.toString());
			}
			bottom.add(next);

			Link clear = getButtonLink(this.iwrb.getLocalizedString("clear", "Clear"));
			clear.setURL("javascript:clearMatrix();");
			bottom.add(clear);
		}
		
		add(form);
	}
	
	private void showPhaseTwo(IWContext iwc) throws RemoteException {
		User applicant = getApplicant(iwc);
		List parents = (List) iwc.getSessionAttribute(PROPERTY_PARENTS);

		String[] months = iwc.getParameterValues(PARAMETER_MONTH);
		Map monthMap = getMonthMap(iwc, months);
		if (monthMap.isEmpty()) {
			setError(ACTION_PHASE_1, PARAMETER_MONTH, iwrb.getLocalizedString("error.no_month_selected", "No month value was selected.  You have to select at least one month to be able to continue."));
		}
		else if (parents.size() > 1) {
			Iterator iterator = monthMap.keySet().iterator();
			while (iterator.hasNext()) {
				String receiver = (String) iterator.next();
				Collection values = (Collection) monthMap.get(receiver);
				if (values.size() > 8 && !receiver.equals(CaretakerOfTheMonth._Caretaker)) {
					setError(ACTION_PHASE_1, PARAMETER_MONTH, iwrb.getLocalizedString("error.month_size_exceeded", "You can only select 2/3 of the next 12 months for the same custodian."));
				}
			}
		}
		
		if (iwc.isParameterSet(PARAMETER_NEEDS_CARE_CHOICE)) {
			boolean hasSchoolChoice = false;
	
			for (int i = 0; i < 3; i++) {
				if (iwc.isParameterSet(PARAMETER_PROVIDER + "_" + (i + 1))) {
					hasSchoolChoice = true;
					break;
				}
			}
			if (!hasSchoolChoice) {
				setError(ACTION_PHASE_1, PARAMETER_PROVIDER + "_1", this.iwrb.getLocalizedString("application_error.guarantee_providers_empty", "Please select at least one provider"));
			}
	
			if (hasSchoolChoice) {
				Collection schools = new ArrayList();
	
				for (int i = 0; i < 3; i++) {
					if (iwc.isParameterSet(PARAMETER_PROVIDER + "_" + (i + 1))) {
						if (!schools.contains(iwc.getParameter(PARAMETER_PROVIDER + "_" + (i + 1)))) {
							schools.add(iwc.getParameter(PARAMETER_PROVIDER + "_" + (i + 1)));
						}
						else {
							setError(ACTION_PHASE_1, PARAMETER_PROVIDER + "_1", this.iwrb.getLocalizedString("application_error.same_provider_selected", "Please do not select the same provider more than once"));
							break;
						}
					}
				}
			}
		}
		
		if (hasErrors(ACTION_PHASE_1)) {
			showPhaseOne(iwc);
			return;
		}
		
		Form form = createForm(iwc, ACTION_PHASE_2);
		form.setEventListener(this.getClass());

		addErrors(iwc, form);

		form.add(getPhasesHeader(this.iwrb.getLocalizedString("application.account_information", "Account information"), ACTION_PHASE_2, ACTION_SAVE));

		form.add(getPersonInfo(iwc, applicant));

		Heading1 heading = new Heading1(this.iwrb.getLocalizedString("application.account_information", "Account information"));
		heading.setStyleClass("subHeader");
		heading.setStyleClass("topSubHeader");
		form.add(heading);
		
		Layer section = new Layer(Layer.DIV);
		section.setStyleClass("formSection");
		form.add(section);

		Layer helpLayer = new Layer(Layer.DIV);
		helpLayer.setStyleClass("helperText");
		if (parents.size() > 1) {
			helpLayer.add(new Text(this.iwrb.getLocalizedString("application.account_help", "Enter account information for the receivers of the service guarantee.")));
		}
		else {
			helpLayer.add(new Text(this.iwrb.getLocalizedString("application.account_single_help", "Enter account information for the receivers of the service guarantee.")));
		}
		section.add(helpLayer);
		
		ServiceGuaranteeApplication application = (ServiceGuaranteeApplication) iwc.getSessionAttribute(PROPERTY_APPLICATION);
		String personalID1 = application != null ? application.getPersonIdentificationNumberOfGuardian1() : null;
		String personalID2 = application != null ? application.getPersonIdentificationNumberOfGuardian2() : null;
		
		String loggedInUserPersonalID = getUser(iwc).getPersonalID();
		if (!monthMap.keySet().contains(loggedInUserPersonalID)) {
			form.add(new HiddenInput(PARAMETER_IGNORE_BANK_ACCOUNT, Boolean.TRUE.toString()));
		}
		
		Collection custodians = new ArrayList();
		Iterator iterator = monthMap.keySet().iterator();
		while (iterator.hasNext()) {
			String personalID = (String) iterator.next();
			
			boolean isLoggedInUser = false;
			User custodian = null;
			try {
				custodian = getUserBusiness(iwc).getUser(personalID);
			}
			catch (FinderException e) {
				e.printStackTrace();
			}
			custodians.add(custodian);

			if (custodian.equals(getUser(iwc))) {
				isLoggedInUser = true;
			}
			
			BankAccount bankAccount1 = application.getBankAccountOfGuardian1();
			BankAccount bankAccount2 = application.getBankAccountOfGuardian2();
			boolean guardian1 = false;
			boolean guardian2 = false;
			
			TextInput bankNumber = new TextInput(PARAMETER_BANK_NUMBER);
			bankNumber.setMaxlength(4);
			bankNumber.keepStatusOnAction(true);

			TextInput ledger = new TextInput(PARAMETER_LEDGER);
			ledger.setMaxlength(2);
			ledger.keepStatusOnAction(true);

			TextInput accountNumber = new TextInput(PARAMETER_ACCOUNT_NUMBER);
			accountNumber.setMaxlength(6);
			accountNumber.keepStatusOnAction(true);

			if (personalID1 != null && personalID1.equals(personalID) && bankAccount1 != null && bankAccount1.getBankID() != null && bankAccount1.getLedger() != null && bankAccount1.getAccountNumber() != null) {
				bankNumber.setValue(bankAccount1.getBankID().intValue());
				ledger.setValue(bankAccount1.getLedger().intValue());
				accountNumber.setValue(bankAccount1.getAccountNumber().intValue());
				guardian1 = true;
			}
			if (personalID2 != null && personalID2.equals(personalID) && bankAccount2 != null && bankAccount2.getBankID() != null && bankAccount2.getLedger() != null && bankAccount2.getAccountNumber() != null) {
				bankNumber.setValue(bankAccount2.getBankID().intValue());
				ledger.setValue(bankAccount2.getLedger().intValue());
				accountNumber.setValue(bankAccount2.getAccountNumber().intValue());
				guardian2 = true;
			}

			Layer formItem = new Layer();
			formItem.setStyleClass("formItem");
			Label label = new Label();
			label.setLabel(new Name(custodian.getFirstName(), custodian.getMiddleName(), custodian.getLastName()).getName(iwc.getCurrentLocale()));
			if (isLoggedInUser) {
				label.setFor(accountNumber.getID());
			}
			formItem.add(label);
			if (isLoggedInUser) {
				Span bankSpan = new Span();
				bankSpan.setStyleClass("bankInfo");
				bankSpan.setStyleClass("bankNumber");
				bankSpan.add(bankNumber);
				bankSpan.add(new Span(new Text(iwrb.getLocalizedString("bank_info.bank_number", "Bank number"))));
				formItem.add(bankSpan);

				Span ledgerSpan = new Span();
				ledgerSpan.setStyleClass("bankInfo");
				ledgerSpan.setStyleClass("ledger");
				ledgerSpan.add(ledger);
				ledgerSpan.add(new Span(new Text(iwrb.getLocalizedString("bank_info.ledger", "Ledger"))));
				formItem.add(ledgerSpan);

				Span accountSpan = new Span();
				accountSpan.setStyleClass("bankInfo");
				accountSpan.setStyleClass("accountNumber");
				accountSpan.add(accountNumber);
				accountSpan.add(new Span(new Text(iwrb.getLocalizedString("bank_info.account_number", "Account number"))));
				formItem.add(accountSpan);
			}
			else {
				BankAccount account = null;
				Span span = new Span();
				if (guardian1) {
					account = bankAccount1;
				}
				else if (guardian2) {
					account = bankAccount2;
				}
				
				if (account != null && account.getBankID() != null && account.getLedger() != null && account.getAccountNumber() != null) {
					span.add(new Text(getBankAccount(account)));
				}
				else {
					span.add(new Text(iwrb.getLocalizedString("bank_account.info_missing", "No account info")));
				}
				
				formItem.add(span);
			}
			formItem.add(new HiddenInput(PARAMETER_CUSTODIAN, custodian.getPrimaryKey().toString()));
			section.add(formItem);
		}
		
		Layer clearLayer = new Layer(Layer.DIV);
		clearLayer.setStyleClass("Clear");
		section.add(clearLayer);

		int count = 1;
		Iterator iterator2 = custodians.iterator();
		while (iterator2.hasNext()) {
			User custodian = (User) iterator2.next();
			
			heading = new Heading1(new Name(custodian.getFirstName(), custodian.getMiddleName(), custodian.getLastName()).getName(iwc.getCurrentLocale()));
			heading.setStyleClass("subHeader");
			form.add(heading);
			
			section = new Layer(Layer.DIV);
			section.setStyleClass("formSection");
			form.add(section);

			helpLayer = new Layer(Layer.DIV);
			helpLayer.setStyleClass("helperText");
			helpLayer.add(new Text(this.iwrb.getLocalizedString("application.caretaker_receiver_help", "Select which custodian is the receiver of the payment for the caretaker.")));
			section.add(helpLayer);
			
			DropdownMenu receiver = new DropdownMenu(PARAMETER_CARETAKER_RECEIVER);
			receiver.addMenuElement(WhoTakesCareOfChildForThisGuardian._Guardian, new Name(custodian.getFirstName(), custodian.getMiddleName(), custodian.getLastName()).getName(iwc.getCurrentLocale()));
			receiver.addMenuElement(WhoTakesCareOfChildForThisGuardian._ThirdParty, this.iwrb.getLocalizedString("caretaker", "Care taker"));
			receiver.addMenuElement(WhoTakesCareOfChildForThisGuardian._Both, this.iwrb.getLocalizedString("half_and_half", "Care taker and custodian"));
			if (count == 1 && application != null) {
				receiver.setSelectedElement(application.getWhoTakesCareOfChildForGuardian1().getValue());
			}
			if (count == 2 && application != null) {
				receiver.setSelectedElement(application.getWhoTakesCareOfChildForGuardian2().getValue());
			}
			
			Layer formItem = new Layer();
			formItem.setStyleClass("formItem");
			Label label = new Label(this.iwrb.getLocalizedString("application.caretaker", "Caretaker"), receiver);
			formItem.add(label);
			formItem.add(receiver);
			section.add(formItem);
			section.add(new HiddenInput(PARAMETER_CARETAKER_RECEIVER + "_pk", custodian.getPrimaryKey().toString()));

			clearLayer = new Layer(Layer.DIV);
			clearLayer.setStyleClass("Clear");
			section.add(clearLayer);
			count++;
		}

		heading = new Heading1(this.iwrb.getLocalizedString("application.agreement_info", "Agreement information"));
		heading.setStyleClass("subHeader");
		form.add(heading);

		section = new Layer(Layer.DIV);
		section.setStyleClass("formSection");
		form.add(section);

		CheckBox agree = new CheckBox(PARAMETER_AGREEMENT, Boolean.TRUE.toString());
		agree.setStyleClass("checkbox");
		agree.keepStatusOnAction(true);

		Paragraph paragraph = new Paragraph();
		paragraph.setStyleClass("agreement");
		paragraph.add(new Text(this.iwrb.getLocalizedString("application.agreement", "Agreement text")));
		section.add(paragraph);

		Layer formItem = new Layer(Layer.DIV);
		formItem.setStyleClass("formItem");
		formItem.setStyleClass("radioButtonItem");
		formItem.setStyleClass("required");
		if (hasError(PARAMETER_AGREEMENT)) {
			formItem.setStyleClass("hasError");
		}
		Label label = new Label(new Span(new Text(this.iwrb.getLocalizedString("application.agree_terms", "Yes, I agree"))), agree);
		formItem.add(agree);
		formItem.add(label);
		section.add(formItem);

		clearLayer = new Layer(Layer.DIV);
		clearLayer.setStyleClass("Clear");
		section.add(clearLayer);

		Layer bottom = new Layer(Layer.DIV);
		bottom.setStyleClass("bottom");
		form.add(bottom);

		Link next = getButtonLink(this.iwrb.getLocalizedString("next", "Next"));
		next.setValueOnClick(PARAMETER_ACTION, String.valueOf(ACTION_OVERVIEW));
		next.setToFormSubmit(form);
		bottom.add(next);

		Link back = getButtonLink(this.iwrb.getLocalizedString("previous", "Previous"));
		back.setValueOnClick(PARAMETER_ACTION, String.valueOf(ACTION_PHASE_1));
		back.setToFormSubmit(form);
		bottom.add(back);

		add(form);
	}

	private void save(IWContext iwc) throws RemoteException {
		Form form = createForm(iwc, ACTION_SAVE);
		form.add(getPhasesHeader(this.iwrb.getLocalizedString("service_guarantee.receipt", "Application receipt"), ACTION_SAVE, ACTION_SAVE));

		iwc.removeSessionAttribute(PROPERTY_PARENTS);
		iwc.removeSessionAttribute(PROPERTY_APPLICATION);
		
		form.add(getReceiptLayer(iwc, this.iwrb.getLocalizedString("service_guarantee.receipt_subject", "Application sent"), this.iwrb.getLocalizedString("service_guarantee.receipt_body", "Application sent body")));
		
		Layer clearLayer = new Layer(Layer.DIV);
		clearLayer.setStyleClass("Clear");
		form.add(clearLayer);

		Layer bottom = new Layer(Layer.DIV);
		bottom.setStyleClass("bottom");
		form.add(bottom);

		try {
			ICPage page = getUserBusiness(iwc).getHomePageForUser(iwc.getCurrentUser());
			Link link = getButtonLink(this.iwrb.getLocalizedString("my_page", "My page"));
			link.setStyleClass("homeButton");
			link.setPage(page);
			bottom.add(link);
		}
		catch (FinderException fe) {
			fe.printStackTrace();
		}
		
		if (getSurveyURL() != null) {
			Link link = getButtonLink(iwrb.getLocalizedString("survey", "Survey"));
			link.setURL(getSurveyURL());
			link.setTarget(Link.TARGET_BLANK_WINDOW);
			bottom.add(link);
		}
		
		add(form);
	}

	private void showOverview(IWContext iwc) throws RemoteException {
		String[] months = iwc.getParameterValues(PARAMETER_MONTH);
		Map monthMap = getMonthMap(iwc, months);

		BankAccount bankAccount = null;
		if (iwc.isParameterSet(PARAMETER_IGNORE_BANK_ACCOUNT)) {
			bankAccount = null;
		}
		else if (!iwc.isParameterSet(PARAMETER_ACCOUNT_NUMBER) || !iwc.isParameterSet(PARAMETER_BANK_NUMBER) || !iwc.isParameterSet(PARAMETER_LEDGER)) {
			setError(PARAMETER_ACCOUNT_NUMBER, iwrb.getLocalizedString("error.must_enter_account_number", "You have to enter an account number"));
		}
		else {
			String bankNumber = iwc.getParameter(PARAMETER_BANK_NUMBER);
			String ledgerNumber = iwc.getParameter(PARAMETER_LEDGER);
			String accountNumber = iwc.getParameter(PARAMETER_ACCOUNT_NUMBER);
			
			int bank = -1;
			int ledger = -1;
			int account = -1;
			try {
				bank = Integer.parseInt(bankNumber);
				ledger = Integer.parseInt(ledgerNumber);
				account = Integer.parseInt(accountNumber);
			}
			catch (NumberFormatException nfe) {
				log(nfe);
			}
			
			bankAccount = new BankAccount(new Integer(account), new Short((short) bank), new UnsignedByte(ledger));
			if (!BankAccountVerification.getInstance().isValid(bankAccount)) {
				setError(PARAMETER_ACCOUNT_NUMBER, this.iwrb.getLocalizedString("error.invalid_bank_account_number", "You have entered an invalid bank account number."));
			}
		}
		if (!iwc.isParameterSet(PARAMETER_CARETAKER_RECEIVER) && monthMap.containsKey(CaretakerOfTheMonth._Caretaker)) {
			setError(PARAMETER_CARETAKER_RECEIVER, iwrb.getLocalizedString("error.must_select_caretaker_reciever", "You have to select the caretaker receiver."));
		}
		if (!iwc.isParameterSet(PARAMETER_AGREEMENT)) {
			setError(PARAMETER_AGREEMENT, this.iwrb.getLocalizedString("must_agree_terms", "You have to agree to the terms."));
		}
		
		if (hasErrors()) {
			showPhaseTwo(iwc);
			return;
		}
		
		User applicant = getApplicant(iwc);
		List parents = (List) iwc.getSessionAttribute(PROPERTY_PARENTS);
		
		String[] caretakers = iwc.getParameterValues(PARAMETER_CARETAKER_RECEIVER);
		String[] caretakerPK = iwc.getParameterValues(PARAMETER_CARETAKER_RECEIVER + "_pk");
		Map caretakerMap = new HashMap();
		for (int i = 0; i < caretakerPK.length; i++) {
			Integer pk = new Integer(caretakerPK[i].toString());
			String caretaker = caretakers[i];
			
			caretakerMap.put(pk, caretaker);
		}
		
		try {
			if (iwc.isParameterSet(PARAMETER_NEEDS_CARE_CHOICE)) {
				Collection providerCollection = new ArrayList();
				for (int i = 0; i < 3; i++) {
					if (iwc.isParameterSet(PARAMETER_PROVIDER + "_" + (i + 1))) {
						Integer providerID = new Integer(iwc.getParameter(PARAMETER_PROVIDER + "_" + (i + 1)));
						if (providerID.intValue() != -1) {
							providerCollection.add(getChildCareSession(iwc).getProvider(providerID));
						}
					}
				}
				DaycareProvider[] providers = (DaycareProvider[]) providerCollection.toArray(new DaycareProvider[providerCollection.size()]);
				User parent = getUser(iwc);
				User child = getApplicant(iwc);
	
				getChildCareService(iwc).storeChildCareApplication(getChildCareSession(iwc).getDaycareApplication(getUser(iwc).getPersonalID(), child.getPersonalID()), child, providers, null, null, false, getChildCareSession(iwc).getAllProviders(), parent, false);
			}
			
			getChildCareService(iwc).storeServiceGuarantee((ServiceGuaranteeApplication) iwc.getSessionAttribute(PROPERTY_APPLICATION), applicant, parents, bankAccount, monthMap, caretakerMap, getUser(iwc));
			ServiceGuaranteeApplication serviceGuarantee = getChildCareService(iwc).getDaycareService().getServiceGuaranteeApplication(getUser(iwc).getPersonalID(), applicant.getPersonalID());
			iwc.setSessionAttribute(PROPERTY_APPLICATION, serviceGuarantee);
		}
		catch (DaycareFaultContract dfc) {
			dfc.printStackTrace();
			setError(ACTION_PHASE_2, PARAMETER_AGREEMENT, dfc.getErrorMessage());
		}

		if (hasErrors()) {
			showPhaseTwo(iwc);
			return;
		}
		
		Form form = createForm(iwc, ACTION_OVERVIEW);
		form.setEventListener(this.getClass());

		form.add(getPhasesHeader(this.iwrb.getLocalizedString("application.payment_overview", "Payment overview"), ACTION_OVERVIEW, ACTION_SAVE));

		form.add(getPersonInfo(iwc, applicant));

		NumberFormat format = NumberFormat.getCurrencyInstance(iwc.getCurrentLocale());
		format.setMaximumFractionDigits(0);

		PaymentPrediction[] predictions = getChildCareService(iwc).getDaycareService().getPaymentPrediction(getUser(iwc).getPersonalID(), applicant.getPersonalID());
		if (predictions != null) {
			for (int i = 0; i < predictions.length; i++) {
				PaymentPrediction prediction = predictions[i];
				IWTimestamp stamp = new IWTimestamp(prediction.getDueDate().getTime());
				IWCalendar calendar = new IWCalendar();
				
				if (prediction.getRecipientName() != null) {
					PaymentPredictionDetail[] details = prediction.getPaymentPredictionDetails();
	
					Heading1 heading = new Heading1(calendar.getMonthName(stamp.getMonth(), iwc.getCurrentLocale(), IWCalendar.FULL) + " " + stamp.getYear());
					heading.setStyleClass("subHeader");
					if (i == 0) {
						heading.setStyleClass("topSubHeader");
					}
					form.add(heading);
					
					Layer section = new Layer(Layer.DIV);
					section.setStyleClass("formSection");
					section.setStyleClass("noHelpSection");
					form.add(section);
					
					Layer formItem = new Layer();
					formItem.setStyleClass("formItem");
					Label label = new Label();
					label.setLabel(iwrb.getLocalizedString("payment_receiver", "Payment receiver"));
					Span span = new Span(new Text(prediction.getRecipientName() + (prediction.getRecipientBankAccount() != null ? (" (" + iwrb.getLocalizedString("account_number", "account number") + ": " + getChildCareService(iwc).formatBankAccount(prediction.getRecipientBankAccount()) + ")") : "")));
					formItem.add(label);
					formItem.add(span);
					section.add(formItem);
					
					for (int j = 0; j < details.length; j++) {
						PaymentPredictionDetail detail = details[j];
						IWTimestamp from = new IWTimestamp(detail.getPayFrom().getTime());
						IWTimestamp to = new IWTimestamp(detail.getPayTo().getTime());
	
						formItem = new Layer();
						formItem.setStyleClass("formItem");
						label = new Label();
						label.setLabel(from.getDateString("d. MMM", iwc.getCurrentLocale()) + " - " + to.getDateString("d. MMM", iwc.getCurrentLocale()));
						span = new Span(new Text(detail.getExplanation()));
						if (detail.getAmount().intValue() > 0 && detail.getDays().intValue() != detail.getDaysInMonth().intValue()) {
							String days = detail.getDays().toString();
							if (days.substring(days.length() - 1).equals("1")) {
								days = iwrb.getLocalizedString("day", "day");
							}
							else {
								days = iwrb.getLocalizedString("days", "days");
							}
							String month = detail.getDaysInMonth().toString();
							if (month.substring(month.length() - 1).equals("1")) {
								month = iwrb.getLocalizedString("day_in_month", "day in month");
							}
							else {
								month = iwrb.getLocalizedString("days_in_month", "days in month");
							}
							
							span.add(new Text(", " + format.format(detail.getAmount()) + " * (" + detail.getDays().toString() + " " + days + ")/(" + detail.getDaysInMonth().toString() + " " + month + ") = " + format.format(prediction.getAmountDue().floatValue())));
						}
						else if (detail.getAmount().intValue() > 0) {
							span.add(new Text(", " + format.format(prediction.getAmountDue().floatValue())));
						}
						formItem.add(label);
						formItem.add(span);
						section.add(formItem);
					}
	
					formItem = new Layer();
					formItem.setStyleClass("formItem");
					formItem.setStyleClass("totalItem");
					label = new Label();
					label.setLabel(iwrb.getLocalizedString("total_amount", "Total amount"));
					span = new Span(new Text(format.format(prediction.getAmountDue().floatValue())));
					formItem.add(label);
					formItem.add(span);
					section.add(formItem);
					
					Layer clearLayer = new Layer(Layer.DIV);
					clearLayer.setStyleClass("Clear");
					section.add(clearLayer);
				}
			}
		}

		Layer bottom = new Layer(Layer.DIV);
		bottom.setStyleClass("bottom");
		form.add(bottom);

		Link next = getButtonLink(this.iwrb.getLocalizedString("next", "Next"));
		next.setValueOnClick(PARAMETER_ACTION, String.valueOf(ACTION_SAVE));
		next.setToFormSubmit(form);
		bottom.add(next);

		Link back = getButtonLink(this.iwrb.getLocalizedString("previous", "Previous"));
		back.setValueOnClick(PARAMETER_ACTION, String.valueOf(ACTION_PHASE_2));
		back.setToFormSubmit(form);
		bottom.add(back);

		add(form);
	}

	protected User getUser(IWContext iwc) throws RemoteException {
		if (this.iUseSessionUser) {
			return getUserSession(iwc).getUser();
		}
		else {
			return iwc.getCurrentUser();
		}
	}

	@Override
	protected DropdownMenu getUserChooser(IWContext iwc, User user, User chosenUser, String parameterName, IWResourceBundle iwrb) throws RemoteException {
		return getUserChooser(iwc, null, user, chosenUser, parameterName, iwrb);
	}
	
	@Override
	protected DropdownMenu getUserChooser(IWContext iwc, Object applicationPK, User user, User chosenUser, String parameterName, IWResourceBundle iwrb) throws RemoteException {
		Collection children = new ArrayList();

		ChildAndDaycareApplicationState childrenArray[] = getChildCareService(iwc).getDaycareService().getChildrenAndDaycareApplicationState(user.getPersonalID());
		for (int i = 0; i < childrenArray.length; i++) {
			ChildAndDaycareApplicationState state = childrenArray[i];
			try {
				children.add(getUserBusiness(iwc).getUser(state.getPersonIdentificationNumber()));
			}
			catch (FinderException fe) {
				fe.printStackTrace();
			}
		}
		
		return getUserChooser(iwc, applicationPK, user, chosenUser, children, parameterName, iwrb);
	}

	private Map getMonthMap(IWContext iwc, String[] months) {
		Map monthMap = new LinkedHashMap();
		
		for (int i = 0; i < months.length; i++) {
			String month = months[i];
			
			String receiver = iwc.getParameter(PARAMETER_MONTH + "_" + month);
			IWTimestamp stamp = new IWTimestamp(month);
			
			if (receiver != null) {
				Collection userValues = (Collection) monthMap.get(receiver);
				if (userValues == null) {
					userValues = new ArrayList();
				}
				
				userValues.add(stamp);
				monthMap.put(receiver, userValues);
			}
		}

		return monthMap;
	}
	
	private String getBankAccount(BankAccount bankAccount) {
		NumberFormat bank = NumberFormat.getNumberInstance();
		bank.setMinimumIntegerDigits(4);
		bank.setMaximumFractionDigits(0);
		bank.setGroupingUsed(false);
		
		NumberFormat ledger = NumberFormat.getNumberInstance();
		ledger.setMinimumIntegerDigits(2);
		ledger.setMaximumFractionDigits(0);
		ledger.setGroupingUsed(false);
		
		NumberFormat account = NumberFormat.getNumberInstance();
		account.setMinimumIntegerDigits(6);
		account.setMaximumFractionDigits(0);
		account.setGroupingUsed(false);
		
		return bank.format(bankAccount.getBankID() != null ? bankAccount.getBankID().intValue() : 0) + "-" + ledger.format(bankAccount.getLedger() != null ? bankAccount.getLedger().intValue() : 0) + "-" + account.format(bankAccount.getAccountNumber() != null ? bankAccount.getAccountNumber().intValue() : 0);
	}

	protected ChildCareSession getChildCareSession(IWUserContext iwuc) {
		try {
			return (ChildCareSession) IBOLookup.getSessionInstance(iwuc, ChildCareSession.class);
		}
		catch (IBOLookupException ile) {
			throw new IBORuntimeException(ile);
		}
	}

	protected ChildCareRVKService getChildCareService(IWApplicationContext iwac) {
		try {
			return (ChildCareRVKService) IBOLookup.getServiceInstance(iwac, ChildCareRVKService.class);
		}
		catch (IBOLookupException ile) {
			throw new IBORuntimeException(ile);
		}
	}

	@Override
	protected UserBusiness getUserBusiness(IWApplicationContext iwac) {
		try {
			return (UserBusiness) IBOLookup.getServiceInstance(iwac, UserBusiness.class);
		}
		catch (IBOLookupException ile) {
			throw new IBORuntimeException(ile);
		}
	}

	protected Web2Business getWeb2Business(IWApplicationContext iwac) {
		try {
			return (Web2Business) IBOLookup.getServiceInstance(iwac, Web2Business.class);
		}
		catch (IBOLookupException ile) {
			throw new IBORuntimeException(ile);
		}
	}

	protected UserSession getUserSession(IWUserContext iwuc) {
		try {
			return (UserSession) IBOLookup.getSessionInstance(iwuc, UserSession.class);
		}
		catch (IBOLookupException ile) {
			throw new IBORuntimeException(ile);
		}
	}

	protected AddressBusiness getAddressBusiness(IWApplicationContext iwac) {
		try {
			return (AddressBusiness) IBOLookup.getServiceInstance(iwac, AddressBusiness.class);
		}
		catch (IBOLookupException ile) {
			throw new IBORuntimeException(ile);
		}
	}

	public void setUseSessionUser(boolean useSessionUser) {
		this.iUseSessionUser = useSessionUser;
	}

	private String getSurveyURL() {
		return this.iSurveyURL;
	}

	public void setSurveyURL(String surveyURL) {
		this.iSurveyURL = surveyURL;
	}
}