package com.uc.utils.export.excel;

import java.util.List;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;

import com.uc.utils.export.excel.DefaultExcelExportOptions;
import com.uc.utils.export.excel.ExcelHelper;
import com.uc.utils.export.excel.ExcelListExportor;
import com.uc.utils.export.excel.ExcelSheetHeader;
import com.uc.utils.export.excel.IExcelExportOptions;


public abstract class TableExportorBase<DataType extends Object> extends ExcelListExportor<DataType> {
	
	static IExcelExportOptions defaultExportOptions=new DefaultExcelExportOptions();
	
	public TableExportorBase(ExcelSheetHeader header, List<DataType> data, IExcelExportOptions options){
		super(header, data, options);
	}
	
	@Override
	protected Workbook createWorkbook() {
	  Workbook workbook= super.createWorkbook();
	  createStyle(workbook);
	  return workbook;
	}

	public static Object lockObj = new Object();
	
	private Font dataFont;
	private CellStyle dataStyle;
	
	protected void createStyle(Workbook workbook) {
		dataStyle =workbook.createCellStyle();
		ExcelHelper.setBorder(dataStyle, BorderStyle.THIN);
		dataStyle.setAlignment(HorizontalAlignment.LEFT);
		dataStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		dataFont=createFont(workbook, "宋体", (short) 12, (short) 0);
		dataStyle.setFont(dataFont);
	}
	
	protected Font createFont(Workbook workbook,String fontName, short size, short style){
		Font font=ExcelHelper.createFont(workbook, fontName, size, style);
		return font;		
	}
	
	@Override
	protected void onSetDataCellStyle(Cell cell, int i, DataType item) {
		cell.setCellStyle(dataStyle);
	}
	
	@Override
	public IExcelExportOptions getExportOptions() {
		if(super.getExportOptions()!=null){
			return super.getExportOptions();
		}
		return defaultExportOptions;
	}

}
