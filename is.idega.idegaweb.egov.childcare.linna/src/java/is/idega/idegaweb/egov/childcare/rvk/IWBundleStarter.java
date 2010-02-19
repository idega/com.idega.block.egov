/*
 * $Id: IWBundleStarter.java,v 1.10 2008/12/03 04:15:35 laddi Exp $ Created on 6.8.2006
 * 
 * Copyright (C) 2006 Idega Software hf. All Rights Reserved.
 * 
 * This software is the proprietary information of Idega hf. Use is subject to license terms.
 */
package is.idega.idegaweb.egov.childcare.rvk;

import is.idega.idegaweb.egov.childcare.rvk.business.ChildCareConstants;
import is.idega.idegaweb.egov.childcare.rvk.business.ChildCareRVKService;

import com.idega.block.process.business.CaseCodeManager;
import com.idega.idegaweb.IWBundle;
import com.idega.idegaweb.IWBundleStartable;
import com.idega.idegaweb.IWMainApplication;

public class IWBundleStarter implements IWBundleStartable {

	public void start(IWBundle starterBundle) {
		addStandardViews(starterBundle.getApplication());

		CaseCodeManager.getInstance().addCaseBusinessForCode(ChildCareConstants.CHILD_CARE_CASE_CODE_KEY, ChildCareRVKService.class);
		CaseCodeManager.getInstance().addCaseBusinessForCode(ChildCareConstants.GUARANTEE_CASE_CODE_KEY, ChildCareRVKService.class);
	}

	public void stop(IWBundle starterBundle) {
	}

	protected void addStandardViews(IWMainApplication iwma){
		if (iwma.getIWApplicationContext().getApplicationSettings().getBoolean("egov.rvk.show.childcare.view", true)) {
			ChildcareViewManager manager = ChildcareViewManager.getInstance(iwma);
			manager.getChildcareViewNode();
		}
	}
}