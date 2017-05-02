package com.uc.web.forms;

import com.uc.web.domain.Menu;

public interface MenuTreeItem<KeyType> extends Menu<KeyType> {
	String getIcon();
	void setIcon(String icon);
}
