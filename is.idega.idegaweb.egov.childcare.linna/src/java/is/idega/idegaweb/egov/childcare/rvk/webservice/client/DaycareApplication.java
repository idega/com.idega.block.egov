/**
 * DaycareApplication.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Aug 26, 2008 (12:29:12 CEST) WSDL2Java emitter.
 */

package is.idega.idegaweb.egov.childcare.rvk.webservice.client;

public class DaycareApplication  implements java.io.Serializable {
    private is.idega.idegaweb.egov.childcare.rvk.webservice.client.Child child;

    private java.lang.String comments;

    private java.util.Calendar dateOfApplication;

    private java.util.Calendar dateOfLastChange;

    private java.lang.Boolean expired;

    private is.idega.idegaweb.egov.childcare.rvk.webservice.client.Guardian[] guardians;

    private is.idega.idegaweb.egov.childcare.rvk.webservice.client.IntendedDuration intendedDuration;

    private is.idega.idegaweb.egov.childcare.rvk.webservice.client.NextOfKinBesidesGuardian nextOfKinBesidesGuardians;

    private is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareProgram program;

    private is.idega.idegaweb.egov.childcare.rvk.webservice.client.RequestedDaycareProvider[] requestedDaycareProviders;

    private java.lang.Boolean willAcceptAlternativeProviders;

    public DaycareApplication() {
    }

    public DaycareApplication(
           is.idega.idegaweb.egov.childcare.rvk.webservice.client.Child child,
           java.lang.String comments,
           java.util.Calendar dateOfApplication,
           java.util.Calendar dateOfLastChange,
           java.lang.Boolean expired,
           is.idega.idegaweb.egov.childcare.rvk.webservice.client.Guardian[] guardians,
           is.idega.idegaweb.egov.childcare.rvk.webservice.client.IntendedDuration intendedDuration,
           is.idega.idegaweb.egov.childcare.rvk.webservice.client.NextOfKinBesidesGuardian nextOfKinBesidesGuardians,
           is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareProgram program,
           is.idega.idegaweb.egov.childcare.rvk.webservice.client.RequestedDaycareProvider[] requestedDaycareProviders,
           java.lang.Boolean willAcceptAlternativeProviders) {
           this.child = child;
           this.comments = comments;
           this.dateOfApplication = dateOfApplication;
           this.dateOfLastChange = dateOfLastChange;
           this.expired = expired;
           this.guardians = guardians;
           this.intendedDuration = intendedDuration;
           this.nextOfKinBesidesGuardians = nextOfKinBesidesGuardians;
           this.program = program;
           this.requestedDaycareProviders = requestedDaycareProviders;
           this.willAcceptAlternativeProviders = willAcceptAlternativeProviders;
    }


    /**
     * Gets the child value for this DaycareApplication.
     * 
     * @return child
     */
    public is.idega.idegaweb.egov.childcare.rvk.webservice.client.Child getChild() {
        return child;
    }


    /**
     * Sets the child value for this DaycareApplication.
     * 
     * @param child
     */
    public void setChild(is.idega.idegaweb.egov.childcare.rvk.webservice.client.Child child) {
        this.child = child;
    }


    /**
     * Gets the comments value for this DaycareApplication.
     * 
     * @return comments
     */
    public java.lang.String getComments() {
        return comments;
    }


    /**
     * Sets the comments value for this DaycareApplication.
     * 
     * @param comments
     */
    public void setComments(java.lang.String comments) {
        this.comments = comments;
    }


    /**
     * Gets the dateOfApplication value for this DaycareApplication.
     * 
     * @return dateOfApplication
     */
    public java.util.Calendar getDateOfApplication() {
        return dateOfApplication;
    }


    /**
     * Sets the dateOfApplication value for this DaycareApplication.
     * 
     * @param dateOfApplication
     */
    public void setDateOfApplication(java.util.Calendar dateOfApplication) {
        this.dateOfApplication = dateOfApplication;
    }


    /**
     * Gets the dateOfLastChange value for this DaycareApplication.
     * 
     * @return dateOfLastChange
     */
    public java.util.Calendar getDateOfLastChange() {
        return dateOfLastChange;
    }


