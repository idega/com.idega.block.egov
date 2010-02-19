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

import java.util.Collection;

import javax.ejb.FinderException;

import com.idega.data.GenericEntity;
import com.idega.data.IDORelationshipException;
import com.idega.data.query.MatchCriteria;
import com.idega.data.query.SelectQuery;
import com.idega.data.query.Table;
import com.idega.user.data.User;


public class ServiceGuaranteeMonthBMPBean extends GenericEntity implements ServiceGuaranteeMonth {

	private static final String ENTITY_NAME = "service_guarantee_month";
	
	private static final String COLUMN_APPLICATION = "application_id";
	private static final String COLUMN_MONTH = "month";
	private static final String COLUMN_YEAR = "year";
	private static final String COLUMN_RECEIVER = "receiver";
	
	public String getEntityName() {
		return ENTITY_NAME;
	}

	public void initializeAttributes() {
		addAttribute(getIDColumnName());
		
		addManyToOneRelationship(COLUMN_APPLICATION, ServiceGuarantee.class);
		
		addAttribute(COLUMN_MONTH, "Month", Integer.class);
		addAttribute(COLUMN_YEAR, "Year", Integer.class);
		addAttribute(COLUMN_RECEIVER, "Receiver", String.class);
	}

	//Getters
	public ServiceGuarantee getServiceGuarantee() {
		return (ServiceGuarantee) getColumnValue(COLUMN_APPLICATION);
	}
	
	public int getMonth() {
		return getIntColumnValue(COLUMN_MONTH);
	}
	
	public int getYear() {
		return getIntColumnValue(COLUMN_YEAR);
	}
	
	public String getReceiver() {
		return getStringColumnValue(COLUMN_RECEIVER);
	}
	
	//Setters
	public void setServiceGuarantee(ServiceGuarantee application) {
		setColumn(COLUMN_APPLICATION, application);
	}
	
	public void setMonth(int month) {
		setColumn(COLUMN_MONTH, month);
	}
	
	public void setYear(int year) {
		setColumn(COLUMN_YEAR, year);
	}
	
	public void setReceiver(String receiver) {
		setColumn(COLUMN_RECEIVER, receiver);
	}
	
	//Finders
	public Object ejbFindByChildAndMonthAndYear(User child, int month, int year) throws FinderException {
		Table table = new Table(this);
		Table guarantee = new Table(ServiceGuarantee.class);
		
		SelectQuery query = new SelectQuery(table);
		query.addColumn(table.getColumn(getIDColumnName()));
		try {
			query.addJoin(table, guarantee);
		}
		catch (IDORelationshipException ire) {
			throw new FinderException(ire.getMessage());
		}
		query.addCriteria(new MatchCriteria(guarantee.getColumn("child_id"), MatchCriteria.EQUALS, child));
		query.addCriteria(new MatchCriteria(table.getColumn(COLUMN_MONTH), MatchCriteria.EQUALS, month));
		query.addCriteria(new MatchCriteria(table.getColumn(COLUMN_YEAR), MatchCriteria.EQUALS, year));
		
		return idoFindOnePKByQuery(query);
	}

	public Collection ejbFindAllByApplication(ServiceGuarantee application) throws FinderException {
		Table table = new Table(this);
		
		SelectQuery query = new SelectQuery(table);
		query.addColumn(table.getColumn(getIDColumnName()));
		
		query.addCriteria(new MatchCriteria(table.getColumn(COLUMN_APPLICATION), MatchCriteria.EQUALS, application));

		return super.idoFindPKsByQuery(query);
	}
}