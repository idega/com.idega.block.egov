/**
 * ChildAndDaycareApplicationState.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Aug 26, 2008 (12:29:12 CEST) WSDL2Java emitter.
 */

package is.idega.idegaweb.egov.childcare.rvk.webservice.client;

public class ChildAndDaycareApplicationState  implements java.io.Serializable {
    private java.util.Calendar dateOfLastChangeDaycareApplication;

    private java.util.Calendar dateOfLastChangeServiceGuaranteeApplication;

    private java.lang.String name;

    private java.lang.String personIdentificationNumber;

    public ChildAndDaycareApplicationState() {
    }

    public ChildAndDaycareApplicationState(
           java.util.Calendar dateOfLastChangeDaycareApplication,
           java.util.Calendar dateOfLastChangeServiceGuaranteeApplication,
           java.lang.String name,
           java.lang.String personIdentificationNumber) {
           this.dateOfLastChangeDaycareApplication = dateOfLastChangeDaycareApplication;
           this.dateOfLastChangeServiceGuaranteeApplication = dateOfLastChangeServiceGuaranteeApplication;
           this.name = name;
           this.personIdentificationNumber = personIdentificationNumber;
    }


    /**
     * Gets the dateOfLastChangeDaycareApplication value for this ChildAndDaycareApplicationState.
     * 
     * @return dateOfLastChangeDaycareApplication
     */
    public java.util.Calendar getDateOfLastChangeDaycareApplication() {
        return dateOfLastChangeDaycareApplication;
    }


    /**
     * Sets the dateOfLastChangeDaycareApplication value for this ChildAndDaycareApplicationState.
     * 
     * @param dateOfLastChangeDaycareApplication
     */
    public void setDateOfLastChangeDaycareApplication(java.util.Calendar dateOfLastChangeDaycareApplication) {
        this.dateOfLastChangeDaycareApplication = dateOfLastChangeDaycareApplication;
    }


    /**
     * Gets the dateOfLastChangeServiceGuaranteeApplication value for this ChildAndDaycareApplicationState.
     * 
     * @return dateOfLastChangeServiceGuaranteeApplication
     */
    public java.util.Calendar getDateOfLastChangeServiceGuaranteeApplication() {
        return dateOfLastChangeServiceGuaranteeApplication;
    }


    /**
     * Sets the dateOfLastChangeServiceGuaranteeApplication value for this ChildAndDaycareApplicationState.
     * 
     * @param dateOfLastChangeServiceGuaranteeApplication
     */
    public void setDateOfLastChangeServiceGuaranteeApplication(java.util.Calendar dateOfLastChangeServiceGuaranteeApplication) {
        this.dateOfLastChangeServiceGuaranteeApplication = dateOfLastChangeServiceGuaranteeApplication;
    }


    /**
     * Gets the name value for this ChildAndDaycareApplicationState.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this ChildAndDaycareApplicationState.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the personIdentificationNumber value for this ChildAndDaycareApplicationState.
     * 
     * @return personIdentificationNumber
     */
    public java.lang.String getPersonIdentificationNumber() {
        return personIdentificationNumber;
    }


    /**
     * Sets the personIdentificationNumber value for this ChildAndDaycareApplicationState.
     * 
     * @param personIdentificationNumber
     */
    public void setPersonIdentificationNumber(java.lang.String personIdentificationNumber) {
        this.personIdentificationNumber = personIdentificationNumber;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ChildAndDaycareApplicationState)) return false;
        ChildAndDaycareApplicationState other = (ChildAndDaycareApplicationState) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.dateOfLastChangeDaycareApplication==null && other.getDateOfLastChangeDaycareApplication()==null) || 
             (this.dateOfLastChangeDaycareApplication!=null &&
              this.dateOfLastChangeDaycareApplication.equals(other.getDateOfLastChangeDaycareApplication()))) &&
            ((this.dateOfLastChangeServiceGuaranteeApplication==null && other.getDateOfLastChangeServiceGuaranteeApplication()==null) || 
             (this.dateOfLastChangeServiceGuaranteeApplication!=null &&
              this.dateOfLastChangeServiceGuaranteeApplication.equals(other.getDateOfLastChangeServiceGuaranteeApplication()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.personIdentificationNumber==null && other.getPersonIdentificationNumber()==null) || 
             (this.personIdentificationNumber!=null &&
              this.personIdentificationNumber.equals(other.getPersonIdentificationNumber())));
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
        if (getDateOfLastChangeDaycareApplication() != null) {
            _hashCode += getDateOfLastChangeDaycareApplication().hashCode();
        }
        if (getDateOfLastChangeServiceGuaranteeApplication() != null) {
            _hashCode += getDateOfLastChangeServiceGuaranteeApplication().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getPersonIdentificationNumber() != null) {
            _hashCode += getPersonIdentificationNumber().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ChildAndDaycareApplicationState.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "ChildAndDaycareApplicationState"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dateOfLastChangeDaycareApplication");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "DateOfLastChangeDaycareApplication"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dateOfLastChangeServiceGuaranteeApplication");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "DateOfLastChangeServiceGuaranteeApplication"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "Name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("personIdentificationNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "PersonIdentificationNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
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
