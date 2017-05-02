package com.uc.web.tools.generator.ace.list;

import java.util.List;

import com.uc.web.forms.ui.AbstractUIFormatorBase;
import com.uc.web.forms.ui.ContainerProvider;
import com.uc.web.tools.generator.FormFieldDescriptor;
import com.uc.web.tools.generator.TableFormHiddenFormator;
import com.uc.web.tools.generator.utils.FormFormatorHelper;

public class TableFormHiddenFormatorImpl extends AbstractUIFormatorBase implements ContainerProvider, TableFormHiddenFormator{
	@Override
	public String getHeader() {
		return HIDDEN_HEADER;
	}
	@Override
	public String getTail() {
		return "";
	}
	private String prefix;
	String getPrefix(){
		return prefix;
	}
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	@Override
	public ContainerProvider getContainerProvider() {
		return super.getContainerProvider()==null?this:super.getContainerProvider();
	}
	
	static final String HIDDEN_HEADER=
		"<input type=\"hidden\" id=\"action\" name=\"action\" value=\"${action}\" />" +
		"<input type=\"hidden\" id=\"selectedId\" name=\"selectedId\" value=\"\" />" +
		"<input type=\"hidden\" id=\"queryInput.queryOrderBy\" name=\"queryInput.queryOrderBy\" value=\"${queryInput.queryOrderBy }\" />"+
		"<input type=\"hidden\" id=\"queryInput.queryOrder\" name=\"queryInput.queryOrder\" value=\"${queryInput.queryOrder}\" />"+
		"<input type=\"hidden\" id=\"pageCtrl.pageCount\" name=\"pageCtrl.pageCount\" value=\"${pageCtrl.pageCount}\" />"+
		"<input type=\"hidden\" id=\"pageCtrl.total\" name=\"pageCtrl.total\" value=\"${pageCtrl.total }\" />" +
		"<input type=\"hidden\" id=\"pageCtrl.current\" name=\"pageCtrl.current\" value=\"${pageCtrl.current }\" />";	
	
	static final String hiddenItem="<input type=\"hidden\" id=\"queryInput.%s\" name=\"queryInput.%s\" value=\"${queryInput.%s}\" />";
	static final String hiddenScopeItem=
			  "<input type=\"hidden\" id=\"queryInput.%sFrom\" name=\"queryInput.%sFrom\" value=\"${queryInput.%sFrom}\" />"
			+ "<input type=\"hidden\" id=\"queryInput.%sTo\" name=\"queryInput.%sTo\" value=\"${queryInput.%sTo}\" />";
	@Override
	public void formatHTML(List<FormFieldDescriptor> items, StringBuilder builder) {
		if(getContainerProvider()!=null)
			builder.append(getContainerProvider().getHeader());
		
		for(FormFieldDescriptor field: items){
			if(field.isRange()){
				builder.append(String.format(hiddenScopeItem, 
						FormFormatorHelper.getPrefixName(getPrefix(), field.getField()),
						FormFormatorHelper.getPrefixName(getPrefix(), field.getField()),
						FormFormatorHelper.getPrefixName(getPrefix(), field.getField()),
						FormFormatorHelper.getPrefixName(getPrefix(), field.getField()),
						FormFormatorHelper.getPrefixName(getPrefix(), field.getField()),
						FormFormatorHelper.getPrefixName(getPrefix(), field.getField())
						));
			} else {
				builder.append(String.format(hiddenItem,
						FormFormatorHelper.getPrefixName(getPrefix(), field.getField()),
						FormFormatorHelper.getPrefixName(getPrefix(), field.getField()),
						FormFormatorHelper.getPrefixName(getPrefix(), field.getField())
						));
			}
		}
		if(getContainerProvider()!=null)
			builder.append(getContainerProvider().getTail());
	}
}
