package com.uc.utils.export.excel;

public class DefaultExcelExportOptions extends ExcelExportOptions {
	public DefaultExcelExportOptions() {
		setTitleCellOptions(new DefaultTitleCellOptions());
		setAddtionalCellOptions(new DefaultDataCellOptions());
		setColumnHeaderCellOptions(new DefaultColumnHeaderCellOptions());
		setDataCellOptions(getAddtionalCellOptions());
	}
}
