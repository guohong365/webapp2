package com.uc.web.domain;

public interface Menu<KeyType> extends NamedObjct<KeyType> {

	public void setParent(KeyType parentMenu);
	public KeyType getParent();

	public void setOrder(Integer menuOrder);
	public Integer getOrder();
	
	public String getUri();
	public void setUri(String uri);

}
