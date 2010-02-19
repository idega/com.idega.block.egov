package is.idega.idegaweb.egov.childcare.rvk.business;


import javax.ejb.CreateException;
import com.idega.business.IBOHomeImpl;

public class ChildCareSessionHomeImpl extends IBOHomeImpl implements ChildCareSessionHome {

	public Class getBeanInterfaceClass() {
		return ChildCareSession.class;
	}

	public ChildCareSession create() throws CreateException {
		return (ChildCareSession) super.createIBO();
	}
}