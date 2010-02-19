package is.idega.idegaweb.egov.childcare.rvk.webservice;

import is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareFaultContract;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareProvider;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareServiceLocator;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareType;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.IDaycareService;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

public class TestClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TestClient test = new TestClient();
		test.doStuff();
	}

	private void doStuff() {
		try {
			DaycareServiceLocator locator = new DaycareServiceLocator();
			IDaycareService port = locator.getBasicHttpBinding_IDaycareService(new URL("http://10.7.250.41/DaycareWebService/DaycareService.svc"));

			DaycareProvider[] privateProviders = port.getDaycareProvidersByType(DaycareType.PrivateDaycare);
			DaycareProvider[] nannyProviders = port.getDaycareProvidersByType(DaycareType.Nanny);
			
			System.out.println("Private providers: " + privateProviders.length);
			System.out.println("Nanny providers: " + nannyProviders.length);
		}
		catch (ServiceException e) {
			e.printStackTrace();
		}
		catch (DaycareFaultContract e) {
			e.printStackTrace();
		}
		catch (RemoteException e) {
			e.printStackTrace();
		}
		catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}