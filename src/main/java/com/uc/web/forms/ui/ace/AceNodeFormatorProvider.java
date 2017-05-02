package com.uc.web.forms.ui.ace;

import com.uc.web.forms.ui.IUIFormator;
import com.uc.web.forms.ui.TreeViewNode;
import com.uc.web.forms.ui.NodeFormatorProvider;

public class AceNodeFormatorProvider implements NodeFormatorProvider {
	
	IUIFormator<TreeViewNode> topMenuItemFormator;
	IUIFormator<TreeViewNode> subMenuItemFormator;
	IUIFormator<TreeViewNode> leafMenuItemFormator;
	
	public IUIFormator<TreeViewNode> getTopMenuItemFormator() {
		return topMenuItemFormator;
	}
	public void setTopMenuItemFormator(IUIFormator<TreeViewNode> topMenuItemFormator) {
		this.topMenuItemFormator = topMenuItemFormator;
	}
	
	public IUIFormator<TreeViewNode> getSubMenuItemFormator() {
		return subMenuItemFormator;
	}
	public void setSubMenuItemFormator(IUIFormator<TreeViewNode> subMenuItemFormator) {
		this.subMenuItemFormator = subMenuItemFormator;
	}
	public IUIFormator<TreeViewNode> getLeafMenuItemFormator() {
		return leafMenuItemFormator;
	}
	public void setLeafMenuItemFormator(IUIFormator<TreeViewNode> leafMenuItemFormator) {
		this.leafMenuItemFormator = leafMenuItemFormator;
	}
	
	@Override
	public IUIFormator<TreeViewNode> getFormator(TreeViewNode node) {
		if(isLeafNode(node)){
			return getLeafMenuItemFormator();
		}
		if(isMiddleNode(node)){
			return getSubMenuItemFormator();
		}
		if(isTopNode(node)){
			return getTopMenuItemFormator();
		}
		return null;
	}

	private boolean isTopNode(TreeViewNode node) {
		return node.getParent().equals(node.getRoot());
	}
	
	private boolean isMiddleNode(TreeViewNode node){
		return !node.getParent().equals(node.getRoot()) && !node.getChildren().isEmpty();
	}
	
	private boolean isLeafNode(TreeViewNode node){
		return node.getChildren().isEmpty();
	}
	
	
	
	

}
