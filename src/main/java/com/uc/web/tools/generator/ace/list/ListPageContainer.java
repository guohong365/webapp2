package com.uc.web.tools.generator.ace.list;

import com.uc.web.forms.ui.ContainerProvider;

public class ListPageContainer implements ContainerProvider {
	static final String HEADER=
			"<title>${modelTitle}</title>"
		  + "<!-- ajax layout which only needs content area -->"
		  + "<div class=\"row\" id=\"content_container\">"
		  + "  <div class=\"col-xs-12\"><!-- PAGE CONTENT BEGINS -->";
	static final String TAIL=
			"  </div><!-- PAGE CONTENT ENDS -->"
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
