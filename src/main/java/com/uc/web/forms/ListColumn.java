package com.uc.web.forms;

public interface ListColumn extends SimpleColumn, JsonString{
	boolean isSortable();
	void setSortable(boolean sortable);
	ListColumn clone();
}
