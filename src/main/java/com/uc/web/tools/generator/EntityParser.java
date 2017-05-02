package com.uc.web.tools.generator;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.util.StringUtils;

import com.uc.web.tools.annotation.AutoGenerateEntity;
import com.uc.web.tools.annotation.FormField;
import com.uc.web.tools.annotation.ListColumn;
import com.uc.web.tools.annotation.QueryField;

public class EntityParser {
	protected static boolean hasGetter(Field field){
		try {
			PropertyDescriptor descriptor=new PropertyDescriptor(field.getName(),field.getDeclaringClass());
			return descriptor.getReadMethod()!=null;
		} catch (IntrospectionException e) {
			return false;
		}
	}
	protected static void parseListColumns(Class<?> type, List<ListColumnDescriptor> listColumnDescriptors){
		Field[] fields=type.getDeclaredFields();
		for(Field field: fields){
			if(field.isAnnotationPresent(ListColumn.class) && hasGetter(field)){
				listColumnDescriptors.add(new ListColumnDescriptorImpl(field.getName(), field.getType(), field.getAnnotation(ListColumn.class)));
			}
		}
		Class<?> parent=type.getSuperclass();
		if(parent!=null && !parent.equals(Object.class)){
			parseListColumns(parent, listColumnDescriptors);
		}
		listColumnDescriptors.sort(new SortDescriptorByOrder());
	}
	
	public static void parseFormFields(Class<?> type, List<FormFieldDescriptor> formFieldDescriptors){
		Field[] fields=type.getDeclaredFields();
		for(Field field: fields){
			if(field.isAnnotationPresent(FormField.class) && hasGetter(field)){
				formFieldDescriptors.add(new FormFieldDescriptorImpl(field.getName(), field.getType(), field.getAnnotation(FormField.class)));				
			}
		}
		Class<?> parent=type.getSuperclass();
		if(parent!=null && !parent.equals(Object.class)){
			parseFormFields(parent, formFieldDescriptors);
		}
		formFieldDescriptors.sort(new SortDescriptorByOrder());
	}
	
	public static void parseQueryFields(Class<?> type, List<FormFieldDescriptor> queryFields){
		Field[] fields=type.getDeclaredFields();
		for(Field field: fields){
			if(field.isAnnotationPresent(QueryField.class) && hasGetter(field)){
				queryFields.add(new FormFieldDescriptorImpl(field.getName(), field.getType(), field.getAnnotation(QueryField.class)));				
			}
		}
		Class<?> parent=type.getSuperclass();
		if(parent!=null && !parent.equals(Object.class)){
			parseQueryFields(parent, queryFields);
		}
		queryFields.sort(new SortDescriptorByOrder());
	}
	
	static class SortDescriptorByOrder implements Comparator<FieldDescriptor>{
		@Override
		public int compare(FieldDescriptor o1, FieldDescriptor o2) {
			return o1.getOrder()-o2.getOrder();
		}
	}

	public static EntityDescriptor parse(Class<?> clazzEntity) {
		if(!clazzEntity.isAnnotationPresent(AutoGenerateEntity.class)) return null;
		
		AutoGenerateEntity autoGenerateEntity=clazzEntity.getAnnotation(AutoGenerateEntity.class);
		List<ButtonDescriptor> buttons=createButtons(autoGenerateEntity.buttons());
		List<ButtonDescriptor> rowButtons=createButtons(autoGenerateEntity.rowButtons());
		List<FormFieldDescriptor> formFields=new ArrayList<>();
		List<ListColumnDescriptor> columns=new ArrayList<>();
		List<FormFieldDescriptor> queryFields=new ArrayList<>();
		parseFormFields(clazzEntity, formFields);
		parseListColumns(clazzEntity, columns);
		parseQueryFields(clazzEntity, queryFields);
		EntityDescriptor pageDescriptor=new EntityDescriptorImpl(
				clazzEntity,
				autoGenerateEntity.value(),
				buttons,
				rowButtons, formFields, columns, queryFields);		
		return pageDescriptor;
	}
	protected static List<ButtonDescriptor> createButtons(String[] buttons) {
		List<ButtonDescriptor> buttonList=new ArrayList<>();
		String name="";
		String action="";
		String clazz="";
		String icon="";
		ButtonStyle style=ButtonStyle.BOTH;
		if(buttons!=null){
			for(String one:buttons){
				name="";
				action="";
				clazz="";
				icon="";
				style=ButtonStyle.BOTH;
				String[] sections= one.toLowerCase().split("\\|");
				if(sections.length>=1 && !StringUtils.isEmpty(sections[0])){
					name=sections[0];
				} else continue;
				
				if(sections.length>=2) action=sections[1];
				if(sections.length>=3) clazz=sections[2];
				if(sections.length>=4) icon=sections[3];
				if(sections.length>=5) style=
						ButtonDescriptor.ICON.equals(sections[4])? ButtonStyle.ICON:(
						ButtonDescriptor.TEXT.equals(sections[4])? ButtonStyle.TEXT:ButtonStyle.BOTH);
				ButtonDescriptor button=new ButtonDescriptorImpl(name, action, clazz, icon, style);
				buttonList.add(button);
			}
		}
		return buttonList;
	}
	
}
