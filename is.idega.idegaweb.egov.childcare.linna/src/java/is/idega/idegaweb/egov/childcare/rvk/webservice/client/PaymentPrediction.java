/**
 * PaymentPrediction.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Aug 26, 2008 (12:29:12 CEST) WSDL2Java emitter.
 */

package is.idega.idegaweb.egov.childcare.rvk.webservice.client;

public class PaymentPrediction  implements java.io.Serializable {
    private java.math.BigDecimal amountAlreadyPaid;

    private java.math.BigDecimal amountDue;

    private java.math.BigDecimal amountWillBePaid;

    private java.util.Calendar dueDate;

    private is.idega.idegaweb.egov.childcare.rvk.webservice.client.PaymentPredictionDetail[] paymentPredictionDetails;

    private java.lang.String recipientBankAccount;

    private java.lang.String recipientName;

    private java.lang.String recipientPIN;

    public PaymentPrediction() {
    }

    public PaymentPrediction(
           java.math.BigDecimal amountAlreadyPaid,
           java.math.BigDecimal amountDue,
           java.math.BigDecimal amountWillBePaid,
           java.util.Calendar dueDate,
           is.idega.idegaweb.egov.childcare.rvk.webservice.client.PaymentPredictionDetail[] paymentPredictionDetails,
           java.lang.String recipientBankAccount,
           java.lang.String recipientName,
           java.lang.String recipientPIN) {
           this.amountAlreadyPaid = amountAlreadyPaid;
           this.amountDue = amountDue;
           this.amountWillBePaid = amountWillBePaid;
           this.dueDate = dueDate;
           this.paymentPredictionDetails = paymentPredictionDetails;
           this.recipientBankAccount = recipientBankAccount;
           this.recipientName = recipientName;
           this.recipientPIN = recipientPIN;
    }


    /**
     * Gets the amountAlreadyPaid value for this PaymentPrediction.
     * 
     * @return amountAlreadyPaid
     */
    public java.math.BigDecimal getAmountAlreadyPaid() {
        return amountAlreadyPaid;
    }


    /**
     * Sets the amountAlreadyPaid value for this PaymentPrediction.
     * 
     * @param amountAlreadyPaid
     */
    public void setAmountAlreadyPaid(java.math.BigDecimal amountAlreadyPaid) {
        this.amountAlreadyPaid = amountAlreadyPaid;
    }


    /**
     * Gets the amountDue value for this PaymentPrediction.
     * 
     * @return amountDue
     */
    public java.math.BigDecimal getAmountDue() {
        return amountDue;
    }


    /**
     * Sets the amountDue value for this PaymentPrediction.
     * 
     * @param amountDue
     */
    public void setAmountDue(java.math.BigDecimal amountDue) {
        this.amountDue = amountDue;
    }


    /**
     * Gets the amountWillBePaid value for this PaymentPrediction.
     * 
     * @return amountWillBePaid
     */
    public java.math.BigDecimal getAmountWillBePaid() {
        return amountWillBePaid;
    }


    /**
     * Sets the amountWillBePaid value for this PaymentPrediction.
     * 
     * @param amountWillBePaid
     */
    public void setAmountWillBePaid(java.math.BigDecimal amountWillBePaid) {
        this.amountWillBePaid = amountWillBePaid;
    }


    /**
     * Gets the dueDate value for this PaymentPrediction.
     * 
     * @return dueDate
     */
    public java.util.Calendar getDueDate() {
        return dueDate;
    }


    /**
     * Sets the dueDate value for this PaymentPrediction.
     * 
     * @param dueDate
     */
    public void setDueDate(java.util.Calendar dueDate) {
        this.dueDate = dueDate;
    }


    /**
     * Gets the paymentPredictionDetails value for this PaymentPrediction.
     * 
     * @return paymentPredictionDetails
     */
    public is.idega.idegaweb.egov.childcare.rvk.webservice.client.PaymentPredictionDetail[] getPaymentPredictionDetails() {
        return paymentPredictionDetails;
    }


    /**
     * Sets the paymentPredictionDetails value for this PaymentPrediction.
     * 
     * @param paymentPredictionDetails
     */
    public void setPaymentPredictionDetails(is.idega.idegaweb.egov.childcare.rvk.webservice.client.PaymentPredictionDetail[] paymentPredictionDetails) {
        this.paymentPredictionDetails = paymentPredictionDetails;
    }


