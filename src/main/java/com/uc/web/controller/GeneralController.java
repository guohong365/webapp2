package com.uc.web.controller;

import com.uc.web.forms.QueryForm;

public interface GeneralController<KeyType, QueryFormType extends QueryForm<KeyType>,EntityType>
	extends ListController<QueryFormType>,
			ExportController<QueryFormType>,
			DetailController<KeyType, EntityType>

	{	
}