package com.uc.web.forms;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public abstract class ColumnsControllerBase implements ColumnsController {
	private static final long serialVersionUID = -1298529150296534719L;
	Map<String, Column> columns;
	
	public ColumnsControllerBase() {
		columns=new HashMap<>();
		for (Column column : getDefaultColumns()) {
			columns.put(column.getTitle(),  column);
		}
	}
	
	@Override
	public Collection<Column> getColumns() {
		return columns.values();
	}
	
	protected void setColumnShow(String col, boolean show){
		Column column= columns.get(col);
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
		for(Column column:getColumns()){
			if(column.getIndex()==index){
				column.setShow(true);
			}
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
	public void showAll(boolean isShow) {
		for (Column column : getColumns()) {
			column.setShow(isShow);
		}		
	}
	
	public void setColumnsShowFromString(String showConfig){
		char[] flags=showConfig.toCharArray();
		int index;
		for (Iterator<Column> iterator = getColumns().iterator(); iterator.hasNext();) {
			Column column =iterator.next();
			index=column.getIndex();
			if(index< flags.length){
				column.setShow(flags[index]!='0');
			} else {				
				column.setShow(false);
			}
		}
	}
	
	public String getColumnsShowString(){
		StringBuilder builder=new StringBuilder();
		for(Column column:getColumns()){
			builder.append(column.isShow() ? "1": "0");
		}
		return builder.toString();
	}	
	
	@Override
	public Column[] toArray() {		
		Column [] columns=getColumns().toArray(new Column[getColumns().size()]);
		Arrays.sort(columns);
		return columns;
	}
	
	protected abstract Collection<Column> getDefaultColumns();

}
