package com.uc.web.tools.generator.ace.form;

import java.util.List;

import com.uc.web.domain.Code;
import com.uc.web.tools.generator.FormFieldDescriptor;
import com.uc.web.tools.generator.utils.FormFormatorHelper;

public class EnumRadioBoxItemFormator extends EnumItemFormatorBase {
	String header=
			"<form:label path=\"%s\" cssClass=\"control-label col-xs-12 col-sm-4\">%s</form:label>" +
			"<div class=\"col-xs-12 col-sm-8\">";
	String checkbox=
			"  <label class=\"checkbox-inline\">"
		  + "    <form:radionbutton path=\"%s\" value=\"%s\">%s</form:radionbutton>"
		  + "  </label>";
	String tail=
			"</div>";

	@Override
	public void formatHTML(FormFieldDescriptor item, StringBuilder builder) {
		if(getContainerProvider()!=null)
			builder.append(getContainerProvider().getHeader());
		builder.append(
				String.format(header,
						FormFormatorHelper.getPrefixName(getPrefix(), item.getField()),						
						item.getName())
				);
		List<Code> codes=getEnumValues(item.getType());
		for(Code code:codes){
			builder.append(String.format(checkbox, code.getCode(),code.getValue()));
		}
		builder.append(tail);
		if(getContainerProvider()!=null)
			builder.append(getContainerProvider().getTail());
	}
	
}
