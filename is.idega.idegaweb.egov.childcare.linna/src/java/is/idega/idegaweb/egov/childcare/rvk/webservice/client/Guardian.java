/**
 * Guardian.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Aug 26, 2008 (12:29:12 CEST) WSDL2Java emitter.
 */

package is.idega.idegaweb.egov.childcare.rvk.webservice.client;

public class Guardian  implements java.io.Serializable {
    private java.lang.String address;

    private java.lang.String emailAddress;

    private java.lang.String homePhoneNumber;

    private java.lang.String languageCode1;

    private java.lang.String languageCode2;

    private is.idega.idegaweb.egov.childcare.rvk.webservice.client.MaritalState maritalState;

    private java.lang.String mobilePhoneNumber;

    private java.lang.String municipality;

    private java.lang.String name;

    private java.lang.String personIdentificationNumber;

    private java.lang.Short postcode;

    private is.idega.idegaweb.egov.childcare.rvk.webservice.client.Relationship relationship;

    private java.lang.String workPhoneNumber;

    public Guardian() {
    }

    public Guardian(
           java.lang.String address,
           java.lang.String emailAddress,
           java.lang.String homePhoneNumber,
           java.lang.String languageCode1,
           java.lang.String languageCode2,
           is.idega.idegaweb.egov.childcare.rvk.webservice.client.MaritalState maritalState,
           java.lang.String mobilePhoneNumber,
           java.lang.String municipality,
           java.lang.String name,
           java.lang.String personIdentificationNumber,
           java.lang.Short postcode,
           is.idega.idegaweb.egov.childcare.rvk.webservice.client.Relationship relationship,
           java.lang.String workPhoneNumber) {
           this.address = address;
           this.emailAddress = emailAddress;
           this.homePhoneNumber = homePhoneNumber;
           this.languageCode1 = languageCode1;
           this.languageCode2 = languageCode2;
           this.maritalState = maritalState;
           this.mobilePhoneNumber = mobilePhoneNumber;
           this.municipality = municipality;
           this.name = name;
           this.personIdentificationNumber = personIdentificationNumber;
           this.postcode = postcode;
           this.relationship = relationship;
           this.workPhoneNumber = workPhoneNumber;
    }


    /**
     * Gets the address value for this Guardian.
     * 
     * @return address
     */
    public java.lang.String getAddress() {
        return address;
    }


    /**
     * Sets the address value for this Guardian.
     * 
     * @param address
     */
    public void setAddress(java.lang.String address) {
        this.address = address;
    }


    /**
     * Gets the emailAddress value for this Guardian.
     * 
     * @return emailAddress
     */
    public java.lang.String getEmailAddress() {
        return emailAddress;
    }


    /**
     * Sets the emailAddress value for this Guardian.
     * 
     * @param emailAddress
     */
    public void setEmailAddress(java.lang.String emailAddress) {
        this.emailAddress = emailAddress;
    }


    /**
     * Gets the homePhoneNumber value for this Guardian.
     * 
     * @return homePhoneNumber
     */
    public java.lang.String getHomePhoneNumber() {
        return homePhoneNumber;
    }


    /**
     * Sets the homePhoneNumber value for this Guardian.
     * 
     * @param homePhoneNumber
     */
    public void setHomePhoneNumber(java.lang.String homePhoneNumber) {
        this.homePhoneNumber = homePhoneNumber;
    }


    /**
     * Gets the languageCode1 value for this Guardian.
     * 
     * @return languageCode1
     */
    public java.lang.String getLanguageCode1() {
        return languageCode1;
    }


    /**
     * Sets the languageCode1 value for this Guardian.
     * 
     * @param languageCode1
     */
    public void setLanguageCode1(java.lang.String languageCode1) {
        this.languageCode1 = languageCode1;
    }


    /**
     * Gets the languageCode2 value for this Guardian.
     * 
     * @return languageCode2
     */
    public java.lang.String getLanguageCode2() {
        return languageCode2;
    }


    /**
     * Sets the languageCode2 value for this Guardian.
     * 
     * @param languageCode2
     */
    public void setLanguageCode2(java.lang.String languageCode2) {
        this.languageCode2 = languageCode2;
    }


    /**
     * Gets the maritalState value for this Guardian.
     * 
     * @return maritalState
     */
    public is.idega.idegaweb.egov.childcare.rvk.webservice.client.MaritalState getMaritalState() {
        return maritalState;
    }


    /**
     * Sets the maritalState value for this Guardian.
     * 
     * @param maritalState
     */
    public void setMaritalState(is.idega.idegaweb.egov.childcare.rvk.webservice.client.MaritalState maritalState) {
        this.maritalState = maritalState;
    }


