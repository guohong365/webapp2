package com.uc.web.tools.generator;

public interface ButtonDescriptor{
	public static final String ICON="icon";
	public static final String TEXT="text";
	public static final String BOTH="both";
	String getName();
	void setName(String name);
	String getAction();
	void setAction(String action);
	String getClazz();
	void setClazz(String clazz);
	String getIcon();
	void setIcon(String icon);
	ButtonStyle getStyle();
	void setStyle(ButtonStyle style);
}
