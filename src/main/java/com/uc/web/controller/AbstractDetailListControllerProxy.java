package com.uc.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.uc.web.forms.DetailListQueryForm;
import com.uc.web.forms.ui.componet.PageCtrl;

public abstract class AbstractDetailListControllerProxy<KeyType, DetailType, QueryFormType extends DetailListQueryForm<KeyType>, DetailListType> 
	extends AbstractDetailControllerProxy<KeyType, DetailType> 
	implements DetailListControllerProxy<KeyType, DetailType, QueryFormType, DetailListType> {

	private static final String URI_PATH_DETAIL_LIST = "/detail/list";
	private static final String URI_PATH_DETAIL_LIST_TABLE = "/detail/table";
	private static final String URI_PATH_DETAIL_LIST_EXPORT = "/detail/export";

	@Override
	@RequestMapping(value=URI_PATH_DETAIL_LIST_TABLE, method=RequestMethod.POST)
	public String postTablePage(
			@ModelAttribute(PARAM_NAME_QUERY_INPUT)
			QueryFormType queryInput,
			@RequestParam(PARAM_NAME_PAGE_CTRL)
			PageCtrl pageCtrl, 
			Model model) {
		return getDetailListController().postTablePage(queryInput, pageCtrl, model);
	}

	@Override
	@RequestMapping(value=URI_PATH_DETAIL_LIST, method=RequestMethod.POST)
	public String postListPage(
			@ModelAttribute(PARAM_NAME_QUERY_INPUT)
			QueryFormType queryForm, 
			Model model) {
		return getDetailListController().postListPage(queryForm, model);
	}

	@Override
	public QueryFormType createQueryForm() {
		return getDetailListController().createQueryForm();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public DetailListController<KeyType, DetailType, QueryFormType, DetailListType> getDetailListController() {
		return (DetailListController<KeyType, DetailType, QueryFormType, DetailListType>) getDetailController();
	}

	@Override
	public void setDetailListController(
			DetailListController<KeyType, DetailType, QueryFormType, DetailListType> controller) {
		setDetailController(controller);
	}

	@Override	
	public String getListPage(Model model) {
		return getDetailListController().getListPage(model);
	}

	@Override
	@RequestMapping(value=URI_PATH_DETAIL_LIST_EXPORT,method=RequestMethod.POST)
	public void exportFile(
			@ModelAttribute(PARAM_NAME_QUERY_INPUT)
			QueryFormType queryForm, HttpServletRequest request, HttpServletResponse response,
			String type) {
		getLogger().trace(queryForm.toString());
		getDetailListController().exportFile(queryForm, request, response, type);
	}
}
