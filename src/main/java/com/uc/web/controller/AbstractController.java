package com.uc.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

import com.uc.web.forms.ListQueryForm;
import com.uc.web.forms.ui.componet.PageCtrlImpl;

public abstract class AbstractController<KeyType, EntityType, QueryFormType extends ListQueryForm>
	extends AbsrtactControllerBase
	implements 
	DetailController<KeyType, EntityType>,
	ListController<QueryFormType>,
	ExportController<QueryFormType>	
{
		
	@Override
	public String getDetailPage(String action, KeyType recordId, Model model) {
		return onGetDetailPage(action, recordId, model);
	}
	@Override
	public String postDetailPage(String action, EntityType detail) {
		return onPostDetailPage(action, detail);
	}
	
	@Override
	public String getListPage(Model model) {
		return onGetListPage(model);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public QueryFormType createQueryForm() {
		return (QueryFormType) super.createQueryForm();
	}
	
	@Override
	public void exportFile(QueryFormType queryForm, HttpServletRequest request, HttpServletResponse response) {
		onExport(queryForm, request, response);
	}

	@Override
	public String postTablePage(QueryFormType queryInput,PageCtrlImpl pageCtrl, Model model) {
		return onPostTablePage(queryInput, pageCtrl, model);
	}

	@Override
	public String postListPage(QueryFormType queryForm, Model model) {
		return onPostListPage(queryForm, model);
	}

}
