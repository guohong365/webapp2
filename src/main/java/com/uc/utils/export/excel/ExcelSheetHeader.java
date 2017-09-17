package com.uc.utils.export.excel;

import org.apache.poi.ss.usermodel.Sheet;

public interface ExcelSheetHeader extends ExcelColumn {

	ExcelExportOptions getOptions();
	int export(Sheet sheet, int beginRow, int startCol);

}
