package com.uc.web.forms.ui.componet;

import org.springframework.ui.Model;

import com.uc.web.controller.ControllerBase;

public interface DashboardItem extends ControllerBase {
	String doGet(Model model);
	String doPost(String jsonParam, Model model);
		
}
