package com.uc.utils.export.excel;

public interface FontOptions {
	public static final short REGULER = 0;
	public static final short BOLD = 1;
	public static final short ITALIC = 2;
	public static final short STRIKEOUT = 4;
	
	Boolean getBold();
	Short getColor();
	Short getFontHeight();
	Short getFontHeightInPoints();
	String getFontName();
	Boolean getItalic();
	Boolean getStrikeout();
	Short getTypeOffset();
	Byte getUnderline();
}
