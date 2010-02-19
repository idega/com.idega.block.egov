/*
 * $Id$ Created on May 22, 2006
 * 
 * Copyright (C) 2006 Idega Software hf. All Rights Reserved.
 * 
 * This software is the proprietary information of Idega hf. Use is subject to license terms.
 */
package is.idega.idegaweb.egov.childcare.rvk.business;

import is.idega.block.family.business.FamilyConstants;
import is.idega.idegaweb.egov.accounting.business.CitizenBusiness;
import is.idega.idegaweb.egov.childcare.rvk.data.ChildCareChoice;
import is.idega.idegaweb.egov.childcare.rvk.data.ChildCareChoiceHome;
import is.idega.idegaweb.egov.childcare.rvk.data.ChildCareChoiceProvider;
import is.idega.idegaweb.egov.childcare.rvk.data.ChildCareChoiceProviderHome;
import is.idega.idegaweb.egov.childcare.rvk.data.DaycareChild;
import is.idega.idegaweb.egov.childcare.rvk.data.DaycareChildHome;
import is.idega.idegaweb.egov.childcare.rvk.data.DaycareGuardian;
import is.idega.idegaweb.egov.childcare.rvk.data.DaycareGuardianHome;
import is.idega.idegaweb.egov.childcare.rvk.data.ServiceGuarantee;
import is.idega.idegaweb.egov.childcare.rvk.data.ServiceGuaranteeHome;
import is.idega.idegaweb.egov.childcare.rvk.data.ServiceGuaranteeMonth;
import is.idega.idegaweb.egov.childcare.rvk.data.ServiceGuaranteeMonthHome;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.BankAccount;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.CalendarMonth;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.CaretakerOfTheMonth;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.Child;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareApplication;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareProgram;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareProvider;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareServiceLocator;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareType;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.Guardian;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.IDaycareService;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.IntendedDuration;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.MaritalState;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.MonthlyPaymentAssignment;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.Relationship;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.RequestedDaycareProvider;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.ServiceGuaranteeApplication;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.WhoTakesCareOfChildForThisGuardian;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.ejb.CreateException;
import javax.ejb.FinderException;
import javax.xml.rpc.ServiceException;

import org.apache.axis.types.UnsignedByte;

import com.idega.block.process.business.CaseBusiness;
import com.idega.block.process.business.CaseBusinessBean;
import com.idega.block.process.data.Case;
import com.idega.block.school.business.SchoolBusiness;
import com.idega.block.school.data.School;
import com.idega.business.IBORuntimeException;
import com.idega.core.contact.data.Email;
import com.idega.core.contact.data.Phone;
import com.idega.data.IDOLookup;
import com.idega.data.IDOLookupException;
import com.idega.idegaweb.IWResourceBundle;
import com.idega.user.business.NoEmailFoundException;
import com.idega.user.business.NoPhoneFoundException;
import com.idega.user.data.User;
import com.idega.util.IWTimestamp;
import com.idega.util.text.TextSoap;

public class ChildCareRVKServiceBean extends CaseBusinessBean implements ChildCareRVKService, CaseBusiness {

	@Override
	protected String getBundleIdentifier() {
		return ChildCareConstants.IW_BUNDLE_IDENTIFIER;
	}


	public SchoolBusiness getSchoolBusiness() {
		try {
			return (SchoolBusiness) this.getServiceInstance(SchoolBusiness.class);
		}
		catch (RemoteException e) {
			throw new IBORuntimeException(e.getMessage());
		}
	}

	public CitizenBusiness getUserBusiness() {
		try {
			return (CitizenBusiness) this.getServiceInstance(CitizenBusiness.class);
		}
		catch (RemoteException e) {
			throw new IBORuntimeException(e.getMessage());
		}
	}

	private DaycareChildHome getDaycareChildHome() {
		try {
			return (DaycareChildHome) IDOLookup.getHome(DaycareChild.class);
		}
		catch (IDOLookupException e) {
			throw new IBORuntimeException(e);
		}
	}

	private DaycareGuardianHome getGuardianHome() {
		try {
			return (DaycareGuardianHome) IDOLookup.getHome(DaycareGuardian.class);
		}
		catch (IDOLookupException e) {
			throw new IBORuntimeException(e);
		}
	}

	private ServiceGuaranteeHome getServiceGuaranteeHome() {
		try {
			return (ServiceGuaranteeHome) IDOLookup.getHome(ServiceGuarantee.class);
		}
		catch (IDOLookupException e) {
			throw new IBORuntimeException(e);
		}
	}

