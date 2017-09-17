package com.uc.web.domain;

import com.uc.utils.Tree;
import com.uc.utils.TreeNode;

public interface MenuTree extends Tree<Menu > {

	TreeNode<Menu> findItem(TreeNode<Menu> from, Object menuId);

	TreeNode<Menu> findItem(Object menuId);

	void addMenuItem(Menu item) throws NoParentFoundException;
	
}
