package com.uc.web.domain;

public abstract class AbstractOrgnization extends AbstractTreeNamedObject implements Orgnization {
	private Object parent;

	@Override
	public Object getParent() {
		return parent;
	}

	@Override
	public void setParent(Object parent) {
		this.parent = parent;
	}
}
