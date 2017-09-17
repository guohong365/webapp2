package com.uc.web.controller;

import org.springframework.ui.Model;

public interface ManagedColumnListController {
	public static final String PARAM_NAME_MODE = "module";
	public static final String PARAM_NAME_COLUMNS = "columns";
	public static final String URI_PATH_COLUMN_SELECT="/columns";
	

	String getShowColumns(String moduleName, Model model);
	String postSetShowColumns(String moduleName, String columns);
}
