package com.uc.web.tools.generator;

import java.util.List;

import com.uc.web.forms.ui.AbstractUIFormatorBase;

public class PageFormatorImpl extends AbstractUIFormatorBase implements EntityFormator  {
	List<EntityFormator> formators;
	@Override
	public List<EntityFormator> getFormators() {
		return formators;
	}

	@Override
	public void setFormators(List<EntityFormator> formators) {
		this.formators=formators;
	}

	@Override
	public void formatHTML(EntityDescriptor descriptor, StringBuilder builder) {
		if(getContainerProvider()!=null)
			builder.append(getContainerProvider().getHeader());
		for(EntityFormator formator:getFormators()){
			formator.formatHTML(descriptor, builder);
		}
		if(getContainerProvider()!=null)
			builder.append(getContainerProvider().getTail());
	}	
}
