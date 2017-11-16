package com.uc.utils.export.excel;

import java.util.Collection;

import com.uc.utils.export.ValueFormatter;

public interface ExcelListExportor<EntityType> extends ExcelExportor {
	public static final String DATA_STYLE = "DATA_STYLE";
	public static final String TITLE_STYLE="TITLE_STYLE";
	public static final String COLUMN_HEADER_STYLE="COLUMN_HEADER_STYLE";
	public static final String ADDITIONAL_STYLE = "ADDTIONAL_STYLE";
	public static final String DATA_FONT = "DATA_FONT";
	public static final String TITLE_FONT="TITLE_FONT";
	public static final String COLUMN_HEADER_FONT="COLUMN_HEADER_FONT";
	public static final String ADDITIONAL_FONT = "ADDTIONAL_FONT";
	
	Collection<? extends EntityType> getData();
	ExcelSheetHeader getHeader();
	ValueFormatter<EntityType> getFormatter();
	Boolean getAutoFitWidth();
	void setHeader(ExcelSheetHeader header); 
}
