package com.uc.web.controller;

import org.springframework.ui.Model;

import com.uc.web.forms.DetailListQueryForm;
import com.uc.web.forms.ui.componet.PageCtrlImpl;

public interface DetailListController<KeyType, EntityType, DetailQueryFormType extends DetailListQueryForm>
		extends DetailController<KeyType, EntityType> {
	
	public static final String EXPORTOR_OPTION_DETAIL_DATA="_DETAIL";
	
	String getDetailListPage(String action, KeyType selectedId, Model model);
	String postDetailListPage(DetailQueryFormType queryInput, Model model);
	String postDetailTablePage(DetailQueryFormType queryInput, PageCtrlImpl pageCtrlImpl, Model model);
	DetailQueryFormType createDetailQueryForm();
}
