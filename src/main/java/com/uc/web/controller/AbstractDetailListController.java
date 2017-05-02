package com.uc.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

import com.uc.web.forms.DetailListQueryForm;
import com.uc.web.forms.ui.componet.PageCtrl;

public abstract class AbstractDetailListController<
	KeyType, 
	DetailType,
	QueryFormType extends DetailListQueryForm<KeyType>,
	DetailListType>
	extends AbstractDetailController<KeyType, DetailType>
	implements	DetailListController<KeyType,DetailType, QueryFormType, DetailListType>  {
	
	private ListController<KeyType, QueryFormType, DetailListType> listController;

	public ListController<KeyType, QueryFormType, DetailListType> getListController() {
		return listController;
	}

	public void setListController(ListController<KeyType, QueryFormType, DetailListType> listController) {
		this.listController = listController;
		this.listController.setParent(this);
	}
	
	protected String onGetDetailPageAgregation(String action, KeyType selectedId, Model model) {
		QueryFormType queryInput=createQueryForm();
		queryInput.setQuerySelectedId(selectedId);
		getListController().postListPage(queryInput, model);
		return super.onGetDetailPage(action, selectedId, model);
	}
	
	@Override
	public String getDetailPage(String action, KeyType recordId, Model model) {
		if(getParent()==null){
			return super.getDetailPage(action, recordId, model);
		} else {
			return onGetDetailPageAgregation(action, recordId, model);
		}
	}
	
	@Override
	public String postListPage(QueryFormType queryForm, Model model) {
		return getListController().postListPage(queryForm, model);
	}
	
	@Override
	public String postTablePage(QueryFormType queryInput, PageCtrl pageCtrl, Model model) {
		return getListController().postTablePage(queryInput, pageCtrl, model);
	}
	
	@Override
	public QueryFormType createQueryForm() {
		return getListController().createQueryForm();
	}

	@Override
	public String getListPage(Model model) {
		return getListController().getListPage(model);
	}

	@Override
	public void exportFile(QueryFormType queryForm, HttpServletRequest request, HttpServletResponse response,
			String type) {		
		getListController().exportFile(queryForm, request, response, type);		
	}
}
