package com.uc.web.controller;

import com.uc.web.forms.DetailListQueryForm;

public interface DetailListControllerProxy<KeyType,DetailType,QueryFormType extends DetailListQueryForm<KeyType>,DetailListType> 
	extends
		DetailControllerProxy<KeyType, DetailType>,
		DetailListController<KeyType, DetailType, QueryFormType, DetailListType>{
	
	DetailListController<KeyType, DetailType, QueryFormType, DetailListType> getDetailListController();
	void setDetailListController(DetailListController<KeyType, DetailType, QueryFormType, DetailListType> controller);

}
