package com.uc.web.controller.poxy;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uc.web.controller.DetailController;
import com.uc.web.controller.WebAction;

public abstract class AbstractDetailControllerProxy<KeyType,EntityType>
	extends ControllerProxyBaseImpl
	implements DetailControllerProxy<KeyType, EntityType> {
	
	@SuppressWarnings("unchecked")
	@Override
	public DetailController<KeyType, EntityType> getController() {
		if(super.getController() instanceof DetailController)
			return (DetailController<KeyType, EntityType>) super.getController();
		return null;
	}

	@Override
	@RequestMapping(value=URI_PATH_DETAIL, method=RequestMethod.GET)
	public String getDetailPage(
			@RequestParam(value=PARAM_NAME_ACTION, required=false, defaultValue=WebAction.NEW)
			String action,
			@RequestParam(value=PARAM_NAME_SELECTED_ID, required=false)
			KeyType recordId, 
			Model model) {
		return getController().getDetailPage(action, recordId, model);
	}

	@Override
	@RequestMapping(value=URI_PATH_DETAIL, method=RequestMethod.POST, produces="text/plain;charset=UTF-8;")
	@ResponseBody
	public String postDetailPage(
			@RequestParam(value=PARAM_NAME_ACTION, required=true)
			String action,
			@ModelAttribute(value=PARAM_NAME_DETAIL)
			EntityType detail) {		
		return getController().postDetailPage(action, detail);
	}

	@Override
	@ModelAttribute(value=PARAM_NAME_ENTITY_NAME)
	public String getEntityName() {
		return getController().getEntityName();
	}
}
