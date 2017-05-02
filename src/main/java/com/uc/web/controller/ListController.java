package com.uc.web.controller;

import org.springframework.ui.Model;

import com.uc.web.forms.QueryForm;
import com.uc.web.forms.ui.componet.PageCtrl;

public interface ListController <
	KeyType,
	QueryFormType extends QueryForm<KeyType>,
	DetailType> 
	extends	ExportController<KeyType, QueryFormType, DetailType>, 
			ControllerSupport<KeyType> {

	String getListPage(Model model);

	//--------------post table ----------------------------------
	String postTablePage(QueryFormType queryInput, PageCtrl pageCtrl, Model model);

	//--------------- post list --------------------------
	String postListPage(QueryFormType queryForm, Model model);

	String getPageBasePath();
	
	QueryFormType createQueryForm();
}
