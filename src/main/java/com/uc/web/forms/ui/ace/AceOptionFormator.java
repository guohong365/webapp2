package com.uc.web.forms.ui.ace;

import com.uc.web.forms.ui.ContainerProvider;
import com.uc.web.forms.ui.IUIFormator;
import com.uc.web.forms.ui.TreeViewNode;

public class AceOptionFormator implements ContainerProvider, IUIFormator<TreeViewNode> {
	static final String OPT_ITEM_HEADER="<option ";
	static final String OPT_ITEM_TAIL="</option>";
	
	@Override
	public ContainerProvider getContainerProvider() {
		return this;
	}

	@Override
	public void setContainerProvider(ContainerProvider provider) {
	}

	@Override
	public void formatHTML(TreeViewNode componet,  StringBuilder builder) {
		builder.append("value=\"").append(componet.getTag()).append("\"");
		if(componet.isDisabled()){
			builder.append(" disabled=\"disabled\"");
		}
		builder.append(">").append(componet.getText());
	}

	@Override
	public String getHeader() {
		return OPT_ITEM_HEADER;
	}

	@Override
	public String getTail() {
		return OPT_ITEM_TAIL;
	}

}
