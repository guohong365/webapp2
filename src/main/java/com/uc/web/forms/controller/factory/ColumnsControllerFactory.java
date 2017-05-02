package com.uc.web.forms.controller.factory;

import com.uc.web.forms.ColumnsController;

public interface ColumnsControllerFactory {
	String getName();
	ColumnsController createController();  
}
