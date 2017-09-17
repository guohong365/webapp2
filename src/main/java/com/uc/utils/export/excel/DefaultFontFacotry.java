package com.uc.utils.export.excel;

import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Workbook;

public class DefaultFontFacotry implements FontFactory {
	@Override
	public Font create(Workbook workbook, FontOptions options) {
		Font font= workbook.createFont();
		if(options==null) return font;
		if(options.getBold()!=null) font.setBold(options.getBold());
		if(options.getColor()!=null) font.setColor(options.getColor());
		if(options.getItalic()!=null)font.setItalic(options.getItalic());
		if(options.getStrikeout()!=null) font.setStrikeout(options.getStrikeout());
		if(options.getFontHeightInPoints()!=null) font.setFontHeightInPoints(options.getFontHeightInPoints());
		if(options.getFontName()!=null) font.setFontName(options.getFontName());
		if(options.getTypeOffset()!=null) font.setTypeOffset(options.getTypeOffset());
		if(options.getUnderline()!=null) font.setUnderline(options.getUnderline());
		return font;
	}

}
