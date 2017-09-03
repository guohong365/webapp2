package com.uc.web.forms;

import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.util.StringUtils;

import com.uc.web.domain.security.UserProfile;
import com.uc.web.forms.ui.componet.PageCtrl;
import com.uc.web.forms.ui.componet.PageCtrlImpl;

public class ListQueryFormBase implements ListQueryForm{
	
	private PageCtrl pageCtrl = new PageCtrlImpl();
	private Map<String, String> columnMap = new HashedMap<>();
	private UserProfile user;
	private Boolean queryAll;	
	private String queryOrder;
	private String queryOrderBy;	
	private String queryOrderByClause;
	@Override
	public PageCtrl getPageCtrl() {
		return pageCtrl;
	}
	
	@Override
	public Map<String, String> getColumnMap() {
		return columnMap;
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
		return getColumnMap().containsKey(getQueryOrderBy()) ? getColumnMap().get(getQueryOrderBy()) : null;
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

	@Override
	public UserProfile getUser() {
		return user;
	}

	@Override
	public void setUser(UserProfile user) {
		this.user=user;
	}

}
