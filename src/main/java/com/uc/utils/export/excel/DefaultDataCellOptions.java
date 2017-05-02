package com.uc.utils.export.excel;

import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;

public class DefaultDataCellOptions extends ExcelCellOptions {
	public DefaultDataCellOptions() {
		super("宋体", (short)12, (short)0, IndexedColors.AUTOMATIC, IndexedColors.AUTOMATIC, HorizontalAlignment.GENERAL, VerticalAlignment.CENTER);
	}
}
