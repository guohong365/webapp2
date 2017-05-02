package com.uc.web.forms;

import com.uc.web.forms.ui.componet.IPageCtrl;

public interface IWebForm<QueryType extends Object, DataType extends Object> {
	QueryType getQuery();
	void setQuery(QueryType query);
	DataType getData();
	void setData(DataType data);
	IPageCtrl getPageCtrl();
	void setPageCtrl(IPageCtrl pageCtrl);
	String getAction();
	void setAction(String action);
	String getOrderBy();
	void setOrderBy(String orderBy);	
}
