package com.uc.web.forms;

public interface SimpleColumn extends Comparable<SimpleColumn>, Cloneable{
	void setTitle(String title);
	String getTitle();
	void setSort(int sort);
	int getSort();
	boolean isShow();
	void setShow(boolean show);
	SimpleColumn clone();
}
