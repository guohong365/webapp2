package com.uc.web.controller.basic;

import com.uc.web.controller.AbstractDetailListController;
import com.uc.web.forms.DetailListQueryForm;

public class GenericIntegerKeyDetailListController<DetailType, QueryFormType extends DetailListQueryForm<Long>, DetailListType> 
	extends AbstractDetailListController<Long, DetailType, QueryFormType, DetailListType>
	implements IntegerKeyDetailListController<DetailType,QueryFormType, DetailListType>{
}
