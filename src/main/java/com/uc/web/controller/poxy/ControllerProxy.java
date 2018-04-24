package com.uc.web.controller.poxy;

import com.uc.web.controller.ControllerBase;

public interface ControllerProxy {	
	String getBaseUri();
	ControllerBase getController();
}
