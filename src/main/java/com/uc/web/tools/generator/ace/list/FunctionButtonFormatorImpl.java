package com.uc.web.tools.generator.ace.list;

import org.springframework.util.StringUtils;

import com.uc.web.forms.ui.AbstractUIFormatorBase;
import com.uc.web.tools.generator.ButtonDescriptor;
import com.uc.web.tools.generator.ButtonFormator;

public class FunctionButtonFormatorImpl extends AbstractUIFormatorBase implements ButtonFormator {
	static final String BUTTON=
			"          <button class=\"btn btn-sm %s\" data-action=\"%s\" type=\"button\">" +
	        "            %s%s" +
			"          </button>";
	static final String ICON="<i class=\"ace-icon %s\"></i>";
	@Override
	public void formatHTML(ButtonDescriptor button, StringBuilder builder) {
		builder.append(String.format(BUTTON, 
				button.getClazz(),
				button.getAction(),
				StringUtils.isEmpty(button.getIcon())?"":String.format(ICON, button.getIcon()),
				button.getName()
				));	
		}

}
