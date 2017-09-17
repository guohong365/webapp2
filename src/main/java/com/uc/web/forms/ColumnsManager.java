package com.uc.web.forms;

import java.util.List;

public interface ColumnsManager {
	List<ListColumn> getColumns();
	void show(String column);
	void hide(String column);
	void show(int index);
	void hide(int index);
	void setShowAll(boolean isShow);
	void setShowByFlagString(String showFlags);
	
}
