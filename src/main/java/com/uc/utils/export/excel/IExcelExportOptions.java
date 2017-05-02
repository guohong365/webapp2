package com.uc.utils.export.excel;

public interface IExcelExportOptions {
	public IExcelCellOptions getTitleCellOptions();
	public IExcelCellOptions getAddtionalCellOptions();
	public IExcelCellOptions getColumnHeaderCellOptions();
	public IExcelCellOptions getDataCellOptions();
}
