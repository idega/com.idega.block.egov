/**
 * DaycareErrorCode.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Aug 26, 2008 (12:29:12 CEST) WSDL2Java emitter.
 */

package is.idega.idegaweb.egov.childcare.rvk.webservice.client;

public class DaycareErrorCode implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected DaycareErrorCode(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _Unknown = "Unknown";
    public static final java.lang.String _PersonIdentificationNumberWrongLength = "PersonIdentificationNumberWrongLength";
    public static final java.lang.String _ChildPINRequired = "ChildPINRequired";
    public static final java.lang.String _GuardianNull = "GuardianNull";
    public static final java.lang.String _ApplicantNotGuardian = "ApplicantNotGuardian";
    public static final java.lang.String _DaycareProviderNull = "DaycareProviderNull";
    public static final java.lang.String _DaycareProviderWrongOrder = "DaycareProviderWrongOrder";
    public static final java.lang.String _DaycareProviderWrongName = "DaycareProviderWrongName";
    public static final java.lang.String _DaycareProviderWrongPostcode = "DaycareProviderWrongPostcode";
    public static final java.lang.String _ChildWrongDateOfBirth = "ChildWrongDateOfBirth";
    public static final java.lang.String _ChildWrongName = "ChildWrongName";
    public static final java.lang.String _ChildWrongAddress = "ChildWrongAddress";
    public static final java.lang.String _ChildWrongPostcode = "ChildWrongPostcode";
    public static final java.lang.String _ChildWrongMunicipality = "ChildWrongMunicipality";
    public static final java.lang.String _GuardianWrongName = "GuardianWrongName";
    public static final java.lang.String _GuardianWrongAddress = "GuardianWrongAddress";
    public static final java.lang.String _GuardianWrongPostcode = "GuardianWrongPostcode";
    public static final java.lang.String _GuardianWrongMunicipality = "GuardianWrongMunicipality";
    public static final java.lang.String _GuardianWrongMaritalState = "GuardianWrongMaritalState";
    public static final java.lang.String _NextOfKinBesidesGuardianMissingName = "NextOfKinBesidesGuardianMissingName";
    public static final java.lang.String _LanguageCodeWrong = "LanguageCodeWrong";
    public static final java.lang.String _ChildNotInDB = "ChildNotInDB";
    public static final DaycareErrorCode Unknown = new DaycareErrorCode(_Unknown);
    public static final DaycareErrorCode PersonIdentificationNumberWrongLength = new DaycareErrorCode(_PersonIdentificationNumberWrongLength);
    public static final DaycareErrorCode ChildPINRequired = new DaycareErrorCode(_ChildPINRequired);
    public static final DaycareErrorCode GuardianNull = new DaycareErrorCode(_GuardianNull);
    public static final DaycareErrorCode ApplicantNotGuardian = new DaycareErrorCode(_ApplicantNotGuardian);
    public static final DaycareErrorCode DaycareProviderNull = new DaycareErrorCode(_DaycareProviderNull);
    public static final DaycareErrorCode DaycareProviderWrongOrder = new DaycareErrorCode(_DaycareProviderWrongOrder);
    public static final DaycareErrorCode DaycareProviderWrongName = new DaycareErrorCode(_DaycareProviderWrongName);
    public static final DaycareErrorCode DaycareProviderWrongPostcode = new DaycareErrorCode(_DaycareProviderWrongPostcode);
    public static final DaycareErrorCode ChildWrongDateOfBirth = new DaycareErrorCode(_ChildWrongDateOfBirth);
    public static final DaycareErrorCode ChildWrongName = new DaycareErrorCode(_ChildWrongName);
    public static final DaycareErrorCode ChildWrongAddress = new DaycareErrorCode(_ChildWrongAddress);
    public static final DaycareErrorCode ChildWrongPostcode = new DaycareErrorCode(_ChildWrongPostcode);
    public static final DaycareErrorCode ChildWrongMunicipality = new DaycareErrorCode(_ChildWrongMunicipality);
    public static final DaycareErrorCode GuardianWrongName = new DaycareErrorCode(_GuardianWrongName);
    public static final DaycareErrorCode GuardianWrongAddress = new DaycareErrorCode(_GuardianWrongAddress);
    public static final DaycareErrorCode GuardianWrongPostcode = new DaycareErrorCode(_GuardianWrongPostcode);
    public static final DaycareErrorCode GuardianWrongMunicipality = new DaycareErrorCode(_GuardianWrongMunicipality);
    public static final DaycareErrorCode GuardianWrongMaritalState = new DaycareErrorCode(_GuardianWrongMaritalState);
    public static final DaycareErrorCode NextOfKinBesidesGuardianMissingName = new DaycareErrorCode(_NextOfKinBesidesGuardianMissingName);
    public static final DaycareErrorCode LanguageCodeWrong = new DaycareErrorCode(_LanguageCodeWrong);
    public static final DaycareErrorCode ChildNotInDB = new DaycareErrorCode(_ChildNotInDB);
    public java.lang.String getValue() { return _value_;}
    public static DaycareErrorCode fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        DaycareErrorCode enumeration = (DaycareErrorCode)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static DaycareErrorCode fromString(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        return fromValue(value);
    }
    public boolean equals(java.lang.Object obj) {return (obj == this);}
    public int hashCode() { return toString().hashCode();}
    public java.lang.String toString() { return _value_;}
    public java.lang.Object readResolve() throws java.io.ObjectStreamException { return fromValue(_value_);}
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumSerializer(
            _javaType, _xmlType);
    }
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new org.apache.axis.encoding.ser.EnumDeserializer(
            _javaType, _xmlType);
    }
    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DaycareErrorCode.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "DaycareErrorCode"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
