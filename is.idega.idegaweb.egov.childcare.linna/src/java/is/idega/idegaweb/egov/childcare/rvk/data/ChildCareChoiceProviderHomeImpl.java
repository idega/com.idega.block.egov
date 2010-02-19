package is.idega.idegaweb.egov.childcare.rvk.data;


import java.util.Collection;
import javax.ejb.CreateException;
import javax.ejb.FinderException;
import com.idega.data.IDOEntity;
import com.idega.data.IDOFactory;

public class ChildCareChoiceProviderHomeImpl extends IDOFactory implements ChildCareChoiceProviderHome {

	public Class getEntityInterfaceClass() {
		return ChildCareChoiceProvider.class;
	}

	public ChildCareChoiceProvider create() throws CreateException {
		return (ChildCareChoiceProvider) super.createIDO();
	}

	public ChildCareChoiceProvider findByPrimaryKey(Object pk) throws FinderException {
		return (ChildCareChoiceProvider) super.findByPrimaryKeyIDO(pk);
	}

	public Collection findByApplication(ChildCareChoice application) throws FinderException {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Collection ids = ((ChildCareChoiceProviderBMPBean) entity).ejbFindByApplication(application);
		this.idoCheckInPooledEntity(entity);
		return this.getEntityCollectionForPrimaryKeys(ids);
	}

	public ChildCareChoiceProvider findByApplicationAndChoiceNumber(ChildCareChoice application, int choiceNumber) throws FinderException {
		IDOEntity entity = this.idoCheckOutPooledEntity();
		Object pk = ((ChildCareChoiceProviderBMPBean) entity).ejbFindByApplicationAndChoiceNumber(application, choiceNumber);
		this.idoCheckInPooledEntity(entity);
		return this.findByPrimaryKey(pk);
	}
}