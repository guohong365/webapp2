package com.uc.web.forms.ui.ace;

import com.uc.web.forms.MenuTreeItem;
import com.uc.web.forms.ui.AbstractUIFormatorBase;
import com.uc.web.forms.ui.IUIFormator;
import com.uc.web.forms.ui.TreeViewNode;

public class AceMenuItemFormator extends AbstractUIFormatorBase implements IUIFormator<TreeViewNode> {
	static final String MENUITEM=
			  "<li>"
			+ "  <a href=\"#%s\" data-url=\"%s\">"
			+ "    <i class=\"ace-icon %s\"></i>"
			+ "    <span class=\"menu-text\">%s</span>"
			+ "  </a>"
			+ "  <b class=\"arrow\"></b>"
			+ "</li>";

	@Override
	public void formatHTML(TreeViewNode componet,  StringBuilder builder) {
		MenuTreeItem item=(MenuTreeItem) componet.getTag();
		builder.append(String.format(MENUITEM, item.getUri(), item.getUri(), item.getIcon(), item.getName()));
	}
}
