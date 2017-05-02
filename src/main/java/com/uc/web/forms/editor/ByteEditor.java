package com.uc.web.forms.editor;

import org.springframework.beans.propertyeditors.PropertiesEditor;
import org.springframework.util.StringUtils;

public class ByteEditor extends PropertiesEditor {
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if(StringUtils.isEmpty(text))
		{
			setValue(null);
			return;
		}
		setValue(Byte.parseByte(text));
	}
	@Override
	public String getAsText() {
		return getValue()==null?"":getValue().toString();
	}
}