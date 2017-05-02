package com.uc.web.persistence;

import java.util.List;

public interface QueryCondition {

	boolean isValid();

	List<QueryCriterion> getAllCriteria();

	List<QueryCriterion> getCriteria();

	QueryCondition andFieldIsNull(String filed);

	QueryCondition andFieldIsNotNull(String field);

	QueryCondition andFieldEqualTo(String field, Object value);

	QueryCondition andFieldNotEqualTo(String field, Object value);

	QueryCondition andFieldGreaterThan(String field, Object value);

	QueryCondition andFieldGreaterThanOrEqualTo(String field, Object value);

	QueryCondition andFieldLessThan(String field, Object value);

	QueryCondition andFieldLessThanOrEqualTo(String field, Object value);

	QueryCondition andFieldLike(String field, Object value);

	QueryCondition andFieldNotLike(String field, Object value);

	QueryCondition andFieldIn(String field, List<?> values);

	QueryCondition andFieldNotIn(String field, List<?> values);

	QueryCondition andFieldBetween(String field, Object value1, Object value2);

	QueryCondition andFieldNotBetween(String field, Object value1, Object value2);

	void addCriterion(String condition, Object value1, Object value2);

	void addCriterion(String condition, Object value);

	void addCriterion(String condition);
}