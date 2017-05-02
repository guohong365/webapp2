package com.uc.web.service.basic;

import com.uc.web.forms.QueryForm;
import com.uc.web.service.AppService;

public interface StringKeyAppService<QueryFormType extends QueryForm<String>,DetailType> 
	extends AppService<String, QueryFormType, DetailType> {

}
