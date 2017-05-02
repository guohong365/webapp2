package com.uc.web.tools.generator.ace;

import com.uc.web.tools.annotation.ComponentType;
import com.uc.web.tools.generator.EntityDescriptor;
import com.uc.web.tools.generator.EntityFormator;
import com.uc.web.tools.generator.FormFieldDescriptor;
import com.uc.web.tools.generator.PageFormatorImpl;
import com.uc.web.tools.generator.utils.FormFormatorHelper;

public class CommonPageScriptFormator extends PageFormatorImpl implements EntityFormator {
	private static final String CHOSEN="$('.chosen-select').chosen({width:'100%'});";
	private static final String DATE_PICKER=
			"$('.date-picker').datepicker({"
		  + "  format: 'yyyy-mm-dd',"
		  + "  autoclose: true,"
		  + "  todayHighlight: true,"
		  + "  todayBtn: true,"
		  + "  language: 'zh-CN',"
		  + "  endDate : new Date()"
		  + "});";
	private static final String DATE_RANGE=
			"$('.input-daterange').datepicker({"
		  + "  format: 'yyyy-mm-dd',"
		  + "  autoclose: true,"
		  + "  todayHighlight: true,"
		  + "  todayBtn: true,"
		  + "  language: 'zh-CN'"
		  + "});";
	
	public static final int HAS_CHOSEN = 0x01;
	public static final int HAS_DATE_PICKER= 0x02;
	public static final int HAS_DATE_RANGE=0x03;
	@Override
	public void formatHTML(EntityDescriptor descriptors, StringBuilder builder) {
		if(getContainerProvider()!=null)
			builder.append(getContainerProvider().getHeader());
		int set=0;
		for(FormFieldDescriptor field:descriptors.getFormFields()){
			String type=FormFormatorHelper.getFinalComponentType(field);
			switch (type) {
			case ComponentType.DATE:
				set|=HAS_DATE_PICKER;
				break;
			case ComponentType.DATE_RANGE:
				set |=HAS_DATE_RANGE;
				break;
			case ComponentType.SELECT:
			case ComponentType.ENUM_SELECT:
				set |=HAS_CHOSEN;
				break;
			default:
				break;
			}
		}
		if((set & HAS_CHOSEN)!=0){
			builder.append(CHOSEN);
		}
		if((set& HAS_DATE_PICKER)!=0){
			builder.append(DATE_PICKER);
		}
		if((set&HAS_DATE_RANGE)!=0){
			builder.append(DATE_RANGE);
		}
		if(getFormators()!=null){
			for(EntityFormator formator:getFormators()){
				formator.formatHTML(descriptors, builder);
			}
		}
		if(getContainerProvider()!=null)
			builder.append(getContainerProvider().getTail());
	}
}
