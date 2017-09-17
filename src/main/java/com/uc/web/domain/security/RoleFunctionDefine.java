package com.uc.web.domain.security;

import com.uc.web.domain.Function;
import com.uc.web.domain.Role;

public interface RoleFunctionDefine {	
	public Role getRole();
	public void setRole(Role role);	
	Function getFunction();	
	void setFunction(Function func);
	
}
