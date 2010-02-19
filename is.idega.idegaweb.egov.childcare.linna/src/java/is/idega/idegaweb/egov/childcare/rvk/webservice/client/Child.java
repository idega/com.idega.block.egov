/**
 * Child.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Aug 26, 2008 (12:29:12 CEST) WSDL2Java emitter.
 */

package is.idega.idegaweb.egov.childcare.rvk.webservice.client;

public class Child  implements java.io.Serializable {
    private java.lang.String address;

    private java.util.Calendar dateOfBirth;

    private java.lang.String languageCode1;

    private java.lang.String languageCode2;

    private java.lang.String mainPhoneNumber;

    private java.lang.String municipality;

    private java.lang.String name;

    private java.lang.String personIdentificationNumber;

    private java.lang.Short postcode;

    public Child() {
    }

    public Child(
           java.lang.String address,
           java.util.Calendar dateOfBirth,
           java.lang.String languageCode1,
           java.lang.String languageCode2,
           java.lang.String mainPhoneNumber,
           java.lang.String municipality,
           java.lang.String name,
           java.lang.String personIdentificationNumber,
           java.lang.Short postcode) {
           this.address = address;
           this.dateOfBirth = dateOfBirth;
           this.languageCode1 = languageCode1;
           this.languageCode2 = languageCode2;
           this.mainPhoneNumber = mainPhoneNumber;
           this.municipality = municipality;
           this.name = name;
           this.personIdentificationNumber = personIdentificationNumber;
           this.postcode = postcode;
    }


    /**
     * Gets the address value for this Child.
     * 
     * @return address
     */
    public java.lang.String getAddress() {
        return address;
    }


    /**
     * Sets the address value for this Child.
     * 
     * @param address
     */
    public void setAddress(java.lang.String address) {
        this.address = address;
    }


    /**
     * Gets the dateOfBirth value for this Child.
     * 
     * @return dateOfBirth
     */
    public java.util.Calendar getDateOfBirth() {
        return dateOfBirth;
    }


    /**
     * Sets the dateOfBirth value for this Child.
     * 
     * @param dateOfBirth
     */
    public void setDateOfBirth(java.util.Calendar dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    /**
     * Gets the languageCode1 value for this Child.
     * 
     * @return languageCode1
     */
    public java.lang.String getLanguageCode1() {
        return languageCode1;
    }


    /**
     * Sets the languageCode1 value for this Child.
     * 
     * @param languageCode1
     */
    public void setLanguageCode1(java.lang.String languageCode1) {
        this.languageCode1 = languageCode1;
    }


    /**
     * Gets the languageCode2 value for this Child.
     * 
     * @return languageCode2
     */
    public java.lang.String getLanguageCode2() {
        return languageCode2;
    }


    /**
     * Sets the languageCode2 value for this Child.
     * 
     * @param languageCode2
     */
    public void setLanguageCode2(java.lang.String languageCode2) {
        this.languageCode2 = languageCode2;
    }


    /**
     * Gets the mainPhoneNumber value for this Child.
     * 
     * @return mainPhoneNumber
     */
    public java.lang.String getMainPhoneNumber() {
        return mainPhoneNumber;
    }


    /**
     * Sets the mainPhoneNumber value for this Child.
     * 
     * @param mainPhoneNumber
     */
    public void setMainPhoneNumber(java.lang.String mainPhoneNumber) {
        this.mainPhoneNumber = mainPhoneNumber;
    }


    /**
     * Gets the municipality value for this Child.
     * 
     * @return municipality
     */
    public java.lang.String getMunicipality() {
        return municipality;
    }


    /**
     * Sets the municipality value for this Child.
     * 
     * @param municipality
     */
    public void setMunicipality(java.lang.String municipality) {
        this.municipality = municipality;
    }


    /**
     * Gets the name value for this Child.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this Child.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the personIdentificationNumber value for this Child.
     * 
     * @return personIdentificationNumber
     */
    public java.lang.String getPersonIdentificationNumber() {
        return personIdentificationNumber;
    }


    /**
     * Sets the personIdentificationNumber value for this Child.
     * 
     * @param personIdentificationNumber
     */
    public void setPersonIdentificationNumber(java.lang.String personIdentificationNumber) {
        this.personIdentificationNumber = personIdentificationNumber;
    }


    /**
     * Gets the postcode value for this Child.
     * 
     * @return postcode
     */
    public java.lang.Short getPostcode() {
        return postcode;
    }


    /**
     * Sets the postcode value for this Child.
     * 
     * @param postcode
     */
    public void setPostcode(java.lang.Short postcode) {
        this.postcode = postcode;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Child)) return false;
        Child other = (Child) obj;
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
            ((this.dateOfBirth==null && other.getDateOfBirth()==null) || 
             (this.dateOfBirth!=null &&
              this.dateOfBirth.equals(other.getDateOfBirth()))) &&
            ((this.languageCode1==null && other.getLanguageCode1()==null) || 
             (this.languageCode1!=null &&
              this.languageCode1.equals(other.getLanguageCode1()))) &&
            ((this.languageCode2==null && other.getLanguageCode2()==null) || 
             (this.languageCode2!=null &&
              this.languageCode2.equals(other.getLanguageCode2()))) &&
            ((this.mainPhoneNumber==null && other.getMainPhoneNumber()==null) || 
             (this.mainPhoneNumber!=null &&
              this.mainPhoneNumber.equals(other.getMainPhoneNumber()))) &&
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
              this.postcode.equals(other.getPostcode())));
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
        if (getDateOfBirth() != null) {
            _hashCode += getDateOfBirth().hashCode();
        }
        if (getLanguageCode1() != null) {
            _hashCode += getLanguageCode1().hashCode();
        }
        if (getLanguageCode2() != null) {
            _hashCode += getLanguageCode2().hashCode();
        }
        if (getMainPhoneNumber() != null) {
            _hashCode += getMainPhoneNumber().hashCode();
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
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Child.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "Child"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("address");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "Address"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dateOfBirth");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "DateOfBirth"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
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
        elemField.setFieldName("mainPhoneNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "MainPhoneNumber"));
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
