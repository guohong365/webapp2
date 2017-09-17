package com.uc.web.forms.controller.factory;

import java.util.Collection;
import com.uc.web.forms.ColumnsManager;
import com.uc.web.forms.ColumnsManagerImpl;
import com.uc.web.forms.ListColumn;

public class ColumnsManagerFactoryImpl implements ColumnsManagerFactory {
	
	private String name;
	private Collection<ListColumn> defaultColumns;

	public ColumnsManagerFactoryImpl(String name, Collection<ListColumn> columns) {
		this.name=name;
		defaultColumns=columns;
	}
	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@Override
	public ColumnsManager create() {
		return new ColumnsManagerImpl(defaultColumns);
	}	

}
