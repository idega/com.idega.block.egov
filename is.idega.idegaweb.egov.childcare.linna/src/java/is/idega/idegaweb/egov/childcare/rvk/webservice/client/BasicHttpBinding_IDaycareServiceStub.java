/**
 * BasicHttpBinding_IDaycareServiceStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Aug 26, 2008 (12:29:12 CEST) WSDL2Java emitter.
 */

package is.idega.idegaweb.egov.childcare.rvk.webservice.client;

public class BasicHttpBinding_IDaycareServiceStub extends org.apache.axis.client.Stub implements is.idega.idegaweb.egov.childcare.rvk.webservice.client.IDaycareService {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[14];
        _initOperationDesc1();
        _initOperationDesc2();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SubmitPollResponse");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://skolahjalp.is", "responses"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "ArrayOfPollResponse"), is.idega.idegaweb.egov.childcare.rvk.webservice.client.PollResponse[].class, false, false);
        param.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "PollResponse"));
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "DaycareFaultContract"),
                      "is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract",
                      new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "DaycareFaultContract"), 
                      true
                     ));
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SubmitDaycareApplication");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://skolahjalp.is", "personIdentificationNumberOfUser"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://skolahjalp.is", "application"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "DaycareApplication"), is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareApplication.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "DaycareFaultContract"),
                      "is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract",
                      new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "DaycareFaultContract"), 
                      true
                     ));
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetDaycareApplication");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://skolahjalp.is", "personIdentificationNumberOfUser"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://skolahjalp.is", "personIdentificationNumberOfChild"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "DaycareApplication"));
        oper.setReturnClass(is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareApplication.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://skolahjalp.is", "GetDaycareApplicationResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "DaycareFaultContract"),
                      "is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract",
                      new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "DaycareFaultContract"), 
                      true
                     ));
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetChildrenAndDaycareApplicationState");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://skolahjalp.is", "personIdentificationNumberOfGuardian"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "ArrayOfChildAndDaycareApplicationState"));
        oper.setReturnClass(is.idega.idegaweb.egov.childcare.rvk.webservice.client.ChildAndDaycareApplicationState[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://skolahjalp.is", "GetChildrenAndDaycareApplicationStateResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "ChildAndDaycareApplicationState"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "DaycareFaultContract"),
                      "is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract",
                      new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "DaycareFaultContract"), 
                      true
                     ));
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SubmitServiceGuaranteeApplication");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://skolahjalp.is", "personIdentificationNumberOfUser"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://skolahjalp.is", "application"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "ServiceGuaranteeApplication"), is.idega.idegaweb.egov.childcare.rvk.webservice.client.ServiceGuaranteeApplication.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "DaycareFaultContract"),
                      "is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract",
                      new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "DaycareFaultContract"), 
                      true
                     ));
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetServiceGuaranteeApplication");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://skolahjalp.is", "personIdentificationNumberOfUser"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://skolahjalp.is", "personIdentificationNumberOfChild"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "ServiceGuaranteeApplication"));
        oper.setReturnClass(is.idega.idegaweb.egov.childcare.rvk.webservice.client.ServiceGuaranteeApplication.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://skolahjalp.is", "GetServiceGuaranteeApplicationResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "DaycareFaultContract"),
                      "is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract",
                      new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "DaycareFaultContract"), 
                      true
                     ));
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetPaymentPrediction");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://skolahjalp.is", "socialSecurityNumberOfUser"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://skolahjalp.is", "socialSecurityNumberOfChild"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        param.setNillable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "ArrayOfPaymentPrediction"));
        oper.setReturnClass(is.idega.idegaweb.egov.childcare.rvk.webservice.client.PaymentPrediction[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://skolahjalp.is", "GetPaymentPredictionResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "PaymentPrediction"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "DaycareFaultContract"),
                      "is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract",
                      new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "DaycareFaultContract"), 
                      true
                     ));
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetDistinctPostcodes");
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "ArrayOfshort"));
        oper.setReturnClass(short[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://skolahjalp.is", "GetDistinctPostcodesResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "short"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "DaycareFaultContract"),
                      "is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract",
                      new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "DaycareFaultContract"), 
                      true
                     ));
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetDistinctPostcodesByType");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://skolahjalp.is", "daycareType"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "DaycareType"), is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareType.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "ArrayOfshort"));
        oper.setReturnClass(short[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://skolahjalp.is", "GetDistinctPostcodesByTypeResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "short"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "DaycareFaultContract"),
                      "is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract",
                      new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "DaycareFaultContract"), 
                      true
                     ));
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetDaycareProvidersByType");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://skolahjalp.is", "daycareType"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "DaycareType"), is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareType.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "ArrayOfDaycareProvider"));
        oper.setReturnClass(is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareProvider[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://skolahjalp.is", "GetDaycareProvidersByTypeResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "DaycareProvider"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "DaycareFaultContract"),
                      "is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract",
                      new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "DaycareFaultContract"), 
                      true
                     ));
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetDaycareProvidersByTypeAndPostcode");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://skolahjalp.is", "daycareType"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "DaycareType"), is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareType.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://skolahjalp.is", "postcode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"), java.lang.Short.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "ArrayOfDaycareProvider"));
        oper.setReturnClass(is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareProvider[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://skolahjalp.is", "GetDaycareProvidersByTypeAndPostcodeResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "DaycareProvider"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "DaycareFaultContract"),
                      "is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract",
                      new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "DaycareFaultContract"), 
                      true
                     ));
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetDaycareProvidersByPostcode");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://skolahjalp.is", "postcode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"), java.lang.Short.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "ArrayOfDaycareProvider"));
        oper.setReturnClass(is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareProvider[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://skolahjalp.is", "GetDaycareProvidersByPostcodeResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "DaycareProvider"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "DaycareFaultContract"),
                      "is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract",
                      new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "DaycareFaultContract"), 
                      true
                     ));
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetISO639_2LanguageCodes");
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "ArrayOfISO_639_2"));
        oper.setReturnClass(is.idega.idegaweb.egov.childcare.rvk.webservice.client.ISO_639_2[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://skolahjalp.is", "GetISO639_2LanguageCodesResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "ISO_639_2"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "DaycareFaultContract"),
                      "is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract",
                      new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "DaycareFaultContract"), 
                      true
                     ));
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetAllISO639_2LanguageCodes");
        oper.setReturnType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "ArrayOfISO_639_2"));
        oper.setReturnClass(is.idega.idegaweb.egov.childcare.rvk.webservice.client.ISO_639_2[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://skolahjalp.is", "GetAllISO639_2LanguageCodesResult"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "ISO_639_2"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "DaycareFaultContract"),
                      "is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract",
                      new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "DaycareFaultContract"), 
                      true
                     ));
        _operations[13] = oper;

    }

    public BasicHttpBinding_IDaycareServiceStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public BasicHttpBinding_IDaycareServiceStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public BasicHttpBinding_IDaycareServiceStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            /*java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;*/
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "ArrayOfChildAndDaycareApplicationState");
            cachedSerQNames.add(qName);
            cls = is.idega.idegaweb.egov.childcare.rvk.webservice.client.ChildAndDaycareApplicationState[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "ChildAndDaycareApplicationState");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "ChildAndDaycareApplicationState");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "ArrayOfDaycareProvider");
            cachedSerQNames.add(qName);
            cls = is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareProvider[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "DaycareProvider");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "DaycareProvider");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "ArrayOfGuardian");
            cachedSerQNames.add(qName);
            cls = is.idega.idegaweb.egov.childcare.rvk.webservice.client.Guardian[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "Guardian");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "Guardian");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "ArrayOfISO_639_2");
            cachedSerQNames.add(qName);
            cls = is.idega.idegaweb.egov.childcare.rvk.webservice.client.ISO_639_2[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "ISO_639_2");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "ISO_639_2");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "ArrayOfMonthlyPaymentAssignment");
            cachedSerQNames.add(qName);
            cls = is.idega.idegaweb.egov.childcare.rvk.webservice.client.MonthlyPaymentAssignment[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "MonthlyPaymentAssignment");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "MonthlyPaymentAssignment");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "ArrayOfPaymentPrediction");
            cachedSerQNames.add(qName);
            cls = is.idega.idegaweb.egov.childcare.rvk.webservice.client.PaymentPrediction[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "PaymentPrediction");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "PaymentPrediction");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "ArrayOfPaymentPredictionDetail");
            cachedSerQNames.add(qName);
            cls = is.idega.idegaweb.egov.childcare.rvk.webservice.client.PaymentPredictionDetail[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "PaymentPredictionDetail");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "PaymentPredictionDetail");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "ArrayOfPollResponse");
            cachedSerQNames.add(qName);
            cls = is.idega.idegaweb.egov.childcare.rvk.webservice.client.PollResponse[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "PollResponse");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "PollResponse");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "ArrayOfRequestedDaycareProvider");
            cachedSerQNames.add(qName);
            cls = is.idega.idegaweb.egov.childcare.rvk.webservice.client.RequestedDaycareProvider[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "RequestedDaycareProvider");
            qName2 = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "RequestedDaycareProvider");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "BankAccount");
            cachedSerQNames.add(qName);
            cls = is.idega.idegaweb.egov.childcare.rvk.webservice.client.BankAccount.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "CalendarMonth");
            cachedSerQNames.add(qName);
            cls = is.idega.idegaweb.egov.childcare.rvk.webservice.client.CalendarMonth.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "Child");
            cachedSerQNames.add(qName);
            cls = is.idega.idegaweb.egov.childcare.rvk.webservice.client.Child.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "ChildAndDaycareApplicationState");
            cachedSerQNames.add(qName);
            cls = is.idega.idegaweb.egov.childcare.rvk.webservice.client.ChildAndDaycareApplicationState.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "DaycareApplication");
            cachedSerQNames.add(qName);
            cls = is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareApplication.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "DaycareErrorCode");
            cachedSerQNames.add(qName);
            cls = is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareErrorCode.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "DaycareFaultContract");
            cachedSerQNames.add(qName);
            cls = is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "DaycareProgram");
            cachedSerQNames.add(qName);
            cls = is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareProgram.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "DaycareProvider");
            cachedSerQNames.add(qName);
            cls = is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareProvider.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "DaycareType");
            cachedSerQNames.add(qName);
            cls = is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "Guardian");
            cachedSerQNames.add(qName);
            cls = is.idega.idegaweb.egov.childcare.rvk.webservice.client.Guardian.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "IntendedDuration");
            cachedSerQNames.add(qName);
            cls = is.idega.idegaweb.egov.childcare.rvk.webservice.client.IntendedDuration.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "ISO_639_2");
            cachedSerQNames.add(qName);
            cls = is.idega.idegaweb.egov.childcare.rvk.webservice.client.ISO_639_2.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "MaritalState");
            cachedSerQNames.add(qName);
            cls = is.idega.idegaweb.egov.childcare.rvk.webservice.client.MaritalState.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "MonthlyPaymentAssignment");
            cachedSerQNames.add(qName);
            cls = is.idega.idegaweb.egov.childcare.rvk.webservice.client.MonthlyPaymentAssignment.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "NextOfKinBesidesGuardian");
            cachedSerQNames.add(qName);
            cls = is.idega.idegaweb.egov.childcare.rvk.webservice.client.NextOfKinBesidesGuardian.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "PaymentPrediction");
            cachedSerQNames.add(qName);
            cls = is.idega.idegaweb.egov.childcare.rvk.webservice.client.PaymentPrediction.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "PaymentPredictionDetail");
            cachedSerQNames.add(qName);
            cls = is.idega.idegaweb.egov.childcare.rvk.webservice.client.PaymentPredictionDetail.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "PollResponse");
            cachedSerQNames.add(qName);
            cls = is.idega.idegaweb.egov.childcare.rvk.webservice.client.PollResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "Relationship");
            cachedSerQNames.add(qName);
            cls = is.idega.idegaweb.egov.childcare.rvk.webservice.client.Relationship.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "RequestedDaycareProvider");
            cachedSerQNames.add(qName);
            cls = is.idega.idegaweb.egov.childcare.rvk.webservice.client.RequestedDaycareProvider.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "ServiceGuaranteeApplication");
            cachedSerQNames.add(qName);
            cls = is.idega.idegaweb.egov.childcare.rvk.webservice.client.ServiceGuaranteeApplication.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "WhoTakesCareOfChildForThisGuardian");
            cachedSerQNames.add(qName);
            cls = is.idega.idegaweb.egov.childcare.rvk.webservice.client.WhoTakesCareOfChildForThisGuardian.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "ArrayOfshort");
            cachedSerQNames.add(qName);
            cls = short[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short");
            qName2 = new javax.xml.namespace.QName("http://schemas.microsoft.com/2003/10/Serialization/Arrays", "short");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public void submitPollResponse(is.idega.idegaweb.egov.childcare.rvk.webservice.client.PollResponse[] responses) throws java.rmi.RemoteException, is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://skolahjalp.is/IDaycareService/SubmitPollResponse");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://skolahjalp.is", "SubmitPollResponse"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {responses});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract) {
              throw (is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void submitDaycareApplication(java.lang.String personIdentificationNumberOfUser, is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareApplication application) throws java.rmi.RemoteException, is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://skolahjalp.is/IDaycareService/SubmitDaycareApplication");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://skolahjalp.is", "SubmitDaycareApplication"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {personIdentificationNumberOfUser, application});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract) {
              throw (is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareApplication getDaycareApplication(java.lang.String personIdentificationNumberOfUser, java.lang.String personIdentificationNumberOfChild) throws java.rmi.RemoteException, is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://skolahjalp.is/IDaycareService/GetDaycareApplication");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://skolahjalp.is", "GetDaycareApplication"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {personIdentificationNumberOfUser, personIdentificationNumberOfChild});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareApplication) _resp;
            } catch (java.lang.Exception _exception) {
                return (is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareApplication) org.apache.axis.utils.JavaUtils.convert(_resp, is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareApplication.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract) {
              throw (is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public is.idega.idegaweb.egov.childcare.rvk.webservice.client.ChildAndDaycareApplicationState[] getChildrenAndDaycareApplicationState(java.lang.String personIdentificationNumberOfGuardian) throws java.rmi.RemoteException, is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://skolahjalp.is/IDaycareService/GetChildrenAndDaycareApplicationState");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://skolahjalp.is", "GetChildrenAndDaycareApplicationState"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {personIdentificationNumberOfGuardian});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (is.idega.idegaweb.egov.childcare.rvk.webservice.client.ChildAndDaycareApplicationState[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (is.idega.idegaweb.egov.childcare.rvk.webservice.client.ChildAndDaycareApplicationState[]) org.apache.axis.utils.JavaUtils.convert(_resp, is.idega.idegaweb.egov.childcare.rvk.webservice.client.ChildAndDaycareApplicationState[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract) {
              throw (is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void submitServiceGuaranteeApplication(java.lang.String personIdentificationNumberOfUser, is.idega.idegaweb.egov.childcare.rvk.webservice.client.ServiceGuaranteeApplication application) throws java.rmi.RemoteException, is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://skolahjalp.is/IDaycareService/SubmitServiceGuaranteeApplication");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://skolahjalp.is", "SubmitServiceGuaranteeApplication"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {personIdentificationNumberOfUser, application});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract) {
              throw (is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public is.idega.idegaweb.egov.childcare.rvk.webservice.client.ServiceGuaranteeApplication getServiceGuaranteeApplication(java.lang.String personIdentificationNumberOfUser, java.lang.String personIdentificationNumberOfChild) throws java.rmi.RemoteException, is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://skolahjalp.is/IDaycareService/GetServiceGuaranteeApplication");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://skolahjalp.is", "GetServiceGuaranteeApplication"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {personIdentificationNumberOfUser, personIdentificationNumberOfChild});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (is.idega.idegaweb.egov.childcare.rvk.webservice.client.ServiceGuaranteeApplication) _resp;
            } catch (java.lang.Exception _exception) {
                return (is.idega.idegaweb.egov.childcare.rvk.webservice.client.ServiceGuaranteeApplication) org.apache.axis.utils.JavaUtils.convert(_resp, is.idega.idegaweb.egov.childcare.rvk.webservice.client.ServiceGuaranteeApplication.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract) {
              throw (is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public is.idega.idegaweb.egov.childcare.rvk.webservice.client.PaymentPrediction[] getPaymentPrediction(java.lang.String socialSecurityNumberOfUser, java.lang.String socialSecurityNumberOfChild) throws java.rmi.RemoteException, is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://skolahjalp.is/IDaycareService/GetPaymentPrediction");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://skolahjalp.is", "GetPaymentPrediction"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {socialSecurityNumberOfUser, socialSecurityNumberOfChild});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (is.idega.idegaweb.egov.childcare.rvk.webservice.client.PaymentPrediction[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (is.idega.idegaweb.egov.childcare.rvk.webservice.client.PaymentPrediction[]) org.apache.axis.utils.JavaUtils.convert(_resp, is.idega.idegaweb.egov.childcare.rvk.webservice.client.PaymentPrediction[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract) {
              throw (is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public short[] getDistinctPostcodes() throws java.rmi.RemoteException, is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://skolahjalp.is/IDaycareService/GetDistinctPostcodes");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://skolahjalp.is", "GetDistinctPostcodes"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (short[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (short[]) org.apache.axis.utils.JavaUtils.convert(_resp, short[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract) {
              throw (is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public short[] getDistinctPostcodesByType(is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareType daycareType) throws java.rmi.RemoteException, is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://skolahjalp.is/IDaycareService/GetDistinctPostcodesByType");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://skolahjalp.is", "GetDistinctPostcodesByType"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {daycareType});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (short[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (short[]) org.apache.axis.utils.JavaUtils.convert(_resp, short[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract) {
              throw (is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareProvider[] getDaycareProvidersByType(is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareType daycareType) throws java.rmi.RemoteException, is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://skolahjalp.is/IDaycareService/GetDaycareProvidersByType");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://skolahjalp.is", "GetDaycareProvidersByType"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {daycareType});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareProvider[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareProvider[]) org.apache.axis.utils.JavaUtils.convert(_resp, is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareProvider[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract) {
              throw (is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareProvider[] getDaycareProvidersByTypeAndPostcode(is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareType daycareType, java.lang.Short postcode) throws java.rmi.RemoteException, is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://skolahjalp.is/IDaycareService/GetDaycareProvidersByTypeAndPostcode");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://skolahjalp.is", "GetDaycareProvidersByTypeAndPostcode"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {daycareType, postcode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareProvider[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareProvider[]) org.apache.axis.utils.JavaUtils.convert(_resp, is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareProvider[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract) {
              throw (is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareProvider[] getDaycareProvidersByPostcode(java.lang.Short postcode) throws java.rmi.RemoteException, is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://skolahjalp.is/IDaycareService/GetDaycareProvidersByPostcode");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://skolahjalp.is", "GetDaycareProvidersByPostcode"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {postcode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareProvider[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareProvider[]) org.apache.axis.utils.JavaUtils.convert(_resp, is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareProvider[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract) {
              throw (is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public is.idega.idegaweb.egov.childcare.rvk.webservice.client.ISO_639_2[] getISO639_2LanguageCodes() throws java.rmi.RemoteException, is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://skolahjalp.is/IDaycareService/GetISO639_2LanguageCodes");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://skolahjalp.is", "GetISO639_2LanguageCodes"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (is.idega.idegaweb.egov.childcare.rvk.webservice.client.ISO_639_2[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (is.idega.idegaweb.egov.childcare.rvk.webservice.client.ISO_639_2[]) org.apache.axis.utils.JavaUtils.convert(_resp, is.idega.idegaweb.egov.childcare.rvk.webservice.client.ISO_639_2[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract) {
              throw (is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public is.idega.idegaweb.egov.childcare.rvk.webservice.client.ISO_639_2[] getAllISO639_2LanguageCodes() throws java.rmi.RemoteException, is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://skolahjalp.is/IDaycareService/GetAllISO639_2LanguageCodes");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://skolahjalp.is", "GetAllISO639_2LanguageCodes"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (is.idega.idegaweb.egov.childcare.rvk.webservice.client.ISO_639_2[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (is.idega.idegaweb.egov.childcare.rvk.webservice.client.ISO_639_2[]) org.apache.axis.utils.JavaUtils.convert(_resp, is.idega.idegaweb.egov.childcare.rvk.webservice.client.ISO_639_2[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract) {
              throw (is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

}
