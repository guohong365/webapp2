package com.uc.web.tools.generator.ace.list;

import java.util.List;

import com.uc.web.forms.ui.AbstractUIFormatorBase;
import com.uc.web.forms.ui.ContainerProvider;
import com.uc.web.tools.generator.ListColumnDescriptor;
import com.uc.web.tools.generator.TableHeaderFormator;

public class TableHeaderFormatorImpl extends AbstractUIFormatorBase implements ContainerProvider, TableHeaderFormator{
	static final String HEADER="<thead><tr>";
	static final String TAIL="<th></th></tr></thead>";
	@Override
	public java.lang.String getHeader() {
		return HEADER;
	}
	@Override
	public java.lang.String getTail() {
		return TAIL;
	}
	@Override
	public ContainerProvider getContainerProvider() {
		return super.getContainerProvider()==null?this:super.getContainerProvider();
	}

	String sorting=
			"<c:choose>"
		  + "  <c:when test=\"${queryInput.queryOrderBy =='%s' }\">"
		  + "    <th class=\"center sorting_${queryInput.queryOrder }\" data-active=\"true\" data-column=\"%s\">%s</th>"
		  + "  </c:when>"
		  + "  <c:otherwise>"
		  + "    <th class=\"center sorting\" data-column=\"%s\">%s</th>"
		  + "  </c:otherwise>"
		  + "</c:choose>";
	String normal="<th class=\"center\">%s<th>";
	@Override
	public void formatHTML(List<ListColumnDescriptor> fields, StringBuilder builder) {
		if(getContainerProvider()!=null)
			builder.append(getContainerProvider().getHeader());
		
		for(ListColumnDescriptor field:fields){
			if(field.isShow())
				builder.append(
					field.isOrderBy()?
					String.format(sorting,
							field.getName(),field.getName(),field.getName(),field.getName(),field.getName()):
					String.format(normal, field.getName()));
		}
		if(getContainerProvider()!=null)
			builder.append(getContainerProvider().getTail());		
	}
	
}
