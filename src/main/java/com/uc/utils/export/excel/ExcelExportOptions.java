package com.uc.utils.export.excel;

import java.util.Collection;

import com.uc.utils.export.ExportOptions;

public interface ExcelExportOptions extends ExportOptions {	
	@SuppressWarnings("unchecked")
	@Override
	CellOptions get(String name);
	ExcelExportOptions add(CellOptions cellOptions);
	ExcelExportOptions addAll(Collection<CellOptions> allOptions);
}
