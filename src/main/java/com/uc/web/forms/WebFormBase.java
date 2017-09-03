package com.uc.web.forms;

public class WebFormBase<QueryType,	DataType extends Object> implements WebForm<QueryType, DataType> {
	private DataType data;
	private String action;
	private QueryType query;

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder
		.append("WebForm:")
		.append("data=").append(data)
		.append("action=").append(action)
		.append("query=").append(query);
		return builder.toString();
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
	
	public WebFormBase(){
		action="";
	}
	
	public WebFormBase(String action){
		this();
		this.action=action;
	}
	
	public DataType getData(){
		return this.data;
	}
	public void setData(DataType record){
		this.data=record;
	}

}