    /**
     * Gets the mobilePhoneNumber value for this Guardian.
     * 
     * @return mobilePhoneNumber
     */
    public java.lang.String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }


    /**
     * Sets the mobilePhoneNumber value for this Guardian.
     * 
     * @param mobilePhoneNumber
     */
    public void setMobilePhoneNumber(java.lang.String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
    }


    /**
     * Gets the municipality value for this Guardian.
     * 
     * @return municipality
     */
    public java.lang.String getMunicipality() {
        return municipality;
    }


    /**
     * Sets the municipality value for this Guardian.
     * 
     * @param municipality
     */
    public void setMunicipality(java.lang.String municipality) {
        this.municipality = municipality;
    }


    /**
     * Gets the name value for this Guardian.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this Guardian.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the personIdentificationNumber value for this Guardian.
     * 
     * @return personIdentificationNumber
     */
    public java.lang.String getPersonIdentificationNumber() {
        return personIdentificationNumber;
    }


    /**
     * Sets the personIdentificationNumber value for this Guardian.
     * 
     * @param personIdentificationNumber
     */
    public void setPersonIdentificationNumber(java.lang.String personIdentificationNumber) {
        this.personIdentificationNumber = personIdentificationNumber;
    }


    /**
     * Gets the postcode value for this Guardian.
     * 
     * @return postcode
     */
    public java.lang.Short getPostcode() {
        return postcode;
    }


    /**
     * Sets the postcode value for this Guardian.
     * 
     * @param postcode
     */
    public void setPostcode(java.lang.Short postcode) {
        this.postcode = postcode;
    }


    /**
     * Gets the relationship value for this Guardian.
     * 
     * @return relationship
     */
    public is.idega.idegaweb.egov.childcare.rvk.webservice.client.Relationship getRelationship() {
        return relationship;
    }


    /**
     * Sets the relationship value for this Guardian.
     * 
     * @param relationship
     */
    public void setRelationship(is.idega.idegaweb.egov.childcare.rvk.webservice.client.Relationship relationship) {
        this.relationship = relationship;
    }


    /**
     * Gets the workPhoneNumber value for this Guardian.
     * 
     * @return workPhoneNumber
     */
    public java.lang.String getWorkPhoneNumber() {
        return workPhoneNumber;
    }


    /**
     * Sets the workPhoneNumber value for this Guardian.
     * 
     * @param workPhoneNumber
     */
    public void setWorkPhoneNumber(java.lang.String workPhoneNumber) {
        this.workPhoneNumber = workPhoneNumber;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Guardian)) return false;
        Guardian other = (Guardian) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.address==null && other.getAddress()==null) || 
             (this.address!=null &&
              this.address.equals(other.getAddress()))) &&
            ((this.emailAddress==null && other.getEmailAddress()==null) || 
             (this.emailAddress!=null &&
              this.emailAddress.equals(other.getEmailAddress()))) &&
            ((this.homePhoneNumber==null && other.getHomePhoneNumber()==null) || 
             (this.homePhoneNumber!=null &&
              this.homePhoneNumber.equals(other.getHomePhoneNumber()))) &&
            ((this.languageCode1==null && other.getLanguageCode1()==null) || 
             (this.languageCode1!=null &&
              this.languageCode1.equals(other.getLanguageCode1()))) &&
            ((this.languageCode2==null && other.getLanguageCode2()==null) || 
             (this.languageCode2!=null &&
              this.languageCode2.equals(other.getLanguageCode2()))) &&
            ((this.maritalState==null && other.getMaritalState()==null) || 
             (this.maritalState!=null &&
              this.maritalState.equals(other.getMaritalState()))) &&
            ((this.mobilePhoneNumber==null && other.getMobilePhoneNumber()==null) || 
             (this.mobilePhoneNumber!=null &&
              this.mobilePhoneNumber.equals(other.getMobilePhoneNumber()))) &&
            ((this.municipality==null && other.getMunicipality()==null) || 
             (this.municipality!=null &&
              this.municipality.equals(other.getMunicipality()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.personIdentificationNumber==null && other.getPersonIdentificationNumber()==null) || 
             (this.personIdentificationNumber!=null &&
              this.personIdentificationNumber.equals(other.getPersonIdentificationNumber()))) &&
            ((this.postcode==null && other.getPostcode()==null) || 
             (this.postcode!=null &&
              this.postcode.equals(other.getPostcode()))) &&
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
        if (getAddress() != null) {
            _hashCode += getAddress().hashCode();
        }
        if (getEmailAddress() != null) {
            _hashCode += getEmailAddress().hashCode();
        }
        if (getHomePhoneNumber() != null) {
            _hashCode += getHomePhoneNumber().hashCode();
        }
        if (getLanguageCode1() != null) {
            _hashCode += getLanguageCode1().hashCode();
        }
        if (getLanguageCode2() != null) {
            _hashCode += getLanguageCode2().hashCode();
        }
        if (getMaritalState() != null) {
            _hashCode += getMaritalState().hashCode();
        }
        if (getMobilePhoneNumber() != null) {
            _hashCode += getMobilePhoneNumber().hashCode();
        }
        if (getMunicipality() != null) {
            _hashCode += getMunicipality().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getPersonIdentificationNumber() != null) {
            _hashCode += getPersonIdentificationNumber().hashCode();
        }
        if (getPostcode() != null) {
            _hashCode += getPostcode().hashCode();
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
        new org.apache.axis.description.TypeDesc(Guardian.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "Guardian"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("address");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "Address"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("languageCode1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "LanguageCode1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("languageCode2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "LanguageCode2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maritalState");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "MaritalState"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "MaritalState"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("mobilePhoneNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "MobilePhoneNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("municipality");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "Municipality"));
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
        elemField.setFieldName("personIdentificationNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "PersonIdentificationNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("postcode");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "Postcode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
