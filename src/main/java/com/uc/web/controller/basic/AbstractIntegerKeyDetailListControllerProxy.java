package com.uc.web.controller.basic;

import com.uc.web.controller.AbstractDetailListControllerProxy;
import com.uc.web.forms.DetailListQueryForm;

public abstract class AbstractIntegerKeyDetailListControllerProxy<DetailType,QueryFormType extends DetailListQueryForm<Long>, DetailListType> 
	extends AbstractDetailListControllerProxy<Long, DetailType, QueryFormType, DetailListType> {

}
