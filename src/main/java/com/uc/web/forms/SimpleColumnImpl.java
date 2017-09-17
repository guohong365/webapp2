package com.uc.web.forms;

public class SimpleColumnImpl implements SimpleColumn {
	private String title;
	private int sort;
	private boolean show;
	
	public SimpleColumnImpl() {
		this(null);
	}
	public SimpleColumnImpl(String title){
		this(title, true);
	}
	public SimpleColumnImpl(String title, boolean show){
		this(title, show, -1);
	}
	public SimpleColumnImpl(String title, boolean show, int sort){
		this.title=title;
		this.show=show;
		this.sort=sort;
	}
	
	@Override
	public String getTitle() {
		return title;
	}
	@Override
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public int getSort() {
		return sort;
	}
	@Override
	public void setSort(int sort) {
		this.sort = sort;
	}
	@Override
	public boolean isShow() {
		return show;
	}
	@Override
	public void setShow(boolean show) {
		this.show = show;
	}
	
	protected void copyTo(SimpleColumn column){
		column.setTitle(getTitle());
		column.setShow(isShow());
		column.setSort(getSort());
	}
	
	@Override
	public SimpleColumn clone() {
		SimpleColumn column;
		try {
			column = getClass().newInstance();
			copyTo(column);
			return column;
		} catch (Exception e) {
			return null;
		}
	}
	@Override
	public int compareTo(SimpleColumn o) {
		if(o==null) return 1;		
		return getSort() - o.getSort();
	}
	
	
}
