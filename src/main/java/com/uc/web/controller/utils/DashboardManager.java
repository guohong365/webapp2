package com.uc.web.controller.utils;

import java.io.PrintStream;

import com.uc.web.forms.ui.componet.DashboardItem;

public interface DashboardManager {	
	DashboardItem find(String name);
	void dump(PrintStream err);
}