	private ServiceGuaranteeMonthHome getServiceGuaranteeMonthHome() {
		try {
			return (ServiceGuaranteeMonthHome) IDOLookup.getHome(ServiceGuaranteeMonth.class);
		}
		catch (IDOLookupException e) {
			throw new IBORuntimeException(e);
		}
	}

	private ChildCareChoiceHome getChildCareChoiceHome() {
		try {
			return (ChildCareChoiceHome) IDOLookup.getHome(ChildCareChoice.class);
		}
		catch (IDOLookupException e) {
			throw new IBORuntimeException(e);
		}
	}

	private ChildCareChoiceProviderHome getChildCareChoiceProviderHome() {
		try {
			return (ChildCareChoiceProviderHome) IDOLookup.getHome(ChildCareChoiceProvider.class);
		}
		catch (IDOLookupException e) {
			throw new IBORuntimeException(e);
		}
	}

	public ChildCareChoice getApplication(User child) {
		try {
			return getChildCareChoiceHome().findApplicationByChild(child);
		}
		catch (FinderException fe) {
			log(fe);
			return null;
		}
	}
	
	public ChildCareChoiceProvider getProviderChoice(ChildCareChoice application, int choiceNumber) {
		try {
			return getChildCareChoiceProviderHome().findByApplicationAndChoiceNumber(application, choiceNumber);
		}
		catch (FinderException fe) {
			log(fe);
			return null;
		}
	}
	
	private Map getAllProviders() {
		Map allProviders = new HashMap();
		
		try {
			short[] postalCodes = getDaycareService().getDistinctPostcodes();
			for (int i = 0; i < postalCodes.length; i++) {
				short postalCode = postalCodes[i];
				
				try {
					DaycareProvider[] providers = getDaycareService().getDaycareProvidersByPostcode(new Short(postalCode));
					allProviders.put(new Short(postalCode), providers);
				}
				catch (RemoteException re) {
					throw new IBORuntimeException(re);
				}
			}
		}
		catch (DaycareFaultContract e) {
			e.printStackTrace();
		}
		catch (RemoteException re) {
			throw new IBORuntimeException(re);
		}
		
		return allProviders;
	}
	
	public void exportChildcareApplications() {
		try {
			System.out.println("[CHILDCARE EXPORT]: Starting export...");
			Collection publicProviders = new ArrayList(Arrays.asList(getDaycareService().getDaycareProvidersByType(DaycareType.PublicDaycare)));
			publicProviders.addAll(Arrays.asList(getDaycareService().getDaycareProvidersByType(DaycareType.PrivateDaycare)));
			Map allProviders = getAllProviders();

			Collection applications = getChildCareChoiceHome().findNonExported();
			System.out.println("[CHILDCARE EXPORT]: Found " + applications.size() + " non-exported applications.");
			Iterator iterator = applications.iterator();
			while (iterator.hasNext()) {
				ChildCareChoice choice = (ChildCareChoice) iterator.next();
				Collection providerChoices = getProviderChoices(choice);
				if (providerChoices.isEmpty()) {
					choice.setExported(true);
					choice.store();
					continue;
				}
				
				try {
					User owner = choice.getOwner();
					User child = choice.getChild();
					
					DaycareApplication application = null;
					try {
						application = getDaycareService().getDaycareApplication(owner.getPersonalID(), child.getPersonalID());
					}
					catch (DaycareFaultContract dfc) {
						dfc.printStackTrace();
						System.out.println("[CHILDCARE EXPORT]: Failed trying to export application for child: " + child.getPersonalID());
						continue;
					}
					
					boolean doExport = true;
					Collection daycareProviders = new ArrayList();
					Iterator iterator2 = providerChoices.iterator();
					while (iterator2.hasNext()) {
						ChildCareChoiceProvider provider = (ChildCareChoiceProvider) iterator2.next();
						School chosenProvider = provider.getProvider();
						
						boolean foundProvider = false;
						Iterator iterator3 = publicProviders.iterator();
						while (iterator3.hasNext()) {
							DaycareProvider daycareProvider = (DaycareProvider) iterator3.next();
							if (chosenProvider.getName().equals(daycareProvider.getName())) {
								daycareProviders.add(daycareProvider);
								foundProvider = true;
								break;
							}
						}
						
						if (!foundProvider) {
							System.out.println("[CHILDCARE EXPORT]: Could not find DaycareProvider entry for: " + chosenProvider.getName() + " (" + chosenProvider.getPrimaryKey().toString() + ")");
							doExport = false;
						}
					}
					
					if (doExport) {
						try {
							storeChildCareApplication(application, new IWTimestamp(choice.getCreated()).getCalendar(), child, (DaycareProvider[]) daycareProviders.toArray(new DaycareProvider[daycareProviders.size()]), choice.getDaytime(), choice.getDuration(), choice.acceptsOtherProviders(), allProviders, owner, true);
							choice.setExported(true);
							choice.store();
							
							System.out.println("[CHILDCARE EXPORT]: Exported application for child: " + child.getPersonalID());
						}
						catch (DaycareFaultContract dcf) {
							dcf.printStackTrace();
							
							System.out.println("[CHILDCARE EXPORT]: Failed trying to export application for child: " + child.getPersonalID());
						}
					}
				}
				catch (DaycareFaultContract dcf) {
					dcf.printStackTrace();
				}
			}
		}
		catch (FinderException fe) {
			fe.printStackTrace();
		}
		catch (RemoteException re) {
			throw new IBORuntimeException(re);
		}

		System.out.println("[CHILDCARE EXPORT]: Export done...");
	}

