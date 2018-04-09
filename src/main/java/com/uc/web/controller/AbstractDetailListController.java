package com.uc.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

import com.uc.web.forms.DetailListQueryForm;
import com.uc.web.forms.ui.componet.PageCtrlImpl;

public abstract class AbstractDetailListController<
	KeyType, 
	EntityType,
	DetailQueryFormType extends DetailListQueryForm>
	extends AbstractDetailController<KeyType, EntityType>
	implements	DetailListController<KeyType,EntityType, DetailQueryFormType>  {
	
	private ListController<DetailQueryFormType> listController;
	
	public ListController<DetailQueryFormType> getListController() {
		return listController;
	}

	public void setListController(ListController<DetailQueryFormType> listController) {
		this.listController = listController;
	}
	

	@Override
	public String getDetailPage(String action, KeyType selectedId, Model model) {
		DetailQueryFormType queryInput=createQueryForm();
		queryInput.setQueryMainId(selectedId);
		getListController().postListPage(queryInput, model);
		return onGetDetailPage(action, selectedId, model);
		
	}	
	
	@Override
	public String postListPage(DetailQueryFormType queryForm, Model model) {
		return getListController().postListPage(queryForm, model);
	}
	
	@Override
	public String postTablePage(DetailQueryFormType queryInput, PageCtrlImpl pageCtrl, Model model) {
		return getListController().postTablePage(queryInput, pageCtrl, model);
	}
	
	@Override
	public DetailQueryFormType createQueryForm() {
		return getListController().createQueryForm();
	}

	@Override
	public String getListPage(Model model) {
		return getListController().getListPage(model);
	}
	
	public void exportFile(DetailQueryFormType queryInput, HttpServletRequest request, HttpServletResponse response) {
		if(getListController() instanceof ExportController) {
			@SuppressWarnings("unchecked")
			ExportController<DetailQueryFormType> exportController=(ExportController<DetailQueryFormType>) getListController();
			exportController.exportFile(queryInput, request, response);
		}
	}
	
}
