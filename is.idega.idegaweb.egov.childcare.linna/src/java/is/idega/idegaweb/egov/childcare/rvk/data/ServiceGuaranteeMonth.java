package is.idega.idegaweb.egov.childcare.rvk.data;


import com.idega.data.IDOEntity;

public interface ServiceGuaranteeMonth extends IDOEntity {

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.data.ServiceGuaranteeMonthBMPBean#getServiceGuarantee
	 */
	public ServiceGuarantee getServiceGuarantee();

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.data.ServiceGuaranteeMonthBMPBean#getMonth
	 */
	public int getMonth();

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.data.ServiceGuaranteeMonthBMPBean#getYear
	 */
	public int getYear();

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.data.ServiceGuaranteeMonthBMPBean#getReceiver
	 */
	public String getReceiver();

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.data.ServiceGuaranteeMonthBMPBean#setServiceGuarantee
	 */
	public void setServiceGuarantee(ServiceGuarantee application);

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.data.ServiceGuaranteeMonthBMPBean#setMonth
	 */
	public void setMonth(int month);

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.data.ServiceGuaranteeMonthBMPBean#setYear
	 */
	public void setYear(int year);

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.data.ServiceGuaranteeMonthBMPBean#setReceiver
	 */
	public void setReceiver(String receiver);
}