package is.idega.idegaweb.egov.childcare.rvk.data;


import is.idega.block.family.data.Child;
import com.idega.data.IDOEntity;

public interface DaycareChild extends IDOEntity, Child {

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.data.DaycareChildBMPBean#getPrimaryLanguage
	 */
	public String getPrimaryLanguage();

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.data.DaycareChildBMPBean#setPrimaryLanguage
	 */
	public void setPrimaryLanguage(String language);

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.data.DaycareChildBMPBean#getSecondaryLanguage
	 */
	public String getSecondaryLanguage();

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.data.DaycareChildBMPBean#setSecondaryLanguage
	 */
	public void setSecondaryLanguage(String language);
}