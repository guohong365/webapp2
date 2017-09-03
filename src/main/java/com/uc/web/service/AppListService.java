package com.uc.web.service;

import java.util.List;

import com.uc.web.forms.ListQueryForm;
import com.uc.web.persistence.Example;

public interface AppListService<QueryFormType extends ListQueryForm, EntityType> extends Service{
	boolean prepareExample(QueryFormType queryFormType, Example example);
	boolean prepareQueryForm(QueryFormType queryForm);
	Long selectCount(QueryFormType queryForm);
	List<EntityType> select(QueryFormType queryForm, long offset, long count);
	String getDefaultOrderByClause();
	void setDefaultOrderByClause(String defaultOrderBy);
}
