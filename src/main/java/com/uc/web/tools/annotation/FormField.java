package com.uc.web.tools.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface FormField {
	String component() default ComponentType.AUTO;
	String value() default "";
	String field() default "";
	int order() default -1;
	boolean readOnly() default false;
	boolean range() default false;
	boolean required() default false;
	boolean hidden() default false;
	boolean id() default false;
	String[] rules() default {};
	String[] message() default{};
}
