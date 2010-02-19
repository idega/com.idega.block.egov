/*
 * $Id$
 * Created on Sep 18, 2008
 *
 * Copyright (C) 2008 Idega Software hf. All Rights Reserved.
 *
 * This software is the proprietary information of Idega hf.
 * Use is subject to license terms.
 */
package is.idega.idegaweb.egov.childcare.rvk.business;

import is.idega.idegaweb.egov.childcare.rvk.webservice.client.MonthlyPaymentAssignment;

import java.util.Comparator;


public class PaymentAssignmentComparator implements Comparator {

	public int compare(Object arg0, Object arg1) {
		MonthlyPaymentAssignment mpa1 = (MonthlyPaymentAssignment) arg0;
		MonthlyPaymentAssignment mpa2 = (MonthlyPaymentAssignment) arg1;
		
		if (mpa1.getYear().equals(mpa2.getYear())) {
			if (mpa1.getMonth().equals(mpa2.getMonth())) {
				return 0;
			}
		}
		else {
			return mpa1.getYear().intValue() - mpa2.getYear().intValue();
		}
		
		return -1;
	}
}