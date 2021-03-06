package com.uc.web.forms;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.util.StringUtils;

import com.uc.web.domain.EntityBase;
import com.uc.web.domain.security.UserProfile;

public class ListQueryFormImpl extends EntityBase implements ListQueryForm{

	private Map<String, String> columnMap = new HashedMap<>();
	private Boolean queryAll;	
	private String queryOrder;
	private String queryOrderBy;	
	private String queryOrderByClause;
	private String groupByClause;
	private UserProfile user;
	
	public ListQueryFormImpl() {
		queryOrder="ASC";
		buildOrderByColumnMap();
	}
	
	@Override
	public UserProfile getUser() {
		return user;
	}
	@Override
	public void setUser(UserProfile user) {
		this.user=user;
	}
	public Map<String, String> getColumnMap() {
		return columnMap;
	}
	@Override
	public String getGroupByClause() {
		return groupByClause;
	}
	@Override
	public void setGroupByClause(String groupByClause) {
		this.groupByClause=groupByClause;		
	}
	public Boolean getQueryAll() {
		return queryAll;
	}
	public void setQueryAll(Boolean queryAll) {
		this.queryAll = queryAll;
	}	
	@Override
	public String getQueryOrderByClause() {
		if(StringUtils.isEmpty(queryOrderByClause)){			
			String column=getQueryOrderColumn();
			String order=getQueryOrder();
			if(!StringUtils.isEmpty(column)){
				return column + (StringUtils.isEmpty(order) ? " asc" : " " + order);
			}
			return null;
		}
		return queryOrderByClause;
	}

	private String getQueryOrderColumn() {
		String column= getColumnMap().get(getQueryOrderBy());
		return column;
	}

	@Override
	public void setQueryOrderByClause(String queryOrderByClause) {
		this.queryOrderByClause = queryOrderByClause;
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
	public String getQueryOrder() {
		return queryOrder;
	}
	@Override
	public void setQueryOrder(String queryOrder) {
		this.queryOrder = queryOrder;
	}	
	protected void buildOrderByColumnMap() {
	}
}
