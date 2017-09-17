package com.uc.utils.export.excel;

public class ExcelFlatHeader extends ExcelSheetHeaderImpl {
		
	public ExcelFlatHeader() {		
	}
	public ExcelFlatHeader(String title, String[] flatColumns) {
		setTitle(title);
		for(String column : flatColumns){
			addSubColumn(new ExcelColumnImpl(column));
		}
	}
	public void setColumns(String[] flatColumns){
		for(String column : flatColumns){
			addSubColumn(new ExcelColumnImpl(column));
		}
	}	
}
