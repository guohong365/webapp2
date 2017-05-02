package com.uc.web.tools.generator.ace.form;

import java.util.List;
import java.util.Map;

import com.uc.web.forms.ui.AbstractUIFormatorBase;
import com.uc.web.tools.generator.FormControlsFormator;
import com.uc.web.tools.generator.FormFieldDescriptor;
import com.uc.web.tools.generator.FormFieldFormator;
import com.uc.web.tools.generator.utils.FormFormatorHelper;

public class FormControlsFormatorImpl extends AbstractUIFormatorBase implements FormControlsFormator {

	private Map<String, FormFieldFormator> components;
	@Override
	public Map<String, FormFieldFormator> getComponents() {
		return components;
	}
	public void setComponents(Map<String, FormFieldFormator> components) {
		this.components = components;
	}

	protected FormFieldFormator prepareFormator(FormFieldDescriptor descriptor){
		String realType=FormFormatorHelper.getFinalComponentType(descriptor);
		FormFieldFormator formator=getComponents().get(realType);
		return formator;
	}
	
	@Override
	public void formatHTML(List<FormFieldDescriptor> componet, StringBuilder builder) {
		if(getContainerProvider()!=null){
			String header=getContainerProvider().getHeader();
			builder.append(header);
		}
		for(FormFieldDescriptor descriptor: componet){			
			FormFieldFormator formator=prepareFormator(descriptor);
			if(formator!=null){
				formator.formatHTML(descriptor, builder);
			}
		}
		if(getContainerProvider()!=null){
			String tail=getContainerProvider().getTail();
			builder.append(tail);
		}
	}
	


}
