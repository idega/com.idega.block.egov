package is.idega.idegaweb.egov.childcare.rvk.business;


import javax.ejb.CreateException;
import com.idega.business.IBOHome;
import java.rmi.RemoteException;

public interface ChildCareSessionHome extends IBOHome {

	public ChildCareSession create() throws CreateException, RemoteException;
}