    /**
     * Sets the dateOfLastChange value for this DaycareApplication.
     * 
     * @param dateOfLastChange
     */
    public void setDateOfLastChange(java.util.Calendar dateOfLastChange) {
        this.dateOfLastChange = dateOfLastChange;
    }


    /**
     * Gets the expired value for this DaycareApplication.
     * 
     * @return expired
     */
    public java.lang.Boolean getExpired() {
        return expired;
    }


    /**
     * Sets the expired value for this DaycareApplication.
     * 
     * @param expired
     */
    public void setExpired(java.lang.Boolean expired) {
        this.expired = expired;
    }


    /**
     * Gets the guardians value for this DaycareApplication.
     * 
     * @return guardians
     */
    public is.idega.idegaweb.egov.childcare.rvk.webservice.client.Guardian[] getGuardians() {
        return guardians;
    }


    /**
     * Sets the guardians value for this DaycareApplication.
     * 
     * @param guardians
     */
    public void setGuardians(is.idega.idegaweb.egov.childcare.rvk.webservice.client.Guardian[] guardians) {
        this.guardians = guardians;
    }


    /**
     * Gets the intendedDuration value for this DaycareApplication.
     * 
     * @return intendedDuration
     */
    public is.idega.idegaweb.egov.childcare.rvk.webservice.client.IntendedDuration getIntendedDuration() {
        return intendedDuration;
    }


    /**
     * Sets the intendedDuration value for this DaycareApplication.
     * 
     * @param intendedDuration
     */
    public void setIntendedDuration(is.idega.idegaweb.egov.childcare.rvk.webservice.client.IntendedDuration intendedDuration) {
        this.intendedDuration = intendedDuration;
    }


    /**
     * Gets the nextOfKinBesidesGuardians value for this DaycareApplication.
     * 
     * @return nextOfKinBesidesGuardians
     */
    public is.idega.idegaweb.egov.childcare.rvk.webservice.client.NextOfKinBesidesGuardian getNextOfKinBesidesGuardians() {
        return nextOfKinBesidesGuardians;
    }


    /**
     * Sets the nextOfKinBesidesGuardians value for this DaycareApplication.
     * 
     * @param nextOfKinBesidesGuardians
     */
    public void setNextOfKinBesidesGuardians(is.idega.idegaweb.egov.childcare.rvk.webservice.client.NextOfKinBesidesGuardian nextOfKinBesidesGuardians) {
        this.nextOfKinBesidesGuardians = nextOfKinBesidesGuardians;
    }


    /**
     * Gets the program value for this DaycareApplication.
     * 
     * @return program
     */
    public is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareProgram getProgram() {
        return program;
    }


    /**
     * Sets the program value for this DaycareApplication.
     * 
     * @param program
     */
    public void setProgram(is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareProgram program) {
        this.program = program;
    }


    /**
     * Gets the requestedDaycareProviders value for this DaycareApplication.
     * 
     * @return requestedDaycareProviders
     */
    public is.idega.idegaweb.egov.childcare.rvk.webservice.client.RequestedDaycareProvider[] getRequestedDaycareProviders() {
        return requestedDaycareProviders;
    }


    /**
     * Sets the requestedDaycareProviders value for this DaycareApplication.
     * 
     * @param requestedDaycareProviders
     */
    public void setRequestedDaycareProviders(is.idega.idegaweb.egov.childcare.rvk.webservice.client.RequestedDaycareProvider[] requestedDaycareProviders) {
        this.requestedDaycareProviders = requestedDaycareProviders;
    }


    /**
     * Gets the willAcceptAlternativeProviders value for this DaycareApplication.
     * 
     * @return willAcceptAlternativeProviders
     */
    public java.lang.Boolean getWillAcceptAlternativeProviders() {
        return willAcceptAlternativeProviders;
    }


