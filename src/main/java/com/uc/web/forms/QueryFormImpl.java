package com.uc.web.forms;

import java.util.HashMap;
import java.util.Map;

import com.uc.web.domain.security.UserProfileBase;

public class QueryFormImpl<KeyType> extends ListQueryFormBase
	implements QueryForm<KeyType> {	
	private Map<String, Object> queryLimits=new HashMap<String, Object>();
	
	public QueryFormImpl(){
		setQueryOrder("asc");
		buildOrderByColumnMap();
	}
	@SuppressWarnings("unchecked")
	@Override
	public UserProfileBase<KeyType> getQueryUser() {
		if(getUser() instanceof UserProfileBase)
			return (UserProfileBase<KeyType>) getUser();
		return null;
	}


	protected void buildOrderByColumnMap(){		
	}

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
