package com.uc.web.domain;

public abstract class AbstractFunction<KeyType> extends AbstractNamedObject<KeyType> implements Function<KeyType> {
	private String uri;
	private String uriPattern;
	@Override
	public String getUri() {
		return uri;
	}
	@Override
	public void setUri(String uri) {
		this.uri = uri;
	}
	@Override
	public String getUriPattern() {
		return uriPattern;
	}
	@Override
	public void setUriPattern(String uriPattern) {
		this.uriPattern = uriPattern;
	}
}
