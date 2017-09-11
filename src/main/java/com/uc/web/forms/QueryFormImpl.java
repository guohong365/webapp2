package com.uc.web.forms;

import com.uc.web.domain.security.UserProfileBase;

public class QueryFormImpl<KeyType> extends ListQueryFormBase
	implements QueryForm<KeyType> {	
	
	public QueryFormImpl(){
		setQueryOrder("asc");
		buildOrderByColumnMap();
	}
	@SuppressWarnings("unchecked")
	@Override
	public UserProfileBase<KeyType> getUser() {
		if(super.getUser() instanceof UserProfileBase)
			return (UserProfileBase<KeyType>) super.getUser();
		return null;
	}

	protected void buildOrderByColumnMap(){		
	}	
}
