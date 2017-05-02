package com.uc.web.forms.ui.ace;

import com.uc.web.forms.ui.ContainerProvider;
import com.uc.web.forms.ui.IUIFormator;
import com.uc.web.forms.ui.TreeViewNode;

public class AceOptionGroupFormator implements ContainerProvider, IUIFormator<TreeViewNode> {
    static final String OPT_GROUP_HEADER="<optgroup ";
    static final String OPT_GROUP_TAIL="</optgroup>";
	@Override
	public String getHeader() {
		return OPT_GROUP_HEADER;
	}

	@Override
	public String getTail() {
		return OPT_GROUP_TAIL;
	}

	@Override
	public ContainerProvider getContainerProvider() {
		return this;
	}

	@Override
	public void setContainerProvider(ContainerProvider provider) {
	}

	@Override
	public void formatHTML(TreeViewNode componet, StringBuilder builder){
		TreeViewNode node=(TreeViewNode) componet;
		builder.append("label=\"").append(node.getText()).append("\"");
		if(node.isDisabled()){
			builder.append(" disabled=\"disabled\"");
		}
		builder.append(">");
	}

}
