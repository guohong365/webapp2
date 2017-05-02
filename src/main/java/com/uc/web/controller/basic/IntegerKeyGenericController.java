package com.uc.web.controller.basic;

import com.uc.web.controller.GeneralController;
import com.uc.web.forms.QueryForm;

public interface IntegerKeyGenericController<QueryFormType extends QueryForm<Long>, DetailType> 
	extends GeneralController<Long, QueryFormType, DetailType> {

}
