package com.uc.web.tools.generator;

import java.util.List;

import com.uc.web.forms.ui.IUIFormator;

public interface EntityFormator extends IUIFormator<EntityDescriptor> {
	List<EntityFormator> getFormators();
	void setFormators(List<EntityFormator> formators);
}
