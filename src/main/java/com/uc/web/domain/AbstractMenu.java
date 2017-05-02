package com.uc.web.domain;

public abstract class AbstractMenu<KeyType> extends AbstractNamedObject<KeyType> implements Menu<KeyType> {
	private KeyType parent;
	private int order;
	private String uri;

	@Override
	public Integer getOrder() {
		return order;
	}
	@Override
	public void setOrder(Integer menuOrder) {
		this.order = menuOrder;
	}
	@Override
	public KeyType getParent() {
		return parent;
	}
	@Override
	public void setParent(KeyType parentId) {
		this.parent = parentId;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	
	
}
