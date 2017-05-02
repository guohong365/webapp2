package com.uc.utils;

public interface Tree<TreeDataType> {

	TreeNode<TreeDataType> getRoot();

	TreeNode<TreeDataType> addNode(TreeNode<TreeDataType> node, TreeNode<TreeDataType> parent);

	TreeNode<TreeDataType> removeNode(TreeNode<TreeDataType> node);

}