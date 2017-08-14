package com.uc.web.forms.ui;

import java.util.ArrayList;
import java.util.List;

public class TreeViewNode {
	private String text;
	private String tip;
	private boolean disabled;
	private Object tag;
	private List<TreeViewNode> children=new ArrayList<>();
	private TreeViewNode parent;
	private TreeViewNode root;
	
	public TreeViewNode() {		
	}
	
	public TreeViewNode(String text){
		this(text, null, null);
	}
	
	public TreeViewNode(String text, String tip){
		this(text, tip, null);
	}
	
	public TreeViewNode(String text, String tip, Object tag){
		this.text=text;
		this.tip=tip;
		this.tag=tag;
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public Object getTag() {
		return tag;
	}

	public void setTag(Object tag) {
		this.tag = tag;
	}

	public List<TreeViewNode> getChildren() {
		return children;
	}

	public void setChildren(List<TreeViewNode> children) {
		this.children = children;
	}

	public TreeViewNode getParent() {
		return parent;
	}

	public void setParent(TreeViewNode parent) {
		this.parent = parent;
	}

	public TreeViewNode getRoot() {
		return root;
	}

	public void setRoot(TreeViewNode root) {
		this.root = root;
	}

	public void add(TreeViewNode node){
		node.setParent(this);
		getChildren().add(node);
	}
	
	public void remove(TreeViewNode node){
		getChildren().remove(node);
		node.setParent(null);
		node.setRoot(null);
	}


	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}
}
