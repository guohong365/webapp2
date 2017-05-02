package com.uc.web.domain;

public interface IEntiryFactory {
	<T> T CreateInstance(Class<T> class1);
}
