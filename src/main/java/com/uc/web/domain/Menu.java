package com.uc.web.domain;

public interface Menu extends NamedObjct, TreeObject {

	public void setOrder(Integer menuOrder);
	public Integer getOrder();
	
	public String getUri();
	public void setUri(String uri);

}
