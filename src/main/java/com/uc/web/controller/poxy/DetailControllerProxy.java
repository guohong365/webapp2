package com.uc.web.controller.poxy;

import com.uc.web.controller.DetailController;

public interface DetailControllerProxy<KeyType,EntityType>	
	extends DetailController<KeyType,EntityType>,ControllerProxy {
}
