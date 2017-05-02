package com.uc.web.service.basic;

import com.uc.web.forms.QueryForm;
import com.uc.web.service.AbstractAppListService;

public class GenericIntegerKeyAppListService<QueryFormType extends QueryForm<Long>, DetailType> 
	extends AbstractAppListService<Long, QueryFormType, DetailType> 
	implements IntegerKeyAppListService<QueryFormType, DetailType>{

}
