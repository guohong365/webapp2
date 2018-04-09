package com.uc.web.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.uc.web.forms.DetailListQueryForm;
import com.uc.web.forms.ui.componet.PageCtrlImpl;

public abstract class AbstractDetailListControllerProxy<KeyType, EntityType, DetailQueryFormType extends DetailListQueryForm, DetailListType> 
	extends AbstractDetailControllerProxy<KeyType, EntityType> 
	implements DetailListControllerProxy<KeyType, EntityType, DetailQueryFormType> {

	private static final String URI_PATH_DETAIL_LIST = "/detail/list";
	private static final String URI_PATH_DETAIL_LIST_TABLE = "/detail/table";

	
	@Override
	@RequestMapping(value=URI_PATH_DETAIL_LIST_TABLE, method=RequestMethod.POST)
	public String postTablePage(
			@ModelAttribute(PARAM_NAME_QUERY_INPUT)
			DetailQueryFormType queryInput,
			@ModelAttribute(PARAM_NAME_PAGE_CTRL)
			PageCtrlImpl pageCtrl,
			Model model) {
		return getController().postTablePage(queryInput, pageCtrl, model);
	}

	@Override
	@RequestMapping(value=URI_PATH_DETAIL_LIST, method=RequestMethod.POST)
	public String postListPage(
			@ModelAttribute(PARAM_NAME_QUERY_INPUT)
			DetailQueryFormType queryForm, 
			Model model) {
		return getController().postListPage(queryForm, model);
	}
	
	

	@Override
	public DetailQueryFormType createQueryForm() {
		return getController().createQueryForm();
	}	

	@Override	
	public String getListPage(Model model) {
		return getController().getListPage(model);
	}

	@SuppressWarnings("unchecked")
	@Override
	public DetailListController<KeyType, EntityType, DetailQueryFormType> getController() {
		if(super.getController() instanceof DetailListController)
			return (DetailListController<KeyType, EntityType, DetailQueryFormType>) super.getController();
		return null;
	}
}
