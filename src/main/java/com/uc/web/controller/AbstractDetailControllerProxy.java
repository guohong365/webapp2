package com.uc.web.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

public abstract class AbstractDetailControllerProxy<KeyType,DetailType>
	extends ControllerProxySupportImpl<KeyType>
	implements DetailControllerProxy<KeyType, DetailType> {
	
	private DetailController<KeyType, DetailType> detailController;
	
	@Override
	public void setDetailController(
			DetailController<KeyType, DetailType> detailController) {
		this.detailController = detailController;
	}
	@Override
	public DetailController<KeyType, DetailType> getDetailController() {
		return detailController;
	}

	@Override
	@RequestMapping(value=URI_PATH_DETAIL, method=RequestMethod.GET)
	public String getDetailPage(
			@RequestParam(value=PARAM_NAME_ACTION, required=false, defaultValue=WebAction.NEW)
			String action,
			@RequestParam(value=PARAM_NAME_SELECTED_ID, required=false)
			KeyType recordId, 
			Model model) {
		return getDetailController().getDetailPage(action, recordId, model);
	}

	@Override
	@RequestMapping(value=URI_PATH_DETAIL, method=RequestMethod.POST, produces="text/html;charset=UTF-8;")
	@ResponseBody
	public String postDetailPage(
			@RequestParam(value=PARAM_NAME_ACTION, required=true)
			String action,
			@ModelAttribute(value=PARAM_NAME_DETAIL)
			DetailType detail) {
		return getDetailController().postDetailPage(action, detail);
	}

	@Override
	@ModelAttribute(value=PARAM_NAME_MODEL_TITLE)
	public String getModelTitle() {
		return getDetailController().getModelTitle();
	}

	@Override
	public String getPageBasePath() {
		return null;
	}

	@Override
	@ModelAttribute(value=PARAM_NAME_ENTITY_NAME)
	public String getEntityName() {
		return getDetailController().getEntityName();
	}

	@Override
	@ModelAttribute(value=PARAM_NAME_BASE_URL)
	public String getBaseUri(){
		return onGetBaseUri();
	}
	
	protected abstract String onGetBaseUri();

}