	public void storeChildCareApplication(DaycareApplication application, User child, DaycareProvider[] providers, String daytime, String duration, boolean acceptsOtherProviders, Map allProviders, User performer, boolean isPublic) throws RemoteException, DaycareFaultContract {
		storeChildCareApplication(application, null, child, providers, daytime, duration, acceptsOtherProviders, allProviders, performer, isPublic);
	}
	
	public void storeChildCareApplication(DaycareApplication application, Calendar date, User child, DaycareProvider[] providers, String daytime, String duration, boolean acceptsOtherProviders, Map allProviders, User performer, boolean isPublic) throws RemoteException, DaycareFaultContract {
		if (duration != null) {
			application.setIntendedDuration(IntendedDuration.fromString(duration));
		}
		if (daytime != null) {
			application.setProgram(DaycareProgram.fromString(daytime));
		}
		if (date != null) {
			application.setDateOfApplication(date);
			application.setDateOfLastChange(date);
		}
		application.setWillAcceptAlternativeProviders(new Boolean(acceptsOtherProviders));
		
		DaycareChild daycareChild = getDaycareChild(child.getPrimaryKey());
		Phone mainPhone = null;
		try {
			mainPhone = getUserBusiness().getUsersHomePhone(daycareChild);
		}
		catch (NoPhoneFoundException e1) {
			//No phone found...
		}
		
		Child careChild = application.getChild();
		if (daycareChild.getPrimaryLanguage() != null) {
			careChild.setLanguageCode1(daycareChild.getPrimaryLanguage());
		}
		else {
			careChild.setLanguageCode1("ice");
		}
		if (daycareChild.getSecondaryLanguage() != null) {
			careChild.setLanguageCode2(daycareChild.getSecondaryLanguage());
		}
		if (mainPhone != null) {
			careChild.setMainPhoneNumber(mainPhone.getNumber());
		}
		application.setChild(careChild);
		
		Guardian[] guardians = application.getGuardians();
		for (int i = 0; i < guardians.length; i++) {
			Guardian guardian = guardians[i];
			try {
				DaycareGuardian parent = getGuardian(getUserBusiness().getUser(guardian.getPersonIdentificationNumber()).getPrimaryKey());

				Phone homePhone = null;
				try {
					homePhone = parent.getHomePhone();
				}
				catch (NoPhoneFoundException e) {
					//No phone found...
				}
				
				Phone workPhone = null;
				try {
					workPhone = parent.getWorkPhone();
				}
				catch (NoPhoneFoundException e) {
					//No phone found...
				}
				
				Phone mobilePhone = null;
				try {
					mobilePhone = parent.getMobilePhone();
				}
				catch (NoPhoneFoundException e) {
					//No phone found...
				}
				
				Email email = null;
				try {
					email = parent.getEmail();
				}
				catch (NoEmailFoundException e) {
					//No email found...
				}
				
				/*if (parent.getMaritalStatus() != null) {
					if (!guardian.getMaritalState().equals(getMaritalState(parent.getMaritalStatus()))) {
						System.out.println("[CHILDCARE] Martial status mismatch: " + guardian.getMaritalState().getValue() + " != " + getMaritalState(parent.getMaritalStatus()).getValue() + " for personal ID = " + parent.getPersonalID());
					}
					//guardian.setMaritalState(getMaritalState(parent.getMaritalStatus()));
				}*/
				if (daycareChild.getRelation(parent) != null) {
					guardian.setRelationship(getRelationship(daycareChild.getRelation(parent)));
				}
				if (email != null) {
					guardian.setEmailAddress(email.getEmailAddress());
				}
				if (homePhone != null) {
					guardian.setHomePhoneNumber(homePhone.getNumber());
				}
				if (workPhone != null) {
					guardian.setWorkPhoneNumber(workPhone.getNumber());
				}
				if (mobilePhone != null) {
					guardian.setMobilePhoneNumber(mobilePhone.getNumber());
				}
				if (parent.getPrimaryLanguage() != null) {
					guardian.setLanguageCode1(parent.getPrimaryLanguage());
				}
				else {
					guardian.setLanguageCode1("ice");
				}
				if (parent.getSecondaryLanguage() != null) {
					guardian.setLanguageCode2(parent.getSecondaryLanguage());
				}
				
				guardians[i] = guardian;
			}
			catch (FinderException fe) {
				fe.printStackTrace();
			}
		}
		application.setGuardians(guardians);
		
		Collection requestedProviders = new ArrayList();
		for (int i = 0; i < providers.length; i++) {
			DaycareProvider provider = providers[i];
			
			RequestedDaycareProvider requestedProvider = new RequestedDaycareProvider(provider.getDaycareProviderID(), provider.getName(), provider.getPostcode(), new Short((short) (i + 1)));
			requestedProviders.add(requestedProvider);
		}
		
		RequestedDaycareProvider[] oldProviders = application.getRequestedDaycareProviders();
		if (isPublic && oldProviders != null) {
			for (int i = 0; i < oldProviders.length; i++) {
				RequestedDaycareProvider requestedDaycareProvider = oldProviders[i];
				DaycareProvider oldProvider = getProvider(allProviders, requestedDaycareProvider.getDaycareProviderID());
				if (!oldProvider.getType().equals(DaycareType.PublicDaycare)) {
					requestedDaycareProvider.setRanking(new Short((short) (requestedProviders.size() + 1)));
					requestedProviders.add(requestedDaycareProvider);
				}
			}
		}
		
		application.setRequestedDaycareProviders((RequestedDaycareProvider[]) requestedProviders.toArray(new RequestedDaycareProvider[requestedProviders.size()]));
		
		getDaycareService().submitDaycareApplication(performer.getPersonalID(), application);
		
		if (date == null) {
			ChildCareChoice choice = null;
			try {
				choice = getChildCareChoiceHome().findApplicationByChild(daycareChild);
			}
			catch (FinderException fe) {
				try {
					choice = getChildCareChoiceHome().create();
				}
				catch (CreateException ce) {
					ce.printStackTrace();
				}
			}
			
			if (choice != null) {
				choice.setAcceptsOtherProviders(acceptsOtherProviders);
				choice.setDaytime(daytime);
				choice.setDuration(duration);
				choice.setChild(daycareChild);
				choice.setOwner(performer);
				choice.setExported(true);
				
				changeCaseStatus(choice, getCaseStatusOpen(), performer);
			}
		}
	}
	
