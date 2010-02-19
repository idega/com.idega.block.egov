/*
 * $Id: ChildCareChoiceBMPBean.java,v 1.8 2009/05/25 13:42:14 valdas Exp $
 * 
 * Copyright (C) 2002 Idega hf. All Rights Reserved.
 * 
 * This software is the proprietary information of Idega hf. Use is subject to license terms.
 * 
 */
package is.idega.idegaweb.egov.childcare.rvk.data;

import is.idega.idegaweb.egov.childcare.rvk.business.ChildCareConstants;

import java.util.Collection;

import javax.ejb.FinderException;

import com.idega.block.process.data.AbstractCaseBMPBean;
import com.idega.block.process.data.Case;
import com.idega.data.IDOAddRelationshipException;
import com.idega.data.IDORemoveRelationshipException;
import com.idega.data.query.Criteria;
import com.idega.data.query.MatchCriteria;
import com.idega.data.query.OR;
import com.idega.data.query.SelectQuery;
import com.idega.data.query.Table;
import com.idega.user.data.User;

/**
 * 
 * @author palli
 * @version 1.0
 */
public class ChildCareChoiceBMPBean extends AbstractCaseBMPBean implements ChildCareChoice, Case {

	private final static String ENTITY_NAME = "rvk_childcare";
	private final static String CASE_CODE_KEY_DESC = "Application for child care";

	private final static String COLUMN_CHILD = "child_id";
	private static final String COLUMN_DAYTIME = "daytime";
	private static final String COLUMN_DURATION = "duration";
	private static final String COLUMN_ACCEPTS_OTHER_PROVIDER = "accepts_other_provider";
	private static final String COLUMN_EXPORTED = "exported";

	/**
	 * @see com.idega.block.process.data.AbstractCaseBMPBean#getCaseCodeKey()
	 */
	@Override
	public String getCaseCodeKey() {
		return ChildCareConstants.CHILD_CARE_CASE_CODE_KEY;
	}

	/**
	 * @see com.idega.block.process.data.AbstractCaseBMPBean#getCaseCodeDescription()
	 */
	@Override
	public String getCaseCodeDescription() {
		return CASE_CODE_KEY_DESC;
	}

	/**
	 * @see com.idega.data.IDOEntity#getEntityName()
	 */
	@Override
	public String getEntityName() {
		return ENTITY_NAME;
	}

	/**
	 * @see com.idega.data.IDOEntity#initializeAttributes()
	 */
	@Override
	public void initializeAttributes() {
		addGeneralCaseRelation();

		addManyToOneRelationship(COLUMN_CHILD, User.class);
		
		addAttribute(COLUMN_DAYTIME, "Daytime", String.class);
		addAttribute(COLUMN_DURATION, "Duration", String.class);
		addAttribute(COLUMN_ACCEPTS_OTHER_PROVIDER, "Accepts other provider", Boolean.class);
		addAttribute(COLUMN_EXPORTED, "Exported", Boolean.class);
	}
	
	//Getters
	public User getChild() {
		return (User) getColumnValue(COLUMN_CHILD);
	}
	
	public String getDaytime() {
		return getStringColumnValue(COLUMN_DAYTIME);
	}
	
	public String getDuration() {
		return getStringColumnValue(COLUMN_DURATION);
	}
	
	public boolean acceptsOtherProviders() {
		return getBooleanColumnValue(COLUMN_ACCEPTS_OTHER_PROVIDER, false);
	}
	
	public boolean isExported() {
		return getBooleanColumnValue(COLUMN_EXPORTED, false);
	}
	
	//Setters
	public void setChild(User child) {
		setColumn(COLUMN_CHILD, child);
	}
	
	public void setDaytime(String daytime) {
		setColumn(COLUMN_DAYTIME, daytime);
	}
	
	public void setDuration(String duration) {
		setColumn(COLUMN_DURATION, duration);
	}
	
	public void setAcceptsOtherProviders(boolean accepts) {
		setColumn(COLUMN_ACCEPTS_OTHER_PROVIDER, accepts);
	}
	
	public void setExported(boolean exported) {
		setColumn(COLUMN_EXPORTED, exported);
	}
	
	//Finders
	public Object ejbFindApplicationByChild(User child) throws FinderException {
		Table table = new Table(this);
		
		SelectQuery query = new SelectQuery(table);
		query.addColumn(table.getColumn(getIDColumnName()));
		query.addCriteria(new MatchCriteria(table.getColumn(COLUMN_CHILD), MatchCriteria.EQUALS, child));

		return super.idoFindOnePKByQuery(query);
	}
	
	public Collection ejbFindNonExported() throws FinderException {
		Table table = new Table(this);
		
		SelectQuery query = new SelectQuery(table);
		query.addColumn(table.getColumn(getIDColumnName()));
		
		Criteria crit1 = new MatchCriteria(table.getColumn(COLUMN_EXPORTED));
		Criteria crit2 = new MatchCriteria(table.getColumn(COLUMN_EXPORTED), MatchCriteria.EQUALS, false);
		
		query.addCriteria(new OR(crit1, crit2));

		return super.idoFindPKsByQuery(query);
	}

	public void addSubscriber(User subscriber)
			throws IDOAddRelationshipException {
		throw new UnsupportedOperationException("This method is not implemented!");
	}

	public Collection<User> getSubscribers() {
		throw new UnsupportedOperationException("This method is not implemented!");
	}

	public void removeSubscriber(User subscriber)
			throws IDORemoveRelationshipException {
		throw new UnsupportedOperationException("This method is not implemented!");
	}
}