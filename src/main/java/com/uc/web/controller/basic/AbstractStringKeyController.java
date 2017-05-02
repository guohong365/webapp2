package com.uc.web.controller.basic;

import com.uc.web.controller.AbstractController;
import com.uc.web.forms.QueryForm;

public abstract class AbstractStringKeyController<QueryFormType extends QueryForm<String>, DetailType> 
	extends AbstractController<String, QueryFormType, DetailType>
	implements StringKeyGeneralController<QueryFormType, DetailType>{

}
