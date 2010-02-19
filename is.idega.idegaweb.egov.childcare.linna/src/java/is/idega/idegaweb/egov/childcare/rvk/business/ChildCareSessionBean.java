/*
 * $Id: ChildCareSessionBean.java,v 1.13 2008/10/10 12:09:21 laddi Exp $ Created on Mar 30, 2006
 * 
 * Copyright (C) 2006 Idega Software hf. All Rights Reserved.
 * 
 * This software is the proprietary information of Idega hf. Use is subject to license terms.
 */
package is.idega.idegaweb.egov.childcare.rvk.business;

import is.idega.idegaweb.egov.accounting.business.CitizenBusiness;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareApplication;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareProvider;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.DaycareType;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.ISO_639_2;
import is.idega.idegaweb.egov.childcare.rvk.webservice.client.ServiceGuaranteeApplication;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.ejb.FinderException;

import com.idega.business.IBORuntimeException;
import com.idega.business.IBOSessionBean;
import com.idega.idegaweb.IWResourceBundle;
import com.idega.user.data.User;

public class ChildCareSessionBean extends IBOSessionBean implements ChildCareSession {

	private User iChild;
	private Object iChildPK;
	private String iChildUniqueID;

	private short[] postalCodes;
	private short[] publicPostalCodes;
	
	private Map allProviders;
	private Map privateProviders;
	private Collection allPrivateProviders;
	private Map publicProviders;
	private Collection allPublicProviders;
	private Map nannyProviders;
	private Collection allNannyProviders;
	
	private Map careApplications;
	private Map serviceApplications;
	
	private Map isoCodes;

	public User getChild() {
		try {
			if (this.iChild == null && this.iChildPK != null) {
				this.iChild = getUserBusiness().getUser(new Integer(this.iChildPK.toString()));
			}
			else if (this.iChild == null && this.iChildUniqueID != null) {
				try {
					this.iChild = getUserBusiness().getUserByUniqueId(this.iChildUniqueID);
				}
				catch (FinderException fe) {
					fe.printStackTrace();
					this.iChild = null;
				}
			}
		}
		catch (RemoteException re) {
			this.iChild = null;
		}
		return this.iChild;
	}

	public void setChild(Object userPK) {
		this.iChildPK = userPK;
		this.iChildUniqueID = null;
		this.iChild = null;
	}
	
	public short[] getPublicPostalCodes() {
		if (publicPostalCodes == null) {
			try {
				publicPostalCodes = getBusiness().getDaycareService().getDistinctPostcodesByType(DaycareType.PublicDaycare);
			}
			catch (RemoteException re) {
				throw new IBORuntimeException(re);
			}
			getPostalCodes();
			getAllProviders();
		}
		
		return publicPostalCodes;
	}
	
	public short[] getPostalCodes() {
		if (postalCodes == null) {
			try {
				postalCodes = getBusiness().getDaycareService().getDistinctPostcodes();
			}
			catch (RemoteException re) {
				throw new IBORuntimeException(re);
			}
			getAllProviders();
		}
		
		return postalCodes;
	}
	
	public Map getAllProviders() {
		if (allProviders == null) {
			allProviders = new LinkedHashMap();
			publicProviders = new LinkedHashMap();
			privateProviders = new LinkedHashMap();
			nannyProviders = new LinkedHashMap();
			
			short[] postalCodes = getPostalCodes();
			for (int i = 0; i < postalCodes.length; i++) {
				short postalCode = postalCodes[i];
				Collection publicCollection = new ArrayList();
				Collection privateCollection = new ArrayList();
				Collection nannyCollection = new ArrayList();
				
				try {
					DaycareProvider[] providers = getBusiness().getDaycareService().getDaycareProvidersByPostcode(new Short(postalCode));
					if (providers != null) {
						for (int j = 0; j < providers.length; j++) {
							DaycareProvider daycareProvider = providers[j];
							DaycareType type = daycareProvider.getType();
							
							if (type.equals(DaycareType.PublicDaycare)) {
								publicCollection.add(daycareProvider);
							}
							else if (type.equals(DaycareType.PrivateDaycare)) {
								privateCollection.add(daycareProvider);
							}
							else if (type.equals(DaycareType.Nanny)) {
								nannyCollection.add(daycareProvider);
							}
						}
					}
					
					allProviders.put(new Short(postalCode), providers);
					if (!publicCollection.isEmpty()) {
						publicProviders.put(new Short(postalCode), publicCollection.toArray(new DaycareProvider[publicCollection.size()]));
					}
					if (!privateCollection.isEmpty()) {
						privateProviders.put(new Short(postalCode), privateCollection.toArray(new DaycareProvider[privateCollection.size()]));
					}
					if (!nannyCollection.isEmpty()) {
						nannyProviders.put(new Short(postalCode), nannyCollection.toArray(new DaycareProvider[nannyCollection.size()]));
					}
				}
				catch (RemoteException re) {
					throw new IBORuntimeException(re);
				}
			}
		}
		
		return allProviders;
	}
	
