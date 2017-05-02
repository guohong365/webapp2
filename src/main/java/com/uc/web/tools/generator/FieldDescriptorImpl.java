package com.uc.web.tools.generator;

public class FieldDescriptorImpl implements FieldDescriptor {
	private String name;
	private String field;
	private Class<?> type;
	private int order;
	private boolean id;
	
	public FieldDescriptorImpl(String name, String field, Class<?> type, int order, boolean isId) {
		this.name=name;
		this.setField(field);
		this.type=type;
		this.order=order;
		this.id=isId;
	}
	
	@Override
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public Class<?> getType() {
		return type;
	}
	public void setType(Class<?> type) {
		this.type = type;
	}
	@Override
	public int getOrder() {
		return order;
	}
	
	public void setOrder(int order) {
		this.order = order;
	}
	@Override
	public boolean isId() {
		return id;
	}
	public void setId(boolean id) {
		this.id = id;
	}

	@Override
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
}
