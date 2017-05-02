package com.uc.web.tools.generator.ace.form;

import com.uc.web.forms.ui.AbstractUIFormatorBase;
import com.uc.web.forms.ui.ContainerProvider;
import com.uc.web.tools.generator.FormFieldFormator;

public abstract class ItemFormatorBase extends AbstractUIFormatorBase implements FormFieldFormator, ContainerProvider {
	static final String header=
			"<div class=\"col-xs-12 col-sm-6 col-lg-4\">"
		  + "  <div class=\"form-group\">";
	static final String tail=
			"  </div>"
		  + "</div>";
	
	protected static final String required="<span class=\"red\">*</span>";
	
	@Override
	public String getHeader() {
		return header;
	}
	
	@Override
	public String getTail() {
		return tail;
	}
	
	@Override
	public ContainerProvider getContainerProvider() {
		if(super.getContainerProvider()==null) return this;
		return super.getContainerProvider();
	}
	
	private String prefix="";

	protected String getPrefix() {
		return prefix;
	}
	

	@Override
	public void setVariablePrefix(String variablePrefix) {
		prefix=variablePrefix;
	}
	
	public boolean isRequired() {
		return requied;
	}

	public void setRequired(boolean requied) {
		this.requied = requied;
	}

	private boolean requied;

}
