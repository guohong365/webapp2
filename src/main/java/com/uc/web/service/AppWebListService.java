package com.uc.web.service;

import com.uc.web.forms.ListQueryForm;
import com.uc.web.forms.WebListForm;

public interface AppWebListService<QueryFormType extends ListQueryForm,DetailType extends Object>
	extends 
		AppListService<QueryFormType, DetailType>,
		AppExportService<QueryFormType, DetailType>{

	void select(WebListForm<QueryFormType, DetailType> webForm);
}
