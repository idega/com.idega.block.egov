package is.idega.idegaweb.egov.childcare.rvk.business;


import javax.ejb.CreateException;
import com.idega.business.IBOHomeImpl;

public class ChildCareRVKServiceHomeImpl extends IBOHomeImpl implements ChildCareRVKServiceHome {

	public Class getBeanInterfaceClass() {
		return ChildCareRVKService.class;
	}

	public ChildCareRVKService create() throws CreateException {
		return (ChildCareRVKService) super.createIBO();
	}
}