package com.uc.web.persistence;

import java.util.List;

public interface Example {
	public void setOrderByClause(String orderByClause);
	public String getOrderByClause();
	public void setDistinct(boolean distinct);
	public boolean getDistinct();
	public List<QueryCondition> getOredCriteria();
	public void or(QueryCondition criteria);
	public QueryCondition or();
	public void clear();
	
	public boolean isEmpty();
}
