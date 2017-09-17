package com.uc.web.forms;

import java.util.ArrayList;
import java.util.List;

public class ComplexColumnImpl extends SimpleColumnImpl implements ComplexColumn {
	ColSpanAccumulator colSpanAccumulator=new ColSpanAccumulator();
	private int rowSpan;
	private int colSpan;
	private List<ComplexColumn> subColumns;
	private ComplexColumn parent;
	
	public ComplexColumnImpl() {
		this(null);
	}	
	public ComplexColumnImpl(String title){
		this(title, true);
	}
	public ComplexColumnImpl(String title, boolean show){
		this(title, show, -1);
	}
	public ComplexColumnImpl(String title, boolean show, int sort){
		this(title, show, sort, 1);
	}
	public ComplexColumnImpl(String title, boolean show, int sort, int colSpan){
		this(title, show, sort, colSpan, 1);
	}
	public ComplexColumnImpl(String title, boolean show, int sort, int colSpan, int rowSpan){
		super(title, show, sort);
		subColumns=new ArrayList<>();
		parent=null;
		this.rowSpan=rowSpan;
		this.colSpan=colSpan;
	}
	
	protected void copyTo(SimpleColumn column){
		super.copyTo(column);
		if(column instanceof ComplexColumn){
			ComplexColumn complexColumn=(ComplexColumn) column;
			complexColumn.setColSpan(getColSpan());
			complexColumn.setRowSpan(getRowSpan());
			for(ComplexColumn c : getSubColumns()){
			   complexColumn.addSubColumn(c.clone());	
			}
		}
	}
	
	@Override
	public ComplexColumn clone() {
		return  (ComplexColumn) super.clone();
	}

	public List<ComplexColumn> getSubColumns() {
		return subColumns;
	}
	
	public ComplexColumn getParent() {
		return parent;
	}
	public void setParent(ComplexColumn parent) {
		this.parent = parent;
	}
	@Override
	public void setRowSpan(int rowSpan) {
		this.rowSpan=rowSpan;
	}
	@Override
	public int getRowSpan() {		
		return rowSpan;
	}
	@Override
	public int getColSpan() {
		if(getSubColumns().isEmpty())
		  return colSpan;
		synchronized (this) {
			getSubColumns().forEach(colSpanAccumulator.reset());
			return colSpanAccumulator.getSum();
		}
	}
	@Override
	public void setColSpan(int colSpan) {
		this.colSpan=colSpan;
	}

	@Override
	public ComplexColumn addSubColumn(ComplexColumn column) {
		column.setParent(this);
		if(column.getSort() < 0){
			column.setSort(getSubColumns().size());
		}
		getSubColumns().add(column);
		return this;
	}
}
