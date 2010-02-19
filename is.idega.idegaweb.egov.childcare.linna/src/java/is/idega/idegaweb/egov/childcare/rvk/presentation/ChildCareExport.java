/*
 * $Id$ Created on Dec 18, 2006
 * 
 * Copyright (C) 2006 Idega Software hf. All Rights Reserved.
 * 
 * This software is the proprietary information of Idega hf. Use is subject to license terms.
 */
package is.idega.idegaweb.egov.childcare.rvk.presentation;

import javax.faces.component.html.HtmlCommandButton;
import javax.faces.context.FacesContext;
import javax.faces.el.MethodBinding;

import com.idega.presentation.IWBaseComponent;
import com.idega.presentation.IWContext;
import com.idega.util.PresentationUtil;
import com.idega.webface.WFUtil;

public class ChildCareExport extends IWBaseComponent {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.idega.presentation.IWBaseComponent#initializeComponent(javax.faces.context.FacesContext)
	 */
	protected void initializeComponent(FacesContext context) {
		// TODO Auto-generated method stub
		IWContext iwc = IWContext.getIWContext(context);
		PresentationUtil.addStyleSheetToHeader(iwc, iwc.getIWMainApplication().getBundle("is.idega.idegaweb.egov.application").getVirtualPathWithFileNameString("style/application.css"));

		setId(getParent().getId() + "_childcareexport");

		super.initializeComponent(context);

		MethodBinding binding = WFUtil.createMethodBinding("#{ChildCareRVKServiceBean.exportChildcareApplications}", null);

		HtmlCommandButton button = new HtmlCommandButton();
		button.setId(this.getId() + "_childcarervkexportchildcare");
		button.setAction(binding);
		button.setValue("Export childcare applications");

		add(button);

		binding = WFUtil.createMethodBinding("#{ChildCareRVKServiceBean.exportServiceGuarantees}", null);

		button = new HtmlCommandButton();
		button.setId(this.getId() + "_childcarervkexportserviceguarantee");
		button.setAction(binding);
		button.setValue("Export service guarantees");

		add(button);
	}
}