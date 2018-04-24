package com.uc.web.controller.poxy;

import com.uc.web.controller.ExportController;
import com.uc.web.forms.ListQueryForm;

public interface ExportControllerProxy<QueryFormType extends ListQueryForm> 
	extends ExportController<QueryFormType>, ControllerProxy {
	
	ExportController<QueryFormType> getExportController();
}
