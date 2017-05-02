package com.uc.web.tools.generator.ace.form;

import com.uc.web.tools.generator.FormFieldDescriptor;
import com.uc.web.tools.generator.utils.FormFormatorHelper;

public class HiddenItemFormator extends ItemFormatorBase {

	@Override
	public void formatHTML(FormFieldDescriptor field, StringBuilder builder) {
		builder.append(String.format("<form:hidden path=\"%s\" />", 
				FormFormatorHelper.getPrefixName(getPrefix(), field.getField())));
	}
}
