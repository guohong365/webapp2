package com.uc.web.tools.generator;

import java.util.List;

import com.uc.web.tools.annotation.ComponentType;
import com.uc.web.tools.generator.utils.FormFormatorHelper;

public class EntityDescriptorImpl implements EntityDescriptor {
	private Class<?> entityClass;
	private List<ButtonDescriptor> functionButtons;
	private List<ButtonDescriptor> rowButtons;
	private List<FormFieldDescriptor> formFields;
	private List<ListColumnDescriptor> listColumns;
	private List<FormFieldDescriptor> queryFields;
	public EntityDescriptorImpl(
			Class<?> entityClass,
			String name,
			List<ButtonDescriptor> functionButtons,
			List<ButtonDescriptor> rowButtons,
			List<FormFieldDescriptor> formFields,
			List<ListColumnDescriptor> listColumns,
			List<FormFieldDescriptor> queryFields) {
		this.entityClass=entityClass;
		this.name=name;
		this.functionButtons=functionButtons;
		this.rowButtons=rowButtons;
		this.formFields=formFields;
		this.listColumns=listColumns;
		this.queryFields=queryFields;
	}
	private String name;
	@Override
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public List<ButtonDescriptor> getFunctionButtons() {
		return functionButtons;
	}
	public void setFunctionButtons(List<ButtonDescriptor> functionButtons) {
		this.functionButtons = functionButtons;
	}
	@Override
	public List<ButtonDescriptor> getRowButtons() {
		return rowButtons;
	}
	public void setRowButtons(List<ButtonDescriptor> rowButtons) {
		this.rowButtons = rowButtons;
	}
	@Override
	public List<FormFieldDescriptor> getFormFields() {
		return formFields;
	}
	public void setFormFields(List<FormFieldDescriptor> formFields) {
		this.formFields = formFields;
	}
	@Override
	public List<ListColumnDescriptor> getListColumns() {
		return listColumns;
	}
	public void setListColumns(List<ListColumnDescriptor> listColumns) {
		this.listColumns = listColumns;
	}
	@Override
	public List<FormFieldDescriptor> getQueryFields() {
		return queryFields;
	}
	public void setQueryFields(List<FormFieldDescriptor> queryFields) {
		this.queryFields = queryFields;
	}
	@Override
	public Class<?> getEntityClass() {
		return entityClass;
	}
	public void setEntityClass(Class<?> entityClass) {
		this.entityClass = entityClass;
	}
	@Override
	public String getUpperCaseName(String name){
		char[] chars=name.toCharArray();
		StringBuilder builder=new StringBuilder();
		for(char ch:chars){
			if(Character.isUpperCase(ch) && builder.length()!=0){
				builder.append("_");				
			}
			builder.append(ch);
		}
		return builder.toString().toUpperCase();
	}

	protected boolean hasChosen(List<FormFieldDescriptor> fields) {
		for(FormFieldDescriptor field: fields){
			if(ComponentType.SELECT.equals(FormFormatorHelper.getFinalComponentType(field))){
				return true;
			}
		}
		return false;
	}

	protected boolean hasDatePicker(List<FormFieldDescriptor> fields) {
		for(FormFieldDescriptor field: fields){
			if(ComponentType.DATE.equals(FormFormatorHelper.getFinalComponentType(field))){
				return true;
			}
		}
		return false;
	}
	protected boolean hasDateRangePicker(List<FormFieldDescriptor> fields) {
		for(FormFieldDescriptor field: fields){
			if(ComponentType.DATE_RANGE.equals(FormFormatorHelper.getFinalComponentType(field))){
				return true;
			}
		}
		return false;
	}
	
	protected boolean hasRules(List<FormFieldDescriptor> fields) {
		for(FormFieldDescriptor field: fields){
			if(field.isRequired() || (field.getRules()!=null && field.getRules().length>0)){
				return true;
			}
		}
		return false;
	}
	@Override
	public boolean formHasChosen() {
		return hasChosen(formFields);
	}
	@Override
	public boolean formHasDatePicker() {
		return hasDatePicker(formFields);
	}
	@Override
	public boolean formHasDateRangePicker() {
		return hasDateRangePicker(formFields);
	}
	@Override
	public boolean formHasRules() {
		return hasRules(formFields);
	}
	@Override
	public boolean queryHasChosen() {
		return hasChosen(queryFields);
	}
	@Override
	public boolean queryHasDatePicker() {
		return hasDatePicker(queryFields);
	}
	@Override
	public boolean queryHasDateRangePicker() {
		return hasDateRangePicker(queryFields);
	}
}
