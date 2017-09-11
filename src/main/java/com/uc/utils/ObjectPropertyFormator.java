package com.uc.utils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ObjectPropertyFormator {
	
	public static String format(Object object){
		return format(object, "", false, true, true, false);
	}
	
	public static String format(Object object,String prefix,boolean flat, boolean withClassName, boolean singleLinePerValue, boolean justThisClass){
		StringBuilder builder=new StringBuilder();
		if(object==null){
			return "null";			
		}
		String tab=prefix == null ? "" : prefix;		
		Class<?> c=object.getClass();
		do{
			format(object, c, builder,tab, flat, withClassName, singleLinePerValue);
			if(justThisClass) break;
			c=c.getSuperclass();
			if(!flat){
				tab +="\t";
			}
		}while(!c.equals(Object.class));		
		return builder.toString();
	}
	
	
	private static void format(Object object, Class<?> clazz, StringBuilder builder,String tab, boolean flat, boolean withClassName, boolean singleLinePerValue){				
		Field[] fields=clazz.getDeclaredFields();
		if(fields!=null && fields.length>0){
			if(withClassName){
				builder.append(tab).append(clazz.getName()).append(":");
			}
			String prefix = tab + (flat ? "" : "\t");
			for (int i=0; i<fields.length; i++) {
				Field field=fields[i];
				int modifier=field.getModifiers();
				if((modifier & Modifier.FINAL)!=0 || (modifier & Modifier.STATIC)!=0)
					continue;
				switch(modifier){
				case Modifier.PRIVATE:
				case Modifier.PROTECTED:
					formatPrivate(builder, object, field, prefix);
					break;
				case Modifier.PUBLIC:
					formatPublic(builder, object, field, prefix);
					break;
				}
				if(i<fields.length-1){
					builder.append(singleLinePerValue ? '\n' : ',');
				}
			}
			builder.append("\n");
		}		
	}
	
	private static String getFieldAccessName(Field field){
		StringBuilder name=new StringBuilder(field.getName());
		Character ch=Character.toUpperCase(name.charAt(0));
		name.setCharAt(0, ch);
		name.insert(0, "get");
		return name.toString();
	}
	
	private static void formatPrivate(StringBuilder builder, Object object, Field field, String prefix){
		String name=getFieldAccessName(field);		
		try {
			Method method = object.getClass().getMethod(name, (Class<?>[])null);			
			if(method!=null && (method.getModifiers() & Modifier.PUBLIC)!=0)
				builder.append(prefix).append(field.getName()).append("=");
				try {					
					Object value=method.invoke(object);
					if(value==null){
						builder.append("[null]");
					} else {
						builder.append("[").append(value.toString()).append("]");					
					}
					
				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					builder.append("Nan");
				}
		} catch (NoSuchMethodException | SecurityException e) {
		}
	}
	
	private static void formatPublic(StringBuilder builder, Object object,Field field, String prefix){
		builder.append(prefix).append(field.getName()).append("=");
		try {
			Object value=field.get(object);
			if(value==null){
				builder.append("[null]");
			} else {
				builder.append("[").append(value).append("]");
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {
			builder.append("[Nan]");
		}
		
	}
}
