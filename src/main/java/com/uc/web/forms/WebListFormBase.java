package com.uc.web.forms;

import java.util.List;

public class WebListFormBase<
	KeyType,
	QueryFormType extends QueryForm<KeyType>, 
	DataType extends Object> 
	extends WebFormBase<QueryFormType, List<? extends DataType>> {	
}
