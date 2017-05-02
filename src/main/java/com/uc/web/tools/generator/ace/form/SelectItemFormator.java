package com.uc.web.tools.generator.ace.form;

import com.uc.web.tools.generator.FormFieldDescriptor;
import com.uc.web.tools.generator.utils.FormFormatorHelper;

public class SelectItemFormator extends ItemFormatorBase {
	String format=
	"<form:label path=\"%s\" cssClass=\"control-label col-xs-12 col-sm-4\">%s%s：</form:label>"+
	"<div class=\"col-xs-12 col-sm-8\">"+
	"  <form:select path=\"%s\" cssClass=\"form-control chosen-select\">"+
	"    <form:option value=\"\">请选择%s...</form:option>"+
	"    <form:options items=\"${_%s}\" itemLabel=\"value\" itemValue=\"code\" />"+
	"  </form:select>"+
    "</div>";

	@Override
	public void formatHTML(FormFieldDescriptor item, StringBuilder builder) {
		if(getContainerProvider()!=null)
			builder.append(getContainerProvider().getHeader());
		builder.append(
			String.format(format, 
					FormFormatorHelper.getPrefixName(getPrefix(), item.getField()),
					isRequired()?required:"",
					item.getName(),
					FormFormatorHelper.getPrefixName(getPrefix(), item.getField()),
					item.getName(),
					FormFormatorHelper.getUpperCaseName(item.getField())
					)
				);
		if(getContainerProvider()!=null)
			builder.append(getContainerProvider().getTail());
	}
	
	
	
}
