/*
 * $Id$
 * Created on Sep 3, 2008
 *
 * Copyright (C) 2008 Idega Software hf. All Rights Reserved.
 *
 * This software is the proprietary information of Idega hf.
 * Use is subject to license terms.
 */
package is.idega.idegaweb.egov.childcare.rvk.data;

import java.util.Collection;

import javax.ejb.FinderException;

import com.idega.block.school.data.School;
import com.idega.data.GenericEntity;
import com.idega.data.query.MatchCriteria;
import com.idega.data.query.SelectQuery;
import com.idega.data.query.Table;


public class ChildCareChoiceProviderBMPBean extends GenericEntity implements ChildCareChoiceProvider {

	private final static String ENTITY_NAME = "rvk_childcare_provider";

	private static final String COLUMN_APPLICATION = "application_id";
	private static final String COLUMN_PROVIDER = "provider_id";
	private static final String COLUMN_CHOICE_NUMBER = "choice_number";
	
	public String getEntityName() {
		return ENTITY_NAME;
	}

	public void initializeAttributes() {
		addAttribute(getIDColumnName());
		
		addManyToOneRelationship(COLUMN_APPLICATION, ChildCareChoice.class);
		addManyToOneRelationship(COLUMN_PROVIDER, School.class);
		
		addAttribute(COLUMN_CHOICE_NUMBER, "Choice number", Integer.class);
	}
	
	//Getters
	public ChildCareChoice getApplication() {
		return (ChildCareChoice) getColumnValue(COLUMN_APPLICATION);
	}
	
	public School getProvider() {
		return (School) getColumnValue(COLUMN_PROVIDER);
	}
	
	public int getChoiceNumber() {
		return getIntColumnValue(COLUMN_CHOICE_NUMBER);
	}
	
	//Setters
	public void setApplication(ChildCareChoice application) {
		setColumn(COLUMN_APPLICATION, application);
	}
	
	public void setProvider(School provider) {
		setColumn(COLUMN_PROVIDER, provider);
	}
	
	public void setChoiceNumber(int choiceNumber) {
		setColumn(COLUMN_CHOICE_NUMBER, choiceNumber);
	}
	
	//Finders
	public Collection ejbFindByApplication(ChildCareChoice application) throws FinderException {
		Table table = new Table(this);
		
		SelectQuery query = new SelectQuery(table);
		query.addColumn(table.getColumn(getIDColumnName()));
		query.addCriteria(new MatchCriteria(table.getColumn(COLUMN_APPLICATION), MatchCriteria.EQUALS, application));
		query.addOrder(table, COLUMN_CHOICE_NUMBER, true);
		
		return idoFindPKsByQuery(query);
	}

	public Object ejbFindByApplicationAndChoiceNumber(ChildCareChoice application, int choiceNumber) throws FinderException {
		Table table = new Table(this);
		
		SelectQuery query = new SelectQuery(table);
		query.addColumn(table.getColumn(getIDColumnName()));
		query.addCriteria(new MatchCriteria(table.getColumn(COLUMN_APPLICATION), MatchCriteria.EQUALS, application));
		query.addCriteria(new MatchCriteria(table.getColumn(COLUMN_CHOICE_NUMBER), MatchCriteria.EQUALS, choiceNumber));
		
		return idoFindOnePKByQuery(query);
	}
}