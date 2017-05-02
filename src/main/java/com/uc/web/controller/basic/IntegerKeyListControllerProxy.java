package com.uc.web.controller.basic;

import com.uc.web.controller.ListControllerProxy;
import com.uc.web.forms.QueryForm;

public interface IntegerKeyListControllerProxy<QueryFormType extends QueryForm<Long>, DetailType> 
	extends ListControllerProxy<Long,QueryFormType, DetailType>{

}
