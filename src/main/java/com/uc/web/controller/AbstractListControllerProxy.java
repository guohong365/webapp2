package com.uc.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uc.web.forms.QueryForm;
import com.uc.web.forms.ui.componet.PageCtrl;

public abstract class AbstractListControllerProxy<
	KeyType,
	QueryFormType extends QueryForm<KeyType>, 
	DetailType>
	extends ControllerProxySupportImpl<KeyType>
	implements ListControllerProxy<KeyType, QueryFormType, DetailType> {
	
	private ListController<KeyType, QueryFormType, DetailType> listController;
	@Override
	public void setListController(ListController<KeyType, QueryFormType, DetailType> listController) {
		this.listController = listController;
	}
	@Override
	public ListController<KeyType, QueryFormType, DetailType> getListController() {
		return listController;
	}

	@Override
	@RequestMapping(value=URI_PATH_LIST, method=RequestMethod.GET)
	public String getListPage(Model model) {		
		return getListController().getListPage(model);
	}

	@Override
	@RequestMapping(value=URI_PATH_TABLE, method=RequestMethod.POST)
	public String postTablePage(
			@ModelAttribute(PARAM_NAME_QUERY_INPUT)
			QueryFormType queryInput, 
			@ModelAttribute(PARAM_NAME_PAGE_CTRL)
			PageCtrl pageCtrl, Model model) {
		return getListController().postTablePage(queryInput, pageCtrl, model);
	}

	@Override
	@RequestMapping(value=URI_PATH_LIST, method=RequestMethod.POST)
	public String postListPage(
			@ModelAttribute(PARAM_NAME_QUERY_INPUT)
			QueryFormType queryForm, Model model) {
		return getListController().postListPage(queryForm, model);
	}

	@Override
	public String getPageBasePath() {
		return null;
	}

	@Override
	@ModelAttribute(value=PARAM_NAME_MODEL_TITLE)
	public String getModelTitle() {
		return getListController().getModelTitle();
	}

	@Override
	@RequestMapping(value=URI_PATH_EXPORT, method=RequestMethod.POST)
	public void exportFile(
			@ModelAttribute(PARAM_NAME_QUERY_INPUT)
			QueryFormType queryForm, HttpServletRequest request, HttpServletResponse response,
			String type) {
		getListController().exportFile(queryForm, request, response, type);
	}

	@Override
	@ModelAttribute(value=PARAM_NAME_BASE_URL)
	public String getBaseUri() {
		return onGetBaseUri();
	}
	protected abstract String onGetBaseUri();
	
	@Override
	public QueryFormType createQueryForm() {
		return getListController().createQueryForm();
	}
}
