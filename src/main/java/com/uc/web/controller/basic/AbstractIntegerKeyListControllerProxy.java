package com.uc.web.controller.basic;

import com.uc.web.controller.AbstractListControllerProxy;
import com.uc.web.forms.QueryForm;

public abstract class AbstractIntegerKeyListControllerProxy<QueryFormType extends QueryForm<Long>, DetailType>
	extends AbstractListControllerProxy<Long, QueryFormType, DetailType>
	implements IntegerKeyListControllerProxy<QueryFormType, DetailType>{

}
