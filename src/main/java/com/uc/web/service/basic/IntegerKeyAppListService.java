package com.uc.web.service.basic;

import com.uc.web.forms.QueryForm;
import com.uc.web.service.AppListService;

public interface IntegerKeyAppListService<QueryFormType extends QueryForm<Long>, DetailType> 
extends AppListService<Long, QueryFormType, DetailType> {

}
