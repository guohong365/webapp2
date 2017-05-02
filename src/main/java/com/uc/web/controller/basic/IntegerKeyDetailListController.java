package com.uc.web.controller.basic;

import com.uc.web.controller.DetailListController;
import com.uc.web.forms.DetailListQueryForm;

public interface IntegerKeyDetailListController<DetailType,QueryFormType extends DetailListQueryForm<Long>, DetailListType>
	extends DetailListController<Long,DetailType, QueryFormType, DetailListType>{

}
