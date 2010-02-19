package is.idega.idegaweb.egov.childcare.rvk.data;


import javax.ejb.CreateException;
import javax.ejb.FinderException;
import com.idega.data.IDOFactory;

public class DaycareChildHomeImpl extends IDOFactory implements DaycareChildHome {

	public Class getEntityInterfaceClass() {
		return DaycareChild.class;
	}

	public DaycareChild create() throws CreateException {
		return (DaycareChild) super.createIDO();
	}

	public DaycareChild findByPrimaryKey(Object pk) throws FinderException {
		return (DaycareChild) super.findByPrimaryKeyIDO(pk);
	}
}