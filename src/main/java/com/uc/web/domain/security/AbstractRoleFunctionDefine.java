package com.uc.web.domain.security;

import com.uc.web.domain.Function;
import com.uc.web.domain.Role;

public abstract class AbstractRoleFunctionDefine 
	implements RoleFunctionDefine {
	
	private Role role;
	private Function function;

	@Override
	public Role getRole() {
		return role;
	}

	@Override
	public void setRole(Role role) {
		this.role=role;
		
	}

	@Override
	public Function getFunction() {
		return function;
	}

	@Override
	public void setFunction(Function func) {
		this.function=func;
		
	}
	
}
