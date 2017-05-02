package com.uc.web.forms;

import java.io.Serializable;
import java.util.Collection;

public interface ColumnsController extends Serializable {
	Collection<Column> getColumns();
	void show(String column);
	void hide(String column);
	void show(int index);
	void hide(int index);
	void showAll(boolean isShow);
	Column[] toArray();
	
}
