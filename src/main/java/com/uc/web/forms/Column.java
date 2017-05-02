package com.uc.web.forms;

import java.util.List;

public interface Column extends Comparable<Column> {
	void setIndex(int index);
	int getIndex();
	void setTitle(String title);

	String getTitle();

	void setRowSpan(int rowSpan);

	int getRowSpan();

	int getColSpan();

	void setColSpan(int colSpan);

	List<Column> getSubColumns();

	void setParent(Column parent);

	Column getParent();

	Column addSubColumn(Column column);

	void setSortable(boolean sortable);

	boolean isSortable();

	boolean isShow();

	void setShow(boolean show);

	void setWidth(int width);

	int getWidth();
}
