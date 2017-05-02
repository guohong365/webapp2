package com.uc.web.domain;

public interface Role<KeyType> extends NamedObjct<KeyType> {
	public Boolean getInternal();
	public void setInternal(Boolean internal);
}
