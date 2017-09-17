package com.uc.utils.export.excel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;

public class Excel97WorkbookFacotry implements WorkbookFacotry {
	@Override
	public Workbook create() {
		return new HSSFWorkbook();
	}
}
