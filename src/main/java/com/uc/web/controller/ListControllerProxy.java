package com.uc.web.controller;

import com.uc.web.forms.QueryForm;

public interface ListControllerProxy<KeyType,QueryFormType extends QueryForm<KeyType>,DetailType>
	extends ListController<KeyType, QueryFormType,DetailType>, ControllerProxy{
	
	ListController<KeyType,QueryFormType,DetailType> getListController();	
	void setListController(ListController<KeyType,	QueryFormType,	DetailType> controller);
}
