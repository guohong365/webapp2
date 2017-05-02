package com.uc.web.tools.generator.ace.form;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.uc.web.domain.basic.BasicCode;
import com.uc.web.tools.annotation.EnumItemDescription;

public abstract class EnumItemFormatorBase extends ItemFormatorBase {

	List<BasicCode> getEnumValues(Class<?> clazz){
		List<BasicCode> list=new ArrayList<>();
		Field[]fields=clazz.getDeclaredFields();
		for(Field field:fields){
			if(field.isAnnotationPresent(EnumItemDescription.class)){
				list.add(new BasicCode(field.getName(), field.getAnnotation(EnumItemDescription.class).value()));
			} else {
				list.add(new BasicCode(field.getName(), field.getName()));
			}
		}
		return list;
	}
	
}
