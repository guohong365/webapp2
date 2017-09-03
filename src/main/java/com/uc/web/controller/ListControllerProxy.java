package com.uc.web.controller;

import com.uc.web.forms.ListQueryForm;

public interface ListControllerProxy<QueryFormType extends ListQueryForm>
	extends ListController<QueryFormType>, ControllerProxy{	
	@Override
	ListController<QueryFormType> getController();
	ExportController<QueryFormType> getExportController();
}
