package com.uc.web.service.basic;

import com.uc.web.forms.QueryForm;
import com.uc.web.service.AbstractAppListService;

public class GenericStringKeyAppListService<QueryFormType extends QueryForm<String>, DetailType>
	extends AbstractAppListService<String, QueryFormType, DetailType>
	implements StringKeyAppListService<QueryFormType, DetailType>{
}
