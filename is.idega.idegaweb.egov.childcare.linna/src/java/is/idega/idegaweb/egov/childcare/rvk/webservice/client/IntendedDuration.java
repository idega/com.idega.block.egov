/**
 * IntendedDuration.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Aug 26, 2008 (12:29:12 CEST) WSDL2Java emitter.
 */

package is.idega.idegaweb.egov.childcare.rvk.webservice.client;

public class IntendedDuration implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected IntendedDuration(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _Unknown = "Unknown";
    public static final java.lang.String _Four = "Four";
    public static final java.lang.String _FourAndAHalf = "FourAndAHalf";
    public static final java.lang.String _Five = "Five";
    public static final java.lang.String _FiveAndAHalf = "FiveAndAHalf";
    public static final java.lang.String _Six = "Six";
    public static final java.lang.String _SixAndAHalf = "SixAndAHalf";
    public static final java.lang.String _Seven = "Seven";
    public static final java.lang.String _SevenAndAHalf = "SevenAndAHalf";
    public static final java.lang.String _Eight = "Eight";
    public static final java.lang.String _EightAndAHalf = "EightAndAHalf";
    public static final java.lang.String _Nine = "Nine";
    public static final java.lang.String _NineAndHalf = "NineAndHalf";
    public static final IntendedDuration Unknown = new IntendedDuration(_Unknown);
    public static final IntendedDuration Four = new IntendedDuration(_Four);
    public static final IntendedDuration FourAndAHalf = new IntendedDuration(_FourAndAHalf);
    public static final IntendedDuration Five = new IntendedDuration(_Five);
    public static final IntendedDuration FiveAndAHalf = new IntendedDuration(_FiveAndAHalf);
    public static final IntendedDuration Six = new IntendedDuration(_Six);
    public static final IntendedDuration SixAndAHalf = new IntendedDuration(_SixAndAHalf);
    public static final IntendedDuration Seven = new IntendedDuration(_Seven);
    public static final IntendedDuration SevenAndAHalf = new IntendedDuration(_SevenAndAHalf);
    public static final IntendedDuration Eight = new IntendedDuration(_Eight);
    public static final IntendedDuration EightAndAHalf = new IntendedDuration(_EightAndAHalf);
    public static final IntendedDuration Nine = new IntendedDuration(_Nine);
    public static final IntendedDuration NineAndHalf = new IntendedDuration(_NineAndHalf);
    public java.lang.String getValue() { return _value_;}
    public static IntendedDuration fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        IntendedDuration enumeration = (IntendedDuration)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static IntendedDuration fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(IntendedDuration.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "IntendedDuration"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
