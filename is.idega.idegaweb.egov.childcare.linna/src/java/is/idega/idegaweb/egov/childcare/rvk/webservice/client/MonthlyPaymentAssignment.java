/**
 * MonthlyPaymentAssignment.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Aug 26, 2008 (12:29:12 CEST) WSDL2Java emitter.
 */

package is.idega.idegaweb.egov.childcare.rvk.webservice.client;

public class MonthlyPaymentAssignment  implements java.io.Serializable {
    private is.idega.idegaweb.egov.childcare.rvk.webservice.client.CalendarMonth month;

    private java.lang.String personIdentificationNumberOfRecipient;

    private java.lang.Short year;

    public MonthlyPaymentAssignment() {
    }

    public MonthlyPaymentAssignment(
           is.idega.idegaweb.egov.childcare.rvk.webservice.client.CalendarMonth month,
           java.lang.String personIdentificationNumberOfRecipient,
           java.lang.Short year) {
           this.month = month;
           this.personIdentificationNumberOfRecipient = personIdentificationNumberOfRecipient;
           this.year = year;
    }


    /**
     * Gets the month value for this MonthlyPaymentAssignment.
     * 
     * @return month
     */
    public is.idega.idegaweb.egov.childcare.rvk.webservice.client.CalendarMonth getMonth() {
        return month;
    }


    /**
     * Sets the month value for this MonthlyPaymentAssignment.
     * 
     * @param month
     */
    public void setMonth(is.idega.idegaweb.egov.childcare.rvk.webservice.client.CalendarMonth month) {
        this.month = month;
    }


    /**
     * Gets the personIdentificationNumberOfRecipient value for this MonthlyPaymentAssignment.
     * 
     * @return personIdentificationNumberOfRecipient
     */
    public java.lang.String getPersonIdentificationNumberOfRecipient() {
        return personIdentificationNumberOfRecipient;
    }


    /**
     * Sets the personIdentificationNumberOfRecipient value for this MonthlyPaymentAssignment.
     * 
     * @param personIdentificationNumberOfRecipient
     */
    public void setPersonIdentificationNumberOfRecipient(java.lang.String personIdentificationNumberOfRecipient) {
        this.personIdentificationNumberOfRecipient = personIdentificationNumberOfRecipient;
    }


    /**
     * Gets the year value for this MonthlyPaymentAssignment.
     * 
     * @return year
     */
    public java.lang.Short getYear() {
        return year;
    }


    /**
     * Sets the year value for this MonthlyPaymentAssignment.
     * 
     * @param year
     */
    public void setYear(java.lang.Short year) {
        this.year = year;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof MonthlyPaymentAssignment)) return false;
        MonthlyPaymentAssignment other = (MonthlyPaymentAssignment) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.month==null && other.getMonth()==null) || 
             (this.month!=null &&
              this.month.equals(other.getMonth()))) &&
            ((this.personIdentificationNumberOfRecipient==null && other.getPersonIdentificationNumberOfRecipient()==null) || 
             (this.personIdentificationNumberOfRecipient!=null &&
              this.personIdentificationNumberOfRecipient.equals(other.getPersonIdentificationNumberOfRecipient()))) &&
            ((this.year==null && other.getYear()==null) || 
             (this.year!=null &&
              this.year.equals(other.getYear())));
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
        if (getMonth() != null) {
            _hashCode += getMonth().hashCode();
        }
        if (getPersonIdentificationNumberOfRecipient() != null) {
            _hashCode += getPersonIdentificationNumberOfRecipient().hashCode();
        }
        if (getYear() != null) {
            _hashCode += getYear().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MonthlyPaymentAssignment.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "MonthlyPaymentAssignment"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("month");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "Month"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "CalendarMonth"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("personIdentificationNumberOfRecipient");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "PersonIdentificationNumberOfRecipient"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("year");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "Year"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
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
