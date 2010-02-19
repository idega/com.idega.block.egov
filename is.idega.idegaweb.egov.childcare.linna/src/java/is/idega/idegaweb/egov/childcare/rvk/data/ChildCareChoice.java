package is.idega.idegaweb.egov.childcare.rvk.data;


import com.idega.block.process.data.Case;
import com.idega.user.data.User;
import com.idega.data.IDOEntity;

public interface ChildCareChoice extends IDOEntity, Case {

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.data.ChildCareChoiceBMPBean#getCaseCodeKey
	 */
	public String getCaseCodeKey();

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.data.ChildCareChoiceBMPBean#getCaseCodeDescription
	 */
	public String getCaseCodeDescription();

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.data.ChildCareChoiceBMPBean#getChild
	 */
	public User getChild();

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.data.ChildCareChoiceBMPBean#getDaytime
	 */
	public String getDaytime();

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.data.ChildCareChoiceBMPBean#getDuration
	 */
	public String getDuration();

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.data.ChildCareChoiceBMPBean#acceptsOtherProviders
	 */
	public boolean acceptsOtherProviders();

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.data.ChildCareChoiceBMPBean#isExported
	 */
	public boolean isExported();

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.data.ChildCareChoiceBMPBean#setChild
	 */
	public void setChild(User child);

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.data.ChildCareChoiceBMPBean#setDaytime
	 */
	public void setDaytime(String daytime);

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.data.ChildCareChoiceBMPBean#setDuration
	 */
	public void setDuration(String duration);

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.data.ChildCareChoiceBMPBean#setAcceptsOtherProviders
	 */
	public void setAcceptsOtherProviders(boolean accepts);

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.data.ChildCareChoiceBMPBean#setExported
	 */
	public void setExported(boolean exported);
}