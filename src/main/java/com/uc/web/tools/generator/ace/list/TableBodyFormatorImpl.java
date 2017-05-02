package com.uc.web.tools.generator.ace.list;

import java.util.List;

import org.springframework.util.StringUtils;

import com.uc.web.forms.ui.ContainerProvider;
import com.uc.web.tools.generator.ButtonsAcceptor;
import com.uc.web.tools.generator.ButtonsFormator;
import com.uc.web.tools.generator.IdAccepter;
import com.uc.web.tools.generator.ListColumnDescriptor;
import com.uc.web.tools.generator.TableBodyFormator;
import com.uc.web.tools.generator.utils.FormFormatorHelper;

public class TableBodyFormatorImpl extends ButtonsFormatorBase implements TableBodyFormator, ContainerProvider, ButtonsAcceptor{
	static final String HEADER="<tbody><c:forEach var=\"item\" items=\"${records}\"><tr>";
	
	String column="<td>${item.%s}</td>";
	
	static final String TAIL="</tr></c:forEach></tbody>";
	
	@Override
	public String getHeader() {
		return HEADER;
	}
	@Override
	public String getTail() {
		return TAIL;
	}
	
	@Override
	public ContainerProvider getContainerProvider() {
		return super.getContainerProvider()==null?this:super.getContainerProvider();
	}
	@Override
	public void formatHTML(List<ListColumnDescriptor> fields, StringBuilder builder) {
		if(getContainerProvider()!=null)
			builder.append(getContainerProvider().getHeader());
		for(ListColumnDescriptor field:fields){
			if(field.isShow())
				builder.append(String.format(column, field.getField()));
		}
		ButtonsFormator formator=getRowButtonsFormator();		
		if(formator!=null){			
			String id=FormFormatorHelper.findId(fields);
			if(!StringUtils.isEmpty(id) && formator instanceof IdAccepter){
				((IdAccepter)formator).setId(id);
			}
			formator.formatHTML(getRowButtons(), builder);
		}			
		if(getContainerProvider()!=null)
			builder.append(getContainerProvider().getTail());		
	}
	private ButtonsFormator rowButtonsFormator;
	public ButtonsFormator getRowButtonsFormator() {
		return rowButtonsFormator;
	}
	public void setRowButtonsFormator(ButtonsFormator rowButtonsFormator) {
		this.rowButtonsFormator = rowButtonsFormator;
	}
	
}