	public Map getPublicProviders() {
		if (publicProviders == null) {
			publicProviders = new LinkedHashMap();
			
			short[] postalCodes = getPostalCodes();
			for (int i = 0; i < postalCodes.length; i++) {
				short postalCode = postalCodes[i];

				try {
					DaycareProvider[] providers = getBusiness().getDaycareService().getDaycareProvidersByTypeAndPostcode(DaycareType.PublicDaycare, new Short(postalCode));
					if (providers != null) {
						publicProviders.put(new Short(postalCode), providers);
					}
				}
				catch (RemoteException re) {
					throw new IBORuntimeException(re);
				}
			}
		}
		
		return publicProviders;
	}

	public Map getPrivateProviders() {
		if (privateProviders == null) {
			privateProviders = new LinkedHashMap();
			
			short[] postalCodes = getPostalCodes();
			for (int i = 0; i < postalCodes.length; i++) {
				short postalCode = postalCodes[i];

				try {
					DaycareProvider[] providers = getBusiness().getDaycareService().getDaycareProvidersByTypeAndPostcode(DaycareType.PrivateDaycare, new Short(postalCode));
					if (providers != null) {
						privateProviders.put(new Short(postalCode), providers);
					}
				}
				catch (RemoteException re) {
					throw new IBORuntimeException(re);
				}
			}
		}
		
		return privateProviders;
	}
	
	public Collection getAllPublicProviders() {
		if (allPublicProviders == null) {
			try {
				DaycareProvider[] providers = getBusiness().getDaycareService().getDaycareProvidersByType(DaycareType.PublicDaycare);
				if (providers != null) {
					allPublicProviders = Arrays.asList(providers);
				}
			}
			catch (RemoteException re) {
				throw new IBORuntimeException(re);
			}
		}
		
		return allPublicProviders;
	}

	public Collection getAllPrivateProviders() {
		if (allPrivateProviders == null) {
			try {
				DaycareProvider[] providers = getBusiness().getDaycareService().getDaycareProvidersByType(DaycareType.PrivateDaycare);
				if (providers != null) {
					allPrivateProviders = Arrays.asList(providers);
				}
			}
			catch (RemoteException re) {
				throw new IBORuntimeException(re);
			}
		}
		
		return allPrivateProviders;
	}

	public Map getNannyProviders() {
		if (nannyProviders == null) {
			nannyProviders = new LinkedHashMap();
			
			short[] postalCodes = getPostalCodes();
			for (int i = 0; i < postalCodes.length; i++) {
				short postalCode = postalCodes[i];

				try {
					DaycareProvider[] providers = getBusiness().getDaycareService().getDaycareProvidersByTypeAndPostcode(DaycareType.Nanny, new Short(postalCode));
					if (providers != null) {
						nannyProviders.put(new Short(postalCode), providers);
					}
				}
				catch (RemoteException re) {
					throw new IBORuntimeException(re);
				}
			}
		}
		
		return nannyProviders;
	}
	
	public Collection getAllNannyProviders() {
		if (allNannyProviders == null) {
			try {
				DaycareProvider[] providers = getBusiness().getDaycareService().getDaycareProvidersByType(DaycareType.Nanny);
				if (providers != null) {
					allNannyProviders = Arrays.asList(providers);
				}
			}
			catch (RemoteException re) {
				throw new IBORuntimeException(re);
			}
		}
		
		return allNannyProviders;
	}

	public DaycareProvider getProvider(Integer ID) {
		Map map = getAllProviders();
		Iterator iterator = map.values().iterator();
		while (iterator.hasNext()) {
			DaycareProvider[] providers = (DaycareProvider[]) iterator.next();
			for (int i = 0; i < providers.length; i++) {
				DaycareProvider daycareProvider = providers[i];
				if (daycareProvider.getDaycareProviderID().equals(ID)) {
					return daycareProvider;
				}
			}
		}
		
		return null;
	}
	
	public DaycareApplication getDaycareApplication(String parentPersonalID, String personalID) {
		if (careApplications == null) {
			careApplications = new HashMap();
		}
		
		if (!careApplications.containsKey(personalID)) {
			try {
				DaycareApplication application = getBusiness().getDaycareService().getDaycareApplication(parentPersonalID, personalID);
				careApplications.put(personalID, application);
			}
			catch (RemoteException re) {
				throw new IBORuntimeException(re);
			}
		}
		
		return (DaycareApplication) careApplications.get(personalID);
	}

