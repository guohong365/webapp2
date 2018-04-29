package com.uc.web.controller.poxy;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uc.web.controller.WebAction;
import com.uc.web.domain.security.UserProfile;
import com.uc.web.forms.ListQueryForm;
import com.uc.web.forms.ui.componet.PageCtrlImpl;

public class AbstractControllerProxy<KeyType, EntityType,QueryFormType extends ListQueryForm>
	extends AbstractControllerProxyBase<KeyType, EntityType, QueryFormType>
	implements ListControllerProxy<QueryFormType>, DetailControllerProxy<KeyType, EntityType>{
	
	@Override
	@RequestMapping(value=URI_PATH_DETAIL, method=RequestMethod.GET)
	public String getDetailPage(
			@RequestParam(value=PARAM_NAME_ACTION, required=false, defaultValue=WebAction.NEW)
			String action,
			@RequestParam(value=PARAM_NAME_SELECTED_ID, required=false)
			KeyType recordId, 
			Model model) {
		return super.getDetailPage(action, recordId, model);
	}

	@Override
	@RequestMapping(value=URI_PATH_DETAIL, method=RequestMethod.POST, produces="text/plain;charset=UTF-8;")
	@ResponseBody
	public String postDetailPage(
			@RequestParam(value=PARAM_NAME_ACTION, required=true)
			String action,
			@ModelAttribute(value=PARAM_NAME_DETAIL)
			EntityType detail) {		
		return super.postDetailPage(action, detail);
	}

	@Override
	@ModelAttribute(value=PARAM_NAME_ENTITY_NAME)
	public String getEntityName() {
		return super.getEntityName();
	}	
	
	@Override
	@RequestMapping(value=URI_PATH_LIST, method=RequestMethod.GET)
	public String getListPage(Model model) {		
		return super.getListPage(model);
	}

	@Override
	@RequestMapping(value=URI_PATH_TABLE, method=RequestMethod.POST)
	public String postTablePage(
			@ModelAttribute(PARAM_NAME_QUERY_INPUT)
			QueryFormType queryInput,
			@ModelAttribute(PARAM_NAME_PAGE_CTRL)
			PageCtrlImpl pageCtrl,
			Model model) {
		return super.postTablePage(queryInput, pageCtrl, model);
	}

	@Override
	@RequestMapping(value=URI_PATH_LIST, method=RequestMethod.POST)
	public String postListPage(
			@ModelAttribute(PARAM_NAME_QUERY_INPUT)
			QueryFormType queryForm, Model model) {
		return super.postListPage(queryForm, model);
	}

	@Override
	@RequestMapping(value=URI_PATH_EXPORT, method=RequestMethod.POST)
	public void exportFile(
			@ModelAttribute(PARAM_NAME_QUERY_INPUT)
			QueryFormType queryForm, HttpServletRequest request, HttpServletResponse response) {
		if(getExportController()!=null){
			super.exportFile(queryForm, request, response);
		}
	}
	
	@Override
	@ModelAttribute(value=PARAM_NAME_CURRENT_USER)
	public UserProfile getUser(){
		return super.getUser();
	}
}
