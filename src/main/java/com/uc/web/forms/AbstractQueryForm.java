package com.uc.web.forms;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.StringUtils;

import com.uc.web.domain.EntityBase;
import com.uc.web.domain.security.UserProfile;

public abstract class AbstractQueryForm<KeyType> extends EntityBase
	implements QueryForm<KeyType> {
	
	private String queryOrder;
	private String queryOrderBy;
	
	private String queryOrderByClause;
	
	private UserProfile<KeyType> queryUser;
	private Map<String, Object> queryLimits=new HashMap<String, Object>();
	private Map<String, String> orderByColumnMap;
	
	protected Map<String, String> getColumnMap(){
		return orderByColumnMap;
	}
	public AbstractQueryForm(){
		orderByColumnMap=new HashMap<String, String>();
		queryOrder="asc";
		buildOrderByColumnMap();
	}


	@Override
	public String getQueryOrder() {
		return queryOrder;
	}

	@Override
	public void setQueryOrder(String queryOrder) {
		this.queryOrder = queryOrder;
	}

	@Override
	public String getQueryOrderBy() {		
		return queryOrderBy;
	}

	@Override
	public void setQueryOrderBy(String queryOrderBy) {
		this.queryOrderBy = queryOrderBy;
	}

	@Override
	public UserProfile<KeyType> getQueryUser() {
		return queryUser;
	}

	@Override
	public void setQueryUser(UserProfile<KeyType> queryUser) {
		this.queryUser = queryUser;
	}
	
	protected String getQueryOrderColumn() {		
		return orderByColumnMap.get(getQueryOrderBy());
	}
	
	@Override
	public void setQueryOrderByClause(String orderByClause) {
		this.queryOrderByClause=orderByClause;	
	}

	@Override
	public String getQueryOrderByClause() {
		if(StringUtils.isEmpty(queryOrderByClause)){			
			String column=getQueryOrderColumn();
			String order=getQueryOrder();
			if(!StringUtils.isEmpty(column)){
				return column + ((order==null || order.isEmpty())? " asc" : " " + order);
			}
			return null;
		}
		return queryOrderByClause;
	}
	protected abstract void buildOrderByColumnMap();

	@Override
	public void addLimits(String name, Object item){
		queryLimits.put(name, item);
	}

	@Override
	public void addLimits(Map<String,? extends Object> map){
		queryLimits.putAll(map);
	}

	@Override
	public Object getLimits(String name){
		return queryLimits.get(name);
	}

	@Override
	public void clearLimits(){
		queryLimits.clear();
	}
}
