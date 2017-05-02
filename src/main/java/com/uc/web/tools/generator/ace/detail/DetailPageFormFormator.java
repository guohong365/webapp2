package com.uc.web.tools.generator.ace.detail;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.uc.web.tools.generator.FormControlsFormator;
import com.uc.web.tools.generator.FormFieldDescriptor;
import com.uc.web.tools.generator.EntityDescriptor;
import com.uc.web.tools.generator.EntityFormator;
import com.uc.web.tools.generator.PageFormatorImpl;

public class DetailPageFormFormator extends PageFormatorImpl implements EntityFormator {
	private static final String FORM_HEADER=
			"<form:form modelAttribute=\"detailInput\" cssClass=\"form-horizontal\" role=\"form\" action=\"#\" method=\"post\">"
		  + "  <input type=\"hidden\" id=\"action\" name=\"action\" value=\"${action }\" />";
	private static final String SECOND=
		    "  <div class=\"modal-header no-padding\">"
		  + "    <div class=\"table-header\">"
		  + "      <button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\"><span class=\"white\">&times;</span></button>"
		  + "      ${actionName}"
		  + "    </div>"
		  + "  </div>"
		  + "  <div class=\"modal-body\">"
		  + "    <div class=\"row\">"
		  + "      <div class=\"col-xs-12\">"
		  + "        <div class=\"widget-box\">"
		  + "          <div class=\"widget-header blue\"><h4 class=\"widget-title\">%s</h4></div>"
		  + "          <div class=\"widget-body\">"
		  + "            <div class=\"widget-main\">"
		  + "              <div class=\"row\">";
	private static final String FORM_TAIL=
			"              </div>"
		  + "            </div>"
		  + "          </div>"
		  + "        </div>"
		  + "      </div>"
		  + "    </div>"
		  + "  </div>"
		  + "  <div class=\"modal-footer\">"
		  + "    <button id=\"btnSave\" class=\"btn btn-sm btn-primary\" type=\"submit\">"
		  + "      <i class=\"ace-icon fa fa-check\"></i> 保存</button>"
		  + "    <button id=\"btnCancel\" class=\"btn btn-sm\" data-dismiss=\"modal\">"
		  + "      <i class=\"ace-icon fa fa-times\"></i> 取消</button>"
		  + "  </div>"
		  + "</form:form>";
	
	FormControlsFormator controlsFormator;
	public FormControlsFormator getControlsFormator() {
		return controlsFormator;
	}
	public void setControlsFormator(FormControlsFormator controlsFormator) {
		this.controlsFormator = controlsFormator;
	}
	private void splitHidden(List<FormFieldDescriptor> all, List<FormFieldDescriptor> hidden, List<FormFieldDescriptor> normal) {
		for(FormFieldDescriptor item:all){
			if(item.isHidden()) 
				hidden.add(item);
			else 
				normal.add(item);
		}
	}
	@Override
	public void formatHTML(EntityDescriptor page, StringBuilder builder) {
		if(getContainerProvider()!=null)
			builder.append(getContainerProvider().getHeader());
		builder.append(FORM_HEADER);
		if(getControlsFormator()!=null){
			List<FormFieldDescriptor> hidden=new ArrayList<>();
			List<FormFieldDescriptor> normal=new ArrayList<>();
			splitHidden(page.getFormFields(), hidden, normal);					
			getControlsFormator().formatHTML(hidden, builder);
			builder.append(
					String.format(SECOND,
							StringUtils.isEmpty(page.getName())? "${entiryName}": page.getName()));
			getControlsFormator().formatHTML(normal, builder);
		} else {
			builder.append(SECOND);
		}
		if(getFormators()!=null){
			for(EntityFormator formator:getFormators()){
				formator.formatHTML(page, builder);
			}
		}
		builder.append(FORM_TAIL);		
		if(getContainerProvider()!=null)
			builder.append(getContainerProvider().getTail());
		
	}
	
}
