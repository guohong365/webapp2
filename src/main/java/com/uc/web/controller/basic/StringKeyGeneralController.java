package com.uc.web.controller.basic;

import com.uc.web.controller.GeneralController;
import com.uc.web.forms.QueryForm;

public interface StringKeyGeneralController<QueryFormType extends QueryForm<String>, DetailType> 
	extends GeneralController<String, QueryFormType, DetailType> {

}
