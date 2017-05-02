package com.uc.utils.export.excel;

public class ExcelExportOptions implements IExcelExportOptions {
	private static IExcelCellOptions defaultTitleOptions=new DefaultTitleCellOptions();
	private static IExcelCellOptions defualtColumnHeaderOptions=new DefaultColumnHeaderCellOptions();
	private static IExcelCellOptions defaultAdditionalOptions=new DefaultDataCellOptions();
	private static IExcelCellOptions defaultDataCellOptions=new DefaultDataCellOptions();
	
	private IExcelCellOptions titleCellOptions;
	private IExcelCellOptions addtionalCellOptions;
	private IExcelCellOptions columnHeaderCellOptions;
	private IExcelCellOptions dataCellOptions;
	
	@Override
	public IExcelCellOptions getTitleCellOptions() {
		if(titleCellOptions==null) return defaultTitleOptions;
		return titleCellOptions;
	}
	
	public void setTitleCellOptions(IExcelCellOptions titleCellOptions) {
		this.titleCellOptions = titleCellOptions;
	}

	@Override
	public IExcelCellOptions getAddtionalCellOptions() {
		if(addtionalCellOptions==null) return defaultAdditionalOptions;
		return addtionalCellOptions;
	}
	
	public void setAddtionalCellOptions(IExcelCellOptions addtionalCellOptions) {
		this.addtionalCellOptions = addtionalCellOptions;
	}
	
	@Override
	public IExcelCellOptions getColumnHeaderCellOptions() {
		if(columnHeaderCellOptions==null) return defualtColumnHeaderOptions;
		return columnHeaderCellOptions;
	}

	public void setColumnHeaderCellOptions(IExcelCellOptions columnHeaderCellOptions) {
		this.columnHeaderCellOptions = columnHeaderCellOptions;
	}

	@Override
	public IExcelCellOptions getDataCellOptions() {
		if(dataCellOptions==null) return defaultDataCellOptions;
		return dataCellOptions;
	}
	
	public void setDataCellOptions(IExcelCellOptions dataCellOptions) {
		this.dataCellOptions = dataCellOptions;
	}

}
