package com.uc.web.domain.security;

import com.uc.web.domain.Function;
import com.uc.web.domain.Role;

public abstract class AbstractRoleFunctionDefine<KeyType> 
	implements IRoleFunctionDefine<KeyType> {
	
	private Role<KeyType> role;
	private Function<KeyType> function;

	@Override
	public Role<KeyType> getRole() {
		return role;
	}

	@Override
	public void setRole(Role<KeyType> role) {
		this.role=role;
		
	}

	@Override
	public Function<KeyType> getFunction() {
		return function;
	}

	@Override
	public void setFunction(Function<KeyType> func) {
		this.function=func;
		
	}
	
}
