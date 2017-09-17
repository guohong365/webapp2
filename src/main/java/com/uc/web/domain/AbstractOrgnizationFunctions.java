package com.uc.web.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class AbstractOrgnizationFunctions implements OrgnizationFunctions {
	
	private Orgnization orgnization;
	private List<Function> functions=new ArrayList<>();

	@Override
	public Orgnization getOrgnization() {
		return orgnization;
	}

	@Override
	public void setOrgnization(Orgnization org) {
		orgnization=org;
	}

	@Override
	public List<Function> getFunctions() {
		return functions;
	}

	@Override
	public void addFunction(Function func) {
		functions.add(func);
		
	}

	@Override
	public void addFunction(Collection<? extends Function> funcs) {
		functions.addAll(funcs);		
	}

	@Override
	public void removeFunction(Function func) {
		functions.remove(func);
	}

	@Override
	public void removeAllFunction() {
		functions.clear();
	}

	@Override
	public Function findFunction(Object funcId) {
		for (Function iFunction : functions) {
			if(iFunction.getId().equals(funcId)){
				return iFunction;
			}				
		}
		return null;
	}


}
