package com.uc.utils.export.excel;

import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;

public class ExcelCellOptions implements IExcelCellOptions, IExcelCellOptionsEditor {
	private String fontName;
	private  short fontSize;
	private  short fontStyle;
	private  IndexedColors bkColor;
	private  IndexedColors color;
	private  HorizontalAlignment hAlignment;
	private  VerticalAlignment vAlignment;
	
	public ExcelCellOptions(String fontName, short fontSize, short fontStyle, IndexedColors color, IndexedColors bkColor,HorizontalAlignment hAlignment,VerticalAlignment vAlignment){
		setFontName(fontName);
		setFontSize(fontSize);
		setFontStyle(fontStyle);
		setColor(color);
		setBkColor(bkColor);
		setHAlignment(hAlignment);
		setVAlignment(vAlignment);		
	}
	
	public ExcelCellOptions(String fontName, short fontSize, short fontStyle, IndexedColors color, IndexedColors bkColor,HorizontalAlignment hAlignment){
		this(fontName, fontSize, fontStyle, color, bkColor, hAlignment, VerticalAlignment.CENTER);
	}
	
	public ExcelCellOptions(String fontName, short fontSize, short fontStyle, IndexedColors color, IndexedColors bkColor){
		this(fontName, fontSize, fontStyle, color, bkColor, HorizontalAlignment.GENERAL);
	}
	
	public ExcelCellOptions(String fontName, short fontSize, short fontStyle){
		this(fontName, fontSize, fontStyle, IndexedColors.AUTOMATIC, IndexedColors.AUTOMATIC);
	}	
	
	public ExcelCellOptions(String fontName, short fontSize){
		this(fontName, fontSize, (short) 0);
	}
	
	public String getFontName() {
		return fontName;
	}
	public void setFontName(String fontName) {
		this.fontName = fontName;
	}
	public short getFontSize() {
		return fontSize;
	}
	public void setFontSize(short fontSize) {
		this.fontSize = fontSize;
	}
	public short getFontStyle() {
		return fontStyle;
	}
	public void setFontStyle(short fontStyle) {
		this.fontStyle = fontStyle;
	}
	public IndexedColors getBkColor() {
		return bkColor;
	}
	public void setBkColor(IndexedColors bkColor) {
		this.bkColor = bkColor;
	}
	public IndexedColors getColor() {
		return color;
	}
	public void setColor(IndexedColors color) {
		this.color = color;
	}
	public HorizontalAlignment getHAlignment() {
		return hAlignment;
	}
	public void setHAlignment(HorizontalAlignment hAlignment) {
		this.hAlignment = hAlignment;
	}
	public VerticalAlignment getVAlignment() {
		return vAlignment;
	}
	public void setVAlignment(VerticalAlignment vAlignment) {
		this.vAlignment = vAlignment;
	}
}
