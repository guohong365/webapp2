package com.uc.utils.export.excel;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Workbook;

import com.uc.utils.export.Exportor;

public interface ExcelExportor extends Exportor  {
	void setOptions(ExcelExportOptions options);
	ExcelExportOptions getOptions();
	CellStyle create(CellOptions options);
	Font create(FontOptions options);
	Workbook getWorkbook();
}
