package com.uc.web.controller.impl;

import org.springframework.ui.Model;
import com.uc.web.controller.ControllerBaseImpl;
import com.uc.web.controller.DashboardController;
import com.uc.web.controller.utils.DashboardManager;
import com.uc.web.forms.ui.componet.DashboardItem;

public class DashboardControllerImpl extends ControllerBaseImpl implements DashboardController {
	private DashboardManager manager;
	public void setManager(DashboardManager manager) {
		this.manager = manager;
	}
	public DashboardManager getManager() {
		return manager;
	}
	
	@Override	
	public String getDashboardItem(	String name, Model model) {
		if(getLogger().isTraceEnabled()){
			getManager().dump(System.err);
		}
		DashboardItem item= getManager().find(name);
		if(item!=null){
			getLogger().trace("dashboard item found.");
			return item.doGet(model);
		}
		else{
			getLogger().error("dashboard item not found.");
			return getPage404();
		}		
	}

	@Override
	public String postDashboardItem(String name, String jsonParam, Model model) {
		DashboardItem item=getManager().find(name);
		return item.doPost(jsonParam, model);
	}
}
