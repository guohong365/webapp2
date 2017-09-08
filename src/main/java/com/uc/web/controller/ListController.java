package com.uc.web.controller;

import org.springframework.ui.Model;

import com.uc.web.forms.ListQueryForm;
import com.uc.web.forms.ui.componet.PageCtrlImpl;

public interface ListController <QueryFormType extends ListQueryForm> 
	extends ControllerBase {
	
	String getListPage(Model model);
	//--------------post table ----------------------------------
	String postTablePage(QueryFormType queryInput, PageCtrlImpl pageCtrl,  Model model);
	//--------------- post list --------------------------
	String postListPage(QueryFormType queryInput, Model model);
	
	QueryFormType createQueryForm();
}
