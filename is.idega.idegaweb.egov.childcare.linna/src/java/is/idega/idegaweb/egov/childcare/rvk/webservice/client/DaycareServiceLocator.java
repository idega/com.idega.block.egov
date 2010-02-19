/**
 * DaycareServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Aug 26, 2008 (12:29:12 CEST) WSDL2Java emitter.
 */

package is.idega.idegaweb.egov.childcare.rvk.webservice.client;

public class DaycareServiceLocator extends org.apache.axis.client.Service implements is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareService {

    public DaycareServiceLocator() {
    }


    public DaycareServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public DaycareServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BasicHttpBinding_IDaycareService
    private java.lang.String BasicHttpBinding_IDaycareService_address = "http://dagvsrv1.dagvistun-test.grunnskolar.is/DaycareWebService/DaycareService.svc";

    public java.lang.String getBasicHttpBinding_IDaycareServiceAddress() {
        return BasicHttpBinding_IDaycareService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BasicHttpBinding_IDaycareServiceWSDDServiceName = "BasicHttpBinding_IDaycareService";

    public java.lang.String getBasicHttpBinding_IDaycareServiceWSDDServiceName() {
        return BasicHttpBinding_IDaycareServiceWSDDServiceName;
    }

    public void setBasicHttpBinding_IDaycareServiceWSDDServiceName(java.lang.String name) {
        BasicHttpBinding_IDaycareServiceWSDDServiceName = name;
    }

    public is.idega.idegaweb.egov.childcare.rvk.webservice.client.IDaycareService getBasicHttpBinding_IDaycareService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BasicHttpBinding_IDaycareService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBasicHttpBinding_IDaycareService(endpoint);
    }

    public is.idega.idegaweb.egov.childcare.rvk.webservice.client.IDaycareService getBasicHttpBinding_IDaycareService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            is.idega.idegaweb.egov.childcare.rvk.webservice.client.BasicHttpBinding_IDaycareServiceStub _stub = new is.idega.idegaweb.egov.childcare.rvk.webservice.client.BasicHttpBinding_IDaycareServiceStub(portAddress, this);
            _stub.setPortName(getBasicHttpBinding_IDaycareServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBasicHttpBinding_IDaycareServiceEndpointAddress(java.lang.String address) {
        BasicHttpBinding_IDaycareService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (is.idega.idegaweb.egov.childcare.rvk.webservice.client.IDaycareService.class.isAssignableFrom(serviceEndpointInterface)) {
                is.idega.idegaweb.egov.childcare.rvk.webservice.client.BasicHttpBinding_IDaycareServiceStub _stub = new is.idega.idegaweb.egov.childcare.rvk.webservice.client.BasicHttpBinding_IDaycareServiceStub(new java.net.URL(BasicHttpBinding_IDaycareService_address), this);
                _stub.setPortName(getBasicHttpBinding_IDaycareServiceWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("BasicHttpBinding_IDaycareService".equals(inputPortName)) {
            return getBasicHttpBinding_IDaycareService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://tempuri.org/", "DaycareService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://tempuri.org/", "BasicHttpBinding_IDaycareService"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BasicHttpBinding_IDaycareService".equals(portName)) {
            setBasicHttpBinding_IDaycareServiceEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
