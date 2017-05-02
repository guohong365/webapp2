package com.uc.utils;

public class TreeImpl<TreeDataType> implements Tree<TreeDataType> {	
  private TreeNode<TreeDataType> rootNode;
  
  public TreeImpl() {
	rootNode=new BasicTreeNode<>();
}
  
  /* (non-Javadoc)
 * @see com.uc.utils.ITree#getRoot()
 */
@Override
public TreeNode<TreeDataType> getRoot(){
	  return rootNode;
  }
  
  /* (non-Javadoc)
 * @see com.uc.utils.ITree#addNode(com.uc.utils.ITreeNode, com.uc.utils.ITreeNode)
 */
@Override
public TreeNode<TreeDataType> addNode(TreeNode<TreeDataType> node, TreeNode<TreeDataType> parent){
	  if(parent==null){
		  getRoot().addChild(node);
	  } else {
		  parent.addChild(node);
	  }
	  return parent;
  }
  
  protected TreeNode<TreeDataType> findNode(TreeNode<TreeDataType> root, TreeNode<TreeDataType> node){
	  if(root==null || node==null) return null;
	  if(root.equals(node)){
		  return root;
	  }
	  for (TreeNode<TreeDataType> item : root.getChildren()) {
		  if(item.equals(node)) return node;
		  TreeNode<TreeDataType> target=findNode(item, node);
		  if(target!=null) return target;
	  }		
	  return null;
  }
  
  
  /* (non-Javadoc)
 * @see com.uc.utils.ITree#removeNode(com.uc.utils.ITreeNode)
 */
@Override
public TreeNode<TreeDataType> removeNode(TreeNode<TreeDataType> node){
	  if(node.getParent()!=null){
		  node.getParent().removeChild(node);
		  node.setParent(null);
		  return node;
	  }
	  return null;
  }
  
}
