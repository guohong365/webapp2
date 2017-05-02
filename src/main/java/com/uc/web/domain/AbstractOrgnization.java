package com.uc.web.domain;

public abstract class AbstractOrgnization<KeyType> extends AbstractNamedObject<KeyType> implements Orgnization<KeyType> {
	private KeyType parent;

	@Override
	public KeyType getParent() {
		return parent;
	}

	@Override
	public void setParent(KeyType parent) {
		this.parent = parent;
	}
}
