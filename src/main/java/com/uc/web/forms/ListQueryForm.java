package com.uc.web.forms;

import com.uc.web.domain.security.UserProfile;

public interface ListQueryForm {	
	String getQueryOrder();
	void setQueryOrder(String order);
	String getQueryOrderBy();
	void setQueryOrderBy(String orderBy);
	String getQueryOrderByClause();
	void setQueryOrderByClause(String orderByClause);
	String getGroupByClause();
	void setGroupByClause(String groupByClause);
	UserProfile getUser();
	void setUser(UserProfile user);
}
