package com.uc.web.tools.generator;

import com.uc.web.tools.annotation.ListColumn;

public class ListColumnDescriptorImpl extends FieldDescriptorImpl implements ListColumnDescriptor {
	private boolean orderBy;
	private boolean show;
	public ListColumnDescriptorImpl(String fieldName, Class<?> type, ListColumn column) {
		super(column.value(),column.field()==null || "".equals(column.field()) ? fieldName : column.field(),type, column.order(), column.id());
		this.orderBy=column.orderBy();
		this.show=column.show();
	}
	
	@Override
	public boolean isOrderBy() {
		return orderBy;
	}
	public void setOrderBy(boolean orderBy) {
		this.orderBy = orderBy;
	}

	public boolean isShow() {
		return show;
	}

	public void setShow(boolean show) {
		this.show = show;
	}
}
