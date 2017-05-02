package com.uc.web.controller.basic;

import com.uc.web.controller.GenericControllerProxy;
import com.uc.web.forms.QueryForm;

public interface IntegerKeyControllerProxy<QueryFormType extends QueryForm<Long>, DetailType> 
	extends GenericControllerProxy<Long, QueryFormType, DetailType> {
}
