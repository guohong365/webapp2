package com.uc.web.forms.ui;

public class TreeView{
	private TreeViewNode root=new TreeViewNode();
	
	public TreeViewNode getRoot() {
		return root;
	}
	
	public void clear(){
		getRoot().getChildren().clear();
	}
	
	public TreeViewNode add(TreeViewNode item){
		return add(getRoot(), item);
	}
	
	public TreeViewNode add(String text, String tip, Object tag){
		return add(new TreeViewNode(text, tip, tag));
	}
	
	public TreeViewNode add(String text, String tip){
		return add(text, tip,null);
	}
	
	public TreeViewNode add(String text){
		return add(text, null, null);
	}
	
	public TreeViewNode add(TreeViewNode parent, String text){
		return add(parent, text, null, null);
	}
	
	public TreeViewNode add(TreeViewNode parent, String text, String tip){
		return add(parent, text, tip, null);
	}
	
	public TreeViewNode add(TreeViewNode parent, String text, String tip, Object tag){
		return add(parent, new TreeViewNode(text, tip, tag));
	}

	public TreeViewNode add(TreeViewNode parent, TreeViewNode item){
		if(item==null){
			return null;
		}
		item.setParent(parent);		
		item.setRoot(getRoot());
		if(parent==null){
			getRoot().add(item);
			return item;
		}
		parent.add(item);
		return item;
	}
	
	public void remove(TreeViewNode item){
		item.getParent().getChildren().remove(item);
	}
}
