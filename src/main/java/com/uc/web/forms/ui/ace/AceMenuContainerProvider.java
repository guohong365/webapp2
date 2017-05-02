package com.uc.web.forms.ui.ace;

import com.uc.web.forms.ui.ContainerProvider;

public class AceMenuContainerProvider implements ContainerProvider {
	static final String ROOT_HEADER="<ul class=\"nav nav-list\">";
	static final String ROOT_TAIL="</ul>";

	@Override
	public String getHeader() {
		return ROOT_HEADER;
	}

	@Override
	public String getTail() {
		return ROOT_TAIL;
	}
}
