package com.uc.web.domain;

import java.util.List;

import com.uc.utils.TreeNode;
import com.uc.utils.filter.IFilter;
import com.uc.web.domain.basic.NoParentFoundException;

public interface CodeTree<KeyType, TreeCodeType extends TreeCode<KeyType>> {
	public List<TreeCodeType> getList(IFilter<TreeCodeType> filter);
	public void getList(List<TreeCodeType> list, TreeNode<TreeCodeType> from, IFilter<TreeCodeType> filter);
	public List<TreeCodeType> getSubItemList(KeyType rootCode, int depth, boolean includeRoot);
	
	public List<TreeCodeType> getSubItemList(KeyType rootCode, int depth, IFilter<TreeCodeType> filter);
	
	public List<TreeCodeType> getSubItemList(KeyType id, IFilter<TreeCodeType> filter);

	public List<TreeCodeType> getSubItemList(KeyType id, boolean includeRoot);

	public TreeNode<TreeCodeType> findCode(TreeNode<TreeCodeType> from, KeyType code);
	public TreeNode<TreeCodeType> findCode(KeyType code);
	
	public TreeNode<TreeCodeType> findCode(TreeNode<TreeCodeType> from, IFilter<TreeCodeType> filter);
	public TreeNode<TreeCodeType> findCode(IFilter<TreeCodeType> filter);
	

	public void addCode(TreeCodeType code) throws NoParentFoundException;
}