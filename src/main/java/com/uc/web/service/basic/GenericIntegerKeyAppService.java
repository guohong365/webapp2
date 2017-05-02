package com.uc.web.service.basic;

import com.uc.web.forms.QueryForm;
import com.uc.web.service.AbstractAppService;

public class GenericIntegerKeyAppService<QueryFormType extends QueryForm<Long>,DetailType> 
	extends AbstractAppService<Long,QueryFormType, DetailType>
 	implements IntegerKeyAppService<QueryFormType, DetailType>{

}
