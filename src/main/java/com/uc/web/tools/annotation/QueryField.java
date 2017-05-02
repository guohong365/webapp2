package com.uc.web.tools.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface QueryField {
	String component() default ComponentType.AUTO;
	String value() default "";
	String field() default "";
	int order() default -1;
	boolean range() default false;
}
