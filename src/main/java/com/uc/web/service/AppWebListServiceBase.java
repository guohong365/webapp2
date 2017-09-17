package com.uc.web.service;

import java.util.ArrayList;
import java.util.List;

import com.uc.utils.export.Exportor;
import com.uc.web.forms.ListQueryForm;
import com.uc.web.forms.ui.componet.PageCtrl;

public class AppWebListServiceBase	extends AppListServiceBase	implements AppWebListService
{

	@Override
	public List<?> select(ListQueryForm queryForm, PageCtrl pageCtrl) {		
		Long count=null;
		List<?> list;
		
		count=selectCount(queryForm);		
		if(count==null || count == 0){
			PageCtrl.initPageCtrl(pageCtrl, 0);
			return new ArrayList<>();
		}
		if(pageCtrl.getOffset() < 0){
			PageCtrl.initPageCtrl(pageCtrl, count);			
		} else {  //update total of pageCtrl
			pageCtrl.setTotal(count);
		}		
		list=select(queryForm, pageCtrl.getOffset(), pageCtrl.getPageSize());
		onAfterListSelected(list);
		return list;
	}

	@Override
	public List<?> selectForExport(ListQueryForm queryForm) {
		Long count= selectCount(queryForm);
		if(count==null){
			return new ArrayList<>();
		}				
		return select(queryForm, 0, Exportor.MAX_ROW);
	}

}
