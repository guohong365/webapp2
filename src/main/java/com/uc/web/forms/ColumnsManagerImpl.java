package com.uc.web.forms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ColumnsManagerImpl implements ColumnsManager {
	private Map<String, ListColumn> columnsMap=new HashMap<>();
	private List<ListColumn> columns=new ArrayList<>();	
	private List<ListColumn> defaultColumns=new ArrayList<>();
	
	public List<ListColumn> getDefaultColumns() {
		return defaultColumns;
	}
	public void setDefaultColumns(List<ListColumn> defaultColumns) {
		this.defaultColumns = defaultColumns;
	}

	public Map<String, ListColumn> getColumnsMap() {
		return columnsMap;
	}
	public void setColumnsMap(Map<String, ListColumn> columnsMap) {
		this.columnsMap = columnsMap;
	}
	
	public ColumnsManagerImpl(Collection<ListColumn> defaultColumns) {
		this.defaultColumns.addAll(defaultColumns);
		Collections.sort(this.defaultColumns);		
		buildInstance();
	}	
		
	private void buildInstance() {
		int index=0;
		for(ListColumn column : getDefaultColumns()){			
			ListColumn col=column.clone();
			col.setSort(index);	
			index ++;
			columnsMap.put(column.getTitle(), col);
			columns.add(col);
		}
	}
	
	@Override
	public List<ListColumn> getColumns() {
		return columns;
	}
	
	protected void setColumnShow(String col, boolean show){
		ListColumn column= columnsMap.get(col);
		if(column!=null){
			column.setShow(show);
		}		
	}

	@Override
	public void show(String column) {
		setColumnShow(column, true);
	}

	@Override
	public void hide(String column) {
		setColumnShow(column, false);
	}

	protected void setColumnShow(int index, boolean show){
		if(index>=0 && index < columns.size()){
			columns.get(index).setShow(show);
		}
	}
	
	@Override
	public void show(int index) {
		setColumnShow(index, true);
	}

	@Override
	public void hide(int index) {
		setColumnShow(index, false);
	}
	
	@Override
	public void setShowAll(boolean isShow) {
		for (ListColumn column : getColumns()) {
			column.setShow(isShow);
		}		
	}
	@Override
	public void setShowByFlagString(String showFlags){
		char[] flags=showFlags.toCharArray();
		System.err.println("input : " + showFlags);
		for (ListColumn column : getColumns()){
			int index=column.getSort();
			System.err.println("set column ["+ column.getTitle() +"] at [" + column.getSort() +"]");
			if(index< flags.length){
				column.setShow(flags[index]!='0');
			} else {				
				column.setShow(false);
			}
		}
	}
}
