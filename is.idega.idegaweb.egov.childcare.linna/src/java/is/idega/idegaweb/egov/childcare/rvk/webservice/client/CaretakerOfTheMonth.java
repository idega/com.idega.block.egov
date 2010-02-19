/**
 * CaretakerOfTheMonth.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Aug 26, 2008 (12:29:12 CEST) WSDL2Java emitter.
 */

package is.idega.idegaweb.egov.childcare.rvk.webservice.client;

public class CaretakerOfTheMonth implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected CaretakerOfTheMonth(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _None = "None";
    public static final java.lang.String _Guardian1 = "Guardian1";
    public static final java.lang.String _Guardian2 = "Guardian2";
    public static final java.lang.String _Caretaker = "Caretaker";
    public static final CaretakerOfTheMonth None = new CaretakerOfTheMonth(_None);
    public static final CaretakerOfTheMonth Guardian1 = new CaretakerOfTheMonth(_Guardian1);
    public static final CaretakerOfTheMonth Guardian2 = new CaretakerOfTheMonth(_Guardian2);
    public static final CaretakerOfTheMonth Caretaker = new CaretakerOfTheMonth(_Caretaker);
    public java.lang.String getValue() { return _value_;}
    public static CaretakerOfTheMonth fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        CaretakerOfTheMonth enumeration = (CaretakerOfTheMonth)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static CaretakerOfTheMonth fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(CaretakerOfTheMonth.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "CaretakerOfTheMonth"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
