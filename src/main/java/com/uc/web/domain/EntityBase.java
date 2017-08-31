package com.uc.web.domain;

import com.uc.utils.ObjectPropertyFormator;

public abstract class EntityBase implements Cloneable{
	@Override
	public String toString() {
		return ObjectPropertyFormator.format(this);
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
