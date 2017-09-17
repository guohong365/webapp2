package com.uc.web.service;

import java.util.List;

import com.uc.web.forms.ListQueryForm;

public interface AppExportService extends Service {
	List<?> selectForExport(ListQueryForm queryForm);
}
