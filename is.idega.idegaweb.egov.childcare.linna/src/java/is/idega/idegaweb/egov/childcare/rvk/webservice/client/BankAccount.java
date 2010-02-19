/**
 * BankAccount.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Aug 26, 2008 (12:29:12 CEST) WSDL2Java emitter.
 */

package is.idega.idegaweb.egov.childcare.rvk.webservice.client;

public class BankAccount  implements java.io.Serializable {
    private java.lang.Integer accountNumber;

    private java.lang.Short bankID;

    private org.apache.axis.types.UnsignedByte ledger;

    public BankAccount() {
    }

    public BankAccount(
           java.lang.Integer accountNumber,
           java.lang.Short bankID,
           org.apache.axis.types.UnsignedByte ledger) {
           this.accountNumber = accountNumber;
           this.bankID = bankID;
           this.ledger = ledger;
    }


    /**
     * Gets the accountNumber value for this BankAccount.
     * 
     * @return accountNumber
     */
    public java.lang.Integer getAccountNumber() {
        return accountNumber;
    }


    /**
     * Sets the accountNumber value for this BankAccount.
     * 
     * @param accountNumber
     */
    public void setAccountNumber(java.lang.Integer accountNumber) {
        this.accountNumber = accountNumber;
    }


    /**
     * Gets the bankID value for this BankAccount.
     * 
     * @return bankID
     */
    public java.lang.Short getBankID() {
        return bankID;
    }


    /**
     * Sets the bankID value for this BankAccount.
     * 
     * @param bankID
     */
    public void setBankID(java.lang.Short bankID) {
        this.bankID = bankID;
    }


    /**
     * Gets the ledger value for this BankAccount.
     * 
     * @return ledger
     */
    public org.apache.axis.types.UnsignedByte getLedger() {
        return ledger;
    }


    /**
     * Sets the ledger value for this BankAccount.
     * 
     * @param ledger
     */
    public void setLedger(org.apache.axis.types.UnsignedByte ledger) {
        this.ledger = ledger;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof BankAccount)) return false;
        BankAccount other = (BankAccount) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.accountNumber==null && other.getAccountNumber()==null) || 
             (this.accountNumber!=null &&
              this.accountNumber.equals(other.getAccountNumber()))) &&
            ((this.bankID==null && other.getBankID()==null) || 
             (this.bankID!=null &&
              this.bankID.equals(other.getBankID()))) &&
            ((this.ledger==null && other.getLedger()==null) || 
             (this.ledger!=null &&
              this.ledger.equals(other.getLedger())));
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
        if (getAccountNumber() != null) {
            _hashCode += getAccountNumber().hashCode();
        }
        if (getBankID() != null) {
            _hashCode += getBankID().hashCode();
        }
        if (getLedger() != null) {
            _hashCode += getLedger().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(BankAccount.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "BankAccount"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("accountNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "AccountNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("bankID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "BankID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "short"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ledger");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "Ledger"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "unsignedByte"));
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
