package com.uc.web.controller.poxy;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.uc.web.controller.DashboardController;

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
			System.err.println("controller instance :" + getController().getClass() + " name [" + getController().getModuleName() + "]");
		}
		return getController().getDashboardItem(name, model);
	}

	@Override
	@RequestMapping(value="/{name}", method=RequestMethod.POST, produces="application/json;charset=utf-8;")
	@ResponseBody
	public String postDashboardItem( 
			@PathVariable(value="name")
			String name,
			@RequestBody
			String params, Model model) {
		getLogger().trace("pathVaialbe name :" + name);
		if(getLogger().isTraceEnabled()){
			System.err.println("param :" + params.toString() );
		}
		return getController().postDashboardItem(name, params, model);
	}
}
