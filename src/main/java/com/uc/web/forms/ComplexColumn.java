package com.uc.web.forms;

import java.util.List;

public interface ComplexColumn extends SimpleColumn{
	void setRowSpan(int rowSpan);
	int getRowSpan();
	int getColSpan();
	void setColSpan(int colSpan);	
	void setParent(ComplexColumn parent);
	ComplexColumn getParent();
	List<ComplexColumn> getSubColumns();
	ComplexColumn addSubColumn(ComplexColumn column);
	ComplexColumn clone();
}
