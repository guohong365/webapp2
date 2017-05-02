package com.uc.web.tools.generator.ace.form;

import java.util.List;

import com.uc.web.domain.basic.BasicCode;
import com.uc.web.tools.generator.FormFieldDescriptor;
import com.uc.web.tools.generator.utils.FormFormatorHelper;

public class EnumSelectItemFormator extends EnumItemFormatorBase {
	String format=
	"<form:label path=\"%s\" cssClass=\"control-label col-xs-12 col-sm-4\">$s%s：</form:label>"+
	"<div class=\"col-xs-12 col-sm-8\">"+
	"  <form:select path=\"%s\" cssClass=\"form-control chosen-select\">"+
	"    <form:option value=\"\">请选择%s...</form:option>";
	String option=
	"    <form:option value=\"%s\">%s</form:option>";
	String tail=
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
					item.getName())
				);
		List<BasicCode> codes=getEnumValues(item.getType());
		for(BasicCode code: codes){
			builder.append(String.format(option, code.getCode(), code.getValue()));
		}
		builder.append(tail);
		if(getContainerProvider()!=null)
			builder.append(getContainerProvider().getTail());
	}
	
	
	
}
