package com.uc.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uc.web.forms.QueryForm;

public abstract class AbstractControllerProxy<KeyType, QueryFormType extends QueryForm<KeyType>, EntityType> 
	extends ControllerProxyBaseImpl
	implements  
		GenericControllerProxy<KeyType, QueryFormType,EntityType>{
		
	@SuppressWarnings("unchecked")
	@Override
	public GeneralController<KeyType, QueryFormType, EntityType> getController(){
		return (GeneralController<KeyType, QueryFormType, EntityType>) super.getController();
	}
	
	@Override
	@RequestMapping(value=URI_PATH_LIST, method=RequestMethod.GET)
	public String getListPage(Model model) {
		return getController().getListPage(model);
	}

	@Override
	@RequestMapping(value=URI_PATH_TABLE, method=RequestMethod.POST)
	public String postTablePage(
			@ModelAttribute(value=PARAM_NAME_QUERY_INPUT)
			QueryFormType queryInput,
			Model model) {
		return getController().postTablePage(queryInput, model);
	}	

	@Override
	@RequestMapping(value=URI_PATH_LIST, method=RequestMethod.POST)
	public String postListPage(
			@ModelAttribute(value=PARAM_NAME_QUERY_INPUT)
			QueryFormType queryForm, 
			Model model) {
		return getController().postListPage(queryForm, model);
	}

	@Override
	@RequestMapping(value=URI_PATH_EXPORT, method=RequestMethod.POST)
	public void exportFile(
			@ModelAttribute(value=PARAM_NAME_QUERY_INPUT)
			QueryFormType queryForm, 
			HttpServletRequest request, 
			HttpServletResponse response) {
		getController().exportFile(queryForm, request, response);
	}

	@Override
	@RequestMapping(value=URI_PATH_DETAIL, method=RequestMethod.GET)
	public String getDetailPage(
			@RequestParam(value=PARAM_NAME_ACTION, required=false, defaultValue=WebAction.NEW)
			String action,
			@RequestParam(value=PARAM_NAME_SELECTED_ID, required=false, defaultValue="")
			KeyType recordId, 
			Model model) {
		return getController().getDetailPage(action, recordId, model);
	}

	@Override
	@RequestMapping(value=URI_PATH_DETAIL, method=RequestMethod.POST, produces="text/plain;charset=UTF-8")
	@ResponseBody
	public String postDetailPage(
			@RequestParam(value=PARAM_NAME_ACTION)
			String action,
			@ModelAttribute(value=PARAM_NAME_DETAIL)
			EntityType detail) {
		return getController().postDetailPage(action, detail);
	}
	
	@Override
	public QueryFormType createQueryForm() {
		return null;
	}

}
