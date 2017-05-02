package com.uc.web.tools.generator.ace.form;

import com.uc.web.tools.generator.FormFieldDescriptor;
import com.uc.web.tools.generator.utils.FormFormatorHelper;

public class DateItemFormator extends ItemFormatorBase {
	String format=
	"<form:label path=\"%s\" cssClass=\"col-xs-12 col-sm-4 control-label\">%s%s：</form:label>"+
	"<div class=\"col-xs-12 col-sm-8\">"+
	"  <div class=\"input-group\">"+
	"    <form:input path=\"%s\" cssClass=\"form-control date-picker\" />"+
	"    <span class=\"input-group-addon\">"+
	"      <i class=\"fa fa-calendar\"></i>"+
	"    </span>"+
	"  </div>  "+
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
						FormFormatorHelper.getPrefixName(getPrefix(), item.getField()))
				);
		if(getContainerProvider()!=null) 
			builder.append(getContainerProvider().getTail());
	}
	
}
