/*
 * $Id: ChildCareApplication.java,v 1.34 2009/06/26 10:26:24 laddi Exp $ Created
 * on Aug 3, 2005
 * 
 * Copyright (C) 2005 Idega Software hf. All Rights Reserved.
 * 
 * This software is the proprietary information of Idega hf. Use is subject to
 * license terms.
 */
package is.idega.idegaweb.egov.childcare.rvk.presentation;

import is.idega.block.family.business.FamilyConstants;
import is.idega.block.family.business.FamilyLogic;
import is.idega.block.family.business.NoCustodianFound;
import is.idega.block.family.data.Custodian;
import is.idega.block.family.data.Relative;
import is.idega.idegaweb.egov.application.presentation.ApplicationForm;
import is.idega.idegaweb.egov.childcare.rvk.business.ChildCareConstants;
import is.idega.idegaweb.egov.childcare.rvk.business.ChildCareRVKService;
import is.idega.idegaweb.egov.childcare.rvk.business.ChildCareSession;
import is.idega.idegaweb.egov.childcare.rvk.data.DaycareChild;
import is.idega.idegaweb.egov.childcare.rvk.data.DaycareGuardian;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.Child;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.ChildAndDaycareApplicationState;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareApplication;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareProgram;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareProvider;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareType;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.Guardian;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.ISO_639_2;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.IntendedDuration;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.RequestedDaycareProvider;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import javax.ejb.CreateException;
import javax.ejb.FinderException;

import com.idega.block.school.business.SchoolBusiness;
import com.idega.block.school.data.Student;
import com.idega.block.web2.business.Web2Business;
import com.idega.business.IBOLookup;
import com.idega.business.IBOLookupException;
import com.idega.business.IBORuntimeException;
import com.idega.core.builder.data.ICPage;
import com.idega.core.contact.data.Email;
import com.idega.core.contact.data.Phone;
import com.idega.core.location.business.AddressBusiness;
import com.idega.core.location.data.Address;
import com.idega.core.location.data.PostalCode;
import com.idega.event.IWPageEventListener;
import com.idega.idegaweb.IWApplicationContext;
import com.idega.idegaweb.IWException;
import com.idega.idegaweb.IWResourceBundle;
import com.idega.idegaweb.IWUserContext;
import com.idega.presentation.IWContext;
import com.idega.presentation.Layer;
import com.idega.presentation.Span;
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
import com.idega.presentation.ui.TextArea;
import com.idega.presentation.ui.TextInput;
import com.idega.user.business.NoEmailFoundException;
import com.idega.user.business.NoPhoneFoundException;
import com.idega.user.business.UserSession;
import com.idega.user.data.User;
import com.idega.util.CoreConstants;
import com.idega.util.EmailValidator;
import com.idega.util.PersonalIDFormatter;
import com.idega.util.PresentationUtil;
import com.idega.util.text.Name;

/**
 * Last modified: $Date: 2009/06/26 10:26:24 $ by $Author: laddi $
 * 
 * @author <a href="mailto:laddi@idega.com">laddi</a>
 * @version $Revision: 1.34 $
 */
public class ChildCareApplication extends ApplicationForm implements IWPageEventListener {

	private static final int ACTION_PHASE_1 = 1;
	private static final int ACTION_PHASE_2 = 2;
	private static final int ACTION_PHASE_3 = 3;
	private static final int ACTION_OVERVIEW = 4;
	private static final int ACTION_SAVE = 5;

	private static final String PARAMETER_ACTION = "prm_action";
	private static final String PARAMETER_BACK = "prm_back";

	private static final String PARAMETER_PROVIDER = "prm_provider";
	private static final String PARAMETER_AREA = "prm_area";
	private static final String PARAMETER_DURATION = "prm_duration";
	private static final String PARAMETER_DAYTIME = "prm_daytime";
	private static final String PARAMETER_ACCEPTS_OTHER_PROVIDERS = "prm_other_providers";

	private static final String PARAMETER_CHILD = "prm_child";
	private static final String PARAMETER_USER = "prm_user_id";
	private static final String PARAMETER_HOME_PHONE = "prm_home";
	private static final String PARAMETER_WORK_PHONE = "prm_work";
	private static final String PARAMETER_MOBILE_PHONE = "prm_mobile";
	private static final String PARAMETER_EMAIL = "prm_email";
	private static final String PARAMETER_RELATION = "prm_relation";
	private static final String PARAMETER_MARITAL_STATUS = "prm_marital_status";

	private static final String PARAMETER_PRIMARY_LANGUAGE = "prm_primary_language";
	private static final String PARAMETER_SECONDARY_LANGUAGE = "prm_secondary_language";
	private static final String PARAMETER_CHILD_CARE_INFORMATION = "prm_other_info";
	private static final String PARAMETER_AGREEMENT = "prm_agreement";
	
	private boolean iUseSessionUser = false;
	private String iSurveyURL;
	private ICPage iServicePage;

	private IWResourceBundle iwrb;

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
	public String getBundleIdentifier() {
		return ChildCareConstants.IW_BUNDLE_IDENTIFIER;
	}

	@Override
	public String getCaseCode() {
		return ChildCareConstants.CHILD_CARE_CASE_CODE_KEY;
	}

