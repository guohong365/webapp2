package com.uc.web.controller.impl;

import java.io.File;

import org.springframework.ui.Model;

import com.uc.web.controller.ControllerBaseImpl;
import com.uc.web.controller.GenericController;

public class GenericControllerImpl extends ControllerBaseImpl implements GenericController {
	
	private String page;
	
	public void setPage(String page) {
		this.page = page;
	}
	public String getPage() {
		return page;
	}
	
	@Override
	public String GetPage(Model model) {
		return getPageBasePath() + File.pathSeparator + getPage();
	}

	public String PostPage(String jsonParams, Model model) {
		return "";
	}

}
