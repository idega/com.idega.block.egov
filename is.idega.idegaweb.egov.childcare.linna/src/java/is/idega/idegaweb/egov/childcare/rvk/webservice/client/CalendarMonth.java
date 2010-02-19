/**
 * CalendarMonth.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Aug 26, 2008 (12:29:12 CEST) WSDL2Java emitter.
 */

package is.idega.idegaweb.egov.childcare.rvk.webservice.client;

public class CalendarMonth implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected CalendarMonth(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _January = "January";
    public static final java.lang.String _February = "February";
    public static final java.lang.String _March = "March";
    public static final java.lang.String _April = "April";
    public static final java.lang.String _May = "May";
    public static final java.lang.String _June = "June";
    public static final java.lang.String _July = "July";
    public static final java.lang.String _August = "August";
    public static final java.lang.String _September = "September";
    public static final java.lang.String _October = "October";
    public static final java.lang.String _November = "November";
    public static final java.lang.String _December = "December";
    public static final CalendarMonth January = new CalendarMonth(_January);
    public static final CalendarMonth February = new CalendarMonth(_February);
    public static final CalendarMonth March = new CalendarMonth(_March);
    public static final CalendarMonth April = new CalendarMonth(_April);
    public static final CalendarMonth May = new CalendarMonth(_May);
    public static final CalendarMonth June = new CalendarMonth(_June);
    public static final CalendarMonth July = new CalendarMonth(_July);
    public static final CalendarMonth August = new CalendarMonth(_August);
    public static final CalendarMonth September = new CalendarMonth(_September);
    public static final CalendarMonth October = new CalendarMonth(_October);
    public static final CalendarMonth November = new CalendarMonth(_November);
    public static final CalendarMonth December = new CalendarMonth(_December);
    public java.lang.String getValue() { return _value_;}
    public static CalendarMonth fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        CalendarMonth enumeration = (CalendarMonth)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static CalendarMonth fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(CalendarMonth.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "CalendarMonth"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
