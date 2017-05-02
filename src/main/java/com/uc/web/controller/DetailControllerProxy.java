package com.uc.web.controller;

public interface DetailControllerProxy<KeyType,DetailType>	
	extends DetailController<KeyType,DetailType>,ControllerProxy {
	
	DetailController<KeyType, DetailType> getDetailController();	
	void setDetailController(DetailController<KeyType,	DetailType> controller);

}
