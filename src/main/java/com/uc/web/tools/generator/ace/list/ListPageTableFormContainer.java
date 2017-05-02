package com.uc.web.tools.generator.ace.list;

import com.uc.web.forms.ui.ContainerProvider;

public class ListPageTableFormContainer implements ContainerProvider {
	static final String HEADER=
			"<div class=\"row\"><!-- result table begin -->"
		  + "  <div class=\"col-xs-12\" >"
		  + "    <div id=\"listResult\">";
	static final String TAIL=
		    "    </div>"
		  + "    <div id=\"dialogPanel\"></div>"
		  + "  </div>"
		  + "</div><!-- result table end -->";
	@Override
	public String getHeader() {
		return HEADER;
	}
	@Override
	public String getTail() {
		return TAIL;
	}
}
