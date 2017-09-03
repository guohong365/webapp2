package com.uc.web.forms.ui.componet;

public interface PageCtrl {
	long getTotal();
	void setTotal(long total);
	long getPageSize();
	void setPageSize(long pageSize);
	long getOffset();
	void setOffset(long start);
	
	long getPageCount();
	long getPage();
	boolean hasNext();
	boolean hasPrior();
	public static void initPageCtrl(PageCtrl pageCtrl, long total){
		pageCtrl.setTotal(total);
		pageCtrl.setOffset(0);
	}
}
