package com.uc.web.tools.generator.ace.list;

import com.uc.web.tools.generator.FormControlsFormator;
import com.uc.web.tools.generator.EntityDescriptor;
import com.uc.web.tools.generator.EntityFormator;
import com.uc.web.tools.generator.PageFormatorImpl;

public class ListPageConditonFormator extends PageFormatorImpl implements EntityFormator {
	
	private FormControlsFormator formFormator;
	public FormControlsFormator getFormFormator() {
		return formFormator;
	}
	public void setFormFormator(FormControlsFormator formFormator) {
		this.formFormator = formFormator;
	}
	
	@Override
	public void formatHTML(EntityDescriptor descriptor, StringBuilder builder) {
		if(getContainerProvider()!=null)
			builder.append(getContainerProvider().getHeader());
		if(getFormFormator()!=null)
			getFormFormator().formatHTML(descriptor.getFormFields(), builder);
		if(getFormators()!=null){
			for(EntityFormator formator:getFormators()){
				formator.formatHTML(descriptor, builder);
			}
		}
		if(getContainerProvider()!=null)
			builder.append(getContainerProvider().getTail());
	}

}
