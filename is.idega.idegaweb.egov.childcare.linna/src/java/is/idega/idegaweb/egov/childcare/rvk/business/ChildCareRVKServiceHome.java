package is.idega.idegaweb.egov.childcare.rvk.business;


import javax.ejb.CreateException;
import com.idega.business.IBOHome;
import java.rmi.RemoteException;

public interface ChildCareRVKServiceHome extends IBOHome {

	public ChildCareRVKService create() throws CreateException, RemoteException;
}