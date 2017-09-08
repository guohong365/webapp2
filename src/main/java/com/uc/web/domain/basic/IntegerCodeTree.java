package com.uc.web.domain.basic;

import java.util.ArrayList;
import java.util.List;

import com.uc.utils.BasicTreeNode;
import com.uc.utils.TreeImpl;
import com.uc.utils.TreeNode;
import com.uc.utils.filter.IFilter;
import com.uc.web.domain.CodeTree;

public class IntegerCodeTree<TreeCodeType extends IntegerTreeCode> extends TreeImpl<TreeCodeType> implements CodeTree<Long, TreeCodeType> {

	public List<TreeCodeType> getList(IFilter<TreeCodeType> filter){
		List<TreeCodeType> list=new ArrayList<>();
		getList(list, getRoot(), filter);
		return list;
	}
	
	public void getList(List<TreeCodeType> list, TreeNode<TreeCodeType> from, IFilter<TreeCodeType> filter){
		if(from==null) return;
		if(from.getData()!=null &&(filter==null || filter.filter(from.getData())))
			list.add(from.getData());
		for(TreeNode<TreeCodeType> item:from.getChildren()){
			getList(list, item, filter);
		}
	}
	
	@Override
	public List<TreeCodeType> getSubItemList(Long rootCode, int depth, boolean includeRoot) {
		List<TreeCodeType> list=new ArrayList<>();
		TreeNode<TreeCodeType> from=findCode(getRoot(), rootCode);
		if(from!=null){
			if(includeRoot && from.getData()!=null) list.add(from.getData());
			if(depth>0){
				for(TreeNode<TreeCodeType> next: from.getChildren()){
					getSubItemToList(next, list, depth-1);				
				}
			}
			
		}		
		return list;
	}
	
	@Override
	public List<TreeCodeType> getSubItemList(Long rootCode, int depth, IFilter<TreeCodeType> filter) {		
		List<TreeCodeType> list=new ArrayList<>();
		TreeNode<TreeCodeType> from=findCode(getRoot(), rootCode);
		if(from!=null){
			if(filter.filter(from.getData())) list.add(from.getData());
			if(depth>0){
				for(TreeNode<TreeCodeType> next: from.getChildren()){
					getSubItemToList(next, list, depth-1, filter);				
				}
			}
			
		}		
		return list;
	}
	
	@Override
	public List<TreeCodeType> getSubItemList(Long id, boolean includeRoot){
		List<TreeCodeType> list=new ArrayList<>();
		TreeNode<TreeCodeType> rootItem;
		if(id==null) return list;

		rootItem=findCode(getRoot(), id);
		if(rootItem==null || rootItem.getData()==null){ //not found
				return list;
		}
		if(includeRoot){
			list.add(rootItem.getData());
		}
		for(TreeNode<TreeCodeType> item:rootItem.getChildren()){
			getSubItemList(item, list);
		}
		return list;		
	}
	
	@Override
	public List<TreeCodeType> getSubItemList(Long id, IFilter<TreeCodeType> filter) {
		List<TreeCodeType> list=new ArrayList<>();
		TreeNode<TreeCodeType> rootItem;
		
		rootItem = id==null ? getRoot() : findCode(id);
		if(rootItem==null || rootItem.getData()==null){ //not found
				return list;
		}
		if(filter.filter(rootItem.getData())){
			list.add(rootItem.getData());
		}
		for(TreeNode<TreeCodeType> item:rootItem.getChildren()){
			getSubItemList(item, list, filter);
		}
		return list;	
	}
	
	public void getSubItemList(TreeNode<TreeCodeType> rootItem, List<TreeCodeType> list){
		if(rootItem==null || rootItem.getData()==null){
			return;
		}
		list.add(rootItem.getData());
		for(TreeNode<TreeCodeType> item:rootItem.getChildren()){
				getSubItemList(item, list);
		}
	}
	
	public void getSubItemList(TreeNode<TreeCodeType> rootItem, List<TreeCodeType> list, IFilter<TreeCodeType> filter){
		if(rootItem==null || rootItem.getData()==null){
			return;
		}
		if(filter.filter(rootItem.getData())){
			list.add(rootItem.getData());
			for(TreeNode<TreeCodeType> item:rootItem.getChildren()){
				getSubItemList(item, list, filter);
			}
		}
	}
	
