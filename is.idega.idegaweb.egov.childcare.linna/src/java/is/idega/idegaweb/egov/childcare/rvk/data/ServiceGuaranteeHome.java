package is.idega.idegaweb.egov.childcare.rvk.data;


import java.util.Collection;
import javax.ejb.CreateException;
import com.idega.data.IDOHome;
import javax.ejb.FinderException;
import com.idega.user.data.User;

public interface ServiceGuaranteeHome extends IDOHome {

	public ServiceGuarantee create() throws CreateException;

	public ServiceGuarantee findByPrimaryKey(Object pk) throws FinderException;

	public ServiceGuarantee findByChild(User child) throws FinderException;

	public Collection findNonExported() throws FinderException;
}