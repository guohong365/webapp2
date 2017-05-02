package com.uc.web.forms;

import java.util.Map;

import com.uc.web.domain.security.UserProfile;

public interface QueryForm<KeyType> {

	String getQueryOrder();
	void setQueryOrder(String order);

	String getQueryOrderBy();
	void setQueryOrderBy(String orderBy);
	
	UserProfile<KeyType> getQueryUser();

	void setQueryUser(UserProfile<KeyType> queryUser);

	String getQueryOrderByClause();
	void setQueryOrderByClause(String orderByClause);

	void addLimits(String name, Object item);

	void addLimits(Map<String, ? extends Object> map);

	Object getLimits(String name);

	void clearLimits();

}