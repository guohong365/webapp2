package com.uc.web.domain;

public class AbstractTreeNamedObject extends AbstractNamedObject implements TreeObject {
	Object parent;
	public Object getParent(){
		return parent;
	}
	public void setParent(Object parent){
		this.parent=parent;
	}
}
