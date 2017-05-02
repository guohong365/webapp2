package com.uc.web.forms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.uc.utils.LoggerSupportorImpl;

public class ColumnBase extends LoggerSupportorImpl implements Column {	
	
	public static String toString(Collection<Column> columns){
		StringBuilder builder=new StringBuilder();
		for(Column column : columns){
			builder.append(column.toString());
		}
		return builder.toString();
	}
	
	public boolean isSortable() {
		return sortable;
	}

	public void setSortable(boolean sortable) {
		this.sortable = sortable;
	}

	public boolean isShow() {
		return show;
	}

	public void setShow(boolean show) {
		this.show = show;
	}

	public ColumnBase(int index, String title, int colSpan, int rowSpan, boolean show, boolean sortable){
		subColumns=new ArrayList<>();
		this.show=show;
		this.sortable=sortable;
		this.colSpan=colSpan;
		this.rowSpan=rowSpan;	
		parent=null;
		this.index=index;
		this.title=title;
	}
	
	@Override
	public String getTitle() {
		return title;
	}
	@Override
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public List<Column> getSubColumns() {
		return subColumns;
	}
	@Override
	public Column getParent() {
		return parent;
	}
	@Override
	public void setParent(Column parent) {
		this.parent = parent;
	}
	@Override
	public int getColSpan() {
		return colSpan;
	}
	@Override
	public void setColSpan(int colSpan) {
		this.colSpan = colSpan;
	}
	@Override
	public int getRowSpan() {
		return rowSpan;
	}
	@Override
	public void setRowSpan(int rowSpan) {
		this.rowSpan = rowSpan;
	}
	
	private String title;
	private List<Column> subColumns;
	private Column parent;
	private int colSpan;
	private int rowSpan;
	private boolean sortable;
	private boolean show;
	private int width; 
	private int index;
	@Override
	public Column addSubColumn(Column column) {
		subColumns.add(column);
		column.setParent(this);
		column.setIndex(subColumns.size()-1);
		return this;
	}
	
	public Column addSubColumn(Column column, int index){
		subColumns.add(column);
		column.setParent(this);
		column.setIndex(index);
		return this;
		
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public void setIndex(int index) {
		this.index=index;
	}

	@Override
	public int getIndex() {
		return index;
	}

	@Override
	public int compareTo(Column o) {
		if(o==null) return 1;		
		return getIndex()-o.getIndex();
	}
}
