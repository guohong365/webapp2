package com.uc.utils.export.excel;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;

import com.uc.utils.export.Exportor;

public class ExcelHelper {
	
	public static Font createFont(Workbook workbook, String fontName, short size, short style){
		Font font=workbook.createFont();
		font.setFontName(fontName);
		font.setFontHeightInPoints(size);
		if((style & Exportor.BOLD)==Exportor.BOLD){
			font.setBold(true);
			//font.setBoldweight((short) 400);			
		}
		if((style & Exportor.ITALIC)==Exportor.ITALIC){
			font.setItalic(true);
		}
		if((style & Exportor.STRIKEOUT)==Exportor.STRIKEOUT){
			font.setStrikeout(true);
		}
		if((style & Exportor.UNDERLINE)==Exportor.UNDERLINE){
			font.setUnderline((byte) 0xFF);
		}
		return font;
	}
	public static Font createFont(Sheet sheet, String fontName, short size, short style){
		Font font=createFont(sheet.getWorkbook(), fontName, size, style);
		return font;
	}
	public static Font createFont(Sheet sheet, String fontName, short size, short style, short color) {
		Font font=createFont(sheet, fontName, size, style);
		font.setColor(color);
		return font;
	}
	public static void setBorder(CellStyle style, BorderStyle border){
		setBorder(style, border, border, border, border);		
	}
	
	public static void setBorder(CellStyle style, BorderStyle left, BorderStyle top, BorderStyle right, BorderStyle bottom){
		style.setBorderLeft(left);
		style.setBorderRight(right);
		style.setBorderTop(top);
		style.setBorderBottom(bottom);
	}
	
	public static void setRegionBorder(Sheet sheet, CellRangeAddress region, int thin){
		RegionUtil.setBorderLeft(thin, region, sheet);
		RegionUtil.setBorderRight(thin, region, sheet);
		RegionUtil.setBorderTop(thin, region, sheet);
		RegionUtil.setBorderBottom(thin, region, sheet);
	}
	public static int getCellWidth(String value){
		return value.getBytes().length * 256 + 256;
	}
	public static void setRegionBorder(Sheet sheet, CellRangeAddress cellRangeAddress, BorderStyle thin) {
		
		setRegionBorder(sheet, cellRangeAddress, thin.getCode());
	}
	public static Font createFont(Sheet sheet, IExcelCellOptions cellOptions) {
		if(cellOptions==null){
			return sheet.getWorkbook().createFont();
		}
		Font font= createFont(sheet, cellOptions.getFontName(), cellOptions.getFontSize(),cellOptions.getFontStyle());
		font.setColor(cellOptions.getColor().getIndex());
		return font;
	}
}
