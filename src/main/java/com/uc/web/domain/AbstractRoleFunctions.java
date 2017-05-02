package com.uc.web.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class AbstractRoleFunctions<KeyType> implements RoleFunctions<KeyType> {
	@Override
	public void addFunction(Function<KeyType> func) {
		functions.add(func);
	}
	@Override
	public void addFunction(Collection<? extends Function<KeyType>> functions) {
		this.functions.addAll(functions);
	}
	@Override
	public void removeFunction(Function<KeyType> func) {
		this.functions.remove(func);
	}
	@Override
	public void removeAllFunction() {
		this.functions.clear();
	}
	@Override
	public Function<KeyType> findFunction(KeyType key) {
		for (Function<KeyType> iFunction : functions) {
			if(iFunction.getId().equals(key)){
				return iFunction;
			}
		}
		return null;
	}
	
	private Role<KeyType> role;
	private List<Function<KeyType>> functions=new ArrayList<>();
	
	public Role<KeyType> getRole() {
		return role;
	}
	public void setRole(Role<KeyType> role) {
		this.role = role;
	}
	public List<Function<KeyType>> getFunctions() {
		return functions;
	}

}
