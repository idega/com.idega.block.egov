package is.idega.idegaweb.egov.childcare.rvk.business;


import is.idega.idegaweb.egov.childcare.rvk.webservice.client.ISO_639_2;
import java.util.Collection;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.ServiceGuaranteeApplication;
import java.util.Map;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareProvider;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareApplication;
import com.idega.user.data.User;
import com.idega.business.IBOSession;
import java.rmi.RemoteException;

public interface ChildCareSession extends IBOSession {

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.business.ChildCareSessionBean#getChild
	 */
	public User getChild() throws RemoteException;

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.business.ChildCareSessionBean#setChild
	 */
	public void setChild(Object userPK) throws RemoteException;

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.business.ChildCareSessionBean#getPublicPostalCodes
	 */
	public short[] getPublicPostalCodes() throws RemoteException;

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.business.ChildCareSessionBean#getPostalCodes
	 */
	public short[] getPostalCodes() throws RemoteException;

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.business.ChildCareSessionBean#getAllProviders
	 */
	public Map getAllProviders() throws RemoteException;

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.business.ChildCareSessionBean#getPublicProviders
	 */
	public Map getPublicProviders() throws RemoteException;

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.business.ChildCareSessionBean#getPrivateProviders
	 */
	public Map getPrivateProviders() throws RemoteException;

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.business.ChildCareSessionBean#getAllPublicProviders
	 */
	public Collection getAllPublicProviders() throws RemoteException;

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.business.ChildCareSessionBean#getAllPrivateProviders
	 */
	public Collection getAllPrivateProviders() throws RemoteException;

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.business.ChildCareSessionBean#getNannyProviders
	 */
	public Map getNannyProviders() throws RemoteException;

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.business.ChildCareSessionBean#getAllNannyProviders
	 */
	public Collection getAllNannyProviders() throws RemoteException;

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.business.ChildCareSessionBean#getProvider
	 */
	public DaycareProvider getProvider(Integer ID) throws RemoteException;

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.business.ChildCareSessionBean#getDaycareApplication
	 */
	public DaycareApplication getDaycareApplication(String parentPersonalID, String personalID) throws RemoteException;

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.business.ChildCareSessionBean#getServiceGuaranteeApplication
	 */
	public ServiceGuaranteeApplication getServiceGuaranteeApplication(String parentPersonalID, String personalID) throws RemoteException;

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.business.ChildCareSessionBean#getISOCodes
	 */
	public Map getISOCodes() throws RemoteException;

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.business.ChildCareSessionBean#getISOCode
	 */
	public ISO_639_2 getISOCode(String code) throws RemoteException;

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.business.ChildCareSessionBean#flushApplications
	 */
	public void flushApplications() throws RemoteException;

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.business.ChildCareSessionBean#getProvidersByArea
	 */
	public Map getProvidersByArea(String area) throws RemoteException;

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.business.ChildCareSessionBean#getProvidersByType
	 */
	public Map getProvidersByType(String type) throws RemoteException;
}