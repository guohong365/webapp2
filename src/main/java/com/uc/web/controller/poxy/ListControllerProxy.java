package com.uc.web.controller.poxy;

import com.uc.web.controller.ListController;
import com.uc.web.forms.ListQueryForm;

public interface ListControllerProxy<QueryFormType extends ListQueryForm>
	extends ListController<QueryFormType>, ControllerProxy{	
}
