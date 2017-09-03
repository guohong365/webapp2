package com.uc.web.service;

import java.util.ArrayList;
import java.util.List;

import com.uc.utils.export.Exportor;
import com.uc.web.forms.ListQueryForm;
import com.uc.web.forms.WebListForm;
import com.uc.web.forms.ui.componet.PageCtrl;

public class AppWebListServiceBase<QueryFormType extends ListQueryForm, EntityType>
	extends AppListServiceBase<QueryFormType, EntityType>
	implements AppWebListService<QueryFormType, EntityType>
{

	@Override
	public void select(WebListForm<QueryFormType, EntityType> webForm) {
		QueryFormType queryForm = webForm.getQuery();
		PageCtrl pageCtrl = queryForm.getPageCtrl();

		Long count=null;
		List<EntityType> list= null;
		
		count=selectCount(queryForm);		
		if(count==null){
			PageCtrl.initPageCtrl(queryForm.getPageCtrl(), 0);
			webForm.setData(new ArrayList<>());
			return;
		}
		if(pageCtrl.getTotal() < 0){
			PageCtrl.initPageCtrl(pageCtrl, count);			
		} else if(count == 0){
			PageCtrl.initPageCtrl(pageCtrl, 0);			
		} else {  //update total of pageCtrl
			pageCtrl.setTotal(count);
			
		}
		
		list=select(queryForm, queryForm.getPageCtrl().getOffset(), queryForm.getPageCtrl().getPageSize());
		onAfterListSelected(list);
		webForm.setData(list);
	}

	@Override
	public List<EntityType> selectForExport(QueryFormType queryForm) {
		Long count= selectCount(queryForm);
		if(count==null){
			return new ArrayList<>();
		}				
		return select(queryForm, 0, Exportor.MAX_ROW);
	}

}