	public DaycareProvider getProvider(Map allProviders, Integer ID) {
		if (allProviders == null) {
			allProviders = getAllProviders();
		}
		Iterator iterator = allProviders.values().iterator();
		while (iterator.hasNext()) {
			DaycareProvider[] providers = (DaycareProvider[]) iterator.next();
			for (int i = 0; i < providers.length; i++) {
				DaycareProvider daycareProvider = providers[i];
				if (daycareProvider.getDaycareProviderID().equals(ID)) {
					return daycareProvider;
				}
			}
		}
		
		return null;
	}
	
	public Collection getProviders() {
		try {
			return getSchoolBusiness().findAllSchoolsByCategory(getSchoolBusiness().getCategoryChildcare().getCategory());
		}
		catch (RemoteException re) {
			throw new IBORuntimeException(re);
		}
	}
	
	public ServiceGuarantee getApplicationForChild(User child) {
		try {
			return getServiceGuaranteeHome().findByChild(child);
		}
		catch (FinderException fe) {
			log(fe);
			return null;
		}
	}
	
	public Collection getProviderChoices(ChildCareChoice choice) {
		try {
			return getChildCareChoiceProviderHome().findByApplication(choice);
		}
		catch (FinderException e) {
			e.printStackTrace();
			return new ArrayList();
		}
	}
	
	public ServiceGuaranteeMonth getMonthForChild(User child, int month, int year) {
		try {
			return getServiceGuaranteeMonthHome().findByChildAndMonthAndYear(child, month, year);
		}
		catch (FinderException fe) {
			log(fe);
			return null;
		}
	}
	
	public Collection getMonthsByApplication(ServiceGuarantee application) {
		try {
			return getServiceGuaranteeMonthHome().findAllByApplication(application);
		}
		catch (FinderException fe) {
			log(fe);
			return new ArrayList();
		}
	}
	
	public DaycareChild getDaycareChild(Object pk) {
		try {
			return getDaycareChildHome().findByPrimaryKey(pk);
		}
		catch (FinderException fe) {
			fe.printStackTrace();
			return null;
		}
	}
	