    /**
     * Gets the recipientBankAccount value for this PaymentPrediction.
     * 
     * @return recipientBankAccount
     */
    public java.lang.String getRecipientBankAccount() {
        return recipientBankAccount;
    }


    /**
     * Sets the recipientBankAccount value for this PaymentPrediction.
     * 
     * @param recipientBankAccount
     */
    public void setRecipientBankAccount(java.lang.String recipientBankAccount) {
        this.recipientBankAccount = recipientBankAccount;
    }


    /**
     * Gets the recipientName value for this PaymentPrediction.
     * 
     * @return recipientName
     */
    public java.lang.String getRecipientName() {
        return recipientName;
    }


    /**
     * Sets the recipientName value for this PaymentPrediction.
     * 
     * @param recipientName
     */
    public void setRecipientName(java.lang.String recipientName) {
        this.recipientName = recipientName;
    }


    /**
     * Gets the recipientPIN value for this PaymentPrediction.
     * 
     * @return recipientPIN
     */
    public java.lang.String getRecipientPIN() {
        return recipientPIN;
    }


    /**
     * Sets the recipientPIN value for this PaymentPrediction.
     * 
     * @param recipientPIN
     */
    public void setRecipientPIN(java.lang.String recipientPIN) {
        this.recipientPIN = recipientPIN;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PaymentPrediction)) return false;
        PaymentPrediction other = (PaymentPrediction) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.amountAlreadyPaid==null && other.getAmountAlreadyPaid()==null) || 
             (this.amountAlreadyPaid!=null &&
              this.amountAlreadyPaid.equals(other.getAmountAlreadyPaid()))) &&
            ((this.amountDue==null && other.getAmountDue()==null) || 
             (this.amountDue!=null &&
              this.amountDue.equals(other.getAmountDue()))) &&
            ((this.amountWillBePaid==null && other.getAmountWillBePaid()==null) || 
             (this.amountWillBePaid!=null &&
              this.amountWillBePaid.equals(other.getAmountWillBePaid()))) &&
            ((this.dueDate==null && other.getDueDate()==null) || 
             (this.dueDate!=null &&
              this.dueDate.equals(other.getDueDate()))) &&
            ((this.paymentPredictionDetails==null && other.getPaymentPredictionDetails()==null) || 
             (this.paymentPredictionDetails!=null &&
              java.util.Arrays.equals(this.paymentPredictionDetails, other.getPaymentPredictionDetails()))) &&
            ((this.recipientBankAccount==null && other.getRecipientBankAccount()==null) || 
             (this.recipientBankAccount!=null &&
              this.recipientBankAccount.equals(other.getRecipientBankAccount()))) &&
            ((this.recipientName==null && other.getRecipientName()==null) || 
             (this.recipientName!=null &&
              this.recipientName.equals(other.getRecipientName()))) &&
            ((this.recipientPIN==null && other.getRecipientPIN()==null) || 
             (this.recipientPIN!=null &&
              this.recipientPIN.equals(other.getRecipientPIN())));
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
        if (getAmountAlreadyPaid() != null) {
            _hashCode += getAmountAlreadyPaid().hashCode();
        }
        if (getAmountDue() != null) {
            _hashCode += getAmountDue().hashCode();
        }
        if (getAmountWillBePaid() != null) {
            _hashCode += getAmountWillBePaid().hashCode();
        }
        if (getDueDate() != null) {
            _hashCode += getDueDate().hashCode();
        }
        if (getPaymentPredictionDetails() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPaymentPredictionDetails());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPaymentPredictionDetails(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getRecipientBankAccount() != null) {
            _hashCode += getRecipientBankAccount().hashCode();
        }
        if (getRecipientName() != null) {
            _hashCode += getRecipientName().hashCode();
        }
        if (getRecipientPIN() != null) {
            _hashCode += getRecipientPIN().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PaymentPrediction.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "PaymentPrediction"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("amountAlreadyPaid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "AmountAlreadyPaid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("amountDue");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "AmountDue"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("amountWillBePaid");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "AmountWillBePaid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("dueDate");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "DueDate"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paymentPredictionDetails");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "PaymentPredictionDetails"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "PaymentPredictionDetail"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "PaymentPredictionDetail"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("recipientBankAccount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "RecipientBankAccount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("recipientName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "RecipientName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("recipientPIN");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "RecipientPIN"));
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
