package is.idega.idegaweb.egov.childcare.rvk.data;


import javax.ejb.CreateException;
import com.idega.data.IDOHome;
import javax.ejb.FinderException;

public interface DaycareChildHome extends IDOHome {

	public DaycareChild create() throws CreateException;

	public DaycareChild findByPrimaryKey(Object pk) throws FinderException;
}