	public DaycareGuardian getGuardian(Object pk) {
		try {
			return getGuardianHome().findByPrimaryKey(pk);
		}
		catch (FinderException fe) {
			fe.printStackTrace();
			return null;
		}
	}
	
	public void exportServiceGuarantees() {
		try {
			System.out.println("[SERVICEGUARANTEE EXPORT]: Starting export...");

			Collection guarantees = getServiceGuaranteeHome().findNonExported();
			System.out.println("[SERVICEGUARANTEE EXPORT]: Found " + guarantees.size() + " non-exported service guarantees.");

			Iterator iterator = guarantees.iterator();
			while (iterator.hasNext()) {
				ServiceGuarantee guarantee = (ServiceGuarantee) iterator.next();
				User child = guarantee.getChild();
				User owner = guarantee.getOwner();
				try {
					Collection months = getMonthsByApplication(guarantee);
					if (months.isEmpty()) {
						guarantee.setExported(true);
						guarantee.store();
						continue;
					}
					
					DaycareApplication daycareApplication = null;
					ServiceGuaranteeApplication application = null;
					try {
						daycareApplication = getDaycareService().getDaycareApplication(owner.getPersonalID(), child.getPersonalID());
						application = getDaycareService().getServiceGuaranteeApplication(owner.getPersonalID(), child.getPersonalID());
					}
					catch (DaycareFaultContract dfc) {
						dfc.printStackTrace();
						System.out.println("[SERVICEGUARANTEE EXPORT]: Failed trying to export application for child: " + child.getPersonalID());
						continue;
					}
					
					String guardian1 = "";
					String guardian2 = "";
					String caretakerReceiver = "";
					Guardian[] parents = daycareApplication.getGuardians();
					List parentList = new ArrayList();
					for (int i = 0; i < parents.length; i++) {
						Guardian guardian = parents[i];
						DaycareGuardian parent = null;
						try {
							parent = getGuardian(getUserBusiness().getUser(guardian.getPersonIdentificationNumber()).getPrimaryKey());
							if (parent.isCaretakerReceiver()) {
								caretakerReceiver = parent.getPersonalID();
							}
							if (i == 0) {
								guardian1 = parent.getPersonalID();
							}
							else if (i == 1) {
								guardian2 = parent.getPersonalID();
							}
						}
						catch (FinderException fe) {
							log(fe);
						}
						parentList.add(parent);
					}
					
					boolean hasCaretaker = false;
					Map monthMap = new HashMap();
					Iterator iterator2 = months.iterator();
					while (iterator2.hasNext()) {
						ServiceGuaranteeMonth month = (ServiceGuaranteeMonth) iterator2.next();
						String receiver = TextSoap.findAndCut(TextSoap.capitalize(month.getReceiver()), "_");
						if (receiver.equals(CaretakerOfTheMonth._Caretaker)) {
							receiver = caretakerReceiver;
							hasCaretaker = true;
						}
						else if (receiver.equals(CaretakerOfTheMonth._Guardian1)) {
							receiver = guardian1;
						}
						else if (receiver.equals(CaretakerOfTheMonth._Guardian2)) {
							receiver = guardian2;
						}
						
						Collection paymentMonths = (Collection) monthMap.get(receiver);
						if (paymentMonths == null) {
							paymentMonths = new ArrayList();
						}
						paymentMonths.add(new IWTimestamp(1, month.getMonth(), month.getYear()));
						
						monthMap.put(receiver, paymentMonths);
					}
					
					Map caretakerMap = new HashMap();
					Iterator iterator3 = parentList.iterator();
					while (iterator3.hasNext()) {
						DaycareGuardian parent = (DaycareGuardian) iterator3.next();
						caretakerMap.put(parent.getPrimaryKey(), hasCaretaker ? WhoTakesCareOfChildForThisGuardian._Both : WhoTakesCareOfChildForThisGuardian._Guardian);
					}
	
					try {
						storeServiceGuarantee(application, new IWTimestamp(guarantee.getCreated()).getCalendar(), null, child, parentList, null, monthMap, caretakerMap, owner);
						guarantee.setExported(true);
						guarantee.store();
						
						System.out.println("[SERVICEGUARANTEE EXPORT]: Exported application for child: " + child.getPersonalID());
					}
					catch (DaycareFaultContract dfc) {
						System.out.println("[SERVICEGUARANTEE EXPORT] - ERROR:");
						System.out.println("     - ErrorField: " + dfc.getErrorField());
						System.out.println("     - ErrorCode: " + dfc.getErrorCode().getValue());
						System.out.println("     - ErrorMessage: " + dfc.getErrorMessage());
						
						System.out.println("[SERVICEGUARANTEE EXPORT]: Failed trying to export application for child: " + child.getPersonalID());
					}
				}
				catch (DaycareFaultContract dfc) {
					dfc.printStackTrace();
				}
				catch (RemoteException re) {
					throw new IBORuntimeException(re);
				}
			}
		}
		catch (FinderException e) {
			e.printStackTrace();
		}

		System.out.println("[SERVICEGUARANTEE EXPORT]: Export done...");
	}

