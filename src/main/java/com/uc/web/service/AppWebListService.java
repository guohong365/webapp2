package com.uc.web.service;

import java.util.List;

import com.uc.web.forms.ListQueryForm;
import com.uc.web.forms.ui.componet.PageCtrl;

public interface AppWebListService	extends AppListService,	AppExportService{
	List<?> select(ListQueryForm queryForm, PageCtrl pageCtrl);
}
