package com.uc.utils;

import java.util.List;

public interface TreeNode<TreeDataType extends Object> {
	public TreeNode<TreeDataType> getRoot();
	public void setRoot(TreeNode<TreeDataType> root);
	public List<TreeNode<TreeDataType>> getChildren();
	public TreeNode<TreeDataType> getParent();
	public void setParent(TreeNode<TreeDataType> parent);
	public TreeDataType getData();
	public void setData(TreeDataType data);
	
	public void addChild(TreeNode<TreeDataType> node);	
	public void removeChild(TreeNode<TreeDataType> node);
	
	public boolean hasChildren();
	
	public void getSubNodeData(boolean includeSlef, List<TreeDataType> reveiver);
		
}