	@Override
	public void present(IWContext iwc) {
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

				case ACTION_PHASE_3:
					showPhaseThree(iwc);
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

	protected User getUser(IWContext iwc) throws RemoteException {
		if (this.iUseSessionUser) {
			return getUserSession(iwc).getUser();
		}
		else {
			return iwc.getCurrentUser();
		}
	}

	private User getApplicant(IWContext iwc) throws RemoteException {
		return getChildCareSession(iwc).getChild();
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

	protected void showPhaseOne(IWContext iwc) throws RemoteException {
		PresentationUtil.addJavaScriptSourceLineToHeader(iwc, CoreConstants.DWR_ENGINE_SCRIPT);
		PresentationUtil.addJavaScriptSourceLineToHeader(iwc, CoreConstants.DWR_UTIL_SCRIPT);
		PresentationUtil.addJavaScriptSourceLineToHeader(iwc, "/dwr/interface/ChildCareSession.js");
		PresentationUtil.addJavaScriptSourceLineToHeader(iwc, getWeb2Business(iwc).getBundleURIToJQueryLib());
		PresentationUtil.addJavaScriptSourceLineToHeader(iwc, getBundle(iwc).getResourcesVirtualPath() + "/js/childcare.js");
		
		Form form = createForm(ACTION_PHASE_1);
		form.add(new HiddenInput(PARAMETER_ACTION, String.valueOf(ACTION_PHASE_1)));
		form.setEventListener(this.getClass());

		addErrors(iwc, form);

		form.add(getPhasesHeader(this.iwrb.getLocalizedString("application.applicant", "Applicant"), ACTION_PHASE_1, ACTION_SAVE));

		User applicant = getApplicant(iwc);

		Layer info = new Layer(Layer.DIV);
		info.setStyleClass("info");
		form.add(info);

		Heading1 heading = new Heading1(this.iwrb.getLocalizedString("select_applicant", "Select applicant"));
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
		helpLayer.add(new Text(this.iwrb.getLocalizedString("select_applicant_helper_text", "Please select the applicant from the drop down list.")));
		info.add(helpLayer);

		if (applicant != null) {
			DaycareApplication application = getChildCareSession(iwc).getDaycareApplication(getUser(iwc).getPersonalID(), applicant.getPersonalID());
			
			heading = new Heading1(this.iwrb.getLocalizedString("application.provider_information", "Child care provider information"));
			heading.setStyleClass("subHeader");
			heading.setStyleClass("topSubHeader");
			form.add(heading);
	
			Layer section = new Layer(Layer.DIV);
			section.setStyleClass("formSection");
			form.add(section);
	
			helpLayer = new Layer(Layer.DIV);
			helpLayer.setStyleClass("helperText");
			helpLayer.add(new Text(this.iwrb.getLocalizedString("application.school_choose_help", "Select the school/s you want to apply for.")));
			section.add(helpLayer);
	
			short[] postCodes = getChildCareSession(iwc).getPublicPostalCodes();
			RequestedDaycareProvider[] providers = application != null ? application.getRequestedDaycareProviders() : null;
			
			Collection postalCodes = new ArrayList();
			for (int i = 0; i < postCodes.length; i++) {
				short postCode = postCodes[i];
				try {
					PostalCode code = getAddressBusiness(iwc).getPostalCodeAndCreateIfDoesNotExist(String.valueOf(postCode), String.valueOf(postCode));
					postalCodes.add(code);
				}
				catch (CreateException e) {
					e.printStackTrace();
				}
			}
			
			for (int a = 1; a <= 5; a++) {
				RequestedDaycareProvider providerChoice = null;
				if (providers != null) {
					for (int i = 0; i < providers.length; i++) {
						RequestedDaycareProvider requestedDaycareProvider = providers[i];
						if (requestedDaycareProvider.getRanking().intValue() == a && getChildCareSession(iwc).getProvider(requestedDaycareProvider.getDaycareProviderID()).getType().equals(DaycareType.PublicDaycare)) {
							providerChoice = requestedDaycareProvider;
						}
					}
				}
				Collection schools = null;
				
				DropdownMenu areaDropdown = new DropdownMenu(PARAMETER_AREA + "_" + a);
				areaDropdown.setID(PARAMETER_AREA + "_" + a);
				areaDropdown.setStyleClass("areaDropdown");
				Iterator iterator = postalCodes.iterator();
				while (iterator.hasNext()) {
					PostalCode code = (PostalCode) iterator.next();
					areaDropdown.addMenuElement(code.getPostalCode(), code.getPostalAddress());
				}
				areaDropdown.addMenuElementFirst("", this.iwrb.getLocalizedString("application.select_area", "Select area"));
				
				Integer providerID = null;
				if (iwc.isParameterSet(PARAMETER_PROVIDER + "_" + a)) {
					providerID = new Integer(iwc.getParameter(PARAMETER_PROVIDER + "_" + a));
				}
				else if (providerChoice != null) {
					providerID = providerChoice.getDaycareProviderID();
				}
				
				if (providerID != null) {
					DaycareProvider provider = getChildCareSession(iwc).getProvider(providerID);
					areaDropdown.setSelectedElement(provider.getPostcode().toString());

					DaycareProvider[] daycareProviders = (DaycareProvider[]) getChildCareSession(iwc).getPublicProviders().get(provider.getPostcode());
					if (daycareProviders != null) {
						schools = Arrays.asList(daycareProviders);
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
				label = new Label(new Span(new Text(this.iwrb.getLocalizedString("application.school_" + a, "School choice nr. " + a))), areaDropdown);
				formItem.add(label);
				formItem.add(areaDropdown);
				formItem.add(schoolDropdown);
				section.add(formItem);
			}
			
			Layer clearLayer = new Layer(Layer.DIV);
			clearLayer.setStyleClass("Clear");
			section.add(clearLayer);
	
			heading = new Heading1(this.iwrb.getLocalizedString("application.daytime_information", "Daytime information"));
			heading.setStyleClass("subHeader");
			form.add(heading);
	
			section = new Layer(Layer.DIV);
			section.setStyleClass("formSection");
			form.add(section);
	
			helpLayer = new Layer(Layer.DIV);
			helpLayer.setStyleClass("helperText");
			helpLayer.add(new Text(this.iwrb.getLocalizedString("application.daytime_help", "Daytime details...")));
			section.add(helpLayer);
	
			RadioButton allDay = new RadioButton(PARAMETER_DAYTIME, DaycareProgram._AllDay);
			allDay.keepStatusOnAction(true);
			allDay.setSelected(application != null && application.getProgram().getValue().equals(DaycareProgram._AllDay));
			
			formItem = new Layer(Layer.DIV);
			formItem.setStyleClass("formItem");
			formItem.setStyleClass("radioButtonItem");
			label = new Label(new Span(new Text(this.iwrb.getLocalizedString("daytime." + DaycareProgram._AllDay, "All day"))), allDay);
			formItem.add(allDay);
			formItem.add(label);
			section.add(formItem);
	
			RadioButton beforeMidday = new RadioButton(PARAMETER_DAYTIME, DaycareProgram._BeforeMidday);
			beforeMidday.keepStatusOnAction(true);
			beforeMidday.setSelected(application != null && application.getProgram().getValue().equals(DaycareProgram._BeforeMidday));
			
			formItem = new Layer(Layer.DIV);
			formItem.setStyleClass("formItem");
			formItem.setStyleClass("radioButtonItem");
			label = new Label(new Span(new Text(this.iwrb.getLocalizedString("daytime." + DaycareProgram._BeforeMidday, "Before midday"))), beforeMidday);
			formItem.add(beforeMidday);
			formItem.add(label);
			section.add(formItem);
	
			RadioButton afterMidday = new RadioButton(PARAMETER_DAYTIME, DaycareProgram._AfterMidday);
			afterMidday.keepStatusOnAction(true);
			afterMidday.setSelected(application != null && application.getProgram().getValue().equals(DaycareProgram._AfterMidday));
			
			formItem = new Layer(Layer.DIV);
			formItem.setStyleClass("formItem");
			formItem.setStyleClass("radioButtonItem");
			label = new Label(new Span(new Text(this.iwrb.getLocalizedString("daytime." + DaycareProgram._AfterMidday, "After midday"))), afterMidday);
			formItem.add(afterMidday);
			formItem.add(label);
			section.add(formItem);
	
			clearLayer = new Layer(Layer.DIV);
			clearLayer.setStyleClass("Clear");
			section.add(clearLayer);
	
			heading = new Heading1(this.iwrb.getLocalizedString("application.duration_information", "Duration information"));
			heading.setStyleClass("subHeader");
			form.add(heading);
	
			section = new Layer(Layer.DIV);
			section.setStyleClass("formSection");
			form.add(section);
	
			helpLayer = new Layer(Layer.DIV);
			helpLayer.setStyleClass("helperText");
			helpLayer.add(new Text(this.iwrb.getLocalizedString("application.duration_help", "Duration details...")));
			section.add(helpLayer);
	
			DropdownMenu fromTime = new DropdownMenu(PARAMETER_DURATION);
			fromTime.addMenuElementFirst("", iwrb.getLocalizedString("application.select_duration_of_stay", "Select duration"));
			fromTime.addMenuElement(IntendedDuration._Four, iwrb.getLocalizedString("duration." + IntendedDuration._Four, "Four hours"));
			fromTime.addMenuElement(IntendedDuration._FourAndAHalf, iwrb.getLocalizedString("duration." + IntendedDuration._FourAndAHalf, "Four and a half hours"));
			fromTime.addMenuElement(IntendedDuration._Five, iwrb.getLocalizedString("duration." + IntendedDuration._Five, "Five hours"));
			fromTime.addMenuElement(IntendedDuration._FiveAndAHalf, iwrb.getLocalizedString("duration." + IntendedDuration._FiveAndAHalf, "Five and a half hours"));
			fromTime.addMenuElement(IntendedDuration._Six, iwrb.getLocalizedString("duration." + IntendedDuration._Six, "Six hours"));
			fromTime.addMenuElement(IntendedDuration._SixAndAHalf, iwrb.getLocalizedString("duration." + IntendedDuration._SixAndAHalf, "Six and a half hours"));
			fromTime.addMenuElement(IntendedDuration._Seven, iwrb.getLocalizedString("duration." + IntendedDuration._Seven, "Seven hours"));
			fromTime.addMenuElement(IntendedDuration._SevenAndAHalf, iwrb.getLocalizedString("duration." + IntendedDuration._SevenAndAHalf, "Seven and a half hours"));
			fromTime.addMenuElement(IntendedDuration._Eight, iwrb.getLocalizedString("duration." + IntendedDuration._Eight, "Eight hours"));
			fromTime.addMenuElement(IntendedDuration._EightAndAHalf, iwrb.getLocalizedString("duration." + IntendedDuration._EightAndAHalf, "Eight and a half hours"));
			fromTime.addMenuElement(IntendedDuration._Nine, iwrb.getLocalizedString("duration." + IntendedDuration._Nine, "Nine hours"));
			fromTime.addMenuElement(IntendedDuration._NineAndHalf, iwrb.getLocalizedString("duration." + IntendedDuration._NineAndHalf, "Nine and a half hours"));
			if (application != null) {
				fromTime.setSelectedElement(application.getIntendedDuration().getValue());
			}
			
			formItem = new Layer(Layer.DIV);
			formItem.setStyleClass("formItem");
			formItem.setStyleClass("required");
			if (hasError(PARAMETER_DURATION)) {
				formItem.setStyleClass("hasError");
			}
			label = new Label(new Span(new Text(this.iwrb.getLocalizedString("application.duration", "Duration"))), fromTime);
			formItem.add(label);
			formItem.add(fromTime);
			section.add(formItem);
	
			clearLayer = new Layer(Layer.DIV);
			clearLayer.setStyleClass("Clear");
			section.add(clearLayer);
	
			heading = new Heading1(this.iwrb.getLocalizedString("application.accepts_other_providers", "Accepts other providers"));
			heading.setStyleClass("subHeader");
			form.add(heading);
	
			section = new Layer(Layer.DIV);
			section.setStyleClass("formSection");
			form.add(section);
	
			helpLayer = new Layer(Layer.DIV);
			helpLayer.setStyleClass("helperText");
			helpLayer.add(new Text(this.iwrb.getLocalizedString("application.accepts_other_providers_help", "Select yes or no if you accept offers from other providers than the ones you selected.")));
			section.add(helpLayer);
	
			RadioButton yes = new RadioButton(PARAMETER_ACCEPTS_OTHER_PROVIDERS, Boolean.TRUE.toString());
			yes.setStyleClass("radiobutton");
			yes.keepStatusOnAction(true);
			RadioButton no = new RadioButton(PARAMETER_ACCEPTS_OTHER_PROVIDERS, Boolean.FALSE.toString());
			no.setStyleClass("radiobutton");
			no.keepStatusOnAction(true);
			if (application != null && application.getWillAcceptAlternativeProviders().booleanValue()) {
				yes.setSelected(true);
			}
			else if (application != null && !application.getWillAcceptAlternativeProviders().booleanValue()) {
				no.setSelected(true);
			}
	
			formItem = new Layer(Layer.DIV);
			formItem.setStyleClass("formItem");
			formItem.setStyleClass("radioButtonItem");
			label = new Label(this.iwrb.getLocalizedString("yes", "Yes"), yes);
			formItem.add(yes);
			formItem.add(label);
			section.add(formItem);
	
			formItem = new Layer(Layer.DIV);
			formItem.setStyleClass("formItem");
			formItem.setStyleClass("radioButtonItem");
			label = new Label(this.iwrb.getLocalizedString("no", "No"), no);
			formItem.add(no);
			formItem.add(label);
			section.add(formItem);
	
			clearLayer = new Layer(Layer.DIV);
			clearLayer.setStyleClass("Clear");
			section.add(clearLayer);
			
			Layer bottom = new Layer(Layer.DIV);
			bottom.setStyleClass("bottom");
			form.add(bottom);
	
			Link next = getButtonLink(this.iwrb.getLocalizedString("next", "Next"));
			if (getApplicant(iwc) != null) {
				next.setValueOnClick(PARAMETER_ACTION, String.valueOf(ACTION_PHASE_2));
				next.setToFormSubmit(form);
			}
			else {
				next.addParameter(PARAMETER_NO_USER, Boolean.TRUE.toString());
			}
			bottom.add(next);
		}
		
		add(form);
	}

	protected void showPhaseTwo(IWContext iwc) throws RemoteException {
		if (iwc.isParameterSet(PARAMETER_BACK)) {
			saveChildInfo(iwc, getApplicant(iwc));
		}
		if (!iwc.isParameterSet(PARAMETER_DAYTIME)) {
			setError(ACTION_PHASE_1, PARAMETER_DAYTIME, this.iwrb.getLocalizedString("application_error.daytime_empty", "Please select daytime"));
		}
		if (!iwc.isParameterSet(PARAMETER_DURATION)) {
			setError(ACTION_PHASE_1, PARAMETER_DURATION, this.iwrb.getLocalizedString("application_error.duration_empty", "Please select duration"));
		}
		if (!iwc.isParameterSet(PARAMETER_ACCEPTS_OTHER_PROVIDERS)) {
			setError(ACTION_PHASE_1, PARAMETER_ACCEPTS_OTHER_PROVIDERS, this.iwrb.getLocalizedString("application_error.accepts_others_empty", "Please select if you accept other providers"));
		}

		boolean hasSchoolChoice = false;

		for (int i = 0; i < 5; i++) {
			if (iwc.isParameterSet(PARAMETER_PROVIDER + "_" + (i + 1))) {
				hasSchoolChoice = true;
				break;
			}
		}
		if (!hasSchoolChoice) {
			setError(ACTION_PHASE_1, PARAMETER_PROVIDER + "_1", this.iwrb.getLocalizedString("application_error.providers_empty", "Please select at least one provider"));
		}

		if (hasSchoolChoice) {
			Collection schools = new ArrayList();

			for (int i = 0; i < 5; i++) {
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

		if (hasErrors(ACTION_PHASE_1)) {
			showPhaseOne(iwc);
			return;
		}

		Form form = createForm(ACTION_PHASE_2);
		form.addParameter(PARAMETER_ACTION, String.valueOf(ACTION_PHASE_2));

		User applicant = getApplicant(iwc);
		DaycareChild child = getChildCareService(iwc).getDaycareChild(applicant.getPrimaryKey());

		addErrors(iwc, form);

		form.add(getPhasesHeader(this.iwrb.getLocalizedString("application.custodian_information", "Custodian information"), ACTION_PHASE_2, ACTION_SAVE));
		form.add(getPersonInfo(iwc, applicant));

		DaycareApplication application = getChildCareSession(iwc).getDaycareApplication(getUser(iwc).getPersonalID(), applicant.getPersonalID());
		Guardian[] guardians = application.getGuardians();
		for (int i = 0; i < guardians.length; i++) {
			Guardian guardian = guardians[i];
			addParentToForm(form, iwc, child, guardian, (i + 1));
		}

		Layer bottom = new Layer(Layer.DIV);
		bottom.setStyleClass("bottom");
		form.add(bottom);

		Link next = getButtonLink(this.iwrb.getLocalizedString("next", "Next"));
		next.setValueOnClick(PARAMETER_ACTION, String.valueOf(ACTION_PHASE_3));
		next.setToFormSubmit(form);
		bottom.add(next);

		Link back = getButtonLink(this.iwrb.getLocalizedString("previous", "Previous"));
		back.setValueOnClick(PARAMETER_ACTION, String.valueOf(ACTION_PHASE_1));
		back.setToFormSubmit(form);
		bottom.add(back);

		add(form);
	}

	private void addParentToForm(Form form, IWContext iwc, DaycareChild child, Guardian guardian, int number) throws RemoteException {
		Address address = null;
		Phone phone = null;
		Phone work = null;
		Phone mobile = null;
		Email email = null;
		//String maritalStatus = null;
		
		DaycareGuardian custodian = null;
		try {
			User user = getUserBusiness(iwc).getUser(guardian.getPersonIdentificationNumber());
			custodian = getChildCareService(iwc).getGuardian(user.getPrimaryKey());
		}
		catch (FinderException fe) {
			fe.printStackTrace();
			return;
		}

		if (custodian != null) {
			address = getUserBusiness(iwc).getUsersMainAddress(custodian);
			//maritalStatus = custodian.getMaritalStatus();

			try {
				phone = getUserBusiness(iwc).getUsersHomePhone(custodian);
			}
			catch (NoPhoneFoundException npfe) {
				phone = null;
			}

			try {
				work = getUserBusiness(iwc).getUsersWorkPhone(custodian);
			}
			catch (NoPhoneFoundException npfe) {
				work = null;
			}

			try {
				mobile = getUserBusiness(iwc).getUsersMobilePhone(custodian);
			}
			catch (NoPhoneFoundException npfe) {
				mobile = null;
			}

			try {
				email = getUserBusiness(iwc).getUsersMainEmail(custodian);
			}
			catch (NoEmailFoundException nefe) {
				email = null;
			}
		}

		Heading1 heading = new Heading1(this.iwrb.getLocalizedString("custodian", "Custodian"));
		heading.setStyleClass("subHeader");
		if (number == 1) {
			heading.setStyleClass("topSubHeader");
		}
		form.add(heading);

		Layer section = new Layer(Layer.DIV);
		section.setStyleClass("formSection");
		form.add(section);

		Layer helpLayer = new Layer(Layer.DIV);
		helpLayer.setStyleClass("helperText");
		helpLayer.add(new Text(this.iwrb.getLocalizedString("application.custodian_help", "Please fill in the necessary information.  Please note that filling in the relation is mandatory.")));
		section.add(helpLayer);

		TextInput name = new TextInput("name", custodian != null ? custodian.getName() : null);
		name.setDisabled(true);

		Layer formItem = new Layer(Layer.DIV);
		formItem.setStyleClass("formItem");
		Label label = new Label(this.iwrb.getLocalizedString("name", "Name"), name);
		formItem.add(label);
		formItem.add(name);
		section.add(formItem);

		if (custodian != null) {
			formItem.add(new HiddenInput(PARAMETER_USER, custodian.getPrimaryKey().toString()));
		}

		TextInput personalID = new TextInput("personalID", PersonalIDFormatter.format(custodian.getPersonalID(), iwc.getCurrentLocale()));
		personalID.setDisabled(true);

		formItem = new Layer(Layer.DIV);
		formItem.setStyleClass("formItem");
		label = new Label(new Span(new Text(this.iwrb.getLocalizedString("personal_id", "Personal ID"))), personalID);
		formItem.add(label);
		formItem.add(personalID);
		section.add(formItem);

		TextInput addr = new TextInput("address");
		addr.setDisabled(true);
		TextInput zip = new TextInput("zipCode");
		zip.setDisabled(true);
		if (address != null) {
			addr.setContent(address.getStreetAddress());
			PostalCode code = address.getPostalCode();
			if (code != null) {
				zip.setContent(code.getPostalAddress());
			}
		}

		formItem = new Layer(Layer.DIV);
		formItem.setStyleClass("formItem");
		label = new Label(this.iwrb.getLocalizedString("address", "Address"), addr);
		formItem.add(label);
		formItem.add(addr);
		section.add(formItem);

		formItem = new Layer(Layer.DIV);
		formItem.setStyleClass("formItem");
		label = new Label(this.iwrb.getLocalizedString("zip_code", "Zip code"), zip);
		formItem.add(label);
		formItem.add(zip);
		section.add(formItem);

		TextInput homePhone = new TextInput(PARAMETER_HOME_PHONE, null);
		if (phone != null) {
			homePhone.setContent(phone.getNumber());
		}
		else if (guardian.getHomePhoneNumber() != null) {
			homePhone.setContent(guardian.getHomePhoneNumber());
		}
		homePhone.keepStatusOnAction(true, number - 1);
		homePhone.setMaxlength(20);

		formItem = new Layer(Layer.DIV);
		formItem.setStyleClass("formItem");
		formItem.setStyleClass("required");
		if (hasError(PARAMETER_HOME_PHONE)) {
			formItem.setStyleClass("hasError");
		}
		label = new Label(new Span(new Text(this.iwrb.getLocalizedString("home_phone", "Home phone"))), homePhone);
		formItem.add(label);
		formItem.add(homePhone);
		section.add(formItem);

		TextInput workPhone = new TextInput(PARAMETER_WORK_PHONE);
		if (work != null) {
			workPhone.setContent(work.getNumber());
		}
		else if (guardian.getWorkPhoneNumber() != null) {
			workPhone.setContent(guardian.getWorkPhoneNumber());
		}
		workPhone.keepStatusOnAction(true, number - 1);
		workPhone.setMaxlength(20);

		formItem = new Layer(Layer.DIV);
		formItem.setStyleClass("formItem");
		label = new Label(this.iwrb.getLocalizedString("work_phone", "Work phone"), workPhone);
		formItem.add(label);
		formItem.add(workPhone);
		section.add(formItem);

		TextInput mobilePhone = new TextInput(PARAMETER_MOBILE_PHONE, null);
		if (mobile != null) {
			mobilePhone.setContent(mobile.getNumber());
		}
		else if (guardian.getMobilePhoneNumber() != null) {
			mobilePhone.setContent(guardian.getMobilePhoneNumber());
		}
		mobilePhone.keepStatusOnAction(true, number - 1);
		mobilePhone.setMaxlength(20);

		formItem = new Layer(Layer.DIV);
		formItem.setStyleClass("formItem");
		label = new Label(this.iwrb.getLocalizedString("mobile_phone", "Mobile phone"), mobilePhone);
		formItem.add(label);
		formItem.add(mobilePhone);
		section.add(formItem);

		TextInput mail = new TextInput(PARAMETER_EMAIL, null);
		if (email != null) {
			mail.setContent(email.getEmailAddress());
		}
		else if (guardian.getEmailAddress() != null) {
			mail.setContent(guardian.getEmailAddress());
		}
		mail.keepStatusOnAction(true, number - 1);
		mail.setMaxlength(40);

		formItem = new Layer(Layer.DIV);
		formItem.setStyleClass("formItem");
		formItem.setStyleClass("required");
		label = new Label(this.iwrb.getLocalizedString("email", "E-mail"), mail);
		formItem.add(label);
		formItem.add(mail);
		section.add(formItem);

		DropdownMenu relationMenu = getRelationDropdown(custodian);
		if (custodian != null) {
			String relation = child.getRelation(custodian);
			if (relation != null) {
				relationMenu.setSelectedElement(relation);
			}
			else if (guardian.getRelationship() != null) {
				relationMenu.setSelectedElement(getChildCareService(iwc).getRelationship(guardian.getRelationship()));
			}
		}
		relationMenu.keepStatusOnAction(true);

		formItem = new Layer(Layer.DIV);
		formItem.setStyleClass("formItem");
		formItem.setStyleClass("required");
		if (hasError(PARAMETER_RELATION)) {
			formItem.setStyleClass("hasError");
		}
		label = new Label(new Span(new Text(this.iwrb.getLocalizedString("relation", "Relation"))), relationMenu);
		formItem.add(label);
		formItem.add(relationMenu);
		section.add(formItem);

		DropdownMenu maritalStatusMenu = getMaritalStatusDropdown(custodian);
		if (guardian.getMaritalState() != null) {
			maritalStatusMenu.setSelectedElement(getChildCareService(iwc).getMaritalStatus(guardian.getMaritalState()));
		}

		formItem = new Layer(Layer.DIV);
		formItem.setStyleClass("formItem");
		label = new Label(new Span(new Text(this.iwrb.getLocalizedString("marital_status", "Marital status"))), maritalStatusMenu);
		formItem.add(label);
		formItem.add(maritalStatusMenu);
		section.add(formItem);

		Map isoCodes = getChildCareSession(iwc).getISOCodes();
		
		DropdownMenu primaryLanguage = new DropdownMenu(PARAMETER_PRIMARY_LANGUAGE);
		DropdownMenu secondaryLanguage = new DropdownMenu(PARAMETER_SECONDARY_LANGUAGE);
		secondaryLanguage.setMenuElementFirst("", iwrb.getLocalizedString("select_language", "Select language"));

		Iterator iterator = isoCodes.values().iterator();
		while (iterator.hasNext()) {
			ISO_639_2 iso = (ISO_639_2) iterator.next();
			primaryLanguage.addMenuElement(iso.getCode(), iso.getIcelandicName());
			secondaryLanguage.addMenuElement(iso.getCode(), iso.getIcelandicName());
		}
		if (custodian.getPrimaryLanguage() != null) {
			primaryLanguage.setSelectedElement(custodian.getPrimaryLanguage());
		}
		else if (guardian.getLanguageCode1() != null) {
			primaryLanguage.setSelectedElement(guardian.getLanguageCode1());
		}
		else {
			primaryLanguage.setSelectedElement("ice");
		}
		if (custodian.getSecondaryLanguage() != null) {
			secondaryLanguage.setSelectedElement(custodian.getSecondaryLanguage());
		}
		else if (guardian.getLanguageCode2() != null) {
			secondaryLanguage.setSelectedElement(guardian.getLanguageCode2());
		}

		formItem = new Layer(Layer.DIV);
		formItem.setStyleClass("formItem");
		label = new Label(this.iwrb.getLocalizedString("custodian.primary_language", "Primary language"), primaryLanguage);
		formItem.add(label);
		formItem.add(primaryLanguage);
		section.add(formItem);

		formItem = new Layer(Layer.DIV);
		formItem.setStyleClass("formItem");
		label = new Label(this.iwrb.getLocalizedString("child.secondary_language", "Secondary language"), secondaryLanguage);
		formItem.add(label);
		formItem.add(secondaryLanguage);
		section.add(formItem);
		
		Layer clearLayer = new Layer(Layer.DIV);
		clearLayer.setStyleClass("Clear");
		section.add(clearLayer);
	}

	protected void showPhaseThree(IWContext iwc) throws RemoteException {
		this.iwrb = getResourceBundle(iwc);
		boolean saved = saveCustodianInfo(iwc);
		if (!saved) {
			showPhaseTwo(iwc);
			return;
		}

		Form form = createForm(ACTION_PHASE_3);
		form.add(new HiddenInput(PARAMETER_ACTION, String.valueOf(ACTION_PHASE_3)));
		form.add(new HiddenInput(PARAMETER_BACK, ""));

		addErrors(iwc, form);

		form.add(getPhasesHeader(this.iwrb.getLocalizedString("application.child_information", "Child information"), ACTION_PHASE_3, ACTION_SAVE));

		User applicant = getApplicant(iwc);
		form.add(getPersonInfo(iwc, applicant));

		addChildInformation(iwc, getApplicant(iwc), form);

		Layer clearLayer = new Layer(Layer.DIV);
		clearLayer.setStyleClass("Clear");
		form.add(clearLayer);
		
		Heading1 heading = new Heading1(this.iwrb.getLocalizedString("childcare_application.agreement_info", "Agreement information"));
		heading.setStyleClass("subHeader");
		form.add(heading);

		Layer section = new Layer(Layer.DIV);
		section.setStyleClass("formSection");
		form.add(section);

		CheckBox agree = new CheckBox(PARAMETER_AGREEMENT, Boolean.TRUE.toString());
		agree.setStyleClass("checkbox");
		agree.keepStatusOnAction(true);

		Paragraph paragraph = new Paragraph();
		paragraph.setStyleClass("agreement");
		paragraph.add(new Text(this.iwrb.getLocalizedString("childcare_application.agreement", "Agreement text")));
		section.add(paragraph);

		Layer formItem = new Layer(Layer.DIV);
		formItem.setStyleClass("formItem");
		formItem.setStyleClass("radioButtonItem");
		formItem.setStyleClass("required");
		if (hasError(PARAMETER_AGREEMENT)) {
			formItem.setStyleClass("hasError");
		}
		Label label = new Label(new Span(new Text(this.iwrb.getLocalizedString("childcare_application.agree_terms", "Yes, I agree"))), agree);
		formItem.add(agree);
		formItem.add(label);
		section.add(formItem);

		clearLayer = new Layer(Layer.DIV);
		clearLayer.setStyleClass("Clear");
		section.add(clearLayer);
		
		section.add(getAttentionLayer(iwrb.getLocalizedString("application.parent_info", "Parent info...")));

		Layer bottom = new Layer(Layer.DIV);
		bottom.setStyleClass("bottom");
		form.add(bottom);

		Link next = getButtonLink(this.iwrb.getLocalizedString("next", "Next"));
		next.setValueOnClick(PARAMETER_ACTION, String.valueOf(ACTION_OVERVIEW));
		next.setToFormSubmit(form);
		bottom.add(next);

		Link back = getButtonLink(this.iwrb.getLocalizedString("previous", "Previous"));
		back.setValueOnClick(PARAMETER_BACK, Boolean.TRUE.toString());
		back.setValueOnClick(PARAMETER_ACTION, String.valueOf(ACTION_PHASE_2));
		back.setToFormSubmit(form);
		bottom.add(back);

		add(form);
	}

	protected void showOverview(IWContext iwc) throws RemoteException {
		boolean saved = saveChildInfo(iwc, getApplicant(iwc));
		if (!iwc.isParameterSet(PARAMETER_AGREEMENT)) {
			setError(PARAMETER_AGREEMENT, this.iwrb.getLocalizedString("must_agree_terms", "You have to agree to the terms."));
		}

		if (!saved || hasErrors()) {
			showPhaseThree(iwc);
			return;
		}

		Form form = createForm(ACTION_OVERVIEW);
		form.addParameter(PARAMETER_ACTION, String.valueOf(ACTION_OVERVIEW));

		form.add(getPhasesHeader(this.iwrb.getLocalizedString("application.overview", "Overview"), ACTION_OVERVIEW, ACTION_SAVE));

		User applicant = getApplicant(iwc);
		DaycareChild child = getChildCareService(iwc).getDaycareChild(applicant.getPrimaryKey());
		Student student = getSchoolBusiness(iwc).getStudent(applicant);
		form.add(getPersonInfo(iwc, applicant));

		Heading1 heading = new Heading1(this.iwrb.getLocalizedString("application.chosen_provider_information", "Provider choice information"));
		heading.setStyleClass("subHeader");
		heading.setStyleClass("topSubHeader");
		form.add(heading);

		Layer section = new Layer(Layer.DIV);
		section.setStyleClass("formSection");
		form.add(section);

		Layer formItem = new Layer(Layer.DIV);
		Label label = new Label();
		Layer span = new Layer();

		for (int a = 1; a <= 5; a++) {
			if (iwc.isParameterSet(PARAMETER_PROVIDER + "_" + a)) {
				Integer providerID = new Integer(iwc.getParameter(PARAMETER_PROVIDER + "_" + a));
				DaycareProvider school = getChildCareSession(iwc).getProvider(providerID);
	
				if (school != null) {
					formItem = new Layer(Layer.DIV);
					formItem.setStyleClass("formItem");
					formItem.setStyleClass("providerOverviewItem");
					label = new Label();
					label.add(new Text(this.iwrb.getLocalizedString("application.school_" + a, "School choice nr. " + a)));
					span = new Layer(Layer.SPAN);
					span.add(new Text(school.getName()));
					formItem.add(label);
					formItem.add(span);
					section.add(formItem);
				}
			}
		}
		
		Layer clearLayer = new Layer(Layer.DIV);
		clearLayer.setStyleClass("Clear");
		section.add(clearLayer);

		heading = new Heading1(this.iwrb.getLocalizedString("application.from_to_time_information", "From/To time information"));
		heading.setStyleClass("subHeader");
		form.add(heading);

		section = new Layer(Layer.DIV);
		section.setStyleClass("formSection");
		form.add(section);

		String daytime = iwc.getParameter(PARAMETER_DAYTIME);

		if (daytime != null) {
			formItem = new Layer(Layer.DIV);
			formItem.setStyleClass("formItem");
			label = new Label();
			label.add(new Text(this.iwrb.getLocalizedString("application.daytime", "daytime")));
			span = new Layer(Layer.SPAN);
			span.add(new Text(iwrb.getLocalizedString("daytime." + daytime, daytime)));
			formItem.add(label);
			formItem.add(span);
			section.add(formItem);
		}

		String duration = iwc.getParameter(PARAMETER_DURATION);

		if (duration != null) {
			formItem = new Layer(Layer.DIV);
			formItem.setStyleClass("formItem");
			label = new Label();
			label.add(new Text(this.iwrb.getLocalizedString("application.duration", "Duration")));
			span = new Layer(Layer.SPAN);
			span.add(new Text(iwrb.getLocalizedString("duration." + duration, duration)));
			formItem.add(label);
			formItem.add(span);
			section.add(formItem);
		}

		clearLayer = new Layer(Layer.DIV);
		clearLayer.setStyleClass("Clear");
		section.add(clearLayer);

		Collection custodians = null;
		try {
			custodians = child.getCustodians();
		}
		catch (NoCustodianFound ncf) {
			custodians = new ArrayList();
		}
		Custodian custodian = child.getExtraCustodian();
		if (custodian != null) {
			custodians.add(custodian);
		}

		if (!custodians.isEmpty()) {
			heading = new Heading1(this.iwrb.getLocalizedString("application.custodian_information", "Custodian information"));
			heading.setStyleClass("subHeader");
			form.add(heading);

			form.add(getCustodians(iwc, this.iwrb, child, custodians));
		}

		heading = new Heading1(this.iwrb.getLocalizedString("child.child_information", "Child information"));
		heading.setStyleClass("subHeader");
		form.add(heading);

		section = new Layer(Layer.DIV);
		section.setStyleClass("formSection");
		form.add(section);

		addChildInformationOverview(iwc, section, child, student);

		clearLayer = new Layer(Layer.DIV);
		clearLayer.setStyleClass("Clear");
		section.add(clearLayer);

		Layer bottom = new Layer(Layer.DIV);
		bottom.setStyleClass("bottom");
		form.add(bottom);

		Link next = getButtonLink(this.iwrb.getLocalizedString("send", "Send"));
		next.setValueOnClick(PARAMETER_ACTION, String.valueOf(ACTION_SAVE));
		next.setOnClick("this.style.display='none';");
		next.setToFormSubmit(form);
		bottom.add(next);

		Link back = getButtonLink(this.iwrb.getLocalizedString("previous", "Previous"));
		back.setValueOnClick(PARAMETER_ACTION, String.valueOf(ACTION_PHASE_3));
		back.setToFormSubmit(form);
		bottom.add(back);

		add(form);
	}

	protected void addChildInformation(IWContext iwc, User user, Form form) throws RemoteException {
		this.iwrb = getResourceBundle(iwc);

		DaycareChild child = getChildCareService(iwc).getDaycareChild(user.getPrimaryKey());
		Student student = getSchoolBusiness(iwc).getStudent(user);
		Child theChild = getChildCareSession(iwc).getDaycareApplication(getUser(iwc).getPersonalID(), child.getPersonalID()).getChild();

		Phone phone = null;
		try {
			phone = getUserBusiness(iwc).getUsersHomePhone(child);
		}
		catch (NoPhoneFoundException npfe) {
			phone = null;
		}

		Heading1 heading = new Heading1(this.iwrb.getLocalizedString("child.child_languages", "Child languages"));
		heading.setStyleClass("subHeader");
		heading.setStyleClass("topSubHeader");
		form.add(heading);

		Layer section = new Layer(Layer.DIV);
		section.setStyleClass("formSection");
		form.add(section);

		Layer helpLayer = new Layer(Layer.DIV);
		helpLayer.setStyleClass("helperText");
		helpLayer.add(new Text(this.iwrb.getLocalizedString("child.child_languages_help", "Select the child's primary language as well as a secondary language, if any.")));
		section.add(helpLayer);

		Map isoCodes = getChildCareSession(iwc).getISOCodes();
		
		DropdownMenu primaryLanguage = new DropdownMenu(PARAMETER_PRIMARY_LANGUAGE);
		DropdownMenu secondaryLanguage = new DropdownMenu(PARAMETER_PRIMARY_LANGUAGE);
		secondaryLanguage.setMenuElementFirst("", iwrb.getLocalizedString("select_language", "Select language"));

		Iterator iterator = isoCodes.values().iterator();
		while (iterator.hasNext()) {
			ISO_639_2 iso = (ISO_639_2) iterator.next();
			primaryLanguage.addMenuElement(iso.getCode(), iso.getIcelandicName());
			secondaryLanguage.addMenuElement(iso.getCode(), iso.getIcelandicName());
		}
		if (child.getPrimaryLanguage() != null) {
			primaryLanguage.setSelectedElement(child.getPrimaryLanguage());
		}
		else if (theChild.getLanguageCode1() != null) {
			primaryLanguage.setSelectedElement(theChild.getLanguageCode1());
		}
		if (child.getSecondaryLanguage() != null) {
			secondaryLanguage.setSelectedElement(child.getSecondaryLanguage());
		}
		else if (theChild.getLanguageCode2() != null) {
			secondaryLanguage.setSelectedElement(theChild.getLanguageCode2());
		}

		Layer formItem = new Layer(Layer.DIV);
		formItem.setStyleClass("formItem");
		Label label = new Label(this.iwrb.getLocalizedString("child.primary_language", "Primary language"), primaryLanguage);
		formItem.add(label);
		formItem.add(primaryLanguage);
		section.add(formItem);

		formItem = new Layer(Layer.DIV);
		formItem.setStyleClass("formItem");
		label = new Label(this.iwrb.getLocalizedString("child.secondary_language", "Secondary language"), secondaryLanguage);
		formItem.add(label);
		formItem.add(secondaryLanguage);
		section.add(formItem);

		Layer clearLayer = new Layer(Layer.DIV);
		clearLayer.setStyleClass("Clear");
		section.add(clearLayer);

		heading = new Heading1(this.iwrb.getLocalizedString("child.main_phone", "Main phone"));
		heading.setStyleClass("subHeader");
		form.add(heading);

		section = new Layer(Layer.DIV);
		section.setStyleClass("formSection");
		form.add(section);

		helpLayer = new Layer(Layer.DIV);
		helpLayer.setStyleClass("helperText");
		helpLayer.add(new Text(this.iwrb.getLocalizedString("child.main_phone_help", "Enter information about main phone number where custodians can be reached.")));
		section.add(helpLayer);

		TextInput homePhone = new TextInput(PARAMETER_HOME_PHONE, null);
		if (phone != null) {
			homePhone.setContent(phone.getNumber());
		}
		else if (theChild.getMainPhoneNumber() != null) {
			homePhone.setContent(theChild.getMainPhoneNumber());
		}
		homePhone.setMaxlength(20);

		formItem = new Layer(Layer.DIV);
		formItem.setStyleClass("formItem");
		label = new Label(new Span(new Text(this.iwrb.getLocalizedString("main_phone", "Main phone"))), homePhone);
		formItem.add(label);
		formItem.add(homePhone);
		section.add(formItem);

		clearLayer = new Layer(Layer.DIV);
		clearLayer.setStyleClass("Clear");
		section.add(clearLayer);

		heading = new Heading1(this.iwrb.getLocalizedString("child.other_information", "Other information"));
		heading.setStyleClass("subHeader");
		form.add(heading);

		section = new Layer(Layer.DIV);
		section.setStyleClass("formSection");
		form.add(section);

		helpLayer = new Layer(Layer.DIV);
		helpLayer.setStyleClass("helperText");
		helpLayer.add(new Text(this.iwrb.getLocalizedString("child.other_information_help", "If there is anything else that you feel the provider should know about the child, please fill in the details.")));
		section.add(helpLayer);

		TextArea details = new TextArea(PARAMETER_CHILD_CARE_INFORMATION, student.getChildCareOtherInformation());
		details.setStyleClass("details");
		section.add(details);
	}

	protected void addChildInformationOverview(IWContext iwc, Layer section, DaycareChild child, Student student) throws RemoteException {
		this.iwrb = getResourceBundle(iwc);

		String primaryLanguage = child.getPrimaryLanguage();
		String secondaryLanguage = child.getSecondaryLanguage();
		String otherInformation = student.getChildCareOtherInformation();

		Layer formItem = new Layer(Layer.DIV);
		formItem.setStyleClass("formItem");
		Label label = new Label();
		label.add(new Text(this.iwrb.getLocalizedString("child.primary_language", "Primary language")));
		Span span = new Span(new Text(getChildCareSession(iwc).getISOCode(primaryLanguage).getIcelandicName()));
		formItem.add(label);
		formItem.add(span);
		section.add(formItem);
		
		if (secondaryLanguage != null) {
			formItem = new Layer(Layer.DIV);
			formItem.setStyleClass("formItem");
			label = new Label();
			label.add(new Text(this.iwrb.getLocalizedString("child.secondary_language", "Secondary language")));
			span = new Span(new Text(getChildCareSession(iwc).getISOCode(secondaryLanguage).getIcelandicName()));
			formItem.add(label);
			formItem.add(span);
			section.add(formItem);
		}

		if (otherInformation != null) {
			formItem = new Layer(Layer.DIV);
			formItem.setStyleClass("formItem");
			formItem.setStyleClass("informationItem");
			label = new Label();
			label.add(new Text(this.iwrb.getLocalizedString("child.other_information", "Other information")));
			span = new Span();
			Paragraph paragraph = new Paragraph();
			paragraph.add(new Text(otherInformation));
			span.add(paragraph);
			formItem.add(label);
			formItem.add(span);
			section.add(formItem);
		}
	}

	protected Layer getCustodians(IWContext iwc, IWResourceBundle iwrb, DaycareChild child, Collection custodians) throws RemoteException {
		Layer layer = new Layer(Layer.DIV);
		layer.setStyleClass("formSection");

		Layer relation = new Layer(Layer.DIV);
		relation.setStyleClass("formItem");
		relation.setStyleClass("multiValueItem");
		Label label = new Label();
		label.add(iwrb.getLocalizedString("relation", "Relation"));
		relation.add(label);
		layer.add(relation);

		Layer name = new Layer(Layer.DIV);
		name.setStyleClass("formItem");
		name.setStyleClass("multiValueItem");
		label = new Label();
		label.add(iwrb.getLocalizedString("name", "Name"));
		name.add(label);
		layer.add(name);

		Layer personalID = new Layer(Layer.DIV);
		personalID.setStyleClass("formItem");
		personalID.setStyleClass("multiValueItem");
		label = new Label();
		label.add(iwrb.getLocalizedString("personal_id", "Personal ID"));
		personalID.add(label);
		layer.add(personalID);

		Layer address = new Layer(Layer.DIV);
		address.setStyleClass("formItem");
		address.setStyleClass("multiValueItem");
		label = new Label();
		label.add(iwrb.getLocalizedString("address", "Address"));
		address.add(label);
		layer.add(address);

		Layer postal = new Layer(Layer.DIV);
		postal.setStyleClass("formItem");
		postal.setStyleClass("multiValueItem");
		label = new Label();
		label.add(iwrb.getLocalizedString("zip_code", "Zip code"));
		postal.add(label);
		layer.add(postal);

		Layer homePhone = new Layer(Layer.DIV);
		homePhone.setStyleClass("formItem");
		homePhone.setStyleClass("multiValueItem");
		label = new Label();
		label.add(iwrb.getLocalizedString("home_phone", "Home phone"));
		homePhone.add(label);
		layer.add(homePhone);

		Layer workPhone = new Layer(Layer.DIV);
		workPhone.setStyleClass("formItem");
		workPhone.setStyleClass("multiValueItem");
		label = new Label();
		label.add(iwrb.getLocalizedString("work_phone", "Work phone"));
		workPhone.add(label);
		layer.add(workPhone);

		Layer mobile = new Layer(Layer.DIV);
		mobile.setStyleClass("formItem");
		mobile.setStyleClass("multiValueItem");
		label = new Label();
		label.add(iwrb.getLocalizedString("mobile_phone", "Mobile phone"));
		mobile.add(label);
		layer.add(mobile);

		Layer email = new Layer(Layer.DIV);
		email.setStyleClass("formItem");
		email.setStyleClass("multiValueItem");
		label = new Label();
		label.add(iwrb.getLocalizedString("email", "E-mail"));
		email.add(label);
		layer.add(email);

		Layer maritalStatus = new Layer(Layer.DIV);
		maritalStatus.setStyleClass("formItem");
		maritalStatus.setStyleClass("multiValueItem");
		label = new Label();
		label.add(iwrb.getLocalizedString("marital_status", "Marital status"));
		maritalStatus.add(label);
		layer.add(maritalStatus);

		Layer primaryLanguage = new Layer(Layer.DIV);
		primaryLanguage.setStyleClass("formItem");
		primaryLanguage.setStyleClass("multiValueItem");
		label = new Label();
		label.add(iwrb.getLocalizedString("child.primary_language", "Primary language"));
		primaryLanguage.add(label);
		layer.add(primaryLanguage);

		Layer secondaryLanguage = new Layer(Layer.DIV);
		secondaryLanguage.setStyleClass("formItem");
		secondaryLanguage.setStyleClass("multiValueItem");
		label = new Label();
		label.add(iwrb.getLocalizedString("child.secondary_language", "Secondary language"));
		secondaryLanguage.add(label);
		layer.add(secondaryLanguage);
		
		Iterator iter = custodians.iterator();
		while (iter.hasNext()) {
			Custodian custodian = (Custodian) iter.next();
			DaycareGuardian guardian = getChildCareService(iwc).getGuardian(custodian.getPrimaryKey());

			Address userAddress = getUserBusiness(iwc).getUsersMainAddress(custodian);
			Phone userPhone = null;
			Phone userWork = null;
			Phone userMobile = null;
			Email userEmail = null;
			String userMaritalStatus = custodian.getMaritalStatus();
			ISO_639_2 primary = guardian.getPrimaryLanguage() != null ? getChildCareSession(iwc).getISOCode(guardian.getPrimaryLanguage()) : null;
			ISO_639_2 secondary = guardian.getSecondaryLanguage() != null ? getChildCareSession(iwc).getISOCode(guardian.getSecondaryLanguage()) : null;

			try {
				userPhone = getUserBusiness(iwc).getUsersHomePhone(custodian);
			}
			catch (NoPhoneFoundException npfe) {
				userPhone = null;
			}

			try {
				userWork = getUserBusiness(iwc).getUsersWorkPhone(custodian);
			}
			catch (NoPhoneFoundException npfe) {
				userWork = null;
			}

			try {
				userMobile = getUserBusiness(iwc).getUsersMobilePhone(custodian);
			}
			catch (NoPhoneFoundException npfe) {
				userMobile = null;
			}

			try {
				userEmail = getUserBusiness(iwc).getUsersMainEmail(custodian);
			}
			catch (NoEmailFoundException nefe) {
				userEmail = null;
			}

			Layer span = new Layer(Layer.SPAN);
			span.add(new Text(iwrb.getLocalizedString("relation." + child.getRelation(custodian), "")));
			relation.add(span);

			Name custodianName = new Name(custodian.getFirstName(), custodian.getMiddleName(), custodian.getLastName());
			span = new Layer(Layer.SPAN);
			span.add(new Text(custodianName.getName(iwc.getCurrentLocale())));
			name.add(span);

			span = new Layer(Layer.SPAN);
			span.add(new Text(PersonalIDFormatter.format(custodian.getPersonalID(), iwc.getCurrentLocale())));
			personalID.add(span);

			span = new Layer(Layer.SPAN);
			span.add(new Text(userAddress.getStreetAddress()));
			address.add(span);

			span = new Layer(Layer.SPAN);
			span.add(new Text(userAddress.getPostalAddress()));
			postal.add(span);

			span = new Layer(Layer.SPAN);
			if (userPhone != null && userPhone.getNumber() != null) {
				span.add(new Text(userPhone.getNumber()));
			}
			else {
				span.add(Text.getNonBrakingSpace());
			}
			homePhone.add(span);

			span = new Layer(Layer.SPAN);
			if (userWork != null && userWork.getNumber() != null) {
				span.add(new Text(userWork.getNumber()));
			}
			else {
				span.add(Text.getNonBrakingSpace());
			}
			workPhone.add(span);

			span = new Layer(Layer.SPAN);
			if (userMobile != null && userMobile.getNumber() != null) {
				span.add(new Text(userMobile.getNumber()));
			}
			else {
				span.add(Text.getNonBrakingSpace());
			}
			mobile.add(span);

			span = new Layer(Layer.SPAN);
			if (userEmail != null && userEmail.getEmailAddress() != null) {
				span.add(new Text(userEmail.getEmailAddress()));
			}
			else {
				span.add(Text.getNonBrakingSpace());
			}
			email.add(span);

			span = new Layer(Layer.SPAN);
			if (userMaritalStatus != null) {
				span.add(new Text(iwrb.getLocalizedString("marital_status." + userMaritalStatus)));
			}
			else {
				span.add(Text.getNonBrakingSpace());
			}
			maritalStatus.add(span);

			span = new Layer(Layer.SPAN);
			if (primary != null) {
				span.add(new Text(primary.getIcelandicName()));
			}
			else {
				span.add(Text.getNonBrakingSpace());
			}
			primaryLanguage.add(span);

			span = new Layer(Layer.SPAN);
			if (secondary != null) {
				span.add(new Text(secondary.getIcelandicName()));
			}
			else {
				span.add(Text.getNonBrakingSpace());
			}
			secondaryLanguage.add(span);
		}

		Layer clearLayer = new Layer(Layer.DIV);
		clearLayer.setStyleClass("Clear");
		layer.add(clearLayer);

		return layer;
	}

	protected Layer getRelatives(IWContext iwc, IWResourceBundle iwrb, Collection custodians) {
		Layer layer = new Layer(Layer.DIV);
		layer.setStyleClass("formSection");

		Layer relation = new Layer(Layer.DIV);
		relation.setStyleClass("formItem");
		relation.setStyleClass("multiValueItem");
		Label label = new Label();
		label.add(iwrb.getLocalizedString("relation", "Relation"));
		relation.add(label);
		layer.add(relation);

		Layer name = new Layer(Layer.DIV);
		name.setStyleClass("formItem");
		name.setStyleClass("multiValueItem");
		label = new Label();
		label.add(iwrb.getLocalizedString("name", "Name"));
		name.add(label);
		layer.add(name);

		Layer homePhone = new Layer(Layer.DIV);
		homePhone.setStyleClass("formItem");
		homePhone.setStyleClass("multiValueItem");
		label = new Label();
		label.add(iwrb.getLocalizedString("home_phone", "Home phone"));
		homePhone.add(label);
		layer.add(homePhone);

		Layer workPhone = new Layer(Layer.DIV);
		workPhone.setStyleClass("formItem");
		workPhone.setStyleClass("multiValueItem");
		label = new Label();
		label.add(iwrb.getLocalizedString("work_phone", "Work phone"));
		workPhone.add(label);
		layer.add(workPhone);

		Layer mobile = new Layer(Layer.DIV);
		mobile.setStyleClass("formItem");
		mobile.setStyleClass("multiValueItem");
		label = new Label();
		label.add(iwrb.getLocalizedString("mobile_phone", "Mobile phone"));
		mobile.add(label);
		layer.add(mobile);

		Layer email = new Layer(Layer.DIV);
		email.setStyleClass("formItem");
		email.setStyleClass("multiValueItem");
		label = new Label();
		label.add(iwrb.getLocalizedString("email", "E-mail"));
		email.add(label);
		layer.add(email);

		Iterator iter = custodians.iterator();
		while (iter.hasNext()) {
			Relative relative = (Relative) iter.next();

			Layer span = new Layer(Layer.SPAN);
			span.add(new Text(iwrb.getLocalizedString("relation." + relative.getRelation(), "")));
			relation.add(span);

			span = new Layer(Layer.SPAN);
			span.add(new Text(relative.getName()));
			name.add(span);

			span = new Layer(Layer.SPAN);
			if (relative.getHomePhone() != null) {
				span.add(new Text(relative.getHomePhone()));
			}
			else {
				span.add(Text.getNonBrakingSpace());
			}
			homePhone.add(span);

			span = new Layer(Layer.SPAN);
			if (relative.getWorkPhone() != null) {
				span.add(new Text(relative.getWorkPhone()));
			}
			else {
				span.add(Text.getNonBrakingSpace());
			}
			workPhone.add(span);

			span = new Layer(Layer.SPAN);
			if (relative.getMobilePhone() != null) {
				span.add(new Text(relative.getMobilePhone()));
			}
			else {
				span.add(Text.getNonBrakingSpace());
			}
			mobile.add(span);

			span = new Layer(Layer.SPAN);
			if (relative.getEmail() != null) {
				span.add(new Text(relative.getEmail()));
			}
			else {
				span.add(Text.getNonBrakingSpace());
			}
			email.add(span);
		}

		Layer clearLayer = new Layer(Layer.DIV);
		clearLayer.setStyleClass("Clear");
		layer.add(clearLayer);

		return layer;
	}

	protected Layer getForbiddenRelative(IWContext iwc, IWResourceBundle iwrb, Relative relative) {
		Layer layer = new Layer(Layer.DIV);
		layer.setStyleClass("formSection");

		Layer name = new Layer(Layer.DIV);
		name.setStyleClass("formItem");
		Label label = new Label();
		label.add(iwrb.getLocalizedString("name", "Name"));
		name.add(label);
		Layer span = new Layer(Layer.SPAN);
		span.add(new Text(relative.getName()));
		name.add(span);
		layer.add(name);

		if (relative.getPersonalID() != null && relative.getPersonalID().length() > 0) {
			Layer personalID = new Layer(Layer.DIV);
			personalID.setStyleClass("formItem");
			label = new Label();
			label.add(iwrb.getLocalizedString("personal_id", "Personal ID"));
			personalID.add(label);
			span = new Layer(Layer.SPAN);
			span.add(new Text(relative.getPersonalID()));
			personalID.add(span);
			layer.add(personalID);
		}

		if (relative.getDetails() != null && relative.getDetails().length() > 0) {
			Layer details = new Layer(Layer.DIV);
			details.setStyleClass("formItem");
			details.setStyleClass("informationItem");
			label = new Label();
			label.add(iwrb.getLocalizedString("forbidden_details", "Forbidden details"));
			details.add(label);
			span = new Layer(Layer.SPAN);
			span.add(new Text(relative.getDetails()));
			details.add(span);
			layer.add(details);
		}

		Layer clearLayer = new Layer(Layer.DIV);
		clearLayer.setStyleClass("Clear");
		layer.add(clearLayer);

		return layer;
	}

	protected String getBooleanValue(IWContext iwc, boolean booleanValue) {
		return getBooleanValue(iwc, new Boolean(booleanValue));
	}

	protected String getBooleanValue(IWContext iwc, Boolean booleanValue) {
		if (this.iwrb == null) {
			this.iwrb = getResourceBundle(iwc);
		}

		if (booleanValue == null) {
			return this.iwrb.getLocalizedString("no_answer", "Won't answer");
		}
		else if (booleanValue.booleanValue()) {
			return this.iwrb.getLocalizedString("yes", "Yes");
		}
		else {
			return this.iwrb.getLocalizedString("no", "No");
		}
	}

	private void save(IWContext iwc) throws RemoteException {
		boolean saved = false;
		User child = getApplicant(iwc);

		Collection providerCollection = new ArrayList();
		for (int i = 0; i < 5; i++) {
			if (iwc.isParameterSet(PARAMETER_PROVIDER + "_" + (i + 1))) {
				Integer providerID = new Integer(iwc.getParameter(PARAMETER_PROVIDER + "_" + (i + 1)));
				if (providerID.intValue() != -1) {
					providerCollection.add(getChildCareSession(iwc).getProvider(providerID));
				}
			}
		}
		DaycareProvider[] providers = (DaycareProvider[]) providerCollection.toArray(new DaycareProvider[providerCollection.size()]);

		String daytime = iwc.getParameter(PARAMETER_DAYTIME);
		String duration = iwc.getParameter(PARAMETER_DURATION);
		boolean acceptsOtherProviders = new Boolean(iwc.getParameter(PARAMETER_ACCEPTS_OTHER_PROVIDERS)).booleanValue();
		User parent = getUser(iwc);

		try {
			getChildCareService(iwc).storeChildCareApplication(getChildCareSession(iwc).getDaycareApplication(getUser(iwc).getPersonalID(), child.getPersonalID()), child, providers, daytime, duration, acceptsOtherProviders, getChildCareSession(iwc).getAllProviders(), parent, true);
			saved = true;
		}
		catch (DaycareFaultContract dfc) {
			dfc.printStackTrace();
			saved = false;
		}
		catch (RemoteException re) {
			re.printStackTrace();
			saved = false;
		}

		if (saved) {
			getChildCareSession(iwc).setChild(null);
			getChildCareSession(iwc).flushApplications();

			addPhasesReceipt(iwc, this.iwrb.getLocalizedString("application.receipt", "Application receipt"), this.iwrb.getLocalizedString("application.receipt_subject", "Application sent"), this.iwrb.getLocalizedString("application.receipt_body", "Application sent body"), ACTION_SAVE, ACTION_SAVE);

			Layer clearLayer = new Layer(Layer.DIV);
			clearLayer.setStyleClass("Clear");
			add(clearLayer);

			Layer bottom = new Layer(Layer.DIV);
			bottom.setStyleClass("bottom");
			add(bottom);

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
			
			if (getServicePage() != null) {
				Link link = getButtonLink(iwrb.getLocalizedString("service_guarantee", "Service guarantee"));
				link.setPage(getServicePage());
				link.addParameter(PARAMETER_CHILD, child.getPrimaryKey().toString());
				link.setEventListener(ChildCareServiceGuaranteeApplication.class);
				bottom.add(link);
			}
		}
		else {
			add(getPhasesHeader(this.iwrb.getLocalizedString("application.submit_failed", "Application submit failed"), ACTION_SAVE, ACTION_SAVE));
			add(getStopLayer(this.iwrb.getLocalizedString("application.submit_failed", "Application submit failed"), this.iwrb.getLocalizedString("application.submit_failed_info", "Application submit failed")));
		}
	}

	protected boolean saveChildInfo(IWContext iwc, User user) throws RemoteException {
		boolean hasErrors = false;

		String primaryLanguage = iwc.getParameter(PARAMETER_PRIMARY_LANGUAGE);
		String secondaryLanguage = iwc.getParameter(PARAMETER_SECONDARY_LANGUAGE);
		String otherChildCareInformation = iwc.getParameter(PARAMETER_CHILD_CARE_INFORMATION);
		String phone = iwc.isParameterSet(PARAMETER_HOME_PHONE) ? iwc.getParameter(PARAMETER_HOME_PHONE) : null;

		DaycareChild child = getChildCareService(iwc).getDaycareChild(user.getPrimaryKey());
		child.setPrimaryLanguage(primaryLanguage);
		child.setSecondaryLanguage(secondaryLanguage);
		child.store();

		Student student = getSchoolBusiness(iwc).getStudent(user);
		student.setChildCareOtherInformation(otherChildCareInformation);
		student.store();
		
		if (phone != null) {
			getUserBusiness(iwc).updateUserHomePhone(child, phone);
		}

		return !hasErrors;
	}

	protected boolean saveCustodianInfo(IWContext iwc) throws RemoteException {
		boolean hasErrors = false;

		String[] userPKs = iwc.getParameterValues(PARAMETER_USER);
		String[] homePhones = iwc.getParameterValues(PARAMETER_HOME_PHONE);
		String[] workPhones = iwc.getParameterValues(PARAMETER_WORK_PHONE);
		String[] mobilePhones = iwc.getParameterValues(PARAMETER_MOBILE_PHONE);
		String[] emails = iwc.getParameterValues(PARAMETER_EMAIL);
		String[] primaryLanguage = iwc.getParameterValues(PARAMETER_PRIMARY_LANGUAGE);
		String[] secondaryLanguage = iwc.getParameterValues(PARAMETER_SECONDARY_LANGUAGE);

		DaycareChild child = getChildCareService(iwc).getDaycareChild(getApplicant(iwc).getPrimaryKey());

		if (userPKs != null) {
			for (int a = 0; a < userPKs.length; a++) {
				String userPK = userPKs[a];
				String relation = iwc.getParameter(PARAMETER_RELATION + "_" + userPK);
				//String maritalStatus = iwc.getParameter(PARAMETER_MARITAL_STATUS + "_" + userPK);

				if (relation == null || relation.length() == 0) {
					setError(PARAMETER_RELATION, this.iwrb.getLocalizedString("must_select_relation", "You must select a relation to the child."));
					hasErrors = true;
				}
				/*if (maritalStatus == null || maritalStatus.length() == 0) {
					setError(PARAMETER_MARITAL_STATUS, this.iwrb.getLocalizedString("application_error.marital_status_empty", "Please select marital status."));
					hasErrors = true;
				}*/
				if (homePhones[a] == null || homePhones[a].length() == 0) {
					setError(PARAMETER_HOME_PHONE, this.iwrb.getLocalizedString("must_enter_home_phone", "You must enter a home phone for relative."));
					hasErrors = true;
				}
				if (emails[a] == null || emails[a].length() == 0) {
					setError(PARAMETER_EMAIL, this.iwrb.getLocalizedString("must_enter_email", "You must enter an email for relative."));
					hasErrors = true;
				}
				else if (emails[a] != null && !EmailValidator.getInstance().validateEmail(emails[a])) {
					setError(PARAMETER_EMAIL, this.iwrb.getLocalizedString("email_invalid", "You must enter a valid email"));
					hasErrors = true;
				}
				DaycareGuardian custodian = getChildCareService(iwc).getGuardian((new Integer(userPK)));
				custodian.setHomePhone(homePhones[a]);
				custodian.setWorkPhone(workPhones[a]);
				custodian.setMobilePhone(mobilePhones[a]);
				custodian.setEmail(emails[a]);
				//custodian.setMaritalStatus(maritalStatus);
				custodian.setPrimaryLanguage(primaryLanguage[a]);
				if (secondaryLanguage != null) {
					custodian.setSecondaryLanguage(secondaryLanguage[a]);
				}
				custodian.store();

				if (relation != null && relation.length() > 0) {
					child.setRelation(custodian, relation);
					child.store();
				}
			}
		}

		return !hasErrors;
	}

	private int parseAction(IWContext iwc) {
		int action = ACTION_PHASE_1;
		if (iwc.isParameterSet(PARAMETER_ACTION)) {
			action = Integer.parseInt(iwc.getParameter(PARAMETER_ACTION));
		}
		
		return action;
	}

	protected Form createForm(int phase) {
		Form form = new Form();

		if (phase != ACTION_PHASE_1) {
			for (int a = 1; a <= 5; a++) {
				form.maintainParameter(PARAMETER_PROVIDER + "_" + a);
			}
			form.maintainParameter(PARAMETER_DAYTIME);
			form.maintainParameter(PARAMETER_DURATION);
			form.maintainParameter(PARAMETER_ACCEPTS_OTHER_PROVIDERS);
		}
		if (phase != ACTION_PHASE_3) {
			form.maintainParameter(PARAMETER_AGREEMENT);
		}

		return form;
	}

	private DropdownMenu getRelationDropdown(User relative) {
		DropdownMenu relations = new DropdownMenu(PARAMETER_RELATION + (relative != null ? "_" + relative.getPrimaryKey().toString() : ""));
		relations.addMenuElement("", this.iwrb.getLocalizedString("select_relation", "Select relation"));
		relations.addMenuElement(FamilyConstants.RELATION_MOTHER, this.iwrb.getLocalizedString("relation.mother", "Mother"));
		relations.addMenuElement(FamilyConstants.RELATION_FATHER, this.iwrb.getLocalizedString("relation.father", "Father"));
		relations.addMenuElement(FamilyConstants.RELATION_STEPMOTHER, this.iwrb.getLocalizedString("relation.stepmother", "Stepmother"));
		relations.addMenuElement(FamilyConstants.RELATION_STEPFATHER, this.iwrb.getLocalizedString("relation.stepfather", "Stepfather"));
		relations.addMenuElement(FamilyConstants.RELATION_GRANDMOTHER, this.iwrb.getLocalizedString("relation.grandmother", "Grandmother"));
		relations.addMenuElement(FamilyConstants.RELATION_GRANDFATHER, this.iwrb.getLocalizedString("relation.grandfather", "Grandfather"));
		relations.addMenuElement(FamilyConstants.RELATION_SIBLING, this.iwrb.getLocalizedString("relation.sibling", "Sibling"));
		relations.addMenuElement(FamilyConstants.RELATION_OTHER, this.iwrb.getLocalizedString("relation.other", "Other"));

		return relations;
	}

	private DropdownMenu getMaritalStatusDropdown(User user) {
		DropdownMenu maritalStatus = new DropdownMenu(PARAMETER_MARITAL_STATUS + (user != null ? "_" + user.getPrimaryKey().toString() : ""));
		maritalStatus.addMenuElement("", this.iwrb.getLocalizedString("select_marital_status", "Select marital status"));
		maritalStatus.addMenuElement(FamilyConstants.MARITAL_STATUS_MARRIED, this.iwrb.getLocalizedString("marital_status.married", "Married"));
		maritalStatus.addMenuElement(FamilyConstants.MARITAL_STATUS_SINGLE, this.iwrb.getLocalizedString("marital_status.single", "Single"));
		maritalStatus.addMenuElement(FamilyConstants.MARITAL_STATUS_COHABITANT, this.iwrb.getLocalizedString("marital_status.cohabitant", "Cohabitant"));
		maritalStatus.addMenuElement(FamilyConstants.MARITAL_STATUS_DIVORCED, this.iwrb.getLocalizedString("marital_status.divorced", "Divorced"));
		maritalStatus.addMenuElement(FamilyConstants.MARITAL_STATUS_WIDOWED, this.iwrb.getLocalizedString("marital_status.widowed", "Widowed"));
		maritalStatus.setDisabled(true);

		return maritalStatus;
	}

	protected ChildCareRVKService getChildCareService(IWApplicationContext iwac) {
		try {
			return (ChildCareRVKService) IBOLookup.getServiceInstance(iwac, ChildCareRVKService.class);
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

	protected AddressBusiness getAddressBusiness(IWApplicationContext iwac) {
		try {
			return (AddressBusiness) IBOLookup.getServiceInstance(iwac, AddressBusiness.class);
		}
		catch (IBOLookupException ile) {
			throw new IBORuntimeException(ile);
		}
	}

	protected SchoolBusiness getSchoolBusiness(IWApplicationContext iwac) {
		try {
			return (SchoolBusiness) IBOLookup.getServiceInstance(iwac, SchoolBusiness.class);
		}
		catch (IBOLookupException ile) {
			throw new IBORuntimeException(ile);
		}
	}

	protected FamilyLogic getMemberFamilyLogic(IWApplicationContext iwac) {
		try {
			return (FamilyLogic) IBOLookup.getServiceInstance(iwac, FamilyLogic.class);
		}
		catch (IBOLookupException ile) {
			throw new IBORuntimeException(ile);
		}
	}

	protected ChildCareSession getChildCareSession(IWUserContext iwuc) {
		try {
			return (ChildCareSession) IBOLookup.getSessionInstance(iwuc, ChildCareSession.class);
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

	public void setUseSessionUser(boolean useSessionUser) {
		this.iUseSessionUser = useSessionUser;
	}

	private String getSurveyURL() {
		return this.iSurveyURL;
	}

	public void setSurveyURL(String surveyURL) {
		this.iSurveyURL = surveyURL;
	}

	public ICPage getServicePage() {
		return this.iServicePage;
	}
	
	public void setServicePage(ICPage servicePage) {
		this.iServicePage = servicePage;
	}
}