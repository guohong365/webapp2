package com.uc.web.forms.editor;

import org.springframework.beans.propertyeditors.PropertiesEditor;
import org.springframework.util.StringUtils;

public class LongEditor extends PropertiesEditor {
	@Override
	public String getAsText() {
		return getValue()==null? "": getValue().toString();
	}
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if(StringUtils.isEmpty(text)){
			setValue(null);
			return;
		}
		try{
			Long val=Long.parseLong(text);
			setValue(val);
		}catch (Exception e) {
			setValue(null);
		}
	}
}