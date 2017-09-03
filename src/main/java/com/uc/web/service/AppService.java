package com.uc.web.service;

import com.uc.web.forms.QueryForm;

public interface AppService<KeyType,QueryFormType extends QueryForm<KeyType>, DetailType extends Object> 
	extends AppDetailService<KeyType, DetailType>,
			AppWebListService<QueryFormType, DetailType>, 
			Service{
}
