package com.uc.web.forms.controller.factory;

import com.uc.web.forms.ColumnsManager;

public interface ColumnsManagerFactory {
	String getName();
	ColumnsManager create();  
}
