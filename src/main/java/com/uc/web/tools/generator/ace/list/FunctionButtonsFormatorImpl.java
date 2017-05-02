package com.uc.web.tools.generator.ace.list;

import java.util.List;

import com.uc.web.tools.generator.ButtonDescriptor;
import com.uc.web.tools.generator.ButtonFormator;
import com.uc.web.tools.generator.ButtonsFormator;

public class FunctionButtonsFormatorImpl extends ButtonsFormatorBase implements	ButtonsFormator{

	static final String HEADER=				
        "    <div class=\"row\"><!-- functon button begin -->" +
        "      <div class=\"col-xs-12\">" +
        "        <div class=\"btn-group\">";

	static final String TAIL=
		"        </div>"+
		"      </div>" +		
		"	 </div><!-- function button end -->";
	@Override
	public void formatHTML(List<ButtonDescriptor> buttons, StringBuilder builder) {
		ButtonFormator formator=getButtonFormator();
		if(formator==null) return;
		
		if(getContainerProvider()!=null)
			builder.append(getContainerProvider().getHeader());
		builder.append(HEADER);
		
		for(ButtonDescriptor button: buttons){
			formator.formatHTML(button, builder);
		}
		builder.append(TAIL);
		if(getContainerProvider()!=null)
			builder.append(getContainerProvider().getTail());
	}
	
	private ButtonFormator buttonFormator;
	public ButtonFormator getButtonFormator() {
		return buttonFormator;
	}
	public void setButtonFormator(ButtonFormator buttonFormator) {
		this.buttonFormator = buttonFormator;
	}

}
