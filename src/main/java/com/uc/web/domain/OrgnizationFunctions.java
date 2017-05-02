package com.uc.web.domain;

import java.util.Collection;
import java.util.List;

public interface OrgnizationFunctions<KeyType> {
	
	public Orgnization<KeyType> getOrgnization();
	public void setOrgnization(Orgnization<KeyType> org);
	
	public List<Function<KeyType>> getFunctions();
	
	public void addFunction(Function<KeyType> func);
	public void addFunction(Collection<? extends Function<KeyType>> funs);
	public void removeFunction(Function<KeyType> func);
	public void removeAllFunction();
	
	public Function<KeyType> findFunction(KeyType funcId);
	
	
}
