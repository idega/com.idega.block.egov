package is.idega.idegaweb.egov.childcare.rvk.business;


import com.idega.block.process.business.CaseBusiness;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.IDaycareService;
import is.idega.idegaweb.egov.childcare.rvk.data.DaycareGuardian;
import com.idega.block.process.data.Case;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.BankAccount;
import is.idega.idegaweb.egov.childcare.rvk.data.ChildCareChoice;
import com.idega.business.IBOService;
import java.util.Calendar;
import is.idega.idegaweb.egov.childcare.rvk.data.DaycareChild;
import java.util.List;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.MaritalState;
import is.idega.idegaweb.egov.childcare.rvk.data.ServiceGuaranteeMonth;
import is.idega.idegaweb.egov.childcare.rvk.data.ChildCareChoiceProvider;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.Relationship;
import java.util.Map;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.ServiceGuaranteeApplication;
import is.idega.idegaweb.egov.accounting.business.CitizenBusiness;
import com.idega.user.data.User;
import java.rmi.RemoteException;
import java.util.Locale;
import java.util.Collection;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareProvider;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareApplication;
import com.idega.block.school.business.SchoolBusiness;
import is.idega.idegaweb.egov.childcare.rvk.data.ServiceGuarantee;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.CalendarMonth;

public interface ChildCareRVKService extends IBOService, CaseBusiness {

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.business.ChildCareRVKServiceBean#getSchoolBusiness
	 */
	public SchoolBusiness getSchoolBusiness() throws RemoteException;

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.business.ChildCareRVKServiceBean#getUserBusiness
	 */
	public CitizenBusiness getUserBusiness() throws RemoteException;

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.business.ChildCareRVKServiceBean#getApplication
	 */
	public ChildCareChoice getApplication(User child) throws RemoteException;

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.business.ChildCareRVKServiceBean#getProviderChoice
	 */
	public ChildCareChoiceProvider getProviderChoice(ChildCareChoice application, int choiceNumber) throws RemoteException;

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.business.ChildCareRVKServiceBean#exportChildcareApplications
	 */
	public void exportChildcareApplications() throws RemoteException;

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.business.ChildCareRVKServiceBean#storeChildCareApplication
	 */
	public void storeChildCareApplication(DaycareApplication application, User child, DaycareProvider[] providers, String daytime, String duration, boolean acceptsOtherProviders, Map allProviders, User performer, boolean isPublic) throws RemoteException, DaycareFaultContract, RemoteException;

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.business.ChildCareRVKServiceBean#storeChildCareApplication
	 */
	public void storeChildCareApplication(DaycareApplication application, Calendar date, User child, DaycareProvider[] providers, String daytime, String duration, boolean acceptsOtherProviders, Map allProviders, User performer, boolean isPublic) throws RemoteException, DaycareFaultContract, RemoteException;

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.business.ChildCareRVKServiceBean#getProvider
	 */
	public DaycareProvider getProvider(Map allProviders, Integer ID) throws RemoteException;

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.business.ChildCareRVKServiceBean#getProviders
	 */
	public Collection getProviders() throws RemoteException;

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.business.ChildCareRVKServiceBean#getApplicationForChild
	 */
	public ServiceGuarantee getApplicationForChild(User child) throws RemoteException;

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.business.ChildCareRVKServiceBean#getProviderChoices
	 */
	public Collection getProviderChoices(ChildCareChoice choice) throws RemoteException;

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.business.ChildCareRVKServiceBean#getMonthForChild
	 */
	public ServiceGuaranteeMonth getMonthForChild(User child, int month, int year) throws RemoteException;

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.business.ChildCareRVKServiceBean#getMonthsByApplication
	 */
	public Collection getMonthsByApplication(ServiceGuarantee application) throws RemoteException;

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.business.ChildCareRVKServiceBean#getDaycareChild
	 */
	public DaycareChild getDaycareChild(Object pk) throws RemoteException;

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.business.ChildCareRVKServiceBean#getGuardian
	 */
	public DaycareGuardian getGuardian(Object pk) throws RemoteException;

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.business.ChildCareRVKServiceBean#exportServiceGuarantees
	 */
	public void exportServiceGuarantees() throws RemoteException;

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.business.ChildCareRVKServiceBean#storeServiceGuarantee
	 */
	public void storeServiceGuarantee(ServiceGuaranteeApplication application, User child, List custodians, BankAccount bankAccount, Map monthMap, Map caretakerMap, User performer) throws DaycareFaultContract, RemoteException, RemoteException;

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.business.ChildCareRVKServiceBean#storeServiceGuarantee
	 */
	public void storeServiceGuarantee(ServiceGuaranteeApplication application, Calendar date, Calendar changeDate, User child, List custodians, BankAccount bankAccount, Map monthMap, Map caretakerMap, User performer) throws DaycareFaultContract, RemoteException, RemoteException;

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.business.ChildCareRVKServiceBean#getBankAccount
	 */
	public BankAccount getBankAccount(String accountNumber) throws RemoteException;

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.business.ChildCareRVKServiceBean#getCalendarMonth
	 */
	public CalendarMonth getCalendarMonth(int month) throws RemoteException;

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.business.ChildCareRVKServiceBean#getLocalizedCaseDescription
	 */
	public String getLocalizedCaseDescription(Case theCase, Locale locale) throws RemoteException;

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.business.ChildCareRVKServiceBean#getDaycareService
	 */
	public IDaycareService getDaycareService() throws RemoteException;

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.business.ChildCareRVKServiceBean#getRelationship
	 */
	public String getRelationship(Relationship relation) throws RemoteException;

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.business.ChildCareRVKServiceBean#getRelationship
	 */
	public Relationship getRelationship(String relation) throws RemoteException;

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.business.ChildCareRVKServiceBean#getMaritalStatus
	 */
	public String getMaritalStatus(MaritalState state) throws RemoteException;

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.business.ChildCareRVKServiceBean#getMaritalState
	 */
	public MaritalState getMaritalState(String status) throws RemoteException;

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.business.ChildCareRVKServiceBean#formatBankAccount
	 */
	public String formatBankAccount(String accountNumber) throws RemoteException;
}