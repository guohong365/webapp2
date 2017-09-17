package com.uc.utils.export.excel;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class ExcelExportOptionsImpl implements ExcelExportOptions {
	
	private Map<String, CellOptions> map=new HashMap<>();
	
	public ExcelExportOptionsImpl() {
	}
	
	ExcelExportOptionsImpl(Collection<CellOptions> options){
		addAll(options);		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public CellOptions get(String name) {
		try{
			return (CellOptions)map.get(name);
		} catch (Exception e){
			return null;
		}
	}
	@Override
	public ExcelExportOptions add(CellOptions cellOptions){
		map.put(cellOptions.getName(), cellOptions);
		return this;
	}
	@Override
	public ExcelExportOptions addAll(Collection<CellOptions> allOptions){
		for(CellOptions options:allOptions){
			map.put(options.getName(), options);
		}
		return this;
	}

	@Override
	public <T> Collection<CellOptions> getAll() {
		return map.values();
	}
	
}
