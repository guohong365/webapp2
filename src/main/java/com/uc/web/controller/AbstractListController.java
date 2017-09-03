package com.uc.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

import com.uc.web.forms.ListQueryForm;

public abstract class AbstractListController<QueryFormType extends ListQueryForm, EntityType>
	extends AbstractListControllerBase<QueryFormType, EntityType>
	implements ListController<QueryFormType>, ExportController<QueryFormType>  {

	@Override
	public String getListPage(Model model) {
		return onGetListPage(model);
	}
	
	@Override
	public void exportFile(QueryFormType queryForm, HttpServletRequest request, HttpServletResponse response) {
		onExport(queryForm, request, response);
	}

	@Override
	public String postTablePage(QueryFormType queryInput, Model model) {
		return onPostTablePage(queryInput, model);
	}

	@Override
	public String postListPage(QueryFormType queryForm, Model model) {
		return onPostListPage(queryForm, model);
	}
}
