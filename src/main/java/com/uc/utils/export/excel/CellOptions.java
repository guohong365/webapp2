package com.uc.utils.export.excel;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;

public interface CellOptions extends FontOptions{
	String getName();
	
	HorizontalAlignment getAlignment();
	BorderStyle getBorderBottom();
	BorderStyle getBorderLeft();
	BorderStyle getBorderRight();
	BorderStyle getBorderTop();
	Short getBottomBorderColor();
	Short getDataFormat();
	Short getFillBackgroundColor();
	Short getFillForegroundColor();
	FillPatternType getFillPattern();
	Boolean getHidden();
	Short getIndention();
	Short getLeftBorderColor();
	Boolean getLocked();
	Short getRightBorderColor();
	Short getRotation();
	Boolean getShrinkToFit();
	Short getTopBorderColor();
	VerticalAlignment getVerticalAlignment();
	Boolean getWrapText();
}
