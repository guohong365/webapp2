package com.uc.web.domain;

public abstract class AbstractRole extends AbstractNamedObject implements Role{

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
