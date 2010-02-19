/*
 * $Id$
 * Created on Sep 2, 2008
 *
 * Copyright (C) 2008 Idega Software hf. All Rights Reserved.
 *
 * This software is the proprietary information of Idega hf.
 * Use is subject to license terms.
 */
package is.idega.idegaweb.egov.childcare.rvk.data;

import is.idega.block.family.data.Custodian;
import is.idega.block.family.data.CustodianBMPBean;


public class DaycareGuardianBMPBean extends CustodianBMPBean implements Custodian, DaycareGuardian {

	public static final String METADATA_CARETAKER_RECEIVER = "caretaker_receiver";
	public static final String METADATA_ACCOUNT_NUMBER = "account_number";

	public static final String METADATA_PRIMARY_LANGUAGE = "primary_language";
	public static final String METADATA_SECONDARY_LANGUAGE = "secondary_language";

	public boolean isCaretakerReceiver() {
		String meta = getMetaData(METADATA_CARETAKER_RECEIVER);
		if (meta != null && meta.length() > 0) {
			return new Boolean(meta).booleanValue();
		}
		return false;
	}

	public void setCaretakerReceiver(boolean isCaretakerReceiver) {
		setMetaData(METADATA_CARETAKER_RECEIVER, new Boolean(isCaretakerReceiver).toString(), "java.lang.Boolean");
	}
	
	public String getAccountNumber() {
		return getMetaData(METADATA_ACCOUNT_NUMBER);
	}

	public void setAccountNumber(String accountNumber) {
		setMetaData(METADATA_ACCOUNT_NUMBER, accountNumber, "java.lang.String");
	}
	
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