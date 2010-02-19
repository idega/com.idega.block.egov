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

import is.idega.idegaweb.egov.childcare.rvk.business.ChildCareConstants;

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


public class ServiceGuaranteeBMPBean extends AbstractCaseBMPBean implements Case, ServiceGuarantee {

	private static final String ENTITY_NAME = "comm_service_guarantee";
	
	private static final String COLUMN_CHILD = "child_id";
	private static final String COLUMN_CARETAKER_RELATION = "caretaker_relation";
	private static final String COLUMN_PRIVATE_PROVIDER = "private_provider";
	private static final String COLUMN_COMMUNE_PROVIDER = "commune_provider";
	private static final String COLUMN_PRIVATE_CARETAKER = "private_caretaker";
	private static final String COLUMN_EXPORTED = "exported";
	
	@Override
	public String getCaseCodeDescription() {
		return "Case code for service guarantee";
	}

	@Override
	public String getCaseCodeKey() {
		return ChildCareConstants.GUARANTEE_CASE_CODE_KEY;
	}

	@Override
	public String getEntityName() {
		return ENTITY_NAME;
	}

	@Override
	public void initializeAttributes() {
		addGeneralCaseRelation();
		
		addManyToOneRelationship(COLUMN_CHILD, User.class);
		
		addAttribute(COLUMN_CARETAKER_RELATION, "Caretaker relation", String.class);
		addAttribute(COLUMN_COMMUNE_PROVIDER, "Commune provider", Boolean.class);
		addAttribute(COLUMN_PRIVATE_PROVIDER, "Private provider", Boolean.class);
		addAttribute(COLUMN_PRIVATE_CARETAKER, "Private caretaker", Boolean.class);
		addAttribute(COLUMN_EXPORTED, "Exported", Boolean.class);
	}
	
	//Getters
	public User getChild() {
		return (User) getColumnValue(COLUMN_CHILD);
	}
	
	public String getCaretakerRelation() {
		return getStringColumnValue(COLUMN_CARETAKER_RELATION);
	}
	
	public boolean hasCommuneProvider() {
		return getBooleanColumnValue(COLUMN_COMMUNE_PROVIDER, false);
	}
	
	public boolean hasPrivateProvider() {
		return getBooleanColumnValue(COLUMN_PRIVATE_PROVIDER, false);
	}
	
	public boolean hasPrivateCaretaker() {
		return getBooleanColumnValue(COLUMN_PRIVATE_CARETAKER, false);
	}
	
	public boolean isExported() {
		return getBooleanColumnValue(COLUMN_EXPORTED, false);
	}
	
	//Setters
	public void setChild(User child) {
		setColumn(COLUMN_CHILD, child);
	}
	
	public void setCaretakerRelation(String relation) {
		setColumn(COLUMN_CARETAKER_RELATION, relation);
	}
	
	public void setCommuneProvider(boolean hasProvider) {
		setColumn(COLUMN_COMMUNE_PROVIDER, hasProvider);
	}
	
	public void setPrivateProvider(boolean hasProvider) {
		setColumn(COLUMN_PRIVATE_PROVIDER, hasProvider);
	}
	
	public void setPrivateCaretaker(boolean hasProvider) {
		setColumn(COLUMN_PRIVATE_CARETAKER, hasProvider);
	}
	
	public void setExported(boolean exported) {
		setColumn(COLUMN_EXPORTED, exported);
	}
	
	//Finders
	public Object ejbFindByChild(User child) throws FinderException {
		Table table = new Table(this);
		
		SelectQuery query = new SelectQuery(table);
		query.addColumn(table.getColumn(getIDColumnName()));
		query.addCriteria(new MatchCriteria(table.getColumn(COLUMN_CHILD), MatchCriteria.EQUALS, child));
		
		return idoFindOnePKByQuery(query);
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