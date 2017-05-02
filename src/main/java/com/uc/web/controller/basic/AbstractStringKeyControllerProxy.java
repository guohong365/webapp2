package com.uc.web.controller.basic;

import com.uc.web.controller.AbstractControllerProxy;
import com.uc.web.forms.QueryForm;

public abstract class AbstractStringKeyControllerProxy<QueryFormType extends QueryForm<String>, DetailType> 
	extends AbstractControllerProxy<String, QueryFormType,DetailType>
	implements StringKeyControllerProxy<QueryFormType, DetailType>{

}
