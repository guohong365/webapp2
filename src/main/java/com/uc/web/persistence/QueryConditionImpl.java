package com.uc.web.persistence;

import java.util.ArrayList;
import java.util.List;

public class QueryConditionImpl implements QueryCondition {
	
	protected List<QueryCriterion> criteria;

	public QueryConditionImpl() {
		criteria = new ArrayList<QueryCriterion>();
	}

	@Override
	public boolean isValid() {
		return criteria.size() > 0;
	}

	@Override
	public List<QueryCriterion> getAllCriteria() {
		return criteria;
	}

	@Override
	public List<QueryCriterion> getCriteria() {
		return criteria;
	}

	@Override
	public void addCriterion(String condition) {
		if (condition == null) {
			throw new RuntimeException("Value for condition cannot be null");
		}
		criteria.add(new QueryCriterionImpl(condition));
	}

	@Override
	public void addCriterion(String condition, Object value) {
		criteria.add(new QueryCriterionImpl(condition, value));
	}

	@Override
	public void addCriterion(String condition, Object value1, Object value2) {
		criteria.add(new QueryCriterionImpl(condition, value1, value2));
	}

	@Override
	public QueryCondition andFieldIsNull(String filed) {
		addCriterion(filed + " is null");
		return this;
	}

	@Override
	public QueryCondition andFieldIsNotNull(String field) {
		addCriterion(field + " is not null");
		return this;
	}

	@Override
	public QueryCondition andFieldEqualTo(String field, Object value) {
		addCriterion(field + " =", value);
		return this;
	}

	@Override
	public QueryCondition andFieldNotEqualTo(String field, Object value) {
		addCriterion(field + " <>", value);
		return this;
	}

	@Override
	public QueryCondition andFieldGreaterThan(String field, Object value) {
		addCriterion(field + " >", value);
		return this;
	}

	@Override
	public QueryCondition andFieldGreaterThanOrEqualTo(String field, Object value) {
		addCriterion(field + " >=", value);
		return this;
	}

	@Override
	public QueryCondition andFieldLessThan(String field, Object value) {
		addCriterion(field + " <", value);
		return this;
	}

	@Override
	public QueryCondition andFieldLessThanOrEqualTo(String field, Object value) {
		addCriterion(field + " <=", value);
		return this;
	}

	@Override
	public QueryCondition andFieldLike(String field, Object value) {
		addCriterion(field + " like", value);
		return this;
	}

	@Override
	public QueryCondition andFieldNotLike(String field, Object value) {
		addCriterion(field + " not like", value);
		return this;
	}

	@Override
	public QueryCondition andFieldIn(String field, List<?> values) {
		addCriterion(field + " in", values);
		return this;
	}

	@Override
	public QueryCondition andFieldNotIn(String field, List<?> values) {
		addCriterion(field + " not in", values);
		return this;
	}

	@Override
	public QueryCondition andFieldBetween(String field, Object value1, Object value2) {
		addCriterion(field + " between", value1, value2);
		return this;
	}

	@Override
	public QueryCondition andFieldNotBetween(String field, Object value1, Object value2) {
		addCriterion(field + " not between", value1, value2);
		return this;
	}

}
