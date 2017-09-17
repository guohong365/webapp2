package com.uc.web.domain;

public class TreeCodeImpl extends CodeImpl implements TreeCode{
	private Object parent;
	
	public Object getParent() {
		return parent;
	}
	
	public void setParent(Object parent) {
		this.parent = parent;
	}
}
