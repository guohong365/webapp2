package com.uc.web.persistence;

import java.util.ArrayList;
import java.util.List;

public class ExampleImpl implements Example {

	private String orderByClause;
	private boolean distinct;
	private List<QueryCondition> oredCriteria;
	public ExampleImpl() {
		oredCriteria = new ArrayList<QueryCondition>();
	}
	@Override
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}
	@Override
	public String getOrderByClause() {
		return orderByClause;
	}
	@Override
	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

	@Override
	public boolean getDistinct() {
		return distinct;
	}
	@Override
	public List<QueryCondition> getOredCriteria() {
		return oredCriteria;
	}
	@Override
	public void or(QueryCondition criteria) {
		oredCriteria.add(criteria);
	}
	@Override
	public QueryCondition or() {
		QueryCondition criteria = createCriteriaInternal();
		oredCriteria.add(criteria);
		return criteria;
	}

	public QueryCondition createCriteria() {
		QueryCondition criteria = createCriteriaInternal();
		if (oredCriteria.size() == 0) {
			oredCriteria.add(criteria);
		}
		return criteria;
	}

	protected QueryCondition createCriteriaInternal() {
		QueryCondition criteria = new QueryConditionImpl();
		return criteria;
	}

	public void clear() {
		oredCriteria.clear();
		orderByClause = null;
		distinct = false;
	}
	@Override
	public boolean isEmpty() {
		for (QueryCondition iQueryCondition : oredCriteria) {
			if(iQueryCondition.isValid())
				return false;
		}
		return true;
	}

}
