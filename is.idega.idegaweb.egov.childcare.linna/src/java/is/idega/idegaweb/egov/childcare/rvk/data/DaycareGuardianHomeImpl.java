package is.idega.idegaweb.egov.childcare.rvk.data;


import javax.ejb.CreateException;
import javax.ejb.FinderException;
import com.idega.data.IDOFactory;

public class DaycareGuardianHomeImpl extends IDOFactory implements DaycareGuardianHome {

	public Class getEntityInterfaceClass() {
		return DaycareGuardian.class;
	}

	public DaycareGuardian create() throws CreateException {
		return (DaycareGuardian) super.createIDO();
	}

	public DaycareGuardian findByPrimaryKey(Object pk) throws FinderException {
		return (DaycareGuardian) super.findByPrimaryKeyIDO(pk);
	}
}