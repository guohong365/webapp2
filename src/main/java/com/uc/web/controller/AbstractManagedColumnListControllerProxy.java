package com.uc.web.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uc.web.controller.AbstractListControllerProxy;
import com.uc.web.forms.ListQueryForm;

public abstract class AbstractManagedColumnListControllerProxy<QueryFormType extends ListQueryForm>
	extends AbstractListControllerProxy<QueryFormType> implements ManagedColumnListController{
	
	public	ManagedColumnListController getColumnController(){
		if(getController() instanceof ManagedColumnListController)
			return  (ManagedColumnListController) getController();
		return null;
	}
	
	@RequestMapping(value=ManagedColumnListController.URI_PATH_COLUMN_SELECT, method=RequestMethod.GET)
	@Override
	public String getShowColumns(
			@RequestParam(value=ManagedColumnListController.PARAM_NAME_MODE)
			String mode, Model model) {
		return getColumnController().getShowColumns(mode, model);
	}

	@RequestMapping(value=ManagedColumnListController.URI_PATH_COLUMN_SELECT, method=RequestMethod.POST)
	@ResponseBody
	@Override
	public String postSetShowColumns(
			@RequestParam(value=ManagedColumnListController.PARAM_NAME_MODE)
			String mode,
			@RequestParam(value=ManagedColumnListController.PARAM_NAME_COLUMNS)
			String columns) {
		return getColumnController().postSetShowColumns(mode, columns);
	}	
}
