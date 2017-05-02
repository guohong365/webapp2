package com.uc.web.forms.ui.ace;

import com.uc.web.forms.ui.IUIFormator;
import com.uc.web.forms.ui.TreeViewNode;
import com.uc.web.forms.ui.NodeFormatorProvider;

public class AceTreeOptionFormatorProvider implements NodeFormatorProvider {
	private AceOptionFormator optionFormator=new AceOptionFormator();
	private AceOptionGroupFormator groupFormator=new AceOptionGroupFormator();

	@Override
	public IUIFormator<TreeViewNode> getFormator(TreeViewNode node) {
		return (node.getChildren().isEmpty()? optionFormator:groupFormator);
	}
}
