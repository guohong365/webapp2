package com.uc.web.controller;

import com.uc.web.forms.QueryForm;

public interface GenericControllerProxy<KeyType, QueryFormType extends QueryForm<KeyType>,	EntityType>
	extends GeneralController<KeyType, QueryFormType,EntityType>, ControllerProxy{
}
