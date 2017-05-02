package com.uc.web.tools.generator.ace.list;

import java.util.List;

import com.uc.web.forms.ui.AbstractUIFormatorBase;
import com.uc.web.tools.generator.TableBodyFormator;
import com.uc.web.tools.generator.ButtonDescriptor;
import com.uc.web.tools.generator.ButtonsAcceptor;
import com.uc.web.tools.generator.ListColumnDescriptor;
import com.uc.web.tools.generator.TableFormator;
import com.uc.web.tools.generator.TableHeaderFormator;

public class TableFormatorImpl extends AbstractUIFormatorBase implements TableFormator, ButtonsAcceptor {	

	static final String HEADER=
    		"<!-- table data begin-->"+
    		"<table class=\"table table-striped table-bordered table-hover dataTable no-footer\">";
    static final String TAIL=
    		"</table><!-- table data end -->";
    private List<ButtonDescriptor> rowButtons;
    @Override
    public List<ButtonDescriptor> getRowButtons() {
		return rowButtons;
	}
    @Override
    public void setRowButtons(List<ButtonDescriptor> rowButtons) {
		this.rowButtons = rowButtons;
	}
    
    private TableHeaderFormator tableHeaderFormator;
    
    public TableHeaderFormator getTableHeaderFormator() {
		return tableHeaderFormator;
	}
    public void setTableHeaderFormator(TableHeaderFormator tableHeaderFormator) {
		this.tableHeaderFormator = tableHeaderFormator;
	}
    private TableBodyFormator tableBodayFormator;
    public TableBodyFormator getTableBodayFormator() {
		return tableBodayFormator;
	}
    public void setTableBodayFormator(TableBodyFormator tableBodayFormator) {
		this.tableBodayFormator = tableBodayFormator;
	}
	@Override
	public void formatHTML(List<ListColumnDescriptor> componet, StringBuilder builder) {
		if(getContainerProvider()!=null)
			builder.append(getContainerProvider().getHeader());
		builder.append(HEADER);
		TableHeaderFormator headerFormator=getTableHeaderFormator();
		if(headerFormator!=null){
			headerFormator.formatHTML(componet, builder);
		}
		TableBodyFormator bodyFormator=getTableBodayFormator();
		if(bodyFormator!=null){
			if(bodyFormator instanceof ButtonsAcceptor){				
				((ButtonsAcceptor) bodyFormator).setRowButtons(getRowButtons());
			}			
			bodyFormator.formatHTML(componet, builder);
		}
		
		builder.append(TAIL);
		
		if(getContainerProvider()!=null)
			builder.append(getContainerProvider().getHeader());
	}
}
