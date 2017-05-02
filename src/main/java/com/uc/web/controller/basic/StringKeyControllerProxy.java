package com.uc.web.controller.basic;

import com.uc.web.controller.GenericControllerProxy;
import com.uc.web.forms.QueryForm;

public interface StringKeyControllerProxy<QueryFormType extends QueryForm<String>, DetailType>
	extends GenericControllerProxy<String, QueryFormType, DetailType>{

}
