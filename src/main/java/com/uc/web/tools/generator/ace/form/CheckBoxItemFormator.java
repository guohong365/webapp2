package com.uc.web.tools.generator.ace.form;

import com.uc.web.tools.generator.FormFieldDescriptor;
import com.uc.web.tools.generator.utils.FormFormatorHelper;

public class CheckBoxItemFormator extends ItemFormatorBase {
	String formatString=
			"<div class=\"col-xs-12 col-sm-8 col-sm-offset-4\">"
		  + "  <form:label path=\"%s\" cssClass=\"checkbox-inline\">" +
		    "    <form:checkbox path=\"%s\"></form:checkbox>%s"
		  + "  </form:label>"
		  + "</div>";

	@Override
	public void formatHTML(FormFieldDescriptor item, StringBuilder builder) {
		if(getContainerProvider()!=null)
			builder.append(getContainerProvider().getHeader());
		builder.append(
				String.format(formatString,
						FormFormatorHelper.getPrefixName(getPrefix(), item.getField()),
						FormFormatorHelper.getPrefixName(getPrefix(), item.getField()),
						item.getName())
				);		
		if(getContainerProvider()!=null)
			builder.append(getContainerProvider().getTail());
	}
	
}
