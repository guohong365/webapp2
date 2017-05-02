package com.uc.web.forms.ui.easyui;

import com.uc.web.forms.MenuTreeItem;
import com.uc.web.forms.ui.AbstractUIFormatorBase;
import com.uc.web.forms.ui.IUIFormator;
import com.uc.web.forms.ui.TreeViewNode;

public class EasyUIOutlookGroupFormator extends AbstractUIFormatorBase implements IUIFormator<TreeViewNode> {

	@Override
	public void formatHTML(TreeViewNode componet, StringBuilder builder) {
		TreeViewNode node=(TreeViewNode) componet;
			MenuTreeItem<?> menuItem=(MenuTreeItem<?>) node.getTag();
			builder.append(String.format(
						"<div title=\"%s\" data-options=\"iconCls:'%s'\" style=\"overflow:auto;padding:10px;\"><ul>", 
						menuItem.getName(), menuItem.getIcon()));
	}

}
