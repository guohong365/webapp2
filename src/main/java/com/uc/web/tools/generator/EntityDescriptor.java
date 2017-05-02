package com.uc.web.tools.generator;

import java.util.List;

public interface EntityDescriptor {
	List<ButtonDescriptor> getRowButtons();
	List<ListColumnDescriptor> getListColumns();
	List<FormFieldDescriptor> getFormFields();
	List<ButtonDescriptor> getFunctionButtons();
	List<FormFieldDescriptor> getQueryFields();
	String getName();
	Class<?> getEntityClass();
	String getUpperCaseName(String name);
	boolean formHasChosen();
	boolean formHasDatePicker();
	boolean formHasDateRangePicker();
	boolean formHasRules();
	boolean queryHasChosen();
	boolean queryHasDatePicker();
	boolean queryHasDateRangePicker();
}
