package com.uc.web.forms.editor;

import org.springframework.beans.propertyeditors.PropertiesEditor;
import org.springframework.util.StringUtils;

public class ShortEditor extends PropertiesEditor {
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if(StringUtils.isEmpty(text)){
			setValue(null);
			return;
		}
		setValue(Short.parseShort(text));
	}
	@Override
	public String getAsText() {
		if(getValue()==null) return "";
		return getValue().toString();
	}
}