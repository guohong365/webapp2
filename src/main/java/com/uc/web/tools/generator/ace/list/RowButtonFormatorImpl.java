package com.uc.web.tools.generator.ace.list;

import org.springframework.util.StringUtils;

import com.uc.web.forms.ui.AbstractUIFormatorBase;
import com.uc.web.tools.generator.ButtonDescriptor;
import com.uc.web.tools.generator.ButtonFormator;
import com.uc.web.tools.generator.IdAccepter;

public class RowButtonFormatorImpl extends AbstractUIFormatorBase implements ButtonFormator, IdAccepter {
	private String id;

	String BUTTON = "<button data-original-title=\"%s\" data-rel=\"tooltip\" title=\"\" "
			+ "class=\"btn btn-xs %s\" data-action=\"%s\" data-item=\"${item.%s }\" type=\"button\">%s%s"
			+ "</button>";
	String ICON = "<i class=\"ace-icon %s bigger-120\"></i>";

	@Override
	public void formatHTML(ButtonDescriptor button, StringBuilder builder) {
		if (getContainerProvider() != null)
			builder.append(getContainerProvider().getHeader());
		builder.append(
				String.format(BUTTON, 
						button.getName(), 
						button.getClazz(),
						button.getAction(),
						getId(),
						StringUtils.isEmpty(button.getIcon()) ? "" : String.format(ICON, button.getIcon()),
						button.getName())
				);

		if (getContainerProvider() != null)
			builder.append(getContainerProvider().getTail());
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String idColum) {
		this.id = idColum;
	}

}
