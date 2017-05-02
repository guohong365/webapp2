package com.uc.web.tools.generator.ace.list;

import com.uc.web.tools.generator.ButtonsAcceptor;
import com.uc.web.tools.generator.ButtonsFormator;
import com.uc.web.tools.generator.EntityDescriptor;
import com.uc.web.tools.generator.EntityFormator;
import com.uc.web.tools.generator.PageFormatorImpl;
import com.uc.web.tools.generator.TableFormHiddenFormator;
import com.uc.web.tools.generator.TableFormator;

public class ListPageTableFormFormator extends PageFormatorImpl implements EntityFormator {
	static final String FORM_HEADER=
			"<form id=\"FORM_TABLE_FUNCTION\" role=\"form\" action=\"#\" method=\"post\">" +
		    "  <div class=\"dataTables_wrapper form-inline no-footer\">";

	String FORM_TAIL=
    		"    <div class=\"row\"><!-- functon button begin -->"+
    		"      <c:choose>"
    	  + "        <c:when test=\"${pageCtrl.total > 0 }\">"
    	  + "          <div class=\"col-xs-12 col-sm-6\">共${pageCtrl.pageCount }页${pageCtrl.total }条记录, 当前第${pageCtrl.current + 1}页</div>"
    	  + "        </c:when>"
    	  + "        <c:otherwise>"
    	  + "          <div class=\"col-xs-12 col-sm-6\">无记录</div>"
    	  + "        </c:otherwise>"
    	  + "      </c:choose>"
    	  + "      <div class=\"col-xs-12 col-sm-6\">"
    	  + "        <div>"
    	  + "          <c:set var=\"disableFirst\" value=\"btn-info\"></c:set>"
    	  + "          <c:if test=\"${pageCtrl.current==0}\">"
    	  + "            <c:set var=\"disableFirst\" value=\"disabled\"></c:set>"
    	  + "          </c:if>"
    	  + "          <c:set var=\"disableLast\" value=\"btn-info\"></c:set>"
    	  + "          <c:if test=\"${pageCtrl.current==0 or pageCtrl.current==pageCtrl.pageCount -1 }\">"
    	  + "            <c:set var=\"disableLast\" value=\"disabled\" ></c:set>"
    	  + "          </c:if>"
    	  + "          <ul class=\"pagination\">"
    	  + "            <li>"
    	  + "              <button id=\"firstPage\" class=\"btn btn-xs ${disableFirst }\" data-page=\"first\" type=\"button\" >首页</button>"
    	  + "            </li>"
    	  + "            <li>"
    	  + "              <button id=\"priorPage\" class=\"btn btn-xs ${disableFirst }\" data-page=\"prior\" type=\"button\"  >上一页</button>"
    	  + "            </li>"
    	  + "            <li>"
    	  + "              <button id=\"nextPage\" class=\"btn btn-xs ${disableLast }\" data-page=\"next\" type=\"button\"  >下一页</button>"
    	  + "            </li>"
    	  + "            <li>"
    	  + "              <button id=\"lastPage\" class=\"btn btn-xs ${disableLast }\" data-page=\"last\" type=\"button\" >末尾</button>"
    	  + "            </li>"
    	  + "          </ul>"
    	  + "        </div>"
    	  + "      </div>"
    	  + "    </div><!-- function button end -->"
    	  + "  </div>"
    	  + "</form>";

	private ButtonsFormator functionButtonsFormator;
	public ButtonsFormator getFunctionButtonsFormator() {
		return functionButtonsFormator;
	}
	private TableFormHiddenFormator hiddenFormator;
	public TableFormHiddenFormator getHiddenFormator() {
		return hiddenFormator;
	}
	public void setHiddenFormator(TableFormHiddenFormator hiddenFormator) {
		this.hiddenFormator = hiddenFormator;
	}
	
	public void setFunctionButtonsFormator(ButtonsFormator functionButtonsFormator) {
		this.functionButtonsFormator = functionButtonsFormator;
	}
	private TableFormator tableFormator;
	public TableFormator getTableFormator() {
		return tableFormator;
	}
	public void setTableFormator(TableFormator tableFormator) {
		this.tableFormator = tableFormator;
	}

	@Override
	public void formatHTML(EntityDescriptor descriptor, StringBuilder builder) {
		if(getContainerProvider()!=null)
			builder.append(getContainerProvider().getHeader());
		builder.append(FORM_HEADER);
		if(getFunctionButtonsFormator()!=null)
			getFunctionButtonsFormator().formatHTML(descriptor.getFunctionButtons(), builder);
		if(getHiddenFormator()!=null)
			getHiddenFormator().formatHTML(descriptor.getFormFields(), builder);		
		TableFormator formator=getTableFormator();
		if(formator!=null){
			if(formator instanceof ButtonsAcceptor){
				((ButtonsAcceptor) formator).setRowButtons(descriptor.getRowButtons());
			}
			getTableFormator().formatHTML(descriptor.getListColumns(), builder);
		}
		if(getFormators()!=null){
			for(EntityFormator pageFormator:getFormators()){
				pageFormator.formatHTML(descriptor, builder);
			}
		}		
		builder.append(FORM_TAIL);
		if(getContainerProvider()!=null){
			builder.append(getContainerProvider().getTail());
		}
	}

}
