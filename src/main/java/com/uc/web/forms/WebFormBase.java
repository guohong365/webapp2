package com.uc.web.forms;

import com.uc.web.forms.ui.componet.IPageCtrl;
import com.uc.web.forms.ui.componet.PageCtrl;

public class WebFormBase<
	QueryType extends Object, 
	DataType extends Object> 
	implements IWebForm<QueryType, DataType> {
	private DataType data;
	private String action;
	private IPageCtrl pageCtrl;
	private QueryType query;
	private String orderBy;
	public String getOrderBy() {
		return orderBy;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder
		.append("WebForm:")
		.append("data=").append(data)
		.append("action=").append(action)
		.append("pageCtrl=").append(pageCtrl)
		.append("query=")
		.append(query);
		return builder.toString();
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public QueryType getQuery() {
		return query;
	}
	public void setQuery(QueryType query) {
		this.query = query;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public IPageCtrl getPageCtrl() {
		return pageCtrl;
	}
	public void setPageCtrl(IPageCtrl pageCtrl) {
		this.pageCtrl = pageCtrl;
	}
	
	public WebFormBase(){
		action="";
		pageCtrl=new PageCtrl();
	}
	
	public WebFormBase(String action){
		this();
		this.action=action;
	}
	
	public WebFormBase(String action, IPageCtrl pageCtrl){
		this.action=action;
		this.pageCtrl=pageCtrl;
	}
	public DataType getData(){
		return this.data;
	}
	public void setData(DataType records){
		this.data=records;
	}

}
