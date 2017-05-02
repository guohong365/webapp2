package com.uc.web.controller;

import com.uc.web.forms.DetailListQueryForm;

public interface DetailListController<
	KeyType, 
	DetailType, 
	QueryFormType extends DetailListQueryForm<KeyType>, 
	DetailListType>
		extends DetailController<KeyType, DetailType>, ListController<KeyType, QueryFormType, DetailListType>{
	public static final String EXPORTOR_OPTION_DETAIL_DATA="_DETAIL";
}
