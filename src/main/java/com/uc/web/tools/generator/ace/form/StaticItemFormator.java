package com.uc.web.tools.generator.ace.form;

import com.uc.web.tools.generator.FormFieldDescriptor;
import com.uc.web.tools.generator.utils.FormFormatorHelper;

public class StaticItemFormator extends ItemFormatorBase {
	String formatString=
			  "<label  class=\"control-label col-xs-12 col-sm-4\">%s：</label>"
			+ "<div class=\"col-xs-12 col-sm-8\" >"
			+ "  <p class=\"form-control-static blue\">${detailInput.%s}</p>"
			+ "</div>";
	@Override
	public void formatHTML(FormFieldDescriptor item, StringBuilder builder) {
		if(getContainerProvider()!=null){
			builder.append(getContainerProvider().getHeader());
		}
		builder.append(
				String.format(formatString,	item.getName(),
						FormFormatorHelper.getPrefixName(getPrefix(), item.getField())));
		if(getContainerProvider()!=null){
			builder.append(getContainerProvider().getTail());
		}
	}
}
