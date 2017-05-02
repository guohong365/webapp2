package com.uc.web.forms.editor;

import java.math.BigDecimal;

import org.springframework.beans.propertyeditors.PropertiesEditor;
import org.springframework.util.StringUtils;

public class BigDecimalEditor extends PropertiesEditor {
@Override
public void setAsText(String text) throws IllegalArgumentException {
	if(StringUtils.isEmpty(text)){
		setValue(null);
		return;
	}	
	try{
		setValue(new BigDecimal(text));
	}catch (Exception e) {
		setValue(null);
	}
}
@Override
	public String getAsText() {
		return getValue()==null?"": super.getAsText();
	}
}
