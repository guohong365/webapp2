package com.uc.web.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class AbstractRoleFunctions implements RoleFunctions {
	@Override
	public void addFunction(Function func) {
		functions.add(func);
	}
	@Override
	public void addFunction(Collection<? extends Function> functions) {
		this.functions.addAll(functions);
	}
	@Override
	public void removeFunction(Function func) {
		this.functions.remove(func);
	}
	@Override
	public void removeAllFunction() {
		this.functions.clear();
	}
	@Override
	public Function findFunction(Object key) {
		for (Function iFunction : functions) {
			if(iFunction.getId().equals(key)){
				return iFunction;
			}
		}
		return null;
	}
	
	private Role role;
	private List<Function> functions=new ArrayList<>();
	
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public List<Function> getFunctions() {
		return functions;
	}

}
