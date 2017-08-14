package com.uc.web.forms.ui.ace;

import com.uc.web.forms.MenuTreeItem;
import com.uc.web.forms.ui.AbstractUIFormatorBase;
import com.uc.web.forms.ui.IUIFormator;
import com.uc.web.forms.ui.TreeViewNode;

public class AceSubMenuItemFormator extends AbstractUIFormatorBase implements IUIFormator<TreeViewNode>{
	private static final String format=
			"    <i class=\"menu-icon %s\"></i>" +
	        "    <span class=\"menu-text\">%s</span>" +
	        "    <b class=\"arrow fa fa-angle-down\"></b>" +
	        "  </a>" +
	        "  <b class=\"arrow\"></b>" +
	        "  <ul class=\"submenu\">";

	@Override
	public void formatHTML(TreeViewNode componet, StringBuilder builder){
		TreeViewNode node=componet;
			MenuTreeItem<?> menuItem=(MenuTreeItem<?>) node.getTag();
			builder.append(String.format(format, menuItem.getIcon(), menuItem.getName()));
	}
}
