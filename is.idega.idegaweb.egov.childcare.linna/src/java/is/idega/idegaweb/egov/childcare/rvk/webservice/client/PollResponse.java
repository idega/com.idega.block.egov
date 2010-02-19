/**
 * PollResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Aug 26, 2008 (12:29:12 CEST) WSDL2Java emitter.
 */

package is.idega.idegaweb.egov.childcare.rvk.webservice.client;

public class PollResponse  implements java.io.Serializable {
    private java.lang.String answer;

    private java.lang.String childPIN;

    private java.lang.String guardianPIN;

    private java.lang.String question;

    public PollResponse() {
    }

    public PollResponse(
           java.lang.String answer,
           java.lang.String childPIN,
           java.lang.String guardianPIN,
           java.lang.String question) {
           this.answer = answer;
           this.childPIN = childPIN;
           this.guardianPIN = guardianPIN;
           this.question = question;
    }


    /**
     * Gets the answer value for this PollResponse.
     * 
     * @return answer
     */
    public java.lang.String getAnswer() {
        return answer;
    }


    /**
     * Sets the answer value for this PollResponse.
     * 
     * @param answer
     */
    public void setAnswer(java.lang.String answer) {
        this.answer = answer;
    }


    /**
     * Gets the childPIN value for this PollResponse.
     * 
     * @return childPIN
     */
    public java.lang.String getChildPIN() {
        return childPIN;
    }


    /**
     * Sets the childPIN value for this PollResponse.
     * 
     * @param childPIN
     */
    public void setChildPIN(java.lang.String childPIN) {
        this.childPIN = childPIN;
    }


    /**
     * Gets the guardianPIN value for this PollResponse.
     * 
     * @return guardianPIN
     */
    public java.lang.String getGuardianPIN() {
        return guardianPIN;
    }


    /**
     * Sets the guardianPIN value for this PollResponse.
     * 
     * @param guardianPIN
     */
    public void setGuardianPIN(java.lang.String guardianPIN) {
        this.guardianPIN = guardianPIN;
    }


    /**
     * Gets the question value for this PollResponse.
     * 
     * @return question
     */
    public java.lang.String getQuestion() {
        return question;
    }


    /**
     * Sets the question value for this PollResponse.
     * 
     * @param question
     */
    public void setQuestion(java.lang.String question) {
        this.question = question;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PollResponse)) return false;
        PollResponse other = (PollResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.answer==null && other.getAnswer()==null) || 
             (this.answer!=null &&
              this.answer.equals(other.getAnswer()))) &&
            ((this.childPIN==null && other.getChildPIN()==null) || 
             (this.childPIN!=null &&
              this.childPIN.equals(other.getChildPIN()))) &&
            ((this.guardianPIN==null && other.getGuardianPIN()==null) || 
             (this.guardianPIN!=null &&
              this.guardianPIN.equals(other.getGuardianPIN()))) &&
            ((this.question==null && other.getQuestion()==null) || 
             (this.question!=null &&
              this.question.equals(other.getQuestion())));
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
        if (getAnswer() != null) {
            _hashCode += getAnswer().hashCode();
        }
        if (getChildPIN() != null) {
            _hashCode += getChildPIN().hashCode();
        }
        if (getGuardianPIN() != null) {
            _hashCode += getGuardianPIN().hashCode();
        }
        if (getQuestion() != null) {
            _hashCode += getQuestion().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PollResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "PollResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("answer");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "Answer"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("childPIN");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "ChildPIN"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("guardianPIN");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "GuardianPIN"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("question");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "Question"));
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
