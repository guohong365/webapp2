package com.uc.web.tools.generator.ace.form;

import com.uc.web.tools.generator.FormFieldDescriptor;
import com.uc.web.tools.generator.utils.FormFormatorHelper;

public class TextBoxItemFormator extends ItemFormatorBase  {
	String formatString=
			  "<form:label path=\"%s\" cssClass=\"control-label col-xs-12 col-sm-4\">%s%s：</form:label>"
			+ "<div class=\"col-xs-12 col-sm-8\" >"
			+ "  <form:input path=\"%s\" cssClass=\"form-control\" />"
			+ "</div>";
	@Override
	public void formatHTML(FormFieldDescriptor item, StringBuilder builder) {
		if(getContainerProvider()!=null){
			builder.append(getContainerProvider().getHeader());
		}
		builder.append(
				String.format(formatString,
						FormFormatorHelper.getPrefixName(getPrefix(), item.getField()),
						isRequired()?required:"",
						item.getName(),
						FormFormatorHelper.getPrefixName(getPrefix(), item.getField())));
		if(getContainerProvider()!=null){
			builder.append(getContainerProvider().getTail());
		}
	}

}
