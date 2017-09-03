package com.uc.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

import com.uc.web.forms.QueryForm;

public abstract class AbstractController<
	KeyType,QueryFormType extends QueryForm<KeyType>,
	EntityType>
	extends ControllerBaseImpl
	implements GeneralController<KeyType, QueryFormType,EntityType> {
	
	private DetailController<KeyType, EntityType> detailController;
	
	public void setDetailController(DetailController<KeyType, EntityType>  detailController) {
		this.detailController = detailController;
	}
	
	public DetailController<KeyType, EntityType>  getDetailController() {
		return detailController;
	}
	
	private ListController<QueryFormType> listController;
	
	public void setListController(ListController<QueryFormType> listController) {
		this.listController = listController;
	}
	
	public ListController<QueryFormType> getListController() {
		return listController;
	}
	
	@SuppressWarnings("unchecked")
	protected ExportController<QueryFormType> getExportController(){
		if(getListController() instanceof ExportController)
			return (ExportController<QueryFormType>) getListController();
		return null;
	}
	
	//----------------- get list -----------------------------------
	@Override
	public String getListPage(Model model){
		return getListController().getListPage(model);
	}
	
	//--------------post table ----------------------------------
	@Override
	public String postTablePage(QueryFormType queryInput, Model model) {
		return getListController().postListPage(queryInput, model);
	}
	@Override
	public String postListPage(QueryFormType queryForm,	Model model){
		return getListController().postListPage(queryForm, model);
	}
	
    @Override
    public void exportFile(QueryFormType queryForm, HttpServletRequest request,	HttpServletResponse response) {
    	if(getExportController()!=null){
    		getExportController().exportFile(queryForm, request, response);
    	}
    }
    
	@Override
	public String getDetailPage(String action,	KeyType recordId, Model model) {
		return getDetailController().getDetailPage(action, recordId, model);
	}
		
	@Override
	public String postDetailPage(String action,	EntityType detail) {
		return getDetailController().postDetailPage(action, detail);
	}
}
