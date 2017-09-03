package com.uc.web.controller;

public interface ControllerProxy{	
	String getBaseUri();
	String getModuleName();
	ControllerBase getController();
}
