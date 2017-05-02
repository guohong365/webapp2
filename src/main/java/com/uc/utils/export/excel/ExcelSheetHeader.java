package com.uc.utils.export.excel;


import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.uc.web.forms.Column;

public abstract class ExcelSheetHeader extends ExcelColumnImpl {
	
	IExcelExportOptions defaultExportOptions=new DefaultExcelExportOptions();
	
	protected Logger logger; 
	
	private IExcelExportOptions exportOptions;
	private CellStyle titleStyle;
	private CellStyle addtionalStyle;
	private CellStyle columnHeaderStyle;
	
	
	public ExcelSheetHeader(){
		this(null);
	}
	
	public ExcelSheetHeader(IExcelExportOptions options){
		logger=LoggerFactory.getLogger(getClass());
		setExportOptions(options);
	}
	
	public CellStyle getTitleStyle() {
		return titleStyle;
	}
	
	public void setTitleStyle(CellStyle titleStyle) {
		this.titleStyle = titleStyle;
	}
	
	public IExcelExportOptions getExportOptions() {
		if(exportOptions==null) return defaultExportOptions;
		return exportOptions;
	}
	
	public void setExportOptions(IExcelExportOptions exportOptions) {
		this.exportOptions = exportOptions;
	}
	
	public CellStyle getAddtionalStyle() {
		return addtionalStyle;
	}
	
	public void setAddtionalStyle(CellStyle addtionalStyle) {
		this.addtionalStyle = addtionalStyle;
	}
	
	public CellStyle getColumnHeaderStyle() {
		return columnHeaderStyle;
	}
	
	public void setColumnHeaderStyle(CellStyle columnHeaderStyle) {
		this.columnHeaderStyle = columnHeaderStyle;
	}
	
	@Override
	public int getColSpan() {
		int col=0;
		if(getSubColumns()!=null && getSubColumns().size()>0){
			for(Column column : getSubColumns()){
				col += column.getColSpan();
			}
		}
		return col > 1 ? col : 1;
	};
	
	protected void onPrepareExport(Sheet sheet){
		setTitleStyle(createTitleStyle(sheet));
		setAddtionalStyle(createAddtionalStyle(sheet));
		setColumnHeaderStyle(createColumnHeaderStyle(sheet));
		calcHeaderLayout();
	}
		
	public int export(Sheet sheet, int beginRow, int startCol){
		
		onPrepareExport(sheet);
		
		int currentRow=exportTitle(sheet, beginRow, startCol);
		logger.info("after title, row=" + currentRow);
		currentRow=exprotAddtional(sheet, currentRow, startCol);
		logger.info("after addtional, row=" + currentRow);
		currentRow=exportColumnHeader(sheet, currentRow, startCol);
		logger.info("after header, row=" + currentRow);
		return currentRow;
	}
	
	protected CellStyle createTitleStyle(Sheet sheet){
		IExcelCellOptions options=getExportOptions().getTitleCellOptions();
		CellStyle cellStyle=sheet.getWorkbook().createCellStyle();
		Font font=ExcelHelper.createFont(sheet, options);
		cellStyle.setFont(font);
		cellStyle.setAlignment(options==null ? HorizontalAlignment.CENTER : options.getHAlignment());
		cellStyle.setVerticalAlignment(options==null ? VerticalAlignment.CENTER : options.getVAlignment());
		cellStyle.setFillForegroundColor(options==null ? IndexedColors.AUTOMATIC.getIndex() : options.getBkColor().getIndex());
		cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		return cellStyle;
	}
	protected CellStyle createColumnHeaderStyle(Sheet sheet){
		CellStyle cellStyle=sheet.getWorkbook().createCellStyle();
		Font font= ExcelHelper.createFont(sheet, getExportOptions().getColumnHeaderCellOptions());
		cellStyle.setFont(font);
		ExcelHelper.setBorder(cellStyle, BorderStyle.THIN);
		cellStyle.setAlignment(HorizontalAlignment.CENTER);
		cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);		
		return cellStyle;
	}
	
	protected CellStyle createAddtionalStyle(Sheet sheet){
		return null;
	}
	
	protected int exportTitle(Sheet sheet, int beginRow, int startCol){
		CellStyle cellStyle=getTitleStyle();
		
		Row row=sheet.createRow(beginRow);
		Cell cell=row.createCell(startCol);
		cell.setCellValue(getTitle());
		cell.setCellStyle(cellStyle);
		CellRangeAddress rangeAddress=new CellRangeAddress(beginRow, beginRow + getRowSpan() - 1 , 0, getColSpan() - 1);
		sheet.addMergedRegion(rangeAddress);
		//ExcelHelper.setRegionBorder(sheet, rangeAddress, CellStyle.BORDER_THIN);		
		return beginRow + getRowSpan();
	}
	
	protected int exprotAddtional(Sheet sheet, int beginRow, int startCol){
		return beginRow;
	}
	
	protected int exportColumn(Sheet sheet, CellStyle cellStyle, int startRow, int startCol, Column column){
		int subRow=startRow;
		//logger.info(column.toString());
		if(column.getParent()!=null){
			
			Row row=sheet.getRow(startRow);
			if(row==null){
				row=sheet.createRow(startRow);
			}		
			Cell cell = row.createCell(startCol);
			cell.setCellStyle(cellStyle);
			cell.setCellValue(column.getTitle());
			
			if(column.getColSpan()==1){
				int width=((ExcelColumnImpl) column).getWidth();
				if(width > sheet.getColumnWidth(startCol)){
					sheet.setColumnWidth(startCol, width);				
				}
			}
			if(column.getColSpan() > 1 || column.getRowSpan() > 1){
				CellRangeAddress cellRangeAddress=new CellRangeAddress(startRow, startRow + column.getRowSpan() - 1, startCol, startCol + column.getColSpan() - 1);
				//logger.info("column :[" + column.getTitle() + "] at ["+ startRow + ","+ startCol +"], merge:["+ startRow +","+ (startRow + column.getRowSpan() - 1) +", "+ startCol+", "+ (startCol + column.getColSpan() -1) +"]");
				sheet.addMergedRegion(cellRangeAddress);
				ExcelHelper.setRegionBorder(sheet, cellRangeAddress, BorderStyle.THIN);				
			}
			subRow += column.getRowSpan();
		}		
		if(column.getSubColumns()!=null && column.getSubColumns().size()>0){
			int col=startCol;
			for(Column subColumn: column.getSubColumns()){
				int rows=exportColumn(sheet, cellStyle, startRow + column.getRowSpan(), col , subColumn);
				if(rows > subRow){
					subRow =rows;
				}
				col += subColumn.getColSpan();
			}
		}
		return subRow;
	}
	
	protected int exportColumnHeader(Sheet sheet,int startRow, int startCol){
		logger.info("export column header----------------------");
		CellStyle cellStyle=getColumnHeaderStyle();
		int nextRow= exportColumn(sheet, cellStyle, startRow, startCol, this);
		logger.info("row after header is [" + nextRow +"]");
		return nextRow;
	}
	
	protected void calcHeaderLayout(){
		getWidth();
	}
}
