package com.uc.web.domain;

import java.util.Collection;
import java.util.List;

public interface RoleFunctions {
	public Role getRole();
	public void setRole(Role role);
	
	public List<? extends Function> getFunctions();
	
	public void addFunction(Function func);
	public void addFunction(Collection<? extends Function> functions);
	
	public void removeFunction(Function func);
	public void removeAllFunction();
	
	public Function findFunction(Object key);
	
}
