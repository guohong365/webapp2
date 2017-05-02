package com.uc.web.tools.generator;

public interface FormFieldDescriptor extends FieldDescriptor {
	boolean isHidden();
	boolean isRequired();
	boolean isReadOnly();
	String getComponent();
	boolean isRange();
	String[] getRules();
	String[] getMessage();
	void setComponent(String type);
}