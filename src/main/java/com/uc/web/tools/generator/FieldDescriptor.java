package com.uc.web.tools.generator;

public interface FieldDescriptor  {
	boolean isId();
	int getOrder();
	Class<?> getType();
	String getName();
	String getField();
}
