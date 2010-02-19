package is.idega.idegaweb.egov.childcare.rvk.data;


import java.util.Collection;
import javax.ejb.CreateException;
import javax.ejb.FinderException;
import com.idega.user.data.User;
import com.idega.data.IDOEntity;
import com.idega.data.IDOFactory;

public class ServiceGuaranteeMonthHomeImpl extends IDOFactory implements ServiceGuaranteeMonthHome {

	public Class getEntityInterfaceClass() {
		return ServiceGuaranteeMonth.class;
	}

	public ServiceGuaranteeMonth create() throws CreateException {
		return (ServiceGuaranteeMonth) super.createIDO();
	}

	public ServiceGuaranteeMonth findByPrimaryKey(Object pk) throws FinderException {
		return (ServiceGuaranteeMonth) super.findByPrimaryKeyIDO(pk);
	}

	public ServiceGuaranteeMonth findByChildAndMonthAndYear(User child, int month, int year) throws FinderException {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Object pk = ((ServiceGuaranteeMonthBMPBean) entity).ejbFindByChildAndMonthAndYear(child, month, year);
		this.idoCheckInPooledEntity(entity);
		return this.findByPrimaryKey(pk);
	}

	public Collection findAllByApplication(ServiceGuarantee application) throws FinderException {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Collection ids = ((ServiceGuaranteeMonthBMPBean) entity).ejbFindAllByApplication(application);
		this.idoCheckInPooledEntity(entity);
		return this.getEntityCollectionForPrimaryKeys(ids);
	}
}