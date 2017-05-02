package com.uc.web.forms.editor;

import org.springframework.beans.propertyeditors.PropertiesEditor;
import org.springframework.util.StringUtils;

public class IntegerEditor extends PropertiesEditor {
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if(StringUtils.isEmpty(text))
		{
			setValue(null);
			return;
		}
		try{
			setValue(Integer.parseInt(text));
		}catch (Exception e) {
			setValue(null);
		}
	}
	@Override
	public String getAsText() {
		return getValue()==null?"":getValue().toString();
	}
}