package com.uc.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

import com.uc.web.forms.QueryForm;
import com.uc.web.forms.ui.componet.PageCtrl;

public abstract class AbstractController<
	KeyType,QueryFormType extends QueryForm<KeyType>,
	DetailType>
	extends ControllerSupportImpl<KeyType>
	implements GeneralController<KeyType, QueryFormType,DetailType> {
	
	private DetailController<KeyType, DetailType> detailController;
	
	public void setDetailController(DetailController<KeyType, DetailType>  detailController) {
		this.detailController = detailController;
		this.detailController.setParent(this);
	}
	
	public DetailController<KeyType, DetailType>  getDetailController() {
		return detailController;
	}
	
	private ListController<KeyType, QueryFormType, DetailType> listController;
	
	public void setListController(ListController<KeyType, QueryFormType, DetailType> listController) {
		this.listController = listController;
		this.listController.setParent(this);
	}
	
	public ListController<KeyType, QueryFormType, DetailType> getListController() {
		return listController;
	}
	
	//----------------- get list -----------------------------------
	@Override
	public String getListPage(Model model){
		return getListController().getListPage(model);
	}
	
	//--------------post table ----------------------------------
	@Override
	public String postTablePage(
			QueryFormType queryInput,
			PageCtrl pageCtrl,
			Model model) {
		return getListController().postListPage(queryInput, model);
	}
	@Override
	public String postListPage(
			QueryFormType queryForm, 
			Model model){
		return getListController().postListPage(queryForm, model);
	}
	
    @Override
    public void exportFile(
    		QueryFormType queryForm, 
    		HttpServletRequest request, 
    		HttpServletResponse response,
    		String type) {
    	getListController().exportFile(queryForm, request, response, type);
    }
    
	@Override
	public String getDetailPage(
			String action,
			KeyType recordId, Model model) {
		return getDetailController().getDetailPage(action, recordId, model);
	}
		
	@Override
	public String postDetailPage(
			String action,
			DetailType detail) {
		return getDetailController().postDetailPage(action, detail);
	}
}
