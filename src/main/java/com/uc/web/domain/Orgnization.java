package com.uc.web.domain;

public interface Orgnization<KeyType> extends NamedObjct<KeyType> {
	public KeyType getParent();
	public void setParent(KeyType parent);
}
