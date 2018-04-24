package com.uc.web.controller.poxy;

import com.uc.web.controller.DetailListController;
import com.uc.web.forms.DetailListQueryForm;

public interface DetailListControllerProxy<KeyType,EntityType,DetailQueryFormType extends DetailListQueryForm> 
	extends
		DetailControllerProxy<KeyType, EntityType>,
		DetailListController<KeyType, EntityType, DetailQueryFormType>{
	@Override
	DetailListController<KeyType, EntityType, DetailQueryFormType> getController();
}
