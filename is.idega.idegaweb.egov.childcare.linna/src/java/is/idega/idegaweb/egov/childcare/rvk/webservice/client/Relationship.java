/**
 * Relationship.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Aug 26, 2008 (12:29:12 CEST) WSDL2Java emitter.
 */

package is.idega.idegaweb.egov.childcare.rvk.webservice.client;

public class Relationship implements java.io.Serializable {
    private java.lang.String _value_;
    private static java.util.HashMap _table_ = new java.util.HashMap();

    // Constructor
    protected Relationship(java.lang.String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static final java.lang.String _Unknown = "Unknown";
    public static final java.lang.String _Mother = "Mother";
    public static final java.lang.String _Father = "Father";
    public static final java.lang.String _Stepmother = "Stepmother";
    public static final java.lang.String _Stepfather = "Stepfather";
    public static final java.lang.String _Grandmother = "Grandmother";
    public static final java.lang.String _Grandfather = "Grandfather";
    public static final java.lang.String _Sibling = "Sibling";
    public static final java.lang.String _OtherRelationship = "OtherRelationship";
    public static final Relationship Unknown = new Relationship(_Unknown);
    public static final Relationship Mother = new Relationship(_Mother);
    public static final Relationship Father = new Relationship(_Father);
    public static final Relationship Stepmother = new Relationship(_Stepmother);
    public static final Relationship Stepfather = new Relationship(_Stepfather);
    public static final Relationship Grandmother = new Relationship(_Grandmother);
    public static final Relationship Grandfather = new Relationship(_Grandfather);
    public static final Relationship Sibling = new Relationship(_Sibling);
    public static final Relationship OtherRelationship = new Relationship(_OtherRelationship);
    public java.lang.String getValue() { return _value_;}
    public static Relationship fromValue(java.lang.String value)
          throws java.lang.IllegalArgumentException {
        Relationship enumeration = (Relationship)
            _table_.get(value);
        if (enumeration==null) throw new java.lang.IllegalArgumentException();
        return enumeration;
    }
    public static Relationship fromString(java.lang.String value)
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
        new org.apache.axis.description.TypeDesc(Relationship.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "Relationship"));
    }
    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

}
