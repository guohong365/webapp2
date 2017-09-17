package com.uc.web.domain;

import java.util.Collection;
import java.util.List;

public interface OrgnizationFunctions {
	
	public Orgnization getOrgnization();
	public void setOrgnization(Orgnization org);
	
	public List<Function> getFunctions();
	
	public void addFunction(Function func);
	public void addFunction(Collection<? extends Function> funs);
	public void removeFunction(Function func);
	public void removeAllFunction();
	
	public Function findFunction(Object funcId);
	
	
}
