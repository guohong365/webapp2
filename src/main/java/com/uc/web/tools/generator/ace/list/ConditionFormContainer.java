package com.uc.web.tools.generator.ace.list;

import com.uc.web.forms.ui.ContainerProvider;

public class ConditionFormContainer implements ContainerProvider {
	static final String HEADER=
			
			"<div class=\"row\"><!-- search condition begin -->"
		  + "  <div class=\"col-xs-12\">"
		  + "    <form:form class=\"form-horizontal\" role=\"form\" modelAttribute=\"queryInput\" action=\"#\">"
		  + "      <div class=\"row\">";       

	static final String TAIL=
			"      </div>"
		  + "      <div class=\"row\">"
		  + "        <div class=\"col-xs-12\">"
		  + "          <div class=\"form-group align-right\">"
		  + "            <button class=\"btn btn-sm btn-success\" id=\"btnReset\" type=\"button\">"
		  + "              <i class=\"ace-icon fa fa-refresh\"></i>重置</button>"
		  + "            <button class=\"btn btn-sm btn-primary\" id=\"btnSearch\" type=\"button\">"
		  + "              <i class=\"ace-icon fa fa-search\"></i>查询</button>"
		  + "          </div>"
		  + "        </div>"
		  + "      </div>"
		  + "    </form:form>"
		  + "  </div>"
		  + "</div><!-- search condition end -->"
		  + "<div class=\"hr hr-8\"></div>";
	
	@Override
	public String getHeader() {
		return HEADER;
	}
	@Override
	public String getTail() {
		return TAIL;
	}
    
    

}
