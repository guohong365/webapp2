package com.uc.web.forms;

import java.util.Map;

public interface ListQueryForm extends QueryFormBase {	
	String getQueryOrder();
	void setQueryOrder(String order);

	String getQueryOrderBy();
	void setQueryOrderBy(String orderBy);
	String getQueryOrderByClause();
	void setQueryOrderByClause(String orderByClause);
		
	Map<String, String> getColumnMap();
}
