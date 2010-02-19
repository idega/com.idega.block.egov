package is.idega.idegaweb.egov.childcare.rvk.data;


import javax.ejb.CreateException;
import com.idega.data.IDOHome;
import javax.ejb.FinderException;

public interface DaycareGuardianHome extends IDOHome {

	public DaycareGuardian create() throws CreateException;

	public DaycareGuardian findByPrimaryKey(Object pk) throws FinderException;
}