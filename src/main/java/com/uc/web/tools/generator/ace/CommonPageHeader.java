package com.uc.web.tools.generator.ace;

import com.uc.web.tools.generator.EntityDescriptor;
import com.uc.web.tools.generator.EntityFormator;
import com.uc.web.tools.generator.PageFormatorImpl;

public class CommonPageHeader extends PageFormatorImpl implements EntityFormator {
	static final String HEADER=
			"<%@page contentType=\"text/html; charset=UTF-8\" pageEncoding=\"UTF-8\"%>"
		  + "<%@taglib prefix=\"c\" uri=\"http://java.sun.com/jsp/jstl/core\"%>"
		  + "<%@taglib prefix=\"fmt\" uri=\"http://java.sun.com/jsp/jstl/fmt\"%>"
		  + "<%@taglib prefix=\"form\" uri=\"http://www.springframework.org/tags/form\"%>"
		  + "<%@taglib prefix=\"spring\" uri=\"http://www.springframework.org/tags\"%>";
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
		if(getContainerProvider()!=null){
			builder.append(getContainerProvider().getTail());
		}
	}
}