	public ServiceGuaranteeApplication getServiceGuaranteeApplication(String parentPersonalID, String personalID) {
		if (serviceApplications == null) {
			serviceApplications = new HashMap();
		}
		
		if (!serviceApplications.containsKey(personalID)) {
			try {
				ServiceGuaranteeApplication application = getBusiness().getDaycareService().getServiceGuaranteeApplication(parentPersonalID, personalID);
				serviceApplications.put(personalID, application);
			}
			catch (RemoteException re) {
				throw new IBORuntimeException(re);
			}
		}
		
		return (ServiceGuaranteeApplication) serviceApplications.get(personalID);
	}
	
	public Map getISOCodes() {
		if (isoCodes == null) {
			isoCodes = new LinkedHashMap();
			
			try {
				ISO_639_2[] codes = getBusiness().getDaycareService().getISO639_2LanguageCodes();
				for (int i = 0; i < codes.length; i++) {
					ISO_639_2 iso_639_2 = codes[i];
					isoCodes.put(iso_639_2.getCode(), iso_639_2);
				}
			}
			catch (RemoteException re) {
				throw new IBORuntimeException(re);
			}
		}
		
		return isoCodes;
	}
	
	public ISO_639_2 getISOCode(String code) {
		if (isoCodes == null) {
			getISOCodes();
		}
		
		return (ISO_639_2) isoCodes.get(code);
	}
	
	public void flushApplications() {
		serviceApplications = null;
		careApplications = null;
	}

	protected String getBundleIdentifier() {
		return ChildCareConstants.IW_BUNDLE_IDENTIFIER;
	}

	public Map getProvidersByArea(String area) {
		Map map = new LinkedHashMap();
		IWResourceBundle iwrb = getIWApplicationContext().getIWMainApplication().getBundle(getBundleIdentifier()).getResourceBundle(getUserContext().getCurrentLocale());
		
		DaycareProvider[] daycareProviders = (DaycareProvider[]) getPublicProviders().get(new Short(area));

		if (daycareProviders != null) {
			if (daycareProviders.length > 1) {
				map.put("-1", iwrb.getLocalizedString("select_provider","Select provider"));
			}
			
			for (int i = 0; i < daycareProviders.length; i++) {
				DaycareProvider daycareProvider = daycareProviders[i];
				map.put(daycareProvider.getDaycareProviderID().toString(), daycareProvider.getName());
			}
		}
		else {
			map.put("-1", iwrb.getLocalizedString("no_providers_found","No providers found"));
		}
		
		return map;
	}

	public Map getProvidersByType(String type) {
		Map map = new LinkedHashMap();
		IWResourceBundle iwrb = getIWApplicationContext().getIWMainApplication().getBundle(getBundleIdentifier()).getResourceBundle(getUserContext().getCurrentLocale());
		
		boolean isPrivate = false;
		boolean isNanny = false;

		if (type.equals(DaycareType._PrivateDaycare)) {
			isPrivate = true;
		}
		else if (type.equals(DaycareType._Nanny)) {
			isNanny = true;
		}
		
		Collection providers = null;
		if (isPrivate) {
			providers = getAllPrivateProviders();
		}
		else if (isNanny) {
			providers = getAllNannyProviders();
		}

		if (providers != null) {
			if (providers.size() > 1) {
				if (isPrivate) {
					map.put("-1", iwrb.getLocalizedString("select_provider","Select provider"));
				}
				else if (isNanny) {
					map.put("-1", iwrb.getLocalizedString("select_nanny","Select nanny"));
				}
			}
			
			Iterator iterator = providers.iterator();
			while (iterator.hasNext()) {
				DaycareProvider daycareProvider = (DaycareProvider) iterator.next();
				map.put(daycareProvider.getDaycareProviderID().toString(),daycareProvider.getName());
			}
		}
		else {
			if (isPrivate) {
				map.put("-1", iwrb.getLocalizedString("no_providers_found","No providers found"));
			}
			else if (isNanny) {
				map.put("-1", iwrb.getLocalizedString("no_nannies_found","No nannies found"));
			}
		}
		
		return map;
	}

	private CitizenBusiness getUserBusiness() {
		try {
			return (CitizenBusiness) this.getServiceInstance(CitizenBusiness.class);
		}
		catch (RemoteException e) {
			throw new IBORuntimeException(e.getMessage());
		}
	}

	private ChildCareRVKService getBusiness() {
		try {
			return (ChildCareRVKService) this.getServiceInstance(ChildCareRVKService.class);
		}
		catch (RemoteException e) {
			throw new IBORuntimeException(e.getMessage());
		}
	}
}