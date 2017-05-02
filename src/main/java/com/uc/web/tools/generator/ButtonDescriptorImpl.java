package com.uc.web.tools.generator;

public class ButtonDescriptorImpl implements ButtonDescriptor{
	private String name;
	private String action;
	private String clazz;
	private String icon;
	private ButtonStyle style;
	
	public ButtonDescriptorImpl(String name, String action, String clazz, String icon, ButtonStyle style) {
		this.name=name;
		this.action=action;
		this.clazz=clazz;
		this.icon=icon;
		this.style=style;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}
	public ButtonStyle getStyle() {
		return style;
	}
	public void setStyle(ButtonStyle style) {
		this.style = style;
	}
}
