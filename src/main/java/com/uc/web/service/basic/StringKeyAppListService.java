package com.uc.web.service.basic;

import com.uc.web.forms.QueryForm;
import com.uc.web.service.AppListService;

public interface StringKeyAppListService<QueryFormType extends QueryForm<String>, DetailType> 
	extends AppListService<String, QueryFormType, DetailType>{

}
