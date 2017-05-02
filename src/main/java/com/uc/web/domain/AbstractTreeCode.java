package com.uc.web.domain;

public class AbstractTreeCode<KeyType> extends AbstractCode<KeyType> implements TreeCode<KeyType>{
	private KeyType parent;
	
	public KeyType getParent() {
		return parent;
	}
	
	public void setParent(KeyType parent) {
		this.parent = parent;
	}
}
