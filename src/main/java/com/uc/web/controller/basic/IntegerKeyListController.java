package com.uc.web.controller.basic;

import com.uc.web.controller.ListController;
import com.uc.web.forms.QueryForm;

public interface IntegerKeyListController<QueryFormType extends QueryForm<Long>, DetailType> extends 
	ListController<Long,QueryFormType, DetailType> {
}
