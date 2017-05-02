package com.uc.web.forms.ui.componet;

import com.uc.web.utils.SystemConfig;

public class PageCtrl implements IPageCtrl {
	@Override
	public String toString() {
		return "PageCtrl [current=" + current + ", pageCount=" + pageCount + ", action=" + action + ", total=" + total
				+ ", offset=" + offset + "]";
	}

	private static int pageSize=SystemConfig.getPageSize();

	private long current;
	private long pageCount;
	private String action;
	private long total;	
	private long offset;
	
	public static void initPageCtrl(IPageCtrl pageCtrl, long total){
		pageCtrl.setTotal(total);
		pageCtrl.setCurrent(0);
		pageCtrl.setOffset(0);
		pageCtrl.setPageCount(total/pageCtrl.getPageSize()+(total%pageCtrl.getPageSize()==0?0:1));
	}
	
	public PageCtrl(){
		offset=0;
		current=1;
		total=-1;
		pageCount=-1;
		action="action";
	}
	
	@Override
	public IPageCtrl nextPage() {
		if(offset + pageSize >0){
			offset +=pageSize;
			current ++;
			return this;
		}
		return null;
	}

	@Override
	public IPageCtrl priorPage() {
		if(offset > 0){
			if(offset - pageSize >0){
				offset -=pageSize;
				current--;
			} else {
				offset=0;
				current=1;
			}
			return this;
		}
		return null;
	}

	@Override
	public boolean hasNext() {		
		return offset + pageSize < total;
	}

	@Override
	public boolean hasPrior() {		
		return offset>0;
	}

	@Override
	public boolean isLast() {
		return current==1;
	}

	@Override
	public boolean isFirst() {		
		return current==pageCount;
	}

	@Override
	public long getCurrent() {
		return this.current;
	}

	@Override
	public void setCurrent(long page) {
		this.current=page;
	}

	@Override
	public long getPageSize() {
		return PageCtrl.pageSize;
	}

	@Override
	public void setPageSize(long pageSize) {
	}

	@Override
	public long getPageCount() {
		return this.pageCount;
	}

	@Override
	public void setPageCount(long count) {
		this.pageCount=count;
	}

	@Override
	public long getTotal() {
		return this.total;
	}

	@Override
	public void setTotal(long totalCount) {
		this.total=totalCount;		
	}

	@Override
	public long getOffset() {
		return this.offset;
	}

	@Override
	public void setOffset(long start) {
		this.offset=start;
	}

	@Override
	public String getAction() {
		return this.action;
	}

	@Override
	public void setAction(String actionName) {
		this.action=actionName;
	}

	
}
