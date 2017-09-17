package com.uc.utils.export.excel;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;

public class CellOptionsImpl extends FontOptionsImpl implements CellOptions {
	private BorderStyle borderBottom;
	private BorderStyle borderLeft;
	private BorderStyle borderRIght;
	private BorderStyle borderTop;
	private Short colorBorderBottom;
	private Short colorBorderLeft;
	private Short colorBorderRight;
	private Short colorBorderTop;
	private Short dataFormat;
	private Short fillBackgoundColor;
	private Short fillForegroundColor;
	private FillPatternType fillPattern;
	private Boolean hidden;
	private HorizontalAlignment horizontalAlignment;
	private Short indention;
	private Boolean locked;
	private Short rotation;
	private Boolean shrinkToFit;
	private VerticalAlignment verticalAlignment;
	private Boolean wrapText;
	
	private String name;
	
	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public HorizontalAlignment getAlignment() {
		return horizontalAlignment;
	}
	@Override
	public BorderStyle getBorderBottom() {
		return borderBottom;
	}

	@Override
	public BorderStyle getBorderLeft() {
		return borderLeft;
	}
    @Override
	public BorderStyle getBorderRight() {
		return borderRIght;
	}
	@Override
	public BorderStyle getBorderTop() {
		return borderTop;
	}

	@Override
	public Short getBottomBorderColor() {
		return colorBorderBottom;
	}
	@Override
	public Short getDataFormat() {
		return dataFormat;
	}
	@Override
	public Short getFillBackgroundColor() {
		return fillBackgoundColor;
	}
	@Override
	public Short getFillForegroundColor() {
		return fillForegroundColor;
	}
	@Override
	public FillPatternType getFillPattern() {
		return fillPattern;
	}
	@Override
	public Boolean getHidden() {
		return hidden;
	}
	@Override
	public Short getIndention() {
		return indention;
	}
	@Override
	public Short getLeftBorderColor() {		
		return colorBorderLeft;
	}

	@Override
	public Boolean getLocked() {
		return locked;
	}

	@Override
	public Short getRightBorderColor() {
		return colorBorderRight;
	}
	@Override
	public Short getRotation() {
		return rotation;
	}
	@Override
	public Boolean getShrinkToFit() {
		return shrinkToFit;
	}

	@Override
	public Short getTopBorderColor() {
		return colorBorderTop;
	}
	@Override
	public VerticalAlignment getVerticalAlignment() {
		return verticalAlignment;
	}

	@Override
	public Boolean getWrapText() {
		return wrapText;
	}

	public void setAlignment(HorizontalAlignment align) {
	}
	public void setBorderBottom(BorderStyle border) {
		borderBottom=border;
	}

	public void setBorderLeft(BorderStyle border) {
		borderLeft=border;
	}

	public void setBorderRight(BorderStyle border) {
		borderRIght=border;
	}
	public void setBorderTop(BorderStyle border) {
		borderTop=border;
	}

	public void setBottomBorderColor(short color) {
		colorBorderBottom=color;
	}

	public void setDataFormat(short fmt) {
		dataFormat = fmt;
	}
	public void setFillBackgroundColor(short bg) {
		fillBackgoundColor=bg;
	}

	public void setFillForegroundColor(short bg) {
		fillForegroundColor=bg;
	}

	public void setFillPattern(FillPatternType fp) {
		fillPattern=fp;
	}

	public void setHidden(boolean hidden) {
		this.hidden=hidden;
	}
	
	public void setIndention(short indent) {
		indention=indent;
	}
	public void setLeftBorderColor(short color) {
		colorBorderLeft=color;
	}

	public void setLocked(boolean locked) {
		this.locked=locked;
	}

	public void setRightBorderColor(short color) {
		colorBorderRight=color;
	}
	public void setRotation(short rotation) {
		this.rotation=rotation;
	}

	public void setShrinkToFit(boolean shrinkToFit) {
		this.shrinkToFit=shrinkToFit;
	}
	
	public void setTopBorderColor(short color) {
		colorBorderTop=color;
	}
	public void setVerticalAlignment(VerticalAlignment align) {
		this.verticalAlignment=align;
	}

	public void setWrapText(boolean wrapped) {
		this.wrapText=wrapped;
	}
}
