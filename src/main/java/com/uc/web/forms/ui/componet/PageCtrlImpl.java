package com.uc.web.forms.ui.componet;

import com.uc.web.domain.EntityBase;
import com.uc.web.utils.SystemConfig;

public class PageCtrlImpl extends EntityBase implements PageCtrl {
	
	private long pageSize;
	private long total;	
	private long offset;
	
	public PageCtrlImpl(){
		offset=0;
		total=-1;
		pageSize=SystemConfig.getPageSize();
	}
	
	public PageCtrl nextPage() {
		if(hasNext()){
			offset +=pageSize;
			return this;
		}
		return null;
	}

	public PageCtrl priorPage() {
		if(hasPrior()){
			if(offset - pageSize >0){
				offset -=pageSize;
			} else {
				offset=0;
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
	public long getPageSize() {
		return pageSize;
	}

	@Override
	public void setPageSize(long pageSize) {
		this.pageSize=pageSize;
	}

	@Override
	public long getPageCount() {
		return total/pageSize + (total%pageSize > 0 ? 1 : 0);
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
	public long getPage() {
		
		return offset/pageSize + (offset % pageSize > 0 ? 1 : 0);
	}
}
