/**
 * PaymentPredictionDetail.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Aug 26, 2008 (12:29:12 CEST) WSDL2Java emitter.
 */

package is.idega.idegaweb.egov.childcare.rvk.webservice.client;

public class PaymentPredictionDetail  implements java.io.Serializable {
    private java.math.BigDecimal amount;

    private org.apache.axis.types.UnsignedShort days;

    private org.apache.axis.types.UnsignedShort daysInMonth;

    private java.lang.String explanation;

    private java.util.Calendar payFrom;

    private java.util.Calendar payTo;

    public PaymentPredictionDetail() {
    }

    public PaymentPredictionDetail(
           java.math.BigDecimal amount,
           org.apache.axis.types.UnsignedShort days,
           org.apache.axis.types.UnsignedShort daysInMonth,
           java.lang.String explanation,
           java.util.Calendar payFrom,
           java.util.Calendar payTo) {
           this.amount = amount;
           this.days = days;
           this.daysInMonth = daysInMonth;
           this.explanation = explanation;
           this.payFrom = payFrom;
           this.payTo = payTo;
    }


    /**
     * Gets the amount value for this PaymentPredictionDetail.
     * 
     * @return amount
     */
    public java.math.BigDecimal getAmount() {
        return amount;
    }


    /**
     * Sets the amount value for this PaymentPredictionDetail.
     * 
     * @param amount
     */
    public void setAmount(java.math.BigDecimal amount) {
        this.amount = amount;
    }


    /**
     * Gets the days value for this PaymentPredictionDetail.
     * 
     * @return days
     */
    public org.apache.axis.types.UnsignedShort getDays() {
        return days;
    }


    /**
     * Sets the days value for this PaymentPredictionDetail.
     * 
     * @param days
     */
    public void setDays(org.apache.axis.types.UnsignedShort days) {
        this.days = days;
    }


    /**
     * Gets the daysInMonth value for this PaymentPredictionDetail.
     * 
     * @return daysInMonth
     */
    public org.apache.axis.types.UnsignedShort getDaysInMonth() {
        return daysInMonth;
    }


    /**
     * Sets the daysInMonth value for this PaymentPredictionDetail.
     * 
     * @param daysInMonth
     */
    public void setDaysInMonth(org.apache.axis.types.UnsignedShort daysInMonth) {
        this.daysInMonth = daysInMonth;
    }


    /**
     * Gets the explanation value for this PaymentPredictionDetail.
     * 
     * @return explanation
     */
    public java.lang.String getExplanation() {
        return explanation;
    }


    /**
     * Sets the explanation value for this PaymentPredictionDetail.
     * 
     * @param explanation
     */
    public void setExplanation(java.lang.String explanation) {
        this.explanation = explanation;
    }


    /**
     * Gets the payFrom value for this PaymentPredictionDetail.
     * 
     * @return payFrom
     */
    public java.util.Calendar getPayFrom() {
        return payFrom;
    }


    /**
     * Sets the payFrom value for this PaymentPredictionDetail.
     * 
     * @param payFrom
     */
    public void setPayFrom(java.util.Calendar payFrom) {
        this.payFrom = payFrom;
    }


    /**
     * Gets the payTo value for this PaymentPredictionDetail.
     * 
     * @return payTo
     */
    public java.util.Calendar getPayTo() {
        return payTo;
    }


    /**
     * Sets the payTo value for this PaymentPredictionDetail.
     * 
     * @param payTo
     */
    public void setPayTo(java.util.Calendar payTo) {
        this.payTo = payTo;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PaymentPredictionDetail)) return false;
        PaymentPredictionDetail other = (PaymentPredictionDetail) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.amount==null && other.getAmount()==null) || 
             (this.amount!=null &&
              this.amount.equals(other.getAmount()))) &&
            ((this.days==null && other.getDays()==null) || 
             (this.days!=null &&
              this.days.equals(other.getDays()))) &&
            ((this.daysInMonth==null && other.getDaysInMonth()==null) || 
             (this.daysInMonth!=null &&
              this.daysInMonth.equals(other.getDaysInMonth()))) &&
            ((this.explanation==null && other.getExplanation()==null) || 
             (this.explanation!=null &&
              this.explanation.equals(other.getExplanation()))) &&
            ((this.payFrom==null && other.getPayFrom()==null) || 
             (this.payFrom!=null &&
              this.payFrom.equals(other.getPayFrom()))) &&
            ((this.payTo==null && other.getPayTo()==null) || 
             (this.payTo!=null &&
              this.payTo.equals(other.getPayTo())));
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
        if (getAmount() != null) {
            _hashCode += getAmount().hashCode();
        }
        if (getDays() != null) {
            _hashCode += getDays().hashCode();
        }
        if (getDaysInMonth() != null) {
            _hashCode += getDaysInMonth().hashCode();
        }
        if (getExplanation() != null) {
            _hashCode += getExplanation().hashCode();
        }
        if (getPayFrom() != null) {
            _hashCode += getPayFrom().hashCode();
        }
        if (getPayTo() != null) {
            _hashCode += getPayTo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PaymentPredictionDetail.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "PaymentPredictionDetail"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("amount");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "Amount"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "decimal"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("days");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "Days"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("daysInMonth");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "DaysInMonth"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedShort"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("explanation");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "Explanation"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("payFrom");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "PayFrom"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("payTo");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "PayTo"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
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
