package com.uc.utils.export.excel;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Workbook;

public class DefaultCellStyleFactory implements CellStyleFactory {
	
	public CellStyle create(Workbook workbook, CellOptions cellOptions){
		return create(workbook, cellOptions, null);
	}
	@Override
	public CellStyle create(Workbook workbook, CellOptions options, FontFactory factory) {
		CellStyle style=workbook.createCellStyle();
		if(options==null) return style;
		if(options.getAlignment()!=null) style.setAlignment(options.getAlignment());
		if(options.getBorderBottom()!=null) style.setBorderBottom(options.getBorderBottom());
		if(options.getBorderLeft()!=null) style.setBorderLeft(options.getBorderLeft());
		if(options.getBorderRight()!=null) style.setBorderRight(options.getBorderRight());
		if(options.getBorderTop()!=null) style.setBorderTop(options.getBorderTop());
		if(options.getBottomBorderColor()!=null) style.setBottomBorderColor(options.getBottomBorderColor());
		if(options.getDataFormat()!=null) style.setDataFormat(options.getDataFormat());
		if(options.getFillBackgroundColor()!=null) style.setFillBackgroundColor(options.getFillBackgroundColor());
		if(options.getFillForegroundColor()!=null) style.setFillForegroundColor(options.getFillForegroundColor());
		if(options.getFillPattern()!=null) style.setFillPattern(options.getFillPattern());
		if(factory!=null) style.setFont(factory.create(workbook, options));
		if(options.getHidden()!=null) style.setHidden(options.getHidden());
		if(options.getIndention()!=null) style.setIndention(options.getIndention());
		if(options.getLeftBorderColor()!=null) style.setLeftBorderColor(options.getLeftBorderColor());
		if(options.getLocked()!=null) style.setLocked(options.getLocked());
		if(options.getRightBorderColor()!=null) style.setRightBorderColor(options.getRightBorderColor());
		if(options.getRotation()!=null) style.setRotation(options.getRotation());
		if(options.getShrinkToFit()!=null) style.setShrinkToFit(options.getShrinkToFit());
		if(options.getTopBorderColor()!=null) style.setTopBorderColor(options.getTopBorderColor());
		if(options.getVerticalAlignment()!=null) style.setVerticalAlignment(options.getVerticalAlignment());
		if(options.getWrapText()!=null ) style.setWrapText(options.getWrapText());		
		return style;
	}

}
