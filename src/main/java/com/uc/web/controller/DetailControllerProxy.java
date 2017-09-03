package com.uc.web.controller;

public interface DetailControllerProxy<KeyType,EntityType>	
	extends DetailController<KeyType,EntityType>,ControllerProxy {
	@Override
	DetailController<KeyType, EntityType> getController();	
}
