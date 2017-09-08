package com.uc.web.service;

import java.util.List;

import com.uc.web.forms.ListQueryForm;
import com.uc.web.forms.ui.componet.PageCtrl;

public interface AppWebListService<QueryFormType extends ListQueryForm,EntityType extends Object>
	extends 
		AppListService<QueryFormType, EntityType>,
		AppExportService<QueryFormType, EntityType>{

	List<EntityType> select(QueryFormType queryForm, PageCtrl pageCtrl);
}
