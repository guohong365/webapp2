package com.uc.web.forms.ui.ace;

import com.uc.web.forms.ui.ContainerProvider;

public class AceSubmenuContainer implements ContainerProvider {
	static final String SUBMENU_HEADER=
	          "<li>"
	        + "  <a class=\"dropdown-toggle\" href=\"#\">"
;
	
	static final String SUBMENU_TAIL=
			  "  </ul>"
			+ "</li>";

	@Override
	public String getHeader() {
		return SUBMENU_HEADER;
	}

	@Override
	public String getTail() {
		return SUBMENU_TAIL;
	}
	
}
