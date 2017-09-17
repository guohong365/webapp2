package com.uc.web.domain;

import java.util.List;

import com.uc.utils.TreeNode;
import com.uc.utils.filter.IFilter;

public interface CodeTree<TreeCodeType extends TreeCode> {
	public List<TreeCodeType> getList(IFilter<TreeCodeType> filter);
	public void getList(List<TreeCodeType> list, TreeNode<TreeCodeType> from, IFilter<TreeCodeType> filter);
	public List<TreeCodeType> getSubItemList(Object rootCode, int depth, boolean includeRoot);	
	public List<TreeCodeType> getSubItemList(Object rootCode, int depth, IFilter<TreeCodeType> filter);	
	public List<TreeCodeType> getSubItemList(Object id, IFilter<TreeCodeType> filter);
	public List<TreeCodeType> getSubItemList(Object id, boolean includeRoot);
	public TreeNode<TreeCodeType> findCode(TreeNode<TreeCodeType> from, Object code);
	public TreeNode<TreeCodeType> findCode(Object code);	
	public TreeNode<TreeCodeType> findCode(TreeNode<TreeCodeType> from, IFilter<TreeCodeType> filter);
	public TreeNode<TreeCodeType> findCode(IFilter<TreeCodeType> filter);
	public void addCode(TreeCodeType code) throws NoParentFoundException;
}