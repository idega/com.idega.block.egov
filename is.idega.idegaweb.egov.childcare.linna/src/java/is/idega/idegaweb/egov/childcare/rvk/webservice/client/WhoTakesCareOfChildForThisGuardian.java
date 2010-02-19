/**
 * WhoTakesCareOfChildForThisGuardian.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Aug 26, 2008 (12:29:12 CEST) WSDL2Java emitter.
 */

package is.idega.idegaweb.egov.childcare.rvk.webservice.client;

public class WhoTakesCareOfChildForThisGuardian implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected WhoTakesCareOfChildForThisGuardian(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _Guardian = "Guardian";
    public static final java.lang.String _ThirdParty = "ThirdParty";
    public static final java.lang.String _Both = "Both";
    public static final WhoTakesCareOfChildForThisGuardian Guardian = new WhoTakesCareOfChildForThisGuardian(_Guardian);
    public static final WhoTakesCareOfChildForThisGuardian ThirdParty = new WhoTakesCareOfChildForThisGuardian(_ThirdParty);
    public static final WhoTakesCareOfChildForThisGuardian Both = new WhoTakesCareOfChildForThisGuardian(_Both);
    public java.lang.String getValue() { return _value_;}
    public static WhoTakesCareOfChildForThisGuardian fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        WhoTakesCareOfChildForThisGuardian enumeration = (WhoTakesCareOfChildForThisGuardian)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static WhoTakesCareOfChildForThisGuardian fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(WhoTakesCareOfChildForThisGuardian.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "WhoTakesCareOfChildForThisGuardian"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
