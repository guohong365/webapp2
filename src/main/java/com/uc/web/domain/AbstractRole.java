package com.uc.web.domain;

public abstract class AbstractRole<KeyType> extends AbstractNamedObject<KeyType> implements Role<KeyType>{

	private Boolean internal;

	@Override
	public Boolean getInternal() {
		return internal;
	}
	@Override
	public void setInternal(Boolean internal) {
		this.internal = internal;
	}
}
