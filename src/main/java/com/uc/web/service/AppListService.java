package com.uc.web.service;

import java.util.List;

import com.uc.web.forms.ListQueryForm;
import com.uc.web.persistence.Example;

public interface AppListService extends Service{
	boolean prepareExample(ListQueryForm queryFormType, Example example);
	boolean prepareQueryForm(ListQueryForm queryForm);
	Long selectCount(ListQueryForm queryForm);
	List<?> select(ListQueryForm queryForm, long offset, long count);
	String getDefaultOrderByClause();
	void setDefaultOrderByClause(String defaultOrderBy);
}
