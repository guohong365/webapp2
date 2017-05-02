package com.uc.utils.export.excel;

import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;

import com.uc.utils.export.Exportor;

public class DefaultTitleCellOptions extends ExcelCellOptions {
	
	public DefaultTitleCellOptions() {
		super("黑体", (short)20, Exportor.BOLD, IndexedColors.AUTOMATIC, IndexedColors.AUTOMATIC, HorizontalAlignment.CENTER, VerticalAlignment.CENTER);
	}

}
