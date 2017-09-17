package com.uc.utils.export.excel;

import java.util.Arrays;
import java.util.Collection;

import com.uc.web.forms.ComplexColumn;
import com.uc.web.forms.ComplexColumnImpl;
import com.uc.web.forms.SimpleColumn;

public class ExcelColumnImpl extends ComplexColumnImpl implements ExcelColumn {
	
	private int widthAdjust;
	
	public boolean hasChildren() {
		return getSubColumns() != null && getSubColumns().size() > 0;
	}

	@Override
	public void setWidthAdjust(int addWidth) {
		if (hasChildren()) {
			int every = addWidth / getSubColumns().size() + 1;
			for (ComplexColumn column : getSubColumns()) {
				((ExcelColumnImpl) column).setWidthAdjust(every);
			}
		} else {
			widthAdjust = addWidth;
		}
	}

	public int getWidthAdjust() {
		return widthAdjust;
	}

	public ExcelColumnImpl() {
		this("");		
	}

	public ExcelColumnImpl(String title) {
		this(title, 1, 1);
	}

	public ExcelColumnImpl(String title, int colSpan, int rowSpan) {
		super(title, true, -1, colSpan, rowSpan);		
	}
	
	public ExcelColumnImpl(String string, Collection<ExcelColumn> subCloumns){
		this(string);
		if(subCloumns!=null){
		    getSubColumns().addAll(subCloumns);
		}
	}
	public ExcelColumnImpl(String string, ExcelColumn[] subCloumns){
		this(string, subCloumns==null ? null : Arrays.asList(subCloumns));
	}
	
	@Override
	protected void copyTo(SimpleColumn column) {
		super.copyTo(column);
		setWidthAdjust(getWidthAdjust());
	}
	
	@Override
	public ExcelColumn clone() {
		return (ExcelColumn) super.clone();
	}

	@Override
	public int getWidth() {
		int thisWidth = ExcelHelper.getCellWidth(getTitle());
		if (hasChildren()) {
			int subWidth = 0;
			for (ComplexColumn column : getSubColumns()) {
				subWidth += ((ExcelColumnImpl) column).getWidth();
			}
			if (thisWidth > subWidth) {
				setWidthAdjust(thisWidth - subWidth);
			} else {
				thisWidth= subWidth;
			}
			
		}
		return thisWidth + getWidthAdjust();
	}
}
