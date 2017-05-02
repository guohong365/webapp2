package com.uc.web.tools.generator.ace.detail;

import com.uc.web.forms.ui.ContainerProvider;

public class DetailPageContainer implements ContainerProvider {
	private static final String HEADER=			
		    "<div id=\"detail-dialog\" class=\"modal\" tabindex=\"-1\">"
		  + "  <div class=\"modal-dialog\">"
		  + "    <div class=\"modal-content\">";
	private static final String TAIL=
			"    </div>"
		  + "  </div>"
		  + "</div>";
	@Override
	public String getHeader() {
		return HEADER;
	}

	@Override
	public String getTail() {
		return TAIL;
	}

}
