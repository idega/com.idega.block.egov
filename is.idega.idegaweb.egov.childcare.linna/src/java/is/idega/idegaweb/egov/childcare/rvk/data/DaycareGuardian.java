package is.idega.idegaweb.egov.childcare.rvk.data;


import is.idega.block.family.data.Custodian;
import com.idega.data.IDOEntity;

public interface DaycareGuardian extends IDOEntity, Custodian {

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.data.DaycareGuardianBMPBean#isCaretakerReceiver
	 */
	public boolean isCaretakerReceiver();

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.data.DaycareGuardianBMPBean#setCaretakerReceiver
	 */
	public void setCaretakerReceiver(boolean isCaretakerReceiver);

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.data.DaycareGuardianBMPBean#getAccountNumber
	 */
	public String getAccountNumber();

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.data.DaycareGuardianBMPBean#setAccountNumber
	 */
	public void setAccountNumber(String accountNumber);

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.data.DaycareGuardianBMPBean#getPrimaryLanguage
	 */
	public String getPrimaryLanguage();

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.data.DaycareGuardianBMPBean#setPrimaryLanguage
	 */
	public void setPrimaryLanguage(String language);

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.data.DaycareGuardianBMPBean#getSecondaryLanguage
	 */
	public String getSecondaryLanguage();

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.data.DaycareGuardianBMPBean#setSecondaryLanguage
	 */
	public void setSecondaryLanguage(String language);
}