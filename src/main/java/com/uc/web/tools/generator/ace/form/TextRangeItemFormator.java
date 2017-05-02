package com.uc.web.tools.generator.ace.form;

import com.uc.web.tools.generator.FormFieldDescriptor;
import com.uc.web.tools.generator.utils.FormFormatorHelper;

public class TextRangeItemFormator extends ItemFormatorBase  {
	String scopeString=
	"<form:label path=\"%sFrom\" cssClass=\"control-label col-xs-12 col-sm-4\">%s：</form:label>" +
    "<div class=\"col-xs-12 col-sm-8\">" +
    "  <div class=\"input-group\">" +
    "    <span class=\"input-group-addon\">自</span>" +
    "    <form:input cssClass=\"form-control\" path=\"%sFrom\" />" +
    "    <span class=\"input-group-addon\">至</span>" +
    "    <form:input path=\"%sTo\" cssClass=\"form-control\"/>" +                  
    "  </div>" +
    "</div>";
	@Override
	public void formatHTML(FormFieldDescriptor item, StringBuilder builder) {
		if(getContainerProvider()!=null) 
			builder.append(getContainerProvider().getHeader());
		builder.append(
				String.format(scopeString,
						FormFormatorHelper.getPrefixName(getPrefix(), item.getField()),
						item.getName(),
						FormFormatorHelper.getPrefixName(getPrefix(), item.getField()),
						FormFormatorHelper.getPrefixName(getPrefix(), item.getField())));
		if(getContainerProvider()!=null)
			builder.append(getContainerProvider().getTail());
	}

}
