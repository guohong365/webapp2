package com.uc.web.controller.basic;

import com.uc.web.controller.AbstractListController;
import com.uc.web.forms.QueryForm;

public abstract class AbstractIntegerKeyListController<QueryFormType extends QueryForm<Long>, DetailType> 
	extends AbstractListController<Long, QueryFormType, DetailType>
	implements IntegerKeyListController<QueryFormType, DetailType>{
}
