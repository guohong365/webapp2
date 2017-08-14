package com.uc.web.forms.ui;

public class TreeViewFormator extends AbstractUIFormatorBase implements IUIFormator<TreeView>{
	
	NodeFormatorProvider nodeFormatorProvider;
	

		
	public void setNodeFormatorProvider(NodeFormatorProvider nodeFormatorProvider) {
		this.nodeFormatorProvider = nodeFormatorProvider;
	}
	
	public NodeFormatorProvider getNodeFormatorProvider() {
		return nodeFormatorProvider;
	}
		
	
	@Override
	public void formatHTML(TreeView treeView,  StringBuilder builder) {
		if(getContainerProvider()!=null){
			builder.append(getContainerProvider().getHeader());
		}
		for(TreeViewNode node:treeView.getRoot().getChildren()){
			format(node, builder);
		}	
		if(getContainerProvider()!=null){
			builder.append(getContainerProvider().getTail());
		}
	}
	
	protected void format(TreeViewNode node, StringBuilder builder){
		IUIFormator<TreeViewNode> formator=nodeFormatorProvider.getFormator(node);
		
		ContainerProvider provider=formator==null ? getContainerProvider() : formator.getContainerProvider();
		if(provider!=null){
			builder.append(provider.getHeader());
		}
		if(formator!=null){
			formator.formatHTML(node, builder);		
		}
		for(TreeViewNode subitem:node.getChildren()){
			format(subitem, builder);
		}
		if(provider!=null){
			builder.append(provider.getTail());
		}
	}

}
