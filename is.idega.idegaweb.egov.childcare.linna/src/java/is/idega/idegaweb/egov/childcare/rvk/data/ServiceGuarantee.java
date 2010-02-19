package is.idega.idegaweb.egov.childcare.rvk.data;


import com.idega.block.process.data.Case;
import com.idega.user.data.User;
import com.idega.data.IDOEntity;

public interface ServiceGuarantee extends IDOEntity, Case {

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.data.ServiceGuaranteeBMPBean#getCaseCodeDescription
	 */
	public String getCaseCodeDescription();

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.data.ServiceGuaranteeBMPBean#getCaseCodeKey
	 */
	public String getCaseCodeKey();

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.data.ServiceGuaranteeBMPBean#getChild
	 */
	public User getChild();

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.data.ServiceGuaranteeBMPBean#getCaretakerRelation
	 */
	public String getCaretakerRelation();

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.data.ServiceGuaranteeBMPBean#hasCommuneProvider
	 */
	public boolean hasCommuneProvider();

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.data.ServiceGuaranteeBMPBean#hasPrivateProvider
	 */
	public boolean hasPrivateProvider();

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.data.ServiceGuaranteeBMPBean#hasPrivateCaretaker
	 */
	public boolean hasPrivateCaretaker();

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.data.ServiceGuaranteeBMPBean#isExported
	 */
	public boolean isExported();

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.data.ServiceGuaranteeBMPBean#setChild
	 */
	public void setChild(User child);

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.data.ServiceGuaranteeBMPBean#setCaretakerRelation
	 */
	public void setCaretakerRelation(String relation);

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.data.ServiceGuaranteeBMPBean#setCommuneProvider
	 */
	public void setCommuneProvider(boolean hasProvider);

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.data.ServiceGuaranteeBMPBean#setPrivateProvider
	 */
	public void setPrivateProvider(boolean hasProvider);

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.data.ServiceGuaranteeBMPBean#setPrivateCaretaker
	 */
	public void setPrivateCaretaker(boolean hasProvider);

	/**
	 * @see is.idega.idegaweb.egov.childcare.rvk.data.ServiceGuaranteeBMPBean#setExported
	 */
	public void setExported(boolean exported);
}