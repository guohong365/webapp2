package com.uc.web.controller.basic;

import com.uc.web.controller.AbstractController;
import com.uc.web.forms.QueryForm;

public abstract class AbstractIntegerKeyController<QueryFormType extends QueryForm<Long>, DetailType> 
	extends AbstractController<Long,QueryFormType, DetailType>
    implements IntegerKeyGenericController<QueryFormType, DetailType>{
}
