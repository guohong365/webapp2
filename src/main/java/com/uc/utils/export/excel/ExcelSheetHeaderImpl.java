package com.uc.utils.export.excel;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.uc.web.forms.ComplexColumn;

public class ExcelSheetHeaderImpl extends ExcelColumnImpl implements ExcelSheetHeader {
	static ExcelExportOptions defaultExportOptions=new DefaultExcelExportOptions();
	
	protected Logger logger; 
	
	private ExcelExportOptions options;
	
	private CellStyle titleStyle;
	private CellStyle columnHeaderStyle;	
	private ExcelExportor owner;
	@Override
	public void setOwner(ExcelExportor owner) {
		this.owner = owner;
	}
	@Override
	public ExcelExportor getOwner() {
		return owner;
	}
	
	public ExcelSheetHeaderImpl(){
		this(null);
	}
	public ExcelSheetHeaderImpl(String title){
		this(title, new ArrayList<>());
	}
	public ExcelSheetHeaderImpl(String title, Collection<ExcelColumn> columns){
		this(title, columns, defaultExportOptions);
	}
	
	public ExcelSheetHeaderImpl(String title, Collection<ExcelColumn> columns, ExcelExportOptions options){
		if(columns!=null && !columns.isEmpty()){
			getSubColumns().addAll(columns);
		}
		logger=LoggerFactory.getLogger(getClass());
		setOptions(options);
		setTitle(title);
	}

	public ExcelSheetHeaderImpl(String title, ExcelColumn[] columns) {
		this(title, columns == null ? null : Arrays.asList(columns));
	}

	@Override
	public ExcelExportOptions getOptions() {
		if(options==null)
			return defaultExportOptions;
		return options;
	}
	
	@Override
	public int getColSpan() {
		int col=0;
		if(getSubColumns()!=null && getSubColumns().size()>0){
			for(ComplexColumn column : getSubColumns()){
				col += column.getColSpan();
			}
		}
		return col > 1 ? col : 1;
	};
	
	protected void onPrepareExport(Sheet sheet){
		titleStyle=createStyle(sheet, ExcelListExportor.TITLE_STYLE);
		columnHeaderStyle=createStyle(sheet, ExcelListExportor.COLUMN_HEADER_STYLE);
		calcHeaderLayout();
	}
	@Override	
	public int export(Sheet sheet, int beginRow, int startCol){
		onPrepareExport(sheet);
		int currentRow=exportTitle(sheet, beginRow, startCol);
		currentRow=exportColumnHeader(sheet, currentRow, startCol);
		return currentRow;
	}
	
	protected CellStyle createStyle(Sheet sheet, String name){
		CellOptions options=getOptions().get(name);
		CellStyle cellStyle=getOwner().create(options);		
		return cellStyle;
	}
	
	protected int exportTitle(Sheet sheet, int beginRow, int startCol){
		Row row=sheet.createRow(beginRow);
		Cell cell=row.createCell(startCol);
		cell.setCellValue(getTitle());
		cell.setCellStyle(titleStyle);
		CellRangeAddress rangeAddress=new CellRangeAddress(beginRow, beginRow + getRowSpan() - 1 , 0, getColSpan() - 1);
		sheet.addMergedRegion(rangeAddress);
		//ExcelHelper.setRegionBorder(sheet, rangeAddress, CellStyle.BORDER_THIN);		
		return beginRow + getRowSpan();
	}
	
	protected int exportColumn(Sheet sheet, CellStyle cellStyle, int startRow, int startCol, ComplexColumn column){
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
			for(ComplexColumn subColumn: column.getSubColumns()){
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
		int nextRow= exportColumn(sheet, columnHeaderStyle, startRow, startCol, this);
		logger.info("row after header is [" + nextRow +"]");
		return nextRow;
	}
	
	protected void calcHeaderLayout(){
		getWidth();
	}

	public void setOptions(ExcelExportOptions options) {
		this.options = options;
	}
}
