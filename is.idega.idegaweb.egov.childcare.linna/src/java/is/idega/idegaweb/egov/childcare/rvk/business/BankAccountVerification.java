/*
 * $Id$
 * Created on Sep 24, 2008
 *
 * Copyright (C) 2008 Idega Software hf. All Rights Reserved.
 *
 * This software is the proprietary information of Idega hf.
 * Use is subject to license terms.
 */
package is.idega.idegaweb.egov.childcare.rvk.business;

import is.idega.idegaweb.egov.childcare.rvk.webservice.client.BankAccount;

import org.apache.axis.types.UnsignedByte;

import com.idega.repository.data.Instantiator;
import com.idega.repository.data.SingletonRepository;


public class BankAccountVerification {

	private static Instantiator instantiator = new Instantiator() { public Object getInstance() { return new BankAccountVerification();}};

	public static BankAccountVerification getInstance() {
		return (BankAccountVerification) SingletonRepository.getRepository().getInstance(BankAccountVerification.class,instantiator);
	}
	
	public boolean isValid(String accountNumber) {
		BankAccount account = getBankAccount(accountNumber);
		return isValid(account);
	}
	
	public boolean isValid(BankAccount account) {
		if (account.getBankID().intValue() < 1 || account.getBankID().intValue() > 1199) {
			return false;
		}
		if (account.getLedger().intValue() < 1 || account.getLedger().intValue() > 99) {
			return false;
		}
		if (account.getAccountNumber().intValue() < 1 || account.getAccountNumber().intValue() > 999999) {
			return false;
		}
		
		return true;
	}

	private BankAccount getBankAccount(String accountNumber) {
		BankAccount bankAccount = new BankAccount();
		bankAccount.setBankID(new Short(accountNumber.substring(0, accountNumber.indexOf("-"))));
		bankAccount.setLedger(new UnsignedByte(accountNumber.substring(accountNumber.indexOf("-") + 1, accountNumber.lastIndexOf("-"))));
		bankAccount.setAccountNumber(new Integer(accountNumber.substring(accountNumber.lastIndexOf("-") + 1)));
		
		return bankAccount;
	}
	
}
