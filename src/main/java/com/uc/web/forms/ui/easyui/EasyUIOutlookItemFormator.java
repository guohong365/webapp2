package com.uc.web.forms.ui.easyui;

import com.uc.web.forms.MenuTreeItem;
import com.uc.web.forms.ui.AbstractUIFormatorBase;
import com.uc.web.forms.ui.IUIFormator;
import com.uc.web.forms.ui.TreeViewNode;

public class EasyUIOutlookItemFormator extends AbstractUIFormatorBase implements IUIFormator<TreeViewNode> {
	private static final String format="<li><div><a href=\"javascript:void(0)\" data-rel=\"%s\" <span class=\"icon %s\" &nbsp;</span><span class=\"nav\">%s</span></a></div></li>";
	@Override
	public void formatHTML(TreeViewNode componet, StringBuilder builder){
			MenuTreeItem<?> item=(MenuTreeItem<?>) ((TreeViewNode)componet).getTag();
			builder.append(String.format(format, item.getUri(), item.getIcon(), item.getName()));
	}

}
