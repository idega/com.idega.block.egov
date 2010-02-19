/**
 * RequestedDaycareProvider.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Aug 26, 2008 (12:29:12 CEST) WSDL2Java emitter.
 */

package is.idega.idegaweb.egov.childcare.rvk.webservice.client;

public class RequestedDaycareProvider  implements java.io.Serializable {
    private java.lang.Integer daycareProviderID;

    private java.lang.String name;

    private java.lang.Short postcode;

    private java.lang.Short ranking;

    public RequestedDaycareProvider() {
    }

    public RequestedDaycareProvider(
           java.lang.Integer daycareProviderID,
           java.lang.String name,
           java.lang.Short postcode,
           java.lang.Short ranking) {
           this.daycareProviderID = daycareProviderID;
           this.name = name;
           this.postcode = postcode;
           this.ranking = ranking;
    }


    /**
     * Gets the daycareProviderID value for this RequestedDaycareProvider.
     * 
     * @return daycareProviderID
     */
    public java.lang.Integer getDaycareProviderID() {
        return daycareProviderID;
    }


    /**
     * Sets the daycareProviderID value for this RequestedDaycareProvider.
     * 
     * @param daycareProviderID
     */
    public void setDaycareProviderID(java.lang.Integer daycareProviderID) {
        this.daycareProviderID = daycareProviderID;
    }


    /**
     * Gets the name value for this RequestedDaycareProvider.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this RequestedDaycareProvider.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the postcode value for this RequestedDaycareProvider.
     * 
     * @return postcode
     */
    public java.lang.Short getPostcode() {
        return postcode;
    }


    /**
     * Sets the postcode value for this RequestedDaycareProvider.
     * 
     * @param postcode
     */
    public void setPostcode(java.lang.Short postcode) {
        this.postcode = postcode;
    }


    /**
     * Gets the ranking value for this RequestedDaycareProvider.
     * 
     * @return ranking
     */
    public java.lang.Short getRanking() {
        return ranking;
    }


    /**
     * Sets the ranking value for this RequestedDaycareProvider.
     * 
     * @param ranking
     */
    public void setRanking(java.lang.Short ranking) {
        this.ranking = ranking;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof RequestedDaycareProvider)) return false;
        RequestedDaycareProvider other = (RequestedDaycareProvider) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.daycareProviderID==null && other.getDaycareProviderID()==null) || 
             (this.daycareProviderID!=null &&
              this.daycareProviderID.equals(other.getDaycareProviderID()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.postcode==null && other.getPostcode()==null) || 
             (this.postcode!=null &&
              this.postcode.equals(other.getPostcode()))) &&
            ((this.ranking==null && other.getRanking()==null) || 
             (this.ranking!=null &&
              this.ranking.equals(other.getRanking())));
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
        if (getDaycareProviderID() != null) {
            _hashCode += getDaycareProviderID().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getPostcode() != null) {
            _hashCode += getPostcode().hashCode();
        }
        if (getRanking() != null) {
            _hashCode += getRanking().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RequestedDaycareProvider.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "RequestedDaycareProvider"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("daycareProviderID");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "DaycareProviderID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "Name"));
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
        elemField.setFieldName("ranking");
        elemField.setXmlName(new javax.xml.namespace.QName("http://schemas.datacontract.org/2004/07/DaycareWebService", "Ranking"));
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
