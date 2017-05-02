package com.uc.web.forms.ui.componet;

public interface IPageCtrl {
	long getCurrent();
	void setCurrent(long page);
	long getPageSize();
	void setPageSize(long pageSize);
	long getPageCount();
	void setPageCount(long count);
	long getTotal();
	void setTotal(long total);
	long getOffset();
	void setOffset(long start);
	boolean hasNext();
	boolean hasPrior();
	IPageCtrl nextPage();
	IPageCtrl priorPage();
	boolean isLast();
	boolean isFirst();
	String getAction();
	void setAction(String action);
}
