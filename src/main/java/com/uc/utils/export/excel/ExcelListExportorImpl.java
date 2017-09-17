package com.uc.utils.export.excel;

import java.util.Collection;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.springframework.util.StringUtils;

import com.uc.utils.export.ValueFormatter;

public class ExcelListExportorImpl<EntityType> extends AbstractExcelExportor implements ExcelListExportor<EntityType> {
	
	private ExcelObjectCache cache=new ExcelObjectCache();
	
	private Collection<? extends EntityType> data;
	private int startRow;
	private int startCol;
	private ExcelSheetHeader header;
	private ValueFormatter<EntityType> formatter;
	private Boolean autoFitWidth;
	
	public void setFormatter(ValueFormatter<EntityType> formatter) {
		this.formatter = formatter;
	}
	
	@Override
	public ValueFormatter<EntityType> getFormatter() {
		return formatter;
	}
	
	@Override	
	public ExcelSheetHeader getHeader() {
		return header;
	}
	public void setHeader(ExcelSheetHeader header) {
		this.header = header;
	}
	
	@Override
	public Collection<? extends EntityType> getData() {
		return data;
	}
	
	public void setData(Collection<? extends EntityType> data) {
		this.data = data;
	}
	
	public ExcelListExportorImpl(
			ExcelSheetHeader header, 
			Collection<? extends EntityType> data){
		this(header, data, null);
	}
	
	public ExcelListExportorImpl(
			ExcelSheetHeader header, 
			Collection<? extends EntityType> data, 
			ExcelExportOptions excelExportOptions){
		setData(data);
		setHeader(header);
		setOptions(excelExportOptions);
	}
		
	protected Sheet createSheet(String name){
		return getWorkbook().createSheet(name);
	}
	
	@Override
	public CellStyle create(CellOptions options) {
		return getCellStyleFactory().create(getWorkbook(), options, null);
	}
	
	@Override
	protected void exportSheets() {
		Sheet sheet=createSheet(getHeader().getTitle());
		setSheet(sheet);		
		export(getSheet(), startRow, startCol);
	};
	
	protected int export(Sheet sheet, int startRow, int startCol){
		onExporting(sheet, startRow, startCol);
		int current=onExportHeader(sheet, startRow, startCol);
		current = onExportList(sheet, current, startCol);
		current = onExportFooter(sheet, current, startCol);
		onExported(sheet, current);
		return current;
	}
	protected void onExporting(Sheet sheet, int startRow, int startCol){
		
	}
	protected void onExported(Sheet sheet, int current){
	}
	
	protected int onExportHeader(Sheet sheet, int startRow, int startCol){
		return getHeader().export(sheet, startRow, startCol);
	}
	
	protected int onExportFooter(Sheet sheet, int startRow, int startCol){
		return 0;
	}
		
	protected int onExportList(Sheet sheet, int startRow, int startCol){
		int currentRow = startRow;
		for(EntityType  item : getData()){			
			currentRow=onExportRow(sheet, currentRow, startCol, item);			
		}
		return currentRow;
	}
	
	protected int onExportRow(Sheet sheet, int startRow, int startCol, EntityType rowData){
		Row row=sheet.createRow(startRow);
		int index=0;
		while(getFormatter().valid(index, rowData)){
			Cell cell=row.createCell(startCol + index, CellType.STRING);
			cell.setCellStyle(getDataCellStyle(cell, index, rowData));
			onExportCell(cell, getFormatter().get(index, rowData));
			index ++;
		}
		return startRow + 1;
	}
	
	public boolean isCached(String name){
		Object object=cache.get(name);
		return object!=null;
	}
	public Font getFont(String name){
		return getFont(name, getOptions());
	}
	public Font getFont(String name, ExcelExportOptions options){
		Font font=cache.get(name);
		synchronized(this){
			if(font==null && options!=null){
				font = create((FontOptions)options.get(name));
				cache.put(name, font);				
			}
		}
		return font;
	}
	public CellStyle getCellStyle(String name){
		return getCellStyle(name, getOptions());
	}
	
	public CellStyle getCellStyle(String name, ExcelExportOptions options){
		CellStyle style=cache.get(name);
		synchronized (this){
		  if(style==null && options!=null){
			style=create(options.get(name));
			cache.put(name, style);
			Font font= create((FontOptions)options.get(name));
			cache.put(DATA_FONT, font);
			style.setFont(font);			
		  }
		}
		return style;
	}
	
	public void cache(String name, Object object){
		cache.put(name, object);
	}
	
	protected CellStyle getDataCellStyle(Cell cell, int i, EntityType item){		
		return getCellStyle(DATA_STYLE);
	}
	
	protected void onExportCell(Cell cell, String value){		
		int width=0;
		if(value!=null){
			width=calculateCellWidth(value);
		}
		if(width > cell.getSheet().getColumnWidth(cell.getColumnIndex())){
			cell.getSheet().setColumnWidth(cell.getColumnIndex(), width);
		}
		cell.setCellValue(value);
	}
	protected int calculateCellWidth(String value) {
		return StringUtils.isEmpty(value) ? 0 : (value.length() * 256 + 256);
	}

	//TODO: not supported this setting yet
	public Boolean getAutoFitWidth() {
		return autoFitWidth;
	}

	public void setAutoFitWidth(Boolean autoFitWidth) {
		this.autoFitWidth = autoFitWidth;
	}
}