	public void storeServiceGuarantee(ServiceGuaranteeApplication application, User child, List custodians, BankAccount bankAccount, Map monthMap, Map caretakerMap, User performer) throws DaycareFaultContract, RemoteException {
		storeServiceGuarantee(application, null, null, child, custodians, bankAccount, monthMap, caretakerMap, performer);
	}
	
	public void storeServiceGuarantee(ServiceGuaranteeApplication application, Calendar date, Calendar changeDate, User child, List custodians, BankAccount bankAccount, Map monthMap, Map caretakerMap, User performer) throws DaycareFaultContract, RemoteException {
		Collection paymentPlan = new ArrayList();
		Iterator iterator = monthMap.keySet().iterator();
		while (iterator.hasNext()) {
			String receiver = (String) iterator.next();
			Collection values = (Collection) monthMap.get(receiver);
			
			Iterator iterator2 = values.iterator();
			while (iterator2.hasNext()) {
				IWTimestamp stamp = (IWTimestamp) iterator2.next();
				
				MonthlyPaymentAssignment assignment = new MonthlyPaymentAssignment(getCalendarMonth(stamp.getMonth()), receiver, new Short((short) stamp.getYear()));
				paymentPlan.add(assignment);
			}
		}
		
		if (application == null) {
			application = new ServiceGuaranteeApplication();
		}
		if (date != null) {
			Calendar oldDate = application.getDateOfApplication();
			if (!oldDate.getTime().equals(date.getTime())) {
				application.setDateOfApplication(date);
			}
		}
		if (changeDate != null) {
			application.setDateOfLastChange(changeDate);
		}
		
		Collection duplicates = new ArrayList();
		Collection planCollection = new ArrayList();
		MonthlyPaymentAssignment[] oldPlans = application.getPaymentPlan();
		if (oldPlans != null) {
			planCollection.addAll(Arrays.asList(oldPlans));
		}
		
		Iterator iterator2 = paymentPlan.iterator();
		while (iterator2.hasNext()) {
			MonthlyPaymentAssignment assignment = (MonthlyPaymentAssignment) iterator2.next();
			
			Iterator iterator3 = planCollection.iterator();
			while (iterator3.hasNext()) {
				MonthlyPaymentAssignment oldAssignment = (MonthlyPaymentAssignment) iterator3.next();
				if (assignment.getMonth().equals(oldAssignment.getMonth()) && assignment.getYear().equals(oldAssignment.getYear())) {
					duplicates.add(oldAssignment);
				}
			}
		}
		
		IWTimestamp stampNow = new IWTimestamp();
		iterator2 = planCollection.iterator();
		while (iterator2.hasNext()) {
			MonthlyPaymentAssignment oldAssignment = (MonthlyPaymentAssignment) iterator2.next();
			if (oldAssignment.getYear().intValue() < stampNow.getYear()) {
				continue;
			}
			else if (oldAssignment.getYear().intValue() == stampNow.getYear() && getMonth(oldAssignment.getMonth()) < stampNow.getMonth()) {
				continue;
			}
			
			boolean hasMonth = false;
			Iterator iterator3 = paymentPlan.iterator();
			while (iterator3.hasNext()) {
				MonthlyPaymentAssignment assignment = (MonthlyPaymentAssignment) iterator3.next();
				if (assignment.getMonth().equals(oldAssignment.getMonth()) && assignment.getYear().equals(oldAssignment.getYear())) {
					hasMonth = true;
				}
			}
			
			if (!hasMonth) {
				duplicates.add(oldAssignment);
			}
		}
		
		planCollection.removeAll(duplicates);
		planCollection.addAll(paymentPlan);
		
		MonthlyPaymentAssignment[] plans = (MonthlyPaymentAssignment[]) planCollection.toArray(new MonthlyPaymentAssignment[planCollection.size()]);
		application.setPaymentPlan(plans);
		application.setPersonIdentificationNumberOfChild(child.getPersonalID());
		
		int count = 1;
		iterator2 = custodians.iterator();
		while (iterator2.hasNext()) {
			User custodian = (User) iterator2.next();
			String careTaker = (String) caretakerMap.get(custodian.getPrimaryKey());
			if (careTaker == null) {
				careTaker = WhoTakesCareOfChildForThisGuardian._Guardian;
			}
			WhoTakesCareOfChildForThisGuardian caretaker = WhoTakesCareOfChildForThisGuardian.fromString(careTaker);

			if (count == 1) {
				application.setPersonIdentificationNumberOfGuardian1(custodian.getPersonalID());
				if (bankAccount != null && custodian.equals(performer)) {
					application.setBankAccountOfGuardian1(bankAccount);
				}
				/*else if (bankAccount == null) {
					DaycareGuardian guardian = getGuardian(custodian.getPrimaryKey());
					if (guardian.getAccountNumber() != null) {
						application.setBankAccountOfGuardian1(getBankAccount(guardian.getAccountNumber()));
					}
				}*/
				application.setWhoTakesCareOfChildForGuardian1(caretaker);				
			}
			if (count == 2) {
				application.setPersonIdentificationNumberOfGuardian2(custodian.getPersonalID());
				if (bankAccount != null && custodian.equals(performer)) {
					application.setBankAccountOfGuardian2(bankAccount);
				}
				/*else if (bankAccount == null) {
					DaycareGuardian guardian = getGuardian(custodian.getPrimaryKey());
					if (guardian.getAccountNumber() != null) {
						application.setBankAccountOfGuardian2(getBankAccount(guardian.getAccountNumber()));
					}
				}*/
				application.setWhoTakesCareOfChildForGuardian2(caretaker);				
			}
			
			count++;
		}

		getDaycareService().submitServiceGuaranteeApplication(performer.getPersonalID(), application);
		
		if (date == null) {
			ServiceGuarantee guarantee = null;
			try {
				guarantee = getServiceGuaranteeHome().findByChild(child);
			}
			catch (FinderException fe) {
				try {
					guarantee = getServiceGuaranteeHome().create();
				}
				catch (CreateException ce) {
					ce.printStackTrace();
				}
			}
			
			if (guarantee != null) {
				guarantee.setChild(child);
				guarantee.setOwner(performer);
				guarantee.setExported(true);
				
				changeCaseStatus(guarantee, getCaseStatusOpen(), performer);
			}
		}
	}
	
