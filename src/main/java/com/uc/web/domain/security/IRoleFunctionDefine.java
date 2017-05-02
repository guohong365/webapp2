package com.uc.web.domain.security;

import com.uc.web.domain.Function;
import com.uc.web.domain.Role;

public interface IRoleFunctionDefine<KeyType> {
	
	public Role<KeyType> getRole();
	public void setRole(Role<KeyType> role);
	
	Function<KeyType> getFunction();	
	void setFunction(Function<KeyType> func);
	
}
