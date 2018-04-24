package com.uc.web.controller.poxy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import com.uc.web.controller.DetailController;
import com.uc.web.controller.ExportController;
import com.uc.web.controller.ListController;
import com.uc.web.controller.ManagedColumnListController;
import com.uc.web.forms.ListQueryForm;
import com.uc.web.forms.ui.componet.PageCtrlImpl;

public class AbstractControllerProxyBase<KeyType, EntityType, QueryFormType extends ListQueryForm> 
	extends ControllerProxyBaseImpl{
	
	@SuppressWarnings("unchecked")
	public DetailController<KeyType,EntityType> getDetailController() {
		if(getController() instanceof DetailController)
			return (DetailController<KeyType,EntityType>) getController();
		return null;
	}
	
	@SuppressWarnings("unchecked")
	protected ListController<QueryFormType> getListController(){
		if(getController() instanceof ListController) {
			return (ListController<QueryFormType>)getController();
		}
		return null;
	}

	public String getDetailPage(
			String action,
			KeyType recordId, 
			Model model) {
		return getDetailController().getDetailPage(action, recordId, model);
	}

	public String postDetailPage(
			String action,
			EntityType detail) {		
		return getDetailController().postDetailPage(action, detail);
	}

	public String getEntityName() {
		return getDetailController().getEntityName();
	}
	
	@SuppressWarnings("unchecked")
	public ExportController<QueryFormType> getExportController(){
		if(getController() instanceof ExportController){
			return (ExportController<QueryFormType>) getController();
		}
		return null;
	}

	public String getListPage(Model model) {		
		return getListController().getListPage(model);
	}

	public String postTablePage(
			QueryFormType queryInput,
			PageCtrlImpl pageCtrl,
			Model model) {
		return getListController().postTablePage(queryInput, pageCtrl, model);
	}

	public String postListPage(
			QueryFormType queryForm, Model model) {
		return getListController().postListPage(queryForm, model);
	}

	public void exportFile(
			QueryFormType queryForm, HttpServletRequest request, HttpServletResponse response) {
		if(getExportController()!=null){
			getExportController().exportFile(queryForm, request, response);
		}
	}
	public QueryFormType createQueryForm() {
		return null;
	}
	
	public	ManagedColumnListController getColumnController(){
		if(getController() instanceof ManagedColumnListController)
			return  (ManagedColumnListController) getController();
		return null;
	}
	
	public String getShowColumns(String mode, Model model){
		return getColumnController().getShowColumns(mode, model);
	}

	public String postSetShowColumns(String mode, String columns) {
		return getColumnController().postSetShowColumns(mode, columns);
	}	
}
