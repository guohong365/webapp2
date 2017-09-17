package com.uc.utils.export.excel;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;

public class DefaultCellOptions extends CellOptionsImpl {

	public DefaultCellOptions(String name, String fontName, short heiht) {
		this(name, fontName, heiht, false);
	}
	public DefaultCellOptions(String name, String fontName, short heiht, boolean bold) {
		this(name, fontName, heiht, bold, HorizontalAlignment.GENERAL);
	}
	public DefaultCellOptions(String name, String fontName, short heiht, boolean bold, HorizontalAlignment horizAlign) {
		this(name,fontName, heiht, bold, horizAlign, VerticalAlignment.CENTER);
	}
	public DefaultCellOptions(String name, String fontName, short heiht, boolean bold, HorizontalAlignment horizAlign, VerticalAlignment vertAlign) {
		setName(name);
		setFontName(fontName);		
		setFontHeightInPoints((short)12);
		setBold(bold);
		setAlignment(horizAlign);
		setVerticalAlignment(vertAlign);
		setDataFormat((short) CellType.STRING.hashCode());
	}
}
