package com.uc.utils.export.excel;

import org.apache.poi.ss.usermodel.HorizontalAlignment;

public class DefaultExcelExportOptions extends ExcelExportOptionsImpl{

	
	static final String DEFAULT_FONT_NAME ="宋体";
	static final String DEFAULT_TITLE_FONT_NAME="黑体";
	static final short DEFAULT_FONT_HEIGHT = 12;
	static final short DEFAULT_TITLE_HEIGHT=24;
	
	public DefaultExcelExportOptions(){
		this.add(new DefaultCellOptions(ExcelListExportor.TITLE_STYLE, DEFAULT_TITLE_FONT_NAME, DEFAULT_TITLE_HEIGHT, true, HorizontalAlignment.CENTER))
		.add(new DefaultCellOptions(ExcelListExportor.COLUMN_HEADER_STYLE, DEFAULT_FONT_NAME, DEFAULT_FONT_HEIGHT, true, HorizontalAlignment.CENTER))
		.add(new DefaultCellOptions(ExcelListExportor.ADDITIONAL_STYLE,DEFAULT_FONT_NAME, DEFAULT_FONT_HEIGHT))
		.add(new DefaultCellOptions(ExcelListExportor.DATA_STYLE,DEFAULT_FONT_NAME, DEFAULT_FONT_HEIGHT));
	}
	
	public CellOptions getTitleOptions() {
		return get(ExcelListExportor.TITLE_STYLE);
	}

	public CellOptions getAddtionalOptions() {
		return get(ExcelListExportor.DATA_STYLE);
	}
	
	public CellOptions getColumnHeaderOptions() {
		return get(ExcelListExportor.COLUMN_HEADER_STYLE);
	}
	
	public CellOptions getDataOptions() {
		return get(ExcelListExportor.ADDITIONAL_STYLE);
	}
}
