package com.uc.web.tools.generator.ace.list;

import com.uc.web.tools.annotation.ComponentType;
import com.uc.web.tools.generator.EntityDescriptor;
import com.uc.web.tools.generator.EntityFormator;
import com.uc.web.tools.generator.FormFieldDescriptor;
import com.uc.web.tools.generator.PageFormatorImpl;
import com.uc.web.tools.generator.utils.FormFormatorHelper;

public class ListPageScriptFormator extends PageFormatorImpl implements EntityFormator {
	private static final String HEADER=
			"<!-- page specific plugin scripts -->"
		  + "<script type=\"text/javascript\">"
		  + "  var scripts = [ null, null ];"
		  + "  ace.load_ajax_scripts(scripts, function() {";
	private static final String MIDDLE=	  
		    "    $('#content_container').bindPage({"
		  + "      bindPagation : false,"
		  + "      reset : function() {";
		  
	private static final String TAIL=
			"},"
		  + "      afterSave : function (){"
		  + "        return true;},"
		  + "      baseUrl: '<c:url value=\"${baseUrl}\" />',"
		  + "	 });"
		  + "  });"
		  + "</script>";
	
	private static final String JNAME="$('#%s')";
	private static final String CHECK_VAL=".prop('checked', false);";
	private static final String TEXT_VAL=".val();";
	@Override
	public void formatHTML(EntityDescriptor descriptors, StringBuilder builder) {
		builder.append(HEADER);
		StringBuilder resetItems=new StringBuilder();
		for(FormFieldDescriptor field:descriptors.getFormFields()){
			String type=FormFormatorHelper.getFinalComponentType(field);
			switch (type) {
			case ComponentType.CHECKBOX:
				resetItems.append(String.format(JNAME, field.getField()) + CHECK_VAL);
				break;
			case ComponentType.DATE:
				resetItems.append(String.format(JNAME, field.getField()) + TEXT_VAL);
				break;
			case ComponentType.DATE_RANGE:
				resetItems.append(String.format(JNAME, field.getField()+"From") + TEXT_VAL);
				resetItems.append(String.format(JNAME, field.getField()+"To") + TEXT_VAL);
				break;
			case ComponentType.SELECT:
			case ComponentType.ENUM_SELECT:
				resetItems.append(String.format(JNAME, field.getField()) + TEXT_VAL);
				break;
			case ComponentType.RADIO:
			case ComponentType.ENUM_RADIO:
			case ComponentType.TEXT:
			case ComponentType.TEXT_AREA:
				resetItems.append(String.format(JNAME, field.getField()) + TEXT_VAL);
				break;
			case ComponentType.TEXT_RANGE:
				resetItems.append(String.format(JNAME, field.getField()+"From") + TEXT_VAL);
				resetItems.append(String.format(JNAME, field.getField()+"To") + TEXT_VAL);
				break;
			default:
				break;
			}
		}
		if(getFormators()!=null){
			for(EntityFormator formator:getFormators()){
				formator.formatHTML(descriptors, builder);
			}
		}
		builder.append(MIDDLE);		
		builder.append(resetItems);
		builder.append(TAIL);
	}
}
