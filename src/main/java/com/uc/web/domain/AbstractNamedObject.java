package com.uc.web.domain;

import com.uc.web.tools.annotation.FormField;

public abstract class AbstractNamedObject extends EntityBase implements NamedObjct {
	@FormField(id=true, hidden=true)
	private Object id;
	@FormField(value="名称")
	private String name;
	@FormField(value="有效")
	private Boolean valid;
	@Override
	public Object getId() {
		return id;
	}

	public void setId(Object id) {
		this.id = id;
	}
	@Override
	public String getName() {
		return name;
	}
	@Override
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public Boolean getValid() {
		return valid;
	}
	@Override
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
	
}
