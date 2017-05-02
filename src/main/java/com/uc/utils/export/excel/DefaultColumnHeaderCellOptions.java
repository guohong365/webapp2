package com.uc.utils.export.excel;

import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;

import com.uc.utils.export.Exportor;

public class DefaultColumnHeaderCellOptions extends ExcelCellOptions{
	public DefaultColumnHeaderCellOptions() {
		super("宋体",(short)12,Exportor.BOLD,IndexedColors.AUTOMATIC, IndexedColors.AUTOMATIC, HorizontalAlignment.CENTER, VerticalAlignment.CENTER);
	}

}
