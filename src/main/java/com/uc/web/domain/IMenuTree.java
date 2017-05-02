package com.uc.web.domain;

import com.uc.utils.Tree;
import com.uc.utils.TreeNode;
import com.uc.web.domain.basic.NoParentFoundException;

public interface IMenuTree<KeyType, MenuItemType extends Menu<KeyType>> extends Tree<MenuItemType > {

	TreeNode<MenuItemType> findItem(TreeNode<MenuItemType> from, KeyType menuId);

	TreeNode<MenuItemType> findItem(KeyType menuId);

	void addMenuItem(MenuItemType item) throws NoParentFoundException;
	
}