	public BankAccount getBankAccount(String accountNumber) {
		BankAccount bankAccount = new BankAccount();
		bankAccount.setBankID(new Short(accountNumber.substring(0, accountNumber.indexOf("-"))));
		bankAccount.setLedger(new UnsignedByte(accountNumber.substring(accountNumber.indexOf("-") + 1, accountNumber.lastIndexOf("-"))));
		bankAccount.setAccountNumber(new Integer(accountNumber.substring(accountNumber.lastIndexOf("-") + 1)));
		
		return bankAccount;
	}
	
	public CalendarMonth getCalendarMonth(int month) {
		CalendarMonth calendarMonth = null;
		switch (month) {
			case 1:
				calendarMonth = CalendarMonth.January;
				break;
			case 2:
				calendarMonth = CalendarMonth.February;
				break;
			case 3:
				calendarMonth = CalendarMonth.March;
				break;
			case 4:
				calendarMonth = CalendarMonth.April;
				break;
			case 5:
				calendarMonth = CalendarMonth.May;
				break;
			case 6:
				calendarMonth = CalendarMonth.June;
				break;
			case 7:
				calendarMonth = CalendarMonth.July;
				break;
			case 8:
				calendarMonth = CalendarMonth.August;
				break;
			case 9:
				calendarMonth = CalendarMonth.September;
				break;
			case 10:
				calendarMonth = CalendarMonth.October;
				break;
			case 11:
				calendarMonth = CalendarMonth.November;
				break;
			case 12:
				calendarMonth = CalendarMonth.December;
				break;
		}
		
		return calendarMonth;
	}

	public int getMonth(CalendarMonth month) {
		if (month.equals(CalendarMonth.January)) {
			return 1;
		}
		else if (month.equals(CalendarMonth.February)) {
			return 2;
		}
		else if (month.equals(CalendarMonth.March)) {
			return 3;
		}
		else if (month.equals(CalendarMonth.April)) {
			return 4;
		}
		else if (month.equals(CalendarMonth.May)) {
			return 5;
		}
		else if (month.equals(CalendarMonth.June)) {
			return 6;
		}
		else if (month.equals(CalendarMonth.July)) {
			return 7;
		}
		else if (month.equals(CalendarMonth.August)) {
			return 8;
		}
		else if (month.equals(CalendarMonth.September)) {
			return 9;
		}
		else if (month.equals(CalendarMonth.October)) {
			return 10;
		}
		else if (month.equals(CalendarMonth.November)) {
			return 11;
		}
		else if (month.equals(CalendarMonth.December)) {
			return 12;
		}
		
		return 0;
	}

