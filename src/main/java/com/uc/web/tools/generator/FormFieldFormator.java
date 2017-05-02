package com.uc.web.tools.generator;

import com.uc.web.forms.ui.IUIFormator;

public interface FormFieldFormator extends IUIFormator<FormFieldDescriptor> {	
	void setVariablePrefix(String variablePrefix);
	boolean isRequired();
	void setRequired(boolean required);
}
