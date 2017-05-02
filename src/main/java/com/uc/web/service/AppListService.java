package com.uc.web.service;

import com.uc.web.forms.QueryForm;
import com.uc.web.forms.WebListFormBase;
import com.uc.web.persistence.Example;

public interface AppListService<KeyType,QueryFormType extends QueryForm<KeyType>,DetailType extends Object>
	extends AppExportService<QueryFormType, DetailType>,Service, AppServiceErrorHandler {

	boolean prepareExample(QueryFormType queryFormType, Example example);	
	void select(WebListFormBase<KeyType,QueryFormType, DetailType> webForm);
	String getDefaultOrderByClause();
	void setDefaultOrderByClause(String defaultOrderBy);

}
