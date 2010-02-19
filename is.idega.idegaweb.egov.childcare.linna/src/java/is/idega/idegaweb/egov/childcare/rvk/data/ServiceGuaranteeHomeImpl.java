package is.idega.idegaweb.egov.childcare.rvk.data;


import java.util.Collection;
import javax.ejb.CreateException;
import javax.ejb.FinderException;
import com.idega.user.data.User;
import com.idega.data.IDOEntity;
import com.idega.data.IDOFactory;

public class ServiceGuaranteeHomeImpl extends IDOFactory implements ServiceGuaranteeHome {

	public Class getEntityInterfaceClass() {
		return ServiceGuarantee.class;
	}

	public ServiceGuarantee create() throws CreateException {
		return (ServiceGuarantee) super.createIDO();
	}

	public ServiceGuarantee findByPrimaryKey(Object pk) throws FinderException {
		return (ServiceGuarantee) super.findByPrimaryKeyIDO(pk);
	}

	public ServiceGuarantee findByChild(User child) throws FinderException {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Object pk = ((ServiceGuaranteeBMPBean) entity).ejbFindByChild(child);
		this.idoCheckInPooledEntity(entity);
		return this.findByPrimaryKey(pk);
	}

	public Collection findNonExported() throws FinderException {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Collection ids = ((ServiceGuaranteeBMPBean) entity).ejbFindNonExported();
		this.idoCheckInPooledEntity(entity);
		return this.getEntityCollectionForPrimaryKeys(ids);
	}
}