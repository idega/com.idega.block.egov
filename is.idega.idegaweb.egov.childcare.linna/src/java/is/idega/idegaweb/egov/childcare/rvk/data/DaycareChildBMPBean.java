/*
 * $Id$
 * Created on Sep 5, 2008
 *
 * Copyright (C) 2008 Idega Software hf. All Rights Reserved.
 *
 * This software is the proprietary information of Idega hf.
 * Use is subject to license terms.
 */
package is.idega.idegaweb.egov.childcare.rvk.data;

import is.idega.block.family.data.Child;
import is.idega.block.family.data.ChildBMPBean;


public class DaycareChildBMPBean extends ChildBMPBean implements Child, DaycareChild {

	public static final String METADATA_PRIMARY_LANGUAGE = "primary_language";
	public static final String METADATA_SECONDARY_LANGUAGE = "secondary_language";
	
	public String getPrimaryLanguage() {
		return getMetaData(METADATA_PRIMARY_LANGUAGE);
	}

	public void setPrimaryLanguage(String language) {
		if (language != null && language.length() > 0) {
			setMetaData(METADATA_PRIMARY_LANGUAGE, language, "java.lang.String");
		}
	}

	public String getSecondaryLanguage() {
		return getMetaData(METADATA_SECONDARY_LANGUAGE);
	}

	public void setSecondaryLanguage(String language) {
		if (language != null && language.length() > 0) {
			setMetaData(METADATA_SECONDARY_LANGUAGE, language, "java.lang.String");
		}
	}
}