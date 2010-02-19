/**
 * ServiceGuaranteeApplication.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Aug 26, 2008 (12:29:12 CEST) WSDL2Java emitter.
 */

package is.idega.idegaweb.egov.childcare.rvk.webservice.client;

public class ServiceGuaranteeApplication  implements java.io.Serializable {
    private is.idega.idegaweb.egov.childcare.rvk.webservice.client.BankAccount bankAccountOfGuardian1;

    private is.idega.idegaweb.egov.childcare.rvk.webservice.client.BankAccount bankAccountOfGuardian2;

    private java.lang.String comments;

    private java.util.Calendar dateOfApplication;

    private java.util.Calendar dateOfFirstPotentialPayment;

    private java.util.Calendar dateOfLastChange;

    private is.idega.idegaweb.egov.childcare.rvk.webservice.client.MonthlyPaymentAssignment[] paymentPlan;

    private java.lang.String personIdentificationNumberOfChild;

    private java.lang.String personIdentificationNumberOfGuardian1;

    private java.lang.String personIdentificationNumberOfGuardian2;

    private is.idega.idegaweb.egov.childcare.rvk.webservice.client.WhoTakesCareOfChildForThisGuardian whoTakesCareOfChildForGuardian1;

    private is.idega.idegaweb.egov.childcare.rvk.webservice.client.WhoTakesCareOfChildForThisGuardian whoTakesCareOfChildForGuardian2;

    public ServiceGuaranteeApplication() {
    }

    public ServiceGuaranteeApplication(
           is.idega.idegaweb.egov.childcare.rvk.webservice.client.BankAccount bankAccountOfGuardian1,
           is.idega.idegaweb.egov.childcare.rvk.webservice.client.BankAccount bankAccountOfGuardian2,
           java.lang.String comments,
           java.util.Calendar dateOfApplication,
           java.util.Calendar dateOfFirstPotentialPayment,
           java.util.Calendar dateOfLastChange,
           is.idega.idegaweb.egov.childcare.rvk.webservice.client.MonthlyPaymentAssignment[] paymentPlan,
           java.lang.String personIdentificationNumberOfChild,
           java.lang.String personIdentificationNumberOfGuardian1,
           java.lang.String personIdentificationNumberOfGuardian2,
           is.idega.idegaweb.egov.childcare.rvk.webservice.client.WhoTakesCareOfChildForThisGuardian whoTakesCareOfChildForGuardian1,
           is.idega.idegaweb.egov.childcare.rvk.webservice.client.WhoTakesCareOfChildForThisGuardian whoTakesCareOfChildForGuardian2) {
           this.bankAccountOfGuardian1 = bankAccountOfGuardian1;
           this.bankAccountOfGuardian2 = bankAccountOfGuardian2;
           this.comments = comments;
           this.dateOfApplication = dateOfApplication;
           this.dateOfFirstPotentialPayment = dateOfFirstPotentialPayment;
           this.dateOfLastChange = dateOfLastChange;
           this.paymentPlan = paymentPlan;
           this.personIdentificationNumberOfChild = personIdentificationNumberOfChild;
           this.personIdentificationNumberOfGuardian1 = personIdentificationNumberOfGuardian1;
           this.personIdentificationNumberOfGuardian2 = personIdentificationNumberOfGuardian2;
           this.whoTakesCareOfChildForGuardian1 = whoTakesCareOfChildForGuardian1;
           this.whoTakesCareOfChildForGuardian2 = whoTakesCareOfChildForGuardian2;
    }


    /**
     * Gets the bankAccountOfGuardian1 value for this ServiceGuaranteeApplication.
     * 
     * @return bankAccountOfGuardian1
     */
    public is.idega.idegaweb.egov.childcare.rvk.webservice.client.BankAccount getBankAccountOfGuardian1() {
        return bankAccountOfGuardian1;
    }


    /**
     * Sets the bankAccountOfGuardian1 value for this ServiceGuaranteeApplication.
     * 
     * @param bankAccountOfGuardian1
     */
    public void setBankAccountOfGuardian1(is.idega.idegaweb.egov.childcare.rvk.webservice.client.BankAccount bankAccountOfGuardian1) {
        this.bankAccountOfGuardian1 = bankAccountOfGuardian1;
    }


    /**
     * Gets the bankAccountOfGuardian2 value for this ServiceGuaranteeApplication.
     * 
     * @return bankAccountOfGuardian2
     */
    public is.idega.idegaweb.egov.childcare.rvk.webservice.client.BankAccount getBankAccountOfGuardian2() {
        return bankAccountOfGuardian2;
    }


    /**
     * Sets the bankAccountOfGuardian2 value for this ServiceGuaranteeApplication.
     * 
     * @param bankAccountOfGuardian2
     */
    public void setBankAccountOfGuardian2(is.idega.idegaweb.egov.childcare.rvk.webservice.client.BankAccount bankAccountOfGuardian2) {
        this.bankAccountOfGuardian2 = bankAccountOfGuardian2;
    }


    /**
     * Gets the comments value for this ServiceGuaranteeApplication.
     * 
     * @return comments
     */
    public java.lang.String getComments() {
        return comments;
    }


    /**
     * Sets the comments value for this ServiceGuaranteeApplication.
     * 
     * @param comments
     */
    public void setComments(java.lang.String comments) {
        this.comments = comments;
    }


    /**
     * Gets the dateOfApplication value for this ServiceGuaranteeApplication.
     * 
     * @return dateOfApplication
     */
    public java.util.Calendar getDateOfApplication() {
        return dateOfApplication;
    }


    /**
     * Sets the dateOfApplication value for this ServiceGuaranteeApplication.
     * 
     * @param dateOfApplication
     */
    public void setDateOfApplication(java.util.Calendar dateOfApplication) {
        this.dateOfApplication = dateOfApplication;
    }


    /**
     * Gets the dateOfFirstPotentialPayment value for this ServiceGuaranteeApplication.
     * 
     * @return dateOfFirstPotentialPayment
     */
    public java.util.Calendar getDateOfFirstPotentialPayment() {
        return dateOfFirstPotentialPayment;
    }


    /**
     * Sets the dateOfFirstPotentialPayment value for this ServiceGuaranteeApplication.
     * 
     * @param dateOfFirstPotentialPayment
     */
    public void setDateOfFirstPotentialPayment(java.util.Calendar dateOfFirstPotentialPayment) {
        this.dateOfFirstPotentialPayment = dateOfFirstPotentialPayment;
    }


    /**
     * Gets the dateOfLastChange value for this ServiceGuaranteeApplication.
     * 
     * @return dateOfLastChange
     */
    public java.util.Calendar getDateOfLastChange() {
        return dateOfLastChange;
    }


    /**
     * Sets the dateOfLastChange value for this ServiceGuaranteeApplication.
     * 
     * @param dateOfLastChange
     */
    public void setDateOfLastChange(java.util.Calendar dateOfLastChange) {
        this.dateOfLastChange = dateOfLastChange;
    }


    /**
     * Gets the paymentPlan value for this ServiceGuaranteeApplication.
     * 
     * @return paymentPlan
     */
    public is.idega.idegaweb.egov.childcare.rvk.webservice.client.MonthlyPaymentAssignment[] getPaymentPlan() {
        return paymentPlan;
    }


    /**
     * Sets the paymentPlan value for this ServiceGuaranteeApplication.
     * 
     * @param paymentPlan
     */
    public void setPaymentPlan(is.idega.idegaweb.egov.childcare.rvk.webservice.client.MonthlyPaymentAssignment[] paymentPlan) {
        this.paymentPlan = paymentPlan;
    }


    /**
     * Gets the personIdentificationNumberOfChild value for this ServiceGuaranteeApplication.
     * 
     * @return personIdentificationNumberOfChild
     */
    public java.lang.String getPersonIdentificationNumberOfChild() {
        return personIdentificationNumberOfChild;
    }


    /**
     * Sets the personIdentificationNumberOfChild value for this ServiceGuaranteeApplication.
     * 
     * @param personIdentificationNumberOfChild
     */
    public void setPersonIdentificationNumberOfChild(java.lang.String personIdentificationNumberOfChild) {
        this.personIdentificationNumberOfChild = personIdentificationNumberOfChild;
    }


    /**
     * Gets the personIdentificationNumberOfGuardian1 value for this ServiceGuaranteeApplication.
     * 
     * @return personIdentificationNumberOfGuardian1
     */
    public java.lang.String getPersonIdentificationNumberOfGuardian1() {
        return personIdentificationNumberOfGuardian1;
    }


