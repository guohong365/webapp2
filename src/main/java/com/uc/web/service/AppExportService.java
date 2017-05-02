package com.uc.web.service;

import java.util.List;

public interface AppExportService<QueryFormType, DetailType> extends Service {
	List<DetailType> selectForExport(QueryFormType queryForm);
}
