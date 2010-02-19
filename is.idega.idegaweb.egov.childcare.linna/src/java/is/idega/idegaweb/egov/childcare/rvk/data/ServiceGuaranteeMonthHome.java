package is.idega.idegaweb.egov.childcare.rvk.data;


import java.util.Collection;
import javax.ejb.CreateException;
import com.idega.data.IDOHome;
import javax.ejb.FinderException;
import com.idega.user.data.User;

public interface ServiceGuaranteeMonthHome extends IDOHome {

	public ServiceGuaranteeMonth create() throws CreateException;

	public ServiceGuaranteeMonth findByPrimaryKey(Object pk) throws FinderException;

	public ServiceGuaranteeMonth findByChildAndMonthAndYear(User child, int month, int year) throws FinderException;

	public Collection findAllByApplication(ServiceGuarantee application) throws FinderException;
}