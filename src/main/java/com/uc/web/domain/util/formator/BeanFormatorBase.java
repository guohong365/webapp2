package com.uc.web.domain.util.formator;

public class BeanFormatorBase<BeanType extends Object> implements BeanFormator<BeanType>  {

	@Override
	public String toString(BeanType item) {
		return item.getClass().toString();
	}
	
}
