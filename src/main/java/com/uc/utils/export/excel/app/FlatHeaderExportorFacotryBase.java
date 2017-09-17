package com.uc.utils.export.excel.app;

import java.util.Collection;
import java.util.Map;

import com.uc.utils.export.Exportor;
import com.uc.utils.export.ExportorFactory;
import com.uc.utils.export.ValueFormatter;
import com.uc.utils.export.excel.ExcelExportOptions;
import com.uc.utils.export.excel.ExcelListExportorImpl;
import com.uc.utils.export.excel.ExcelSheetHeader;
import com.uc.web.controller.ControllerBase;

public class FlatHeaderExportorFacotryBase<QueryFormType, EntityType> implements ExportorFactory {
	private String[] columns;
	private String title;
	private String fileName;
	private ValueFormatter<EntityType> formatter;
	
	public String[] getColumns() {
		return columns;
	}
	public void setColumns(String[] columns) {
		this.columns = columns;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public ValueFormatter<EntityType> getFormatter() {
		return formatter;
	}
	public void setFormatter(ValueFormatter<EntityType> formatter) {
		this.formatter = formatter;
	}
	@SuppressWarnings("unchecked")
	@Override
	public Exportor create(Map<String, Object> options) {
		Collection<? extends EntityType> data=(Collection<? extends EntityType>) options.get(ControllerBase.EXPORTOR_OPTION_DATA);
		ExcelExportOptions exportOptions=(ExcelExportOptions) options.get(ControllerBase.EXPORTOR_OPTION_EXTERNAL);
		ExcelSheetHeader header = createHeader(options);		
		ExcelListExportorImpl<EntityType> impl=new ExcelListExportorImpl<>(header, data, exportOptions);
		impl.setFileName(fileName);
		impl.setFormatter(formatter);		
		return impl;
	}
	@SuppressWarnings("unchecked")
	protected ExcelSheetHeader createHeader(Map<String, Object> options) {
		ExportHeader<QueryFormType> header=new ExportHeader<>();
		QueryFormType queryForm=(QueryFormType) options.get(ControllerBase.EXPORTOR_OPTION_QUERY_FORM);
		header.setTitle(getTitle());
		header.setColumns(getColumns());
		header.setQueryForm(queryForm);
		return header;
	}
	
}
