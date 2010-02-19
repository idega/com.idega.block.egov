package is.idega.idegaweb.egov.childcare.rvk.data;


import java.util.Collection;
import javax.ejb.CreateException;
import com.idega.data.IDOHome;
import javax.ejb.FinderException;

public interface ChildCareChoiceProviderHome extends IDOHome {

	public ChildCareChoiceProvider create() throws CreateException;

	public ChildCareChoiceProvider findByPrimaryKey(Object pk) throws FinderException;

	public Collection findByApplication(ChildCareChoice application) throws FinderException;

	public ChildCareChoiceProvider findByApplicationAndChoiceNumber(ChildCareChoice application, int choiceNumber) throws FinderException;
}