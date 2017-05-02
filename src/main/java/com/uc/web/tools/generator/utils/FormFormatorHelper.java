package com.uc.web.tools.generator.utils;

import java.util.List;

import org.springframework.util.StringUtils;

import com.uc.web.tools.annotation.ComponentType;
import com.uc.web.tools.generator.FormFieldDescriptor;
import com.uc.web.tools.generator.ListColumnDescriptor;

public class FormFormatorHelper{
	protected static final String BOOLEN="boolean";
	protected static final String BOOLEN_CLASS="java.lang.Boolen";
	protected static final String SHORT="short";
	protected static final String SHORT_CLASS="java.lang.Short";
	protected static final String INTEGER="int";
	protected static final String INTEGER_CLASS="java.lang.Integer";
	protected static final String LONG="long";
	protected static final String LONG_CLASS="java.lang.Long";
	protected static final String DOUBLE="double";
	protected static final String DOUBLE_CLASS="java.lang.Double";
	protected static final String FLOAT="float";
	protected static final String BIG_DECIMAL="java.math.BigDecimal";
	protected static final String BIG_INTEGER="java.math.BigInteger";
	protected static final String FLOAT_CLASS="java.lang.Float";
	protected static final String STRING_CLASS="java.lang.String";
	protected static final String DATE_CLASS="java.util.Date";
	
	protected static final int MAX_ENUM_USE_RADIO = 5;

	public static String getFinalComponentType(FormFieldDescriptor componet) {
		//force return
		if(componet.isHidden()) return ComponentType.HIDDEN;		
		if(componet.isReadOnly()) return ComponentType.STATIC;		
		String typeName=componet.getType().getName();
		if(typeName.equals(BOOLEN) || typeName.equals(BOOLEN_CLASS)) return ComponentType.CHECKBOX;
		
		if(componet.getComponent().equals(ComponentType.AUTO)) {
			if(componet.getType().isEnum())
			  return componet.getType().getDeclaredFields().length >=MAX_ENUM_USE_RADIO? ComponentType.ENUM_SELECT : ComponentType.ENUM_RADIO;
			if(typeName.equals(DATE_CLASS))
				return componet.isRange()? ComponentType.DATE_RANGE: ComponentType.DATE;
			return componet.isRange() ? ComponentType.TEXT_RANGE: ComponentType.TEXT;
		}
		return componet.getComponent();
	}
	
	public static String getUpperCaseName(String name){
		char[] chars=name.toCharArray();
		StringBuilder builder=new StringBuilder();
		for(char ch:chars){
			if(Character.isUpperCase(ch) && builder.length()!=0){
				builder.append("_");				
			}
			builder.append(ch);
		}
		return builder.toString().toUpperCase();
	}
	public static String getPrefixName(String prefix, String name){
		if(StringUtils.isEmpty(prefix)) return name;
		return prefix.substring(0, 1).toLowerCase() + prefix.substring(1) +
				name.substring(0,1).toUpperCase() + name.substring(1);
	}
	public static String findId(List<ListColumnDescriptor> columns){
		for(ListColumnDescriptor column:columns){
			if(column.isId()) return column.getField();
		}
		return "";
	}
	
	public static void preprocessFielsType(List<FormFieldDescriptor> fields){
		for(FormFieldDescriptor field:fields){
			String type=getFinalComponentType(field);
			field.setComponent(type);
		}
	}

}
