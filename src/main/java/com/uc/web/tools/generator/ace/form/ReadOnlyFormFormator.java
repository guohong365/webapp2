package com.uc.web.tools.generator.ace.form;

import com.uc.web.tools.annotation.ComponentType;
import com.uc.web.tools.generator.FormFieldDescriptor;
import com.uc.web.tools.generator.FormFieldFormator;

public class ReadOnlyFormFormator extends FormControlsFormatorImpl {

	@Override
	protected FormFieldFormator prepareFormator(FormFieldDescriptor descriptor) {
		String type=descriptor.isHidden()?  ComponentType.HIDDEN:ComponentType.STATIC;
		return getComponents().get(type);
	}
}
