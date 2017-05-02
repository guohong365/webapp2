package com.uc.web.tools.generator.ace.list;

import java.util.List;

import com.uc.web.forms.ui.AbstractUIFormatorBase;
import com.uc.web.forms.ui.ContainerProvider;
import com.uc.web.tools.generator.ButtonDescriptor;
import com.uc.web.tools.generator.ButtonFormator;
import com.uc.web.tools.generator.ButtonsFormator;
import com.uc.web.tools.generator.IdAccepter;

public class RowButtonsFormator extends AbstractUIFormatorBase implements ButtonsFormator, IdAccepter, ContainerProvider {
	private static final String HEADER="<td><div class=\"btn-group\">";
	private static final String TAIL="</div></td>";

	@Override
	public String getHeader() {
		return HEADER;
	}
	@Override
	public String getTail() {
		return TAIL;
	}
	
	@Override
	public ContainerProvider getContainerProvider() {
		return super.getContainerProvider()==null?this:super.getContainerProvider();
	}
	
	private String id;
	@Override
	public String getId() {
		return id;
	}
	@Override
	public void setId(String id) {
		this.id = id;
	}
	
	private ButtonFormator buttonFormator;
	public ButtonFormator getButtonFormator() {
		return buttonFormator;
	}
	public void setButtonFormator(ButtonFormator buttonFormator) {
		this.buttonFormator = buttonFormator;
	}

	@Override
	public void formatHTML(List<ButtonDescriptor> buttons, StringBuilder builder) {
		ButtonFormator formator=getButtonFormator();
		if(formator==null) return;
		if(formator instanceof IdAccepter){
			((IdAccepter) formator).setId(getId());
		}
		if(getContainerProvider()!=null)
			builder.append(getContainerProvider().getHeader());
		for(ButtonDescriptor button:buttons){
			formator.formatHTML(button, builder);
		}
		if(getContainerProvider()!=null)
			builder.append(getContainerProvider().getTail());
	}

}
