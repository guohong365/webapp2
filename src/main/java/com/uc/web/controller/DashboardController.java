package com.uc.web.controller;

import org.springframework.ui.Model;

public interface DashboardController extends ControllerBase {
	String getDashboardItem(String name, Model model);
	String postDashboardItem(String name, String jsonParam, Model model);
}
