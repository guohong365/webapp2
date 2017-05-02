package com.uc.web.domain;

import java.util.Collection;
import java.util.List;

public interface RoleFunctions<KeyType> {
	public Role<KeyType> getRole();
	public void setRole(Role<KeyType> role);
	
	public List<? extends Function<KeyType>> getFunctions();
	
	public void addFunction(Function<KeyType> func);
	public void addFunction(Collection<? extends Function<KeyType>> functions);
	
	public void removeFunction(Function<KeyType> func);
	public void removeAllFunction();
	
	public Function<KeyType> findFunction(KeyType key);
	
}
