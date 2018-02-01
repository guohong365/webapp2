package com.uc.web.domain;

public abstract class AbstractMenu extends AbstractTreeNamedObject implements Menu {
	private Integer order;
	private String uri;

	@Override
	public Integer getOrder() {
		return order;
	}
	@Override
	public void setOrder(Integer menuOrder) {
		this.order = menuOrder;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	
	
}
