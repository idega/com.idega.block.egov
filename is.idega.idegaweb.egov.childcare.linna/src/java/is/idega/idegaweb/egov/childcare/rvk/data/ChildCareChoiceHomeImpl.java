package is.idega.idegaweb.egov.childcare.rvk.data;


import java.util.Collection;
import javax.ejb.CreateException;
import javax.ejb.FinderException;
import com.idega.user.data.User;
import com.idega.data.IDOEntity;
import com.idega.data.IDOFactory;

public class ChildCareChoiceHomeImpl extends IDOFactory implements ChildCareChoiceHome {

	public Class getEntityInterfaceClass() {
		return ChildCareChoice.class;
	}

	public ChildCareChoice create() throws CreateException {
		return (ChildCareChoice) super.createIDO();
	}

	public ChildCareChoice findByPrimaryKey(Object pk) throws FinderException {
		return (ChildCareChoice) super.findByPrimaryKeyIDO(pk);
	}

	public ChildCareChoice findApplicationByChild(User child) throws FinderException {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Object pk = ((ChildCareChoiceBMPBean) entity).ejbFindApplicationByChild(child);
		this.idoCheckInPooledEntity(entity);
		return this.findByPrimaryKey(pk);
	}

	public Collection findNonExported() throws FinderException {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Collection ids = ((ChildCareChoiceBMPBean) entity).ejbFindNonExported();
		this.idoCheckInPooledEntity(entity);
		return this.getEntityCollectionForPrimaryKeys(ids);
	}
}