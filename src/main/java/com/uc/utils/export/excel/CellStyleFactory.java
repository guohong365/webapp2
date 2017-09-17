package com.uc.utils.export.excel;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Workbook;

public interface CellStyleFactory {
	CellStyle create(Workbook workbook, CellOptions options, FontFactory fontFactory);
}
