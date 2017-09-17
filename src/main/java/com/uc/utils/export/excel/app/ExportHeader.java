package com.uc.utils.export.excel.app;

import org.apache.poi.ss.usermodel.Sheet;

import com.uc.utils.export.excel.ExcelFlatHeader;

public class ExportHeader<QueryFormType> extends ExcelFlatHeader {
	private QueryFormType queryForm;
	
	public void setQueryForm(QueryFormType queryForm) {
		this.queryForm = queryForm;
	}
	public QueryFormType getQueryForm() {
		return queryForm;
	}
		
	@Override	
	public int export(Sheet sheet, int beginRow, int startCol){
		onPrepareExport(sheet);
		int currentRow=exportTitle(sheet, beginRow, startCol);
		currentRow=exprotAddtional(sheet, currentRow, startCol);
		currentRow=exportColumnHeader(sheet, currentRow, startCol);
		return currentRow;
	}
	
    protected int exprotAddtional(Sheet sheet, int currentRow, int startCol) {
		return currentRow;
	}
	
}
