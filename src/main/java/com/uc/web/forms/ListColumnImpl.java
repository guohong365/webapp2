package com.uc.web.forms;

import java.util.List;

public class ListColumnImpl extends SimpleColumnImpl implements ListColumn {
	private boolean sortable;

	@Override
	public boolean isSortable() {
		return sortable;
	}
	@Override
	public void setSortable(boolean sortable) {
		this.sortable=sortable;
	}
	
	public ListColumnImpl() {
		this(null);
	}
	
	public ListColumnImpl(String title){
		this(title, true);
	}
	
	public ListColumnImpl(String title, boolean show){
		this(title, show, -1);
	}
	
	public ListColumnImpl(String title, boolean show, int sort){
		this(title, show, sort, true);
	}
	
	public ListColumnImpl(String title, boolean show, int sort, boolean sortable){
		super(title, show, sort);
		this.sortable=sortable;
	}
	
	@Override
	protected void copyTo(SimpleColumn column) {
		super.copyTo(column);
		if(column instanceof ListColumn){
			ListColumn listColumn=(ListColumn) column;
			listColumn.setSortable(isSortable());
		}
	}
	
	@Override
	public ListColumn clone() {
		return (ListColumn) super.clone();
	}
	
	public static String getArrayString(List<ListColumn> columns){
		StringBuilder builder=new StringBuilder();
		for (ListColumn column:columns) {
			builder.append(column.isShow()? "1":"0");			
		}
		return builder.toString();
	}
	@Override
	public String toJson(){
	   StringBuilder builder=new StringBuilder();
	   builder.append('{').append("\"title\" :");
	   if(getTitle()==null) builder.append("null ,");
	   else builder.append('"').append(getTitle()).append('"').append(',');
	   builder.append("\"sort\" :").append(getSort()).append(',')
	   .append("\"show\" : ").append(isShow())
	   .append("\"sortable\" :").append(isSortable())
	   .append('}');
	   return builder.toString();
	}
	
}
