/**
 * NextOfKinBesidesGuardian.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Aug 26, 2008 (12:29:12 CEST) WSDL2Java emitter.
 */

package is.idega.idegaweb.egov.childcare.rvk.webservice.client;

public class NextOfKinBesidesGuardian  implements java.io.Serializable {
    private java.lang.String emailAddress;

    private java.lang.String homePhoneNumber;

    private java.lang.String mobilePhoneNumber;

    private java.lang.String name;

    private is.idega.idegaweb.egov.childcare.rvk.webservice.client.Relationship relationship;

    private java.lang.String workPhoneNumber;

    public NextOfKinBesidesGuardian() {
    }

    public NextOfKinBesidesGuardian(
           java.lang.String emailAddress,
           java.lang.String homePhoneNumber,
           java.lang.String mobilePhoneNumber,
           java.lang.String name,
           is.idega.idegaweb.egov.childcare.rvk.webservice.client.Relationship relationship,
           java.lang.String workPhoneNumber) {
           this.emailAddress = emailAddress;
           this.homePhoneNumber = homePhoneNumber;
           this.mobilePhoneNumber = mobilePhoneNumber;
           this.name = name;
           this.relationship = relationship;
           this.workPhoneNumber = workPhoneNumber;
    }


    /**
     * Gets the emailAddress value for this NextOfKinBesidesGuardian.
     * 
     * @return emailAddress
     */
    public java.lang.String getEmailAddress() {
        return emailAddress;
    }


    /**
     * Sets the emailAddress value for this NextOfKinBesidesGuardian.
     * 
     * @param emailAddress
     */
    public void setEmailAddress(java.lang.String emailAddress) {
        this.emailAddress = emailAddress;
    }


    /**
     * Gets the homePhoneNumber value for this NextOfKinBesidesGuardian.
     * 
     * @return homePhoneNumber
     */
    public java.lang.String getHomePhoneNumber() {
        return homePhoneNumber;
    }


    /**
     * Sets the homePhoneNumber value for this NextOfKinBesidesGuardian.
     * 
     * @param homePhoneNumber
     */
    public void setHomePhoneNumber(java.lang.String homePhoneNumber) {
        this.homePhoneNumber = homePhoneNumber;
    }


    /**
     * Gets the mobilePhoneNumber value for this NextOfKinBesidesGuardian.
     * 
     * @return mobilePhoneNumber
     */
    public java.lang.String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }


    /**
     * Sets the mobilePhoneNumber value for this NextOfKinBesidesGuardian.
     * 
     * @param mobilePhoneNumber
     */
    public void setMobilePhoneNumber(java.lang.String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }


    /**
     * Gets the name value for this NextOfKinBesidesGuardian.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this NextOfKinBesidesGuardian.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the relationship value for this NextOfKinBesidesGuardian.
     * 
     * @return relationship
     */
    public is.idega.idegaweb.egov.childcare.rvk.webservice.client.Relationship getRelationship() {
        return relationship;
    }


    /**
     * Sets the relationship value for this NextOfKinBesidesGuardian.
     * 
     * @param relationship
     */
    public void setRelationship(is.idega.idegaweb.egov.childcare.rvk.webservice.client.Relationship relationship) {
        this.relationship = relationship;
    }


    /**
     * Gets the workPhoneNumber value for this NextOfKinBesidesGuardian.
     * 
     * @return workPhoneNumber
     */
    public java.lang.String getWorkPhoneNumber() {
        return workPhoneNumber;
    }


    /**
     * Sets the workPhoneNumber value for this NextOfKinBesidesGuardian.
     * 
     * @param workPhoneNumber
     */
    public void setWorkPhoneNumber(java.lang.String workPhoneNumber) {
        this.workPhoneNumber = workPhoneNumber;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof NextOfKinBesidesGuardian)) return false;
        NextOfKinBesidesGuardian other = (NextOfKinBesidesGuardian) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.emailAddress==null && other.getEmailAddress()==null) || 
             (this.emailAddress!=null &&
              this.emailAddress.equals(other.getEmailAddress()))) &&
            ((this.homePhoneNumber==null && other.getHomePhoneNumber()==null) || 
             (this.homePhoneNumber!=null &&
              this.homePhoneNumber.equals(other.getHomePhoneNumber()))) &&
            ((this.mobilePhoneNumber==null && other.getMobilePhoneNumber()==null) || 
             (this.mobilePhoneNumber!=null &&
              this.mobilePhoneNumber.equals(other.getMobilePhoneNumber()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.relationship==null && other.getRelationship()==null) || 
             (this.relationship!=null &&
              this.relationship.equals(other.getRelationship()))) &&
            ((this.workPhoneNumber==null && other.getWorkPhoneNumber()==null) || 
             (this.workPhoneNumber!=null &&
              this.workPhoneNumber.equals(other.getWorkPhoneNumber())));
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
        if (getEmailAddress() != null) {
            _hashCode += getEmailAddress().hashCode();
        }
        if (getHomePhoneNumber() != null) {
            _hashCode += getHomePhoneNumber().hashCode();
        }
        if (getMobilePhoneNumber() != null) {
            _hashCode += getMobilePhoneNumber().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getRelationship() != null) {
            _hashCode += getRelationship().hashCode();
        }
        if (getWorkPhoneNumber() != null) {
            _hashCode += getWorkPhoneNumber().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(NextOfKinBesidesGuardian.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "NextOfKinBesidesGuardian"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("emailAddress");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "EmailAddress"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("homePhoneNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "HomePhoneNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mobilePhoneNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "MobilePhoneNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
        elemField.setFieldName("relationship");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "Relationship"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "Relationship"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("workPhoneNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "WorkPhoneNumber"));
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
