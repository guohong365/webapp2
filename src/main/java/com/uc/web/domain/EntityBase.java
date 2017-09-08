package com.uc.web.domain;

import com.uc.utils.ObjectPropertyFormator;

public abstract class EntityBase implements Cloneable{
	@Override
	public String toString() {
		return ObjectPropertyFormator.format(this, "", true, false, false);
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	public String toString(boolean withClassName, boolean flat, boolean singleLinePerValue){
		return ObjectPropertyFormator.format(this, "", flat, withClassName, singleLinePerValue);
	}
	
}