	@Override
	public String getLocalizedCaseDescription(Case theCase, Locale locale) {
		IWResourceBundle iwrb = getBundle().getResourceBundle(locale);
		return iwrb.getLocalizedString("case_code_key." + theCase.getCode(), theCase.getCode());
	}
	
	public IDaycareService getDaycareService() {
		try {
			String endpoint = this.getIWApplicationContext().getApplicationSettings().getProperty("is.marimo.webservice.url", "http://10.7.250.41/DaycareWebService/DaycareService.svc");
			
			DaycareServiceLocator locator = new DaycareServiceLocator();
			return locator.getBasicHttpBinding_IDaycareService(new URL(endpoint));
		}
		catch (ServiceException se) {
			se.printStackTrace();
			return null;
		}
		catch (MalformedURLException mue) {
			mue.printStackTrace();
			return null;
		}
	}
	
	public String getRelationship(Relationship relation) {
		if (relation.getValue().equals(Relationship._Father)) {
			return FamilyConstants.RELATION_FATHER;
		}
		else if (relation.getValue().equals(Relationship._Grandfather)) {
			return FamilyConstants.RELATION_GRANDFATHER;
		}
		else if (relation.getValue().equals(Relationship._Grandmother)) {
			return FamilyConstants.RELATION_GRANDMOTHER;
		}
		else if (relation.getValue().equals(Relationship._Mother)) {
			return FamilyConstants.RELATION_MOTHER;
		}
		else if (relation.getValue().equals(Relationship._OtherRelationship)) {
			return FamilyConstants.RELATION_OTHER;
		}
		else if (relation.getValue().equals(Relationship._Sibling)) {
			return FamilyConstants.RELATION_SIBLING;
		}
		else if (relation.getValue().equals(Relationship._Stepfather)) {
			return FamilyConstants.RELATION_STEPFATHER;
		}
		else if (relation.getValue().equals(Relationship._Stepmother)) {
			return FamilyConstants.RELATION_STEPMOTHER;
		}
		else {
			return null;
		}
	}

	public Relationship getRelationship(String relation) {
		if (relation.equals(FamilyConstants.RELATION_FATHER)) {
			return Relationship.Father;
		}
		else if (relation.equals(FamilyConstants.RELATION_GRANDFATHER)) {
			return Relationship.Grandfather;
		}
		else if (relation.equals(FamilyConstants.RELATION_GRANDMOTHER)) {
			return Relationship.Grandmother;
		}
		else if (relation.equals(FamilyConstants.RELATION_MOTHER)) {
			return Relationship.Mother;
		}
		else if (relation.equals(FamilyConstants.RELATION_OTHER)) {
			return Relationship.OtherRelationship;
		}
		else if (relation.equals(FamilyConstants.RELATION_SIBLING)) {
			return Relationship.Sibling;
		}
		else if (relation.equals(FamilyConstants.RELATION_STEPFATHER)) {
			return Relationship.Stepfather;
		}
		else if (relation.equals(FamilyConstants.RELATION_STEPMOTHER)) {
			return Relationship.Stepmother;
		}
		else {
			return Relationship.Unknown;
		}
	}
	
	public String getMaritalStatus(MaritalState state) {
		if (state.getValue().equals(MaritalState._MarriedOrLivingTogether)) {
			return FamilyConstants.MARITAL_STATUS_MARRIED;
		}
		else if (state.getValue().equals(MaritalState._Single)) {
			return FamilyConstants.MARITAL_STATUS_SINGLE;
		}
		else {
			return null;
		}
	}
	
	public MaritalState getMaritalState(String status) {
		if (status.equals(FamilyConstants.MARITAL_STATUS_COHABITANT) || status.equals(FamilyConstants.MARITAL_STATUS_MARRIED)) {
			return MaritalState.MarriedOrLivingTogether;
		}
		else if (status.equals(FamilyConstants.MARITAL_STATUS_SINGLE) || status.equals(FamilyConstants.MARITAL_STATUS_DIVORCED) || status.equals(FamilyConstants.MARITAL_STATUS_WIDOWED)) {
			return MaritalState.Single;			
		}
		else {
			return MaritalState.Unknown;
		}
	}
	
	public String formatBankAccount(String accountNumber) {
		if (accountNumber.length() == 12) {
			accountNumber = accountNumber.substring(0, 4) + "-" + accountNumber.substring(4, 6) + "-" + accountNumber.substring(6);
		}
		
		return accountNumber;
	}
}