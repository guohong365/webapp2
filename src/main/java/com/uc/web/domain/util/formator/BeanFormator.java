package com.uc.web.domain.util.formator;

public interface BeanFormator<BeanType extends Object> {
	String toString(BeanType item);
}
