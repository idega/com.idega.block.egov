/**
 * ISO_639_2.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Aug 26, 2008 (12:29:12 CEST) WSDL2Java emitter.
 */

package is.idega.idegaweb.egov.childcare.rvk.webservice.client;

public class ISO_639_2  implements java.io.Serializable {
    private java.lang.String code;

    private java.lang.String icelandicName;

    private java.lang.Boolean isLocalised;

    public ISO_639_2() {
    }

    public ISO_639_2(
           java.lang.String code,
           java.lang.String icelandicName,
           java.lang.Boolean isLocalised) {
           this.code = code;
           this.icelandicName = icelandicName;
           this.isLocalised = isLocalised;
    }


    /**
     * Gets the code value for this ISO_639_2.
     * 
     * @return code
     */
    public java.lang.String getCode() {
        return code;
    }


    /**
     * Sets the code value for this ISO_639_2.
     * 
     * @param code
     */
    public void setCode(java.lang.String code) {
        this.code = code;
    }


    /**
     * Gets the icelandicName value for this ISO_639_2.
     * 
     * @return icelandicName
     */
    public java.lang.String getIcelandicName() {
        return icelandicName;
    }


    /**
     * Sets the icelandicName value for this ISO_639_2.
     * 
     * @param icelandicName
     */
    public void setIcelandicName(java.lang.String icelandicName) {
        this.icelandicName = icelandicName;
    }


    /**
     * Gets the isLocalised value for this ISO_639_2.
     * 
     * @return isLocalised
     */
    public java.lang.Boolean getIsLocalised() {
        return isLocalised;
    }


    /**
     * Sets the isLocalised value for this ISO_639_2.
     * 
     * @param isLocalised
     */
    public void setIsLocalised(java.lang.Boolean isLocalised) {
        this.isLocalised = isLocalised;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ISO_639_2)) return false;
        ISO_639_2 other = (ISO_639_2) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.code==null && other.getCode()==null) || 
             (this.code!=null &&
              this.code.equals(other.getCode()))) &&
            ((this.icelandicName==null && other.getIcelandicName()==null) || 
             (this.icelandicName!=null &&
              this.icelandicName.equals(other.getIcelandicName()))) &&
            ((this.isLocalised==null && other.getIsLocalised()==null) || 
             (this.isLocalised!=null &&
              this.isLocalised.equals(other.getIsLocalised())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getCode() != null) {
            _hashCode += getCode().hashCode();
        }
        if (getIcelandicName() != null) {
            _hashCode += getIcelandicName().hashCode();
        }
        if (getIsLocalised() != null) {
            _hashCode += getIsLocalised().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ISO_639_2.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "ISO_639_2"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("code");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "Code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("icelandicName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "IcelandicName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isLocalised");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "IsLocalised"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
