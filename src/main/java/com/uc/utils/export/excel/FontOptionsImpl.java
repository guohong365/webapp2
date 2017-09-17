package com.uc.utils.export.excel;

import org.apache.poi.ss.usermodel.Font;

public class FontOptionsImpl implements FontOptions, FontOptionsSetter {

	private Boolean bold;
	private Short color;
	private Short fontHeightInPoints;
	private String fontName;
	private Boolean italic;
	private Boolean strikeout;
	private Short typeOffset;
	private Byte underline;
	public FontOptionsImpl(){		
	}
	public FontOptionsImpl(String fontName,short fontHightInPoint){
		this.fontName=fontName;
		this.fontHeightInPoints=fontHightInPoint;
	}
	public FontOptionsImpl(String fontName,short fontHightInPoint, short color){
		this(fontName, fontHightInPoint);
		this.color=color;
	}
	public FontOptionsImpl(String fontName,short fontHightInPoint, short color, short style){
		this(fontName, fontHightInPoint, Font.COLOR_NORMAL);
		this.bold=(style & BOLD)!=0;
		this.italic =(style & ITALIC)!=0;
		this.strikeout=(style & STRIKEOUT)!=0;
	}
	public FontOptionsImpl(String fontName,short fontHightInPoint, short color, short style,byte underline){
		this(fontName, fontHightInPoint, color, style);
		this.underline= underline;
	}
	public FontOptionsImpl(String fontName,short fontHightInPoint, short color, short style,byte underline, short typeOffset){
		this(fontName, fontHightInPoint, color, style, underline);
		this.typeOffset=typeOffset;
	}
	
	@Override
	public Boolean getBold() {
		return bold;
	}
	@Override
	public void setBold(boolean bold) {
		this.bold = bold;
	}
	@Override
	public Short getColor() {
		return color;
	}
	@Override
	public void setColor(short color) {
		this.color = color;
	}
	@Override
	public Short getFontHeight() {
		return (short) (getFontHeightInPoints() * 20);
	}
	@Override
	public Short getFontHeightInPoints() {
		return fontHeightInPoints;
	}
	@Override
	public void setFontHeightInPoints(short fontHeightInPoints) {
		this.fontHeightInPoints = fontHeightInPoints;
	}
	@Override
	public String getFontName() {
		return fontName;
	}
	@Override
	public void setFontName(String fontName) {
		this.fontName = fontName;
	}
	@Override
	public Boolean getItalic() {
		return italic;
	}
	@Override
	public void setItalic(boolean italic) {
		this.italic = italic;
	}
	@Override
	public Boolean getStrikeout() {
		return strikeout;
	}
	@Override
	public void setStrikeout(boolean strikeout) {
		this.strikeout = strikeout;
	}
	@Override
	public Short getTypeOffset() {
		return typeOffset;
	}
	@Override
	public void setTypeOffset(short typeOffset) {
		this.typeOffset = typeOffset;
	}
	@Override
	public Byte getUnderline() {
		return underline;
	}
	@Override
	public void setUnderline(byte underline) {
		this.underline = underline;
	}	
}
