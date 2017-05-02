package com.uc.web.controller;

import com.uc.web.forms.QueryForm;

public interface GeneralController<KeyType,QueryFormType extends QueryForm<KeyType>,DetailType>
	extends ListController<KeyType, QueryFormType, DetailType>,
			DetailController<KeyType, DetailType>
	{	
}