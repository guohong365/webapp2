package com.uc.web.service.basic;

import com.uc.web.forms.QueryForm;
import com.uc.web.service.AbstractAppService;

public class GenericStringKeyAppService<
	QueryFormType extends QueryForm<String>, DetailType> 
	extends AbstractAppService<String, QueryFormType, DetailType> 
	implements StringKeyAppService<QueryFormType, DetailType> {
	
}
