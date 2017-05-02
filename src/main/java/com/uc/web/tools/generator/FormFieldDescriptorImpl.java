package com.uc.web.tools.generator;

import com.uc.web.tools.annotation.FormField;
import com.uc.web.tools.annotation.QueryField;

public class FormFieldDescriptorImpl extends FieldDescriptorImpl implements FormFieldDescriptor {
	private boolean hidden;
	private boolean readOnly;
	private boolean range;
	private boolean required;
	private String[] rules;	
	private String[] message;
	private String component;
	
	public FormFieldDescriptorImpl(String fieldName, Class<?> type, FormField field) 
	{
		super(field.value(),field.field()==null|| "".equals(field.field())? fieldName:field.field(), type, field.order(), field.id());
		this.setRange(field.range());
		this.component=field.component();
		this.readOnly=field.readOnly();
		this.hidden=field.hidden();
		this.required=field.required();
		this.rules=field.rules();
		this.message=field.message();
	}
	
	public FormFieldDescriptorImpl(String fieldName, Class<?> type, QueryField field) 
	{
		super(field.value(),field.field()==null|| "".equals(field.field())? fieldName:field.field(), type, field.order(), false);
		this.setRange(field.range());
		this.component=field.component();
	}
	
	@Override
	public String getComponent() {
		return component;
	}
	public void setComponent(String component) {
		this.component = component;
	}
	@Override
	public boolean isReadOnly() {
		return readOnly;
	}
	public void setReadOnly(boolean readOnly) {
		this.readOnly = readOnly;
	}
	@Override
	public boolean isRequired() {
		return required;
	}
	public void setRequired(boolean required) {
		this.required = required;
	}
	@Override
	public boolean isHidden() {
		return hidden;
	}
	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
	@Override
	public String[] getRules() {
		return rules;
	}
	public void setRules(String[] rules) {
		this.rules = rules;
	}

	public String[] getMessage() {
		return message;
	}

	public void setMessage(String[] message) {
		this.message = message;
	}

	public boolean isRange() {
		return range;
	}

	public void setRange(boolean range) {
		this.range = range;
	}
}
