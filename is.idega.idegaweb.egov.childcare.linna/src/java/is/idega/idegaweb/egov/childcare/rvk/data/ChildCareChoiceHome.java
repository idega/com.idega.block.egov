package is.idega.idegaweb.egov.childcare.rvk.data;


import java.util.Collection;
import javax.ejb.CreateException;
import com.idega.data.IDOHome;
import javax.ejb.FinderException;
import com.idega.user.data.User;

public interface ChildCareChoiceHome extends IDOHome {

	public ChildCareChoice create() throws CreateException;

	public ChildCareChoice findByPrimaryKey(Object pk) throws FinderException;

	public ChildCareChoice findApplicationByChild(User child) throws FinderException;

	public Collection findNonExported() throws FinderException;
}