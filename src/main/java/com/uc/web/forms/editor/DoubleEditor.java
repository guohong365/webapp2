package com.uc.web.forms.editor;

import org.springframework.beans.propertyeditors.PropertiesEditor;
import org.springframework.util.StringUtils;

public class DoubleEditor extends PropertiesEditor {
	private String format;
	
	public DoubleEditor(String format) {
		this.format=format;
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if (StringUtils.isEmpty(text)) {
			setValue(null);
			return;
		}
		setValue(Double.parseDouble(text));
	}
	@Override
	public String getAsText() {
		return getValue()==null?"": String.format(format, getValue());
	}
}