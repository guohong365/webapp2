package com.uc.web.controller;

import com.uc.web.forms.QueryForm;

public interface GenericControllerProxy<KeyType, QueryFormType extends QueryForm<KeyType>,	DetailType>
	extends GeneralController<KeyType, QueryFormType,DetailType>, ControllerProxy{
	GeneralController<KeyType, QueryFormType, DetailType> getController();
	void setContorller(GeneralController<KeyType, QueryFormType, DetailType> controller);

}
