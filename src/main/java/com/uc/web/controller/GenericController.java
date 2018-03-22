package com.uc.web.controller;

import org.springframework.ui.Model;

public interface GenericController extends ControllerBase {
	String GetPage(Model model);
	String PostPage(String jsonParams, Model model);	
}
