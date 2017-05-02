package com.uc.web.forms.editor;

import org.springframework.beans.propertyeditors.PropertiesEditor;
import org.springframework.util.StringUtils;

public class FloatEditor extends PropertiesEditor {
	private String format;
	public FloatEditor(String format) {
		this.format=format;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if(StringUtils.isEmpty(text)){
			setValue(null);
			return;
		}
		setValue(Float.parseFloat(text));
		
	}
	@Override
	public String getAsText() {
		return getValue()==null?"" : String.format(format, getValue());
	}
}