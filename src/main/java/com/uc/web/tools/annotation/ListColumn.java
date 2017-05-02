package com.uc.web.tools.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface ListColumn {
	//title of table column, if empty to use field name by upper case
	String value() default "";
	//filed variable name, if empty to use entity field name
	String field() default "";
	//order of column
	int order() default -1;
	//use this column as sortable column
	boolean orderBy() default true; 
	//if true, the field is primary key of entity
	boolean id() default false;
	boolean show() default true;
}
