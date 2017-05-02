package com.uc.web.tools.generator.ace.detail;

import com.uc.web.tools.annotation.ComponentType;
import com.uc.web.tools.generator.EntityDescriptor;
import com.uc.web.tools.generator.EntityFormator;
import com.uc.web.tools.generator.FormFieldDescriptor;
import com.uc.web.tools.generator.PageFormatorImpl;

public class DetaiModifyPageScriptFormator extends PageFormatorImpl implements EntityFormator {
	private static final String HEADER=
	    "<script type=\"text/javascript\">"
	  + "  $(document).ready(function() {";
	private static final String ignoredForChosen=
	   "    $.validator.setDefaults({ignore:\":hidden:not(.chosen-select)\" });";
	private static final String validate_first=
	    "    $('#detailInput').validate({"
	  + "      errorElement : 'div',"
	  + "      errorClass : 'help-block align-right',"
	  + "      focusInvalid : false,"
	  + "	   highlight : function(e) {$(e).closest('.form-group').removeClass('has-success').addClass('has-error');},"
	  + "      success : function(error, element) {$(error).closest('.form-group').removeClass('has-error').addClass('has-success');$(error).remove();},"
	  + "      unhighlight : function(e) {$(e).closest('.form-group').removeClass('has-error');},"
	  + "      errorPlacement : function(error, element) {$(element).closest('.form-group').append(error);},"
	  + "      rules : {";
	private static final String validate_second=
	  "          },"
	  + "      messages : {";
	private static final String validate_third=
	    "        },"
	  + "    });"
	  + "    $('#detail-dialog').bindKeyMoveForm('#detailInput :input');"
	  + "  });"
	  + "</script>";
	@Override
	public void formatHTML(EntityDescriptor page, StringBuilder builder) {
		boolean hasChosen=false;
		StringBuilder rules=new StringBuilder();
		StringBuilder msg=new StringBuilder();
		for(FormFieldDescriptor field:page.getFormFields()){
			if(field.getComponent()==ComponentType.SELECT|| field.getComponent()==ComponentType.ENUM_SELECT){
				hasChosen=true;
			}			
			if(field.isRequired() || ((field.getRules()!=null && field.getRules().length>0) && !field.isRange())) {				
				rules.append(field.getField()).append(": {");
				msg.append(field.getField()).append(":{");
				if(field.isRequired()){
					rules.append("required : true,");
					msg.append("required : '[").append(field.getName()).append("]不能为空！");
				}
				for(String one:field.getRules()){
					rules.append(one);
				}
				for(String one:field.getMessage()){
					msg.append(one);
				}
				msg.append("},");
				rules.append("},");				
			}
		}
		if(getContainerProvider()!=null)
			builder.append(getContainerProvider().getHeader());
		builder.append(HEADER);
		if(getFormators()!=null){
			for(EntityFormator formator:getFormators()){
				formator.formatHTML(page, builder);
			}
		}
		
		if(hasChosen) builder.append(ignoredForChosen);		
		builder.append(validate_first);
		builder.append(rules);
		builder.append(validate_second);
		builder.append(msg);
		builder.append(validate_third);		
		if(getContainerProvider()!=null)
			builder.append(getContainerProvider().getTail());
		
	}
	
	

}
