package com.uc.web.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class AbstractOrgnizationFunctions<KeyType> implements OrgnizationFunctions<KeyType> {
	
	private Orgnization<KeyType> orgnization;
	private List<Function<KeyType>> functions=new ArrayList<>();

	@Override
	public Orgnization<KeyType> getOrgnization() {
		return orgnization;
	}

	@Override
	public void setOrgnization(Orgnization<KeyType> org) {
		orgnization=org;
	}

	@Override
	public List<Function<KeyType>> getFunctions() {
		return functions;
	}

	@Override
	public void addFunction(Function<KeyType> func) {
		functions.add(func);
		
	}

	@Override
	public void addFunction(Collection<? extends Function<KeyType>> funcs) {
		functions.addAll(funcs);		
	}

	@Override
	public void removeFunction(Function<KeyType> func) {
		functions.remove(func);
	}

	@Override
	public void removeAllFunction() {
		functions.clear();
	}

	@Override
	public Function<KeyType> findFunction(KeyType funcId) {
		for (Function<KeyType> iFunction : functions) {
			if(iFunction.getId().equals(funcId)){
				return iFunction;
			}				
		}
		return null;
	}


}
