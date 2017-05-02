package com.uc.web.tools.generator.ace.detail;

import com.uc.web.tools.generator.EntityDescriptor;
import com.uc.web.tools.generator.EntityFormator;
import com.uc.web.tools.generator.PageFormatorImpl;

public class DetailViewPageScriptFormator extends PageFormatorImpl implements EntityFormator {
	private static final String HEADER=
	    "<script type=\"text/javascript\">"
	  + "  $(document).ready(function() {"
	  + "    <c:if test=\"${action eq 'view'}\" >"
	  + "	  $('#btnCancel').text('关闭');"
	  + "	  $('#btnSave').addClass('hide');"
	  + "	</c:if>";
	private static final String TAIL=  
	    "  });"
	  + "</script>";

	@Override
	public void formatHTML(EntityDescriptor fields, StringBuilder builder) {
		if(getContainerProvider()!=null) 
			builder.append(getContainerProvider().getHeader());
		builder.append(HEADER);
		if(getFormators()!=null){
			for(EntityFormator formator:getFormators()){
				formator.formatHTML(fields, builder);
			}
		}
		builder.append(TAIL);
		if(getContainerProvider()!=null) 
			builder.append(getContainerProvider().getTail());
	}	
}