    /**
     * Sets the personIdentificationNumberOfGuardian1 value for this ServiceGuaranteeApplication.
     * 
     * @param personIdentificationNumberOfGuardian1
     */
    public void setPersonIdentificationNumberOfGuardian1(java.lang.String personIdentificationNumberOfGuardian1) {
        this.personIdentificationNumberOfGuardian1 = personIdentificationNumberOfGuardian1;
    }


    /**
     * Gets the personIdentificationNumberOfGuardian2 value for this ServiceGuaranteeApplication.
     * 
     * @return personIdentificationNumberOfGuardian2
     */
    public java.lang.String getPersonIdentificationNumberOfGuardian2() {
        return personIdentificationNumberOfGuardian2;
    }


    /**
     * Sets the personIdentificationNumberOfGuardian2 value for this ServiceGuaranteeApplication.
     * 
     * @param personIdentificationNumberOfGuardian2
     */
    public void setPersonIdentificationNumberOfGuardian2(java.lang.String personIdentificationNumberOfGuardian2) {
        this.personIdentificationNumberOfGuardian2 = personIdentificationNumberOfGuardian2;
    }


    /**
     * Gets the whoTakesCareOfChildForGuardian1 value for this ServiceGuaranteeApplication.
     * 
     * @return whoTakesCareOfChildForGuardian1
     */
    public is.idega.idegaweb.egov.childcare.rvk.webservice.client.WhoTakesCareOfChildForThisGuardian getWhoTakesCareOfChildForGuardian1() {
        return whoTakesCareOfChildForGuardian1;
    }


    /**
     * Sets the whoTakesCareOfChildForGuardian1 value for this ServiceGuaranteeApplication.
     * 
     * @param whoTakesCareOfChildForGuardian1
     */
    public void setWhoTakesCareOfChildForGuardian1(is.idega.idegaweb.egov.childcare.rvk.webservice.client.WhoTakesCareOfChildForThisGuardian whoTakesCareOfChildForGuardian1) {
        this.whoTakesCareOfChildForGuardian1 = whoTakesCareOfChildForGuardian1;
    }


    /**
     * Gets the whoTakesCareOfChildForGuardian2 value for this ServiceGuaranteeApplication.
     * 
     * @return whoTakesCareOfChildForGuardian2
     */
    public is.idega.idegaweb.egov.childcare.rvk.webservice.client.WhoTakesCareOfChildForThisGuardian getWhoTakesCareOfChildForGuardian2() {
        return whoTakesCareOfChildForGuardian2;
    }


