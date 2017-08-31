package com.uc.web.domain;

public interface NamedObjct<KeyType> extends WithId<KeyType> {
	public KeyType getId();
	public void setId(KeyType id);
	
	public String getName();
	public void setName(String name);
	
	public Boolean getValid();
	public void setValid(Boolean valid);
	
}
