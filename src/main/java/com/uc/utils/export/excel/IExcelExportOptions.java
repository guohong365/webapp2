package com.uc.utils.export.excel;

import com.uc.utils.export.ExportOptions;

public interface IExcelExportOptions extends ExportOptions {
	public IExcelCellOptions getTitleCellOptions();
	public IExcelCellOptions getAddtionalCellOptions();
	public IExcelCellOptions getColumnHeaderCellOptions();
	public IExcelCellOptions getDataCellOptions();
}
