package com.uc.web.forms.ui.easyui;

import com.uc.web.forms.ui.IUIFormator;
import com.uc.web.forms.ui.TreeViewNode;
import com.uc.web.forms.ui.NodeFormatorProvider;

public class EasyUIOutlookNodeFormatorProvider implements NodeFormatorProvider {
	
	IUIFormator<TreeViewNode> groupFormator;
	IUIFormator<TreeViewNode> itemFormator;
	
	public IUIFormator<TreeViewNode> getGroupFormator() {
		return groupFormator;
	}
	public void setGroupFormator(IUIFormator<TreeViewNode> groupFormator) {
		this.groupFormator = groupFormator;
	}
	
	public IUIFormator<TreeViewNode> getItemFormator() {
		return itemFormator;
	}
	public void setItemFormator(IUIFormator<TreeViewNode> itemFormator) {
		this.itemFormator = itemFormator;
	}
	
	boolean isGroup(TreeViewNode node){
		return node.getParent().equals(node.getRoot());
	}

	@Override
	public IUIFormator<TreeViewNode> getFormator(TreeViewNode node) {
		if(isGroup(node)){
			return getGroupFormator();
		}
		return getItemFormator();
	}

}
