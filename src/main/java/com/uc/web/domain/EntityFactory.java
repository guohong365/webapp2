package com.uc.web.domain;

public interface EntityFactory {
	<T> T CreateInstance(Class<T> class1);
}
