package com.uc.web.forms.ui;

public interface IUIFormator<CompoentType> {
	public ContainerProvider getContainerProvider();
	public void setContainerProvider(ContainerProvider provider);

	public void formatHTML(CompoentType fields, StringBuilder builder);
}
