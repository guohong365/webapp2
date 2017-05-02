package com.uc.web.controller.basic;

import com.uc.web.controller.AbstractControllerProxy;
import com.uc.web.forms.QueryForm;

public abstract class AbstractIntegerKeyControllerProxy<QueryFormType extends QueryForm<Long>, DetailType> 
	extends AbstractControllerProxy<Long, QueryFormType, DetailType>
	implements IntegerKeyControllerProxy<QueryFormType, DetailType>
	{

}
