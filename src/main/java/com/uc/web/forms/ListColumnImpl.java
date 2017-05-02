package com.uc.web.forms;

import java.util.Collection;

public class ListColumnImpl extends ColumnBase {

	public ListColumnImpl(int index, String title){	
		this(index, title, false);
	}
	
	public ListColumnImpl(int index, String title, boolean sortable){
		this(index,title, 1, 1, true, sortable);
	}
	
	public ListColumnImpl(int index, String title, boolean show, boolean sortable){
		this(index, title, 1, 1, show, sortable);
	}
	
	public ListColumnImpl(int index, String title, int colSpan, int rowSpan, boolean show, boolean sortable){
		super(index, title, colSpan, rowSpan, show, sortable);
	}
	

	
	public static String getArrayString(Collection<Column> columns){
		StringBuilder builder=new StringBuilder();
		for (Column column:columns) {
			builder.append(column.isShow()? "1":"0");
		}
		return builder.toString();
	}
	
}
