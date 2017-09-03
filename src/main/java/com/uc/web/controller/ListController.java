package com.uc.web.controller;

import org.springframework.ui.Model;

import com.uc.web.forms.ListQueryForm;

public interface ListController <QueryFormType extends ListQueryForm> 
	extends ControllerBase {
	
	String getListPage(Model model);
	//--------------post table ----------------------------------
	String postTablePage(QueryFormType queryInput, Model model);
	//--------------- post list --------------------------
	String postListPage(QueryFormType queryInput, Model model);
	
	QueryFormType createQueryForm();
}
