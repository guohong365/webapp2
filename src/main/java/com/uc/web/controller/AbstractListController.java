package com.uc.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

import com.uc.web.forms.QueryForm;
import com.uc.web.forms.ui.componet.PageCtrl;

public abstract class AbstractListController<
	KeyType, 
	QueryFormType extends QueryForm<KeyType>,
	DetailType>
	extends AbstractListControllerBase<KeyType, QueryFormType, DetailType>
	implements ListController<KeyType, QueryFormType, DetailType>  {

	@Override
	public void exportFile(QueryFormType queryForm, HttpServletRequest request, HttpServletResponse response,
			String type) {
		onExport(queryForm, request, response, type);
	}

	@Override
	public String getListPage(Model model) {
		return onGetListPage(model);
	}

	@Override
	public String postTablePage(QueryFormType queryInput, PageCtrl pageCtrl, Model model) {
		return onPostTablePage(queryInput, pageCtrl, model);
	}

	@Override
	public String postListPage(QueryFormType queryForm, Model model) {
		return onPostListPage(queryForm, model);
	}
	
	@Override
	public QueryFormType createQueryForm() {
		return onCreateNewQueryForm();
	}

}
