package com.uc.web.controller;

import com.uc.web.forms.DetailListQueryForm;

public interface DetailListController<KeyType, EntityType, DetailQueryFormType extends DetailListQueryForm>
		extends 
		DetailController<KeyType, EntityType>, 
		ListController<DetailQueryFormType>{
	public static final String EXPORTOR_OPTION_DETAIL_DATA="_DETAIL";
}
