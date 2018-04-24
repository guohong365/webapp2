package com.uc.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

import com.uc.web.forms.DetailListQueryForm;
import com.uc.web.forms.ListQueryForm;
import com.uc.web.forms.ui.componet.PageCtrlImpl;

public abstract class AbstractDetailListController<
	KeyType, 
	EntityType,
	QueryFormType extends ListQueryForm,
	DetailQueryFormType extends DetailListQueryForm>
	extends AbstractController<KeyType, EntityType, QueryFormType>
	implements	DetailListController<KeyType,EntityType, DetailQueryFormType>  {
	
	private ListController<DetailQueryFormType> detailListController;
	
	public ListController<DetailQueryFormType> getDetailListController() {
		return detailListController;
	}
	public void setDetailListController(ListController<DetailQueryFormType> detailListController) {
		this.detailListController = detailListController;
	}

	@Override
	public String getDetailListPage(String action, KeyType selectedId, Model model) {
		DetailQueryFormType queryInput=createDetailQueryForm();
		queryInput.setQueryMainId(selectedId);
		getDetailListController().postListPage(queryInput, model);
		return onGetDetailPage(action, selectedId, model);
		
	}	
	
	@Override
	public String postDetailListPage(DetailQueryFormType queryForm, Model model) {
		return getDetailListController().postListPage(queryForm, model);
	}
	
	@Override
	public String postDetailTablePage(DetailQueryFormType queryInput, PageCtrlImpl pageCtrl, Model model) {
		return getDetailListController().postTablePage(queryInput, pageCtrl, model);
	}
	
	@Override
	public DetailQueryFormType createDetailQueryForm() {
		return getDetailListController().createQueryForm();
	}

	public void exportDetailList(DetailQueryFormType queryInput, HttpServletRequest request, HttpServletResponse response) {
		if(getDetailListController() instanceof ExportController) {
			@SuppressWarnings("unchecked")
			ExportController<DetailQueryFormType> exportController=(ExportController<DetailQueryFormType>) getDetailListController();
			exportController.exportFile(queryInput, request, response);
		}
	}
	
}
