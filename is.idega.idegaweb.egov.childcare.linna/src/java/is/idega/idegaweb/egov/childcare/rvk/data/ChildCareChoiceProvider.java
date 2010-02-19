package is.idega.idegaweb.egov.childcare.rvk.data;


import com.idega.block.school.data.School;
import com.idega.data.IDOEntity;

public interface ChildCareChoiceProvider extends IDOEntity {

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.data.ChildCareChoiceProviderBMPBean#getApplication
	 */
	public ChildCareChoice getApplication();

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.data.ChildCareChoiceProviderBMPBean#getProvider
	 */
	public School getProvider();

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.data.ChildCareChoiceProviderBMPBean#getChoiceNumber
	 */
	public int getChoiceNumber();

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.data.ChildCareChoiceProviderBMPBean#setApplication
	 */
	public void setApplication(ChildCareChoice application);

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.data.ChildCareChoiceProviderBMPBean#setProvider
	 */
	public void setProvider(School provider);

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.data.ChildCareChoiceProviderBMPBean#setChoiceNumber
	 */
	public void setChoiceNumber(int choiceNumber);
}