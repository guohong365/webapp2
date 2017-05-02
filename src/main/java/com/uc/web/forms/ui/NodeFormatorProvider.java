package com.uc.web.forms.ui;

public interface NodeFormatorProvider {
	IUIFormator<TreeViewNode> getFormator(TreeViewNode node);
}
