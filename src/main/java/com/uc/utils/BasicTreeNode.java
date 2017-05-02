package com.uc.utils;

import java.util.ArrayList;
import java.util.List;

public class BasicTreeNode<TreeDataType extends Object> implements TreeNode<TreeDataType> {
	
	private TreeNode<TreeDataType> root;
	private TreeNode<TreeDataType> parent;
	private List<TreeNode<TreeDataType>> children;
	private TreeDataType data;
	
	public BasicTreeNode() {
		this(null);
	}
	
	public BasicTreeNode(TreeDataType data){
		children=new ArrayList<>();
		this.data=data;
	}

	@Override
	public TreeNode<TreeDataType> getRoot() {
		return root;
	}

	@Override
	public List<TreeNode<TreeDataType>> getChildren() {
		return children;
	}

	@Override
	public TreeNode<TreeDataType> getParent() {
		return parent;
	}

	@Override
	public void setParent(TreeNode<TreeDataType> parent) {
		this.parent=parent;
	}

	@Override
	public TreeDataType getData() {
		return data;
	}

	@Override
	public void setData(TreeDataType data) {
		this.data=data;
	}

	@Override
	public void addChild(TreeNode<TreeDataType> node) {
		if(node!=null){
			node.setParent(this);
			node.setRoot(this);
			getChildren().add(node);
		}
	}

	@Override
	public void removeChild(TreeNode<TreeDataType> node) {
		getChildren().remove(node);
	}

	@Override
	public void setRoot(TreeNode<TreeDataType> root) {
		this.root=root;
	}

	@Override
	public boolean hasChildren() {
		return getChildren().size()>0;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public boolean equals(Object obj) {
		if(obj==null) return false;		
		if(super.equals(obj)) return true;
		if(getClass().equals(obj.getClass())){
			TreeNode<TreeDataType> node=(TreeNode<TreeDataType>) obj;
			return equals(node);
		}
		return false;
	}
	
	public boolean equals(TreeNode<TreeDataType> other){
		if(other==null) return false;		
		if(getData()==null){
			if(other.getData()==null) return true;
			return false;
		}
		
		return getData().equals(other.getData());		
	}

	@Override
	public void getSubNodeData(boolean includeSlef, List<TreeDataType> reveiver) {		
		if(includeSlef){
			reveiver.add(getData());
		}
		for(TreeNode<TreeDataType> node:getChildren()){
			node.getSubNodeData(true, reveiver);
		}
	}
	
}
