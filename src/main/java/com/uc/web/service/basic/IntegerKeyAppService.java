package com.uc.web.service.basic;

import com.uc.web.forms.QueryForm;
import com.uc.web.service.AppService;

public interface IntegerKeyAppService<QueryFormType extends QueryForm<Long>, DetailType> 
	extends AppService<Long, QueryFormType, DetailType> {

}
