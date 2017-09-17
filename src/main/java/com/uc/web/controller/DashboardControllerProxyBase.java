package com.uc.web.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public class DashboardControllerProxyBase extends ControllerProxyBaseImpl implements DashboardControllerProxy{
	
	@Override
	public DashboardController getController() {
		return (DashboardController) super.getController();
	}
	
	@Override	
	@RequestMapping(value="/{name}", method=RequestMethod.GET)	
	public String getDashboardItem(
			@PathVariable(value="name")
			String name, 
			Model model) {
		getLogger().trace("pathVaialbe name :" + name);
		if(getLogger().isTraceEnabled()){
			System.err.println("controller instance :" + getController().getClass());
		}
		return getController().getDashboardItem(name, model);
	}

	@Override
	@RequestMapping(value="/{name}", method=RequestMethod.POST)
	@ResponseBody
	public String postDashboardItem(
			@PathVariable(value="name")
			String name,
			@RequestBody
			String jsonParam, Model model) {
		getLogger().trace("pathVaialbe name :" + name);
		if(getLogger().isTraceEnabled()){
			System.err.println("param :" + jsonParam );
		}
		return getController().postDashboardItem(name, jsonParam, model);
	}
}
