package com.uc.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.uc.web.forms.ListQueryForm;

public abstract class AbstractListControllerProxy<QueryFormType extends ListQueryForm>
	extends ControllerProxyBaseImpl
	implements ListControllerProxy<QueryFormType>, ExportControllerProxy<QueryFormType> {
	
	@SuppressWarnings("unchecked")
	@Override
	public ListController<QueryFormType> getController() {
		return (ListController<QueryFormType>) super.getController();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ExportController<QueryFormType> getExportController(){
		if(getController() instanceof ExportController){
			return (ExportController<QueryFormType>) getController();
		}
		return null;
	}

	@Override
	@RequestMapping(value=URI_PATH_LIST, method=RequestMethod.GET)
	public String getListPage(Model model) {		
		return getController().getListPage(model);
	}

	@Override
	@RequestMapping(value=URI_PATH_TABLE, method=RequestMethod.POST)
	public String postTablePage(
			@ModelAttribute(PARAM_NAME_QUERY_INPUT)
			QueryFormType queryInput,
			Model model) {
		return getController().postTablePage(queryInput, model);
	}

	@Override
	@RequestMapping(value=URI_PATH_LIST, method=RequestMethod.POST)
	public String postListPage(
			@ModelAttribute(PARAM_NAME_QUERY_INPUT)
			QueryFormType queryForm, Model model) {
		return getController().postListPage(queryForm, model);
	}

	@Override
	@RequestMapping(value=URI_PATH_EXPORT, method=RequestMethod.POST)
	public void exportFile(
			@ModelAttribute(PARAM_NAME_QUERY_INPUT)
			QueryFormType queryForm, HttpServletRequest request, HttpServletResponse response) {
		if(getExportController()!=null){
			getExportController().exportFile(queryForm, request, response);
		}
	}
	@Override
	public QueryFormType createQueryForm(){
		return null;
	}
	
}
