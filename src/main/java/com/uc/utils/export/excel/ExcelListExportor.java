package com.uc.utils.export.excel;

import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public abstract class ExcelListExportor<ExportObj> extends ExcelExportor97Base {	
	private List<? extends ExportObj> data;
	private int startRow;
	private int startCol;
	private ExcelSheetHeader header;
	
	public List<? extends ExportObj> getData() {
		return data;
	}

	public void setData(List<? extends ExportObj> data) {
		this.data = data;
	}

	public ExcelSheetHeader getHeader() {
		return header;
	}
	
	public void setHeader(ExcelSheetHeader header) {
		this.header = header;
	}
	
	public ExcelListExportor(ExcelSheetHeader header, List<? extends ExportObj> data, IExcelExportOptions excelExportOptions){
		setData(data);
		setHeader(header);
		setExportOptions(excelExportOptions);
	}
	
	
	protected Sheet createSheet(String name){
		return getWorkbook().createSheet(name);
	}
	
	
	@Override
	protected void exportSheets() {
		Sheet sheet=createSheet(getHeader().getTitle());
		setCurrentSheet(sheet);		
		export(getCurrentSheet(), startRow, startCol);
	};
	
	protected int export(Sheet sheet, int startRow, int startCol){
		for(int i=0; i < getColumnCount(); i++){
			sheet.autoSizeColumn(i, true);
		}		
		int current=onExportHeader(sheet, startRow, startCol);
		current = onExportList(sheet, current, startCol);
		current = onExportFooter(sheet, current, startCol);
		return current;
	}
	
	protected int onExportHeader(Sheet sheet, int startRow, int startCol){
		return getHeader().export(sheet, startRow, startCol);
	}
	
	protected int onExportFooter(Sheet sheet, int startRow, int startCol){
		return 0;
	}
		
	protected int onExportList(Sheet sheet, int startRow, int startCol){
		int currentRow = startRow;
		for(ExportObj  item : getData()){			
			currentRow=onExportRow(sheet, currentRow, startCol, item);			
		}
		return currentRow;
	}
	
	protected int onExportRow(Sheet sheet, int startRow, int startCol, ExportObj rowData){
		Row row=sheet.createRow(startRow);
		for(int i=0; i< getColumnCount(); i++){
			Cell cell=row.createCell(startCol + i, CellType.STRING);		
			onSetDataCellStyle(cell, i, rowData);
			onExportCell(cell, i, rowData);
		}
		return startRow + 1;
	}
	
	protected void onSetDataCellStyle(Cell cell, int i, ExportObj item){
		
	}
	
	protected abstract String onGetColumnValue(int column, ExportObj item);
	
	protected void onExportCell(Cell cell, int column, ExportObj data){
		
		String value=onGetColumnValue(column, data);
		int width=0;
		if(value!=null){
			width=ExcelHelper.getCellWidth(value);
		}
		if(width > cell.getSheet().getColumnWidth(cell.getColumnIndex())){
			cell.getSheet().setColumnWidth(cell.getColumnIndex(), width);
		}
		cell.setCellValue(value);
	}
	
	protected abstract int getColumnCount();
}