    /**
     * Sets the whoTakesCareOfChildForGuardian2 value for this ServiceGuaranteeApplication.
     * 
     * @param whoTakesCareOfChildForGuardian2
     */
    public void setWhoTakesCareOfChildForGuardian2(is.idega.idegaweb.egov.childcare.rvk.webservice.client.WhoTakesCareOfChildForThisGuardian whoTakesCareOfChildForGuardian2) {
        this.whoTakesCareOfChildForGuardian2 = whoTakesCareOfChildForGuardian2;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof ServiceGuaranteeApplication)) return false;
        ServiceGuaranteeApplication other = (ServiceGuaranteeApplication) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.bankAccountOfGuardian1==null && other.getBankAccountOfGuardian1()==null) || 
             (this.bankAccountOfGuardian1!=null &&
              this.bankAccountOfGuardian1.equals(other.getBankAccountOfGuardian1()))) &&
            ((this.bankAccountOfGuardian2==null && other.getBankAccountOfGuardian2()==null) || 
             (this.bankAccountOfGuardian2!=null &&
              this.bankAccountOfGuardian2.equals(other.getBankAccountOfGuardian2()))) &&
            ((this.comments==null && other.getComments()==null) || 
             (this.comments!=null &&
              this.comments.equals(other.getComments()))) &&
            ((this.dateOfApplication==null && other.getDateOfApplication()==null) || 
             (this.dateOfApplication!=null &&
              this.dateOfApplication.equals(other.getDateOfApplication()))) &&
            ((this.dateOfFirstPotentialPayment==null && other.getDateOfFirstPotentialPayment()==null) || 
             (this.dateOfFirstPotentialPayment!=null &&
              this.dateOfFirstPotentialPayment.equals(other.getDateOfFirstPotentialPayment()))) &&
            ((this.dateOfLastChange==null && other.getDateOfLastChange()==null) || 
             (this.dateOfLastChange!=null &&
              this.dateOfLastChange.equals(other.getDateOfLastChange()))) &&
            ((this.paymentPlan==null && other.getPaymentPlan()==null) || 
             (this.paymentPlan!=null &&
              java.util.Arrays.equals(this.paymentPlan, other.getPaymentPlan()))) &&
            ((this.personIdentificationNumberOfChild==null && other.getPersonIdentificationNumberOfChild()==null) || 
             (this.personIdentificationNumberOfChild!=null &&
              this.personIdentificationNumberOfChild.equals(other.getPersonIdentificationNumberOfChild()))) &&
            ((this.personIdentificationNumberOfGuardian1==null && other.getPersonIdentificationNumberOfGuardian1()==null) || 
             (this.personIdentificationNumberOfGuardian1!=null &&
              this.personIdentificationNumberOfGuardian1.equals(other.getPersonIdentificationNumberOfGuardian1()))) &&
            ((this.personIdentificationNumberOfGuardian2==null && other.getPersonIdentificationNumberOfGuardian2()==null) || 
             (this.personIdentificationNumberOfGuardian2!=null &&
              this.personIdentificationNumberOfGuardian2.equals(other.getPersonIdentificationNumberOfGuardian2()))) &&
            ((this.whoTakesCareOfChildForGuardian1==null && other.getWhoTakesCareOfChildForGuardian1()==null) || 
             (this.whoTakesCareOfChildForGuardian1!=null &&
              this.whoTakesCareOfChildForGuardian1.equals(other.getWhoTakesCareOfChildForGuardian1()))) &&
            ((this.whoTakesCareOfChildForGuardian2==null && other.getWhoTakesCareOfChildForGuardian2()==null) || 
             (this.whoTakesCareOfChildForGuardian2!=null &&
              this.whoTakesCareOfChildForGuardian2.equals(other.getWhoTakesCareOfChildForGuardian2())));
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
        if (getBankAccountOfGuardian1() != null) {
            _hashCode += getBankAccountOfGuardian1().hashCode();
        }
        if (getBankAccountOfGuardian2() != null) {
            _hashCode += getBankAccountOfGuardian2().hashCode();
        }
        if (getComments() != null) {
            _hashCode += getComments().hashCode();
        }
        if (getDateOfApplication() != null) {
            _hashCode += getDateOfApplication().hashCode();
        }
        if (getDateOfFirstPotentialPayment() != null) {
            _hashCode += getDateOfFirstPotentialPayment().hashCode();
        }
        if (getDateOfLastChange() != null) {
            _hashCode += getDateOfLastChange().hashCode();
        }
        if (getPaymentPlan() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPaymentPlan());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPaymentPlan(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getPersonIdentificationNumberOfChild() != null) {
            _hashCode += getPersonIdentificationNumberOfChild().hashCode();
        }
        if (getPersonIdentificationNumberOfGuardian1() != null) {
            _hashCode += getPersonIdentificationNumberOfGuardian1().hashCode();
        }
        if (getPersonIdentificationNumberOfGuardian2() != null) {
            _hashCode += getPersonIdentificationNumberOfGuardian2().hashCode();
        }
        if (getWhoTakesCareOfChildForGuardian1() != null) {
            _hashCode += getWhoTakesCareOfChildForGuardian1().hashCode();
        }
        if (getWhoTakesCareOfChildForGuardian2() != null) {
            _hashCode += getWhoTakesCareOfChildForGuardian2().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ServiceGuaranteeApplication.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "ServiceGuaranteeApplication"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bankAccountOfGuardian1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "BankAccountOfGuardian1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "BankAccount"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bankAccountOfGuardian2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "BankAccountOfGuardian2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "BankAccount"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("comments");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "Comments"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dateOfApplication");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "DateOfApplication"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dateOfFirstPotentialPayment");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "DateOfFirstPotentialPayment"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dateOfLastChange");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "DateOfLastChange"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paymentPlan");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "PaymentPlan"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "MonthlyPaymentAssignment"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "MonthlyPaymentAssignment"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("personIdentificationNumberOfChild");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "PersonIdentificationNumberOfChild"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("personIdentificationNumberOfGuardian1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "PersonIdentificationNumberOfGuardian1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("personIdentificationNumberOfGuardian2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "PersonIdentificationNumberOfGuardian2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("whoTakesCareOfChildForGuardian1");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "WhoTakesCareOfChildForGuardian1"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "WhoTakesCareOfChildForThisGuardian"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("whoTakesCareOfChildForGuardian2");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "WhoTakesCareOfChildForGuardian2"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "WhoTakesCareOfChildForThisGuardian"));
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