	protected void getSubItemToList(TreeNode<TreeCodeType> from, List<TreeCodeType> list, int depth) {		
		list.add(from.getData());
		if(depth==0) return;
		for(TreeNode<TreeCodeType> child: from.getChildren()){
			getSubItemToList(child, list, depth-1);
		}
	}
	
	protected void getSubItemToList(TreeNode<TreeCodeType> from, List<TreeCodeType> list, int depth, IFilter<TreeCodeType> filter) {
		
		if(!filter.filter(from.getData())) return;
		
		list.add(from.getData());
		
		if(depth==0) return;
		
		for(TreeNode<TreeCodeType> child: from.getChildren()){
			getSubItemToList(child, list, depth-1);
		}
	}
	
	

	public TreeNode<TreeCodeType> findCode(TreeNode<TreeCodeType> from, Long code){
		TreeNode<TreeCodeType> node;
		if(from==null || code==null) return null;
		if(from.getData()!=null && from.getData().getCode().equals(code)) return from;
		
		for (TreeNode<TreeCodeType> item : from.getChildren()) {
			if(item.getData()!=null && item.getData().getCode().equals(code))
				return item;
			node=findCode(item, code);
			if(node!=null) return node;
		}
		return null;
	}

	@Override
	public TreeNode<TreeCodeType> findCode(Long code) {
		return findCode(getRoot(), code);
	}
	
	@Override
	public void addCode(TreeCodeType code) throws NoParentFoundException{
		if (code==null) return;
		if(code.getParent()==null){
			getRoot().addChild(new BasicTreeNode<>(code));
			return;
		}
		TreeNode<TreeCodeType> parent=findCode(code.getParent());
		if(parent!=null){
			parent.addChild(new BasicTreeNode<>(code));
			return;
		}
		throw new NoParentFoundException("" + code.getParent());
	}
	
	public static IntegerCode getIntegerCodeFromTreeCode(IntegerTreeCode treeCode){
		IntegerCode integerCode=new IntegerCode(treeCode.getCode(),treeCode.getValue(), treeCode.getValid());
		return integerCode;
	}
	
	public List<IntegerCode> getSubCodes(Long rootCode, boolean includeRoot, boolean isAll, Long excludedId){
		List<IntegerCode> list=new ArrayList<>();
		TreeNode<TreeCodeType> root=rootCode==null? getRoot() : findCode(rootCode);
		if(root==null) return list;
		
		getSubCodes(root, includeRoot, isAll, excludedId, list);
				
		return list;
	}	
	
	public void getSubCodes(TreeNode<TreeCodeType> root, boolean includeRoot, boolean isAll, Long excludedId, List<IntegerCode> list){
		if(includeRoot){
			IntegerTreeCode rootCode= root.getData();
		
			if(rootCode.getCode().equals(excludedId)){
				return;
			}
			
			if(rootCode.getValid() || isAll){
				list.add(getIntegerCodeFromTreeCode(rootCode));
			}
		}
		for (TreeNode<TreeCodeType> node : root.getChildren()) {
			getSubCodes(node, true, isAll, excludedId, list);
		}		
	}
	
	protected void dump(StringBuilder builder, TreeNode<TreeCodeType> item, int level){
		for(int i=0; i< level; i++){
			builder.append(' ');
		}
		TreeCodeType treeCode=item.getData();
		builder.append(treeCode.getCode())
			.append(' ')
			.append(treeCode.getValue())
			.append(' ')
			.append(treeCode.getValid().toString())
			.append("\n");
		for(TreeNode<TreeCodeType> child:item.getChildren()){
			dump(builder, child, level + 1);
		}
	}
	
	public String getStringTree(){
		StringBuilder builder=new StringBuilder();
		for(TreeNode<TreeCodeType> child: getRoot().getChildren()){
			dump(builder, child, 0);
		}
		return builder.toString();
	}

	@Override
	public TreeNode<TreeCodeType> findCode(TreeNode<TreeCodeType> from, IFilter<TreeCodeType> filter) {
		TreeNode<TreeCodeType> node;
		if(from==null) return null;
		if(filter.filter(from.getData())) return from;
		
		for (TreeNode<TreeCodeType> item : from.getChildren()) {
			if(filter.filter(item.getData()))
				return item;
			node=findCode(item, filter);
			if(node!=null) return node;
		}
		return null;
	}

	@Override
	public TreeNode<TreeCodeType> findCode(IFilter<TreeCodeType> filter) {
		return findCode(getRoot(), filter);
	}


}
