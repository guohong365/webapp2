package com.uc.web.forms.ui.easyui;

import com.uc.web.forms.ui.ContainerProvider;

public class EasyUIGroupContainerProvider implements ContainerProvider {
	private static final String TAIL="</ul></div>";

	@Override
	public String getHeader() {
		return "";
	}

	@Override
	public String getTail() {
		return TAIL;
	}

}
