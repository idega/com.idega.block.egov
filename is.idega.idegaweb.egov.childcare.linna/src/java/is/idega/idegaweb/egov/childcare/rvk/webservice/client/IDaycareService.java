/**
 * IDaycareService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Aug 26, 2008 (12:29:12 CEST) WSDL2Java emitter.
 */

package is.idega.idegaweb.egov.childcare.rvk.webservice.client;

public interface IDaycareService extends java.rmi.Remote {
    public void submitPollResponse(is.idega.idegaweb.egov.childcare.rvk.webservice.client.PollResponse[] responses) throws java.rmi.RemoteException, is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract;
    public void submitDaycareApplication(java.lang.String personIdentificationNumberOfUser, is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareApplication application) throws java.rmi.RemoteException, is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract;
    public is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareApplication getDaycareApplication(java.lang.String personIdentificationNumberOfUser, java.lang.String personIdentificationNumberOfChild) throws java.rmi.RemoteException, is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract;
    public is.idega.idegaweb.egov.childcare.rvk.webservice.client.ChildAndDaycareApplicationState[] getChildrenAndDaycareApplicationState(java.lang.String personIdentificationNumberOfGuardian) throws java.rmi.RemoteException, is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract;
    public void submitServiceGuaranteeApplication(java.lang.String personIdentificationNumberOfUser, is.idega.idegaweb.egov.childcare.rvk.webservice.client.ServiceGuaranteeApplication application) throws java.rmi.RemoteException, is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract;
    public is.idega.idegaweb.egov.childcare.rvk.webservice.client.ServiceGuaranteeApplication getServiceGuaranteeApplication(java.lang.String personIdentificationNumberOfUser, java.lang.String personIdentificationNumberOfChild) throws java.rmi.RemoteException, is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract;
    public is.idega.idegaweb.egov.childcare.rvk.webservice.client.PaymentPrediction[] getPaymentPrediction(java.lang.String socialSecurityNumberOfUser, java.lang.String socialSecurityNumberOfChild) throws java.rmi.RemoteException, is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract;
    public short[] getDistinctPostcodes() throws java.rmi.RemoteException, is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract;
    public short[] getDistinctPostcodesByType(is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareType daycareType) throws java.rmi.RemoteException, is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract;
    public is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareProvider[] getDaycareProvidersByType(is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareType daycareType) throws java.rmi.RemoteException, is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract;
    public is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareProvider[] getDaycareProvidersByTypeAndPostcode(is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareType daycareType, java.lang.Short postcode) throws java.rmi.RemoteException, is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract;
    public is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareProvider[] getDaycareProvidersByPostcode(java.lang.Short postcode) throws java.rmi.RemoteException, is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract;
    public is.idega.idegaweb.egov.childcare.rvk.webservice.client.ISO_639_2[] getISO639_2LanguageCodes() throws java.rmi.RemoteException, is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract;
    public is.idega.idegaweb.egov.childcare.rvk.webservice.client.ISO_639_2[] getAllISO639_2LanguageCodes() throws java.rmi.RemoteException, is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract;
}
