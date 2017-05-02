package com.uc.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uc.utils.export.ExportType;
import com.uc.web.forms.QueryForm;
import com.uc.web.forms.ui.componet.PageCtrl;

public abstract class AbstractControllerProxy<KeyType, QueryFormType extends QueryForm<KeyType>,DetailType> 
	extends ControllerProxySupportImpl<KeyType>
	implements  
		GenericControllerProxy<KeyType, QueryFormType,DetailType>{
	
	private GeneralController<KeyType, QueryFormType,DetailType> controller;
	
	@Override
	public GeneralController<KeyType, QueryFormType,DetailType> getController(){
		return controller;
	}
	@Override
	public void setContorller(GeneralController<KeyType, QueryFormType,DetailType> controller){
		this.controller=controller;
	}
	
	@Override
	@ModelAttribute(value=PARAM_NAME_MODEL_TITLE)
	public String getModelTitle() {
		return getController().getModelTitle();
	}
	
	@ModelAttribute(value=PARAM_NAME_ENTITY_NAME)
	@Override
	public String getEntityName(){
		return getController().getEntityName();
	}
	
	@Override
	@ModelAttribute(value=PARAM_NAME_BASE_URL)
	public String getBaseUri(){
		return onGetBaseUrl();
	}

	protected abstract String onGetBaseUrl();

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
			@ModelAttribute(value=PARAM_NAME_PAGE_CTRL)
			PageCtrl pageCtrl, 
			Model model) {
		return getController().postTablePage(queryInput, pageCtrl, model);
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
			HttpServletResponse response,
			@RequestParam(value=PARAM_NAME_EXPORT_TYPE, required=false, defaultValue=ExportType.TYPE_EXCEL)
			String type) {
		getController().exportFile(queryForm, request, response, type);
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
			DetailType detail) {
		return getController().postDetailPage(action, detail);
	}
	

	@Override
	public String getPageBasePath() {
		return getController().getPageBasePath();
	}
	@Override
	public QueryFormType createQueryForm() {
		return getController().createQueryForm();
	}

}