    /**
     * Sets the willAcceptAlternativeProviders value for this DaycareApplication.
     * 
     * @param willAcceptAlternativeProviders
     */
    public void setWillAcceptAlternativeProviders(java.lang.Boolean willAcceptAlternativeProviders) {
        this.willAcceptAlternativeProviders = willAcceptAlternativeProviders;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DaycareApplication)) return false;
        DaycareApplication other = (DaycareApplication) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.child==null && other.getChild()==null) || 
             (this.child!=null &&
              this.child.equals(other.getChild()))) &&
            ((this.comments==null && other.getComments()==null) || 
             (this.comments!=null &&
              this.comments.equals(other.getComments()))) &&
            ((this.dateOfApplication==null && other.getDateOfApplication()==null) || 
             (this.dateOfApplication!=null &&
              this.dateOfApplication.equals(other.getDateOfApplication()))) &&
            ((this.dateOfLastChange==null && other.getDateOfLastChange()==null) || 
             (this.dateOfLastChange!=null &&
              this.dateOfLastChange.equals(other.getDateOfLastChange()))) &&
            ((this.expired==null && other.getExpired()==null) || 
             (this.expired!=null &&
              this.expired.equals(other.getExpired()))) &&
            ((this.guardians==null && other.getGuardians()==null) || 
             (this.guardians!=null &&
              java.util.Arrays.equals(this.guardians, other.getGuardians()))) &&
            ((this.intendedDuration==null && other.getIntendedDuration()==null) || 
             (this.intendedDuration!=null &&
              this.intendedDuration.equals(other.getIntendedDuration()))) &&
            ((this.nextOfKinBesidesGuardians==null && other.getNextOfKinBesidesGuardians()==null) || 
             (this.nextOfKinBesidesGuardians!=null &&
              this.nextOfKinBesidesGuardians.equals(other.getNextOfKinBesidesGuardians()))) &&
            ((this.program==null && other.getProgram()==null) || 
             (this.program!=null &&
              this.program.equals(other.getProgram()))) &&
            ((this.requestedDaycareProviders==null && other.getRequestedDaycareProviders()==null) || 
             (this.requestedDaycareProviders!=null &&
              java.util.Arrays.equals(this.requestedDaycareProviders, other.getRequestedDaycareProviders()))) &&
            ((this.willAcceptAlternativeProviders==null && other.getWillAcceptAlternativeProviders()==null) || 
             (this.willAcceptAlternativeProviders!=null &&
              this.willAcceptAlternativeProviders.equals(other.getWillAcceptAlternativeProviders())));
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
        if (getChild() != null) {
            _hashCode += getChild().hashCode();
        }
        if (getComments() != null) {
            _hashCode += getComments().hashCode();
        }
        if (getDateOfApplication() != null) {
            _hashCode += getDateOfApplication().hashCode();
        }
        if (getDateOfLastChange() != null) {
            _hashCode += getDateOfLastChange().hashCode();
        }
        if (getExpired() != null) {
            _hashCode += getExpired().hashCode();
        }
        if (getGuardians() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getGuardians());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getGuardians(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIntendedDuration() != null) {
            _hashCode += getIntendedDuration().hashCode();
        }
        if (getNextOfKinBesidesGuardians() != null) {
            _hashCode += getNextOfKinBesidesGuardians().hashCode();
        }
        if (getProgram() != null) {
            _hashCode += getProgram().hashCode();
        }
        if (getRequestedDaycareProviders() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getRequestedDaycareProviders());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getRequestedDaycareProviders(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getWillAcceptAlternativeProviders() != null) {
            _hashCode += getWillAcceptAlternativeProviders().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DaycareApplication.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "DaycareApplication"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("child");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "Child"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "Child"));
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
        elemField.setFieldName("dateOfLastChange");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "DateOfLastChange"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("expired");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "Expired"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("guardians");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "Guardians"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "Guardian"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "Guardian"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("intendedDuration");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "IntendedDuration"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "IntendedDuration"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nextOfKinBesidesGuardians");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "NextOfKinBesidesGuardians"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "NextOfKinBesidesGuardian"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("program");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "Program"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "DaycareProgram"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requestedDaycareProviders");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "RequestedDaycareProviders"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "RequestedDaycareProvider"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "RequestedDaycareProvider"));
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("willAcceptAlternativeProviders");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "WillAcceptAlternativeProviders"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
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
