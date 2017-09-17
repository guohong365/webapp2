package com.uc.web.forms.ui.componet;

import org.springframework.ui.Model;

import com.uc.web.controller.ControllerBaseImpl;

public abstract class DashboardItemBase extends ControllerBaseImpl implements DashboardItem {
	
	protected void doProcessGet(Model model){
	}
	protected void doProcessPost(String jsonString, Model model){
	}

	@Override
	public String doGet(Model model) {
		doProcessGet(model);
		return getPageBasePath();
	}
		

	@Override
	public String doPost(String jsonString, Model model) {
		doProcessPost(jsonString, model);
		return getPageBasePath();
	}

}
