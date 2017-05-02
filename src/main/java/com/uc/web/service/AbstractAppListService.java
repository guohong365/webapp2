package com.uc.web.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.uc.utils.export.Exportor;
import com.uc.web.forms.QueryForm;
import com.uc.web.forms.WebListFormBase;
import com.uc.web.forms.ui.componet.IPageCtrl;
import com.uc.web.forms.ui.componet.PageCtrl;
import com.uc.web.persistence.ExampleImpl;
import com.uc.web.persistence.Mapper;
import com.uc.web.persistence.AppListMapper;
import com.uc.web.persistence.Example;
import com.uc.web.persistence.AppOptimizedMapper;

public abstract class AbstractAppListService<KeyType, QueryFormType extends QueryForm<KeyType>, DetailType>
	extends ServiceBase
	implements AppListService<KeyType, QueryFormType, DetailType>

{

	private String defaultOrderByClause;
	private AppListMapper<DetailType> appListMapper;
	
	
	@SuppressWarnings("unchecked")
	public AppListMapper<DetailType> getAppListMapper() {
		if(getParent()!=null && appListMapper!=null){
			if(getParent().getMapper() instanceof AppListMapper){
				return (AppListMapper<DetailType>) getParent().getMapper();
			}
		}			
		return appListMapper;
	}
	
	public void setAppListMapper(AppListMapper<DetailType> appListMapper) {
		this.appListMapper = appListMapper;
	}
	
	@Override
	public Mapper getMapper() {
		return getAppListMapper();
	}
	
	@Override
	public boolean prepareExample(QueryFormType queryFormType, Example example) {
		return true;
	}
	
	@Override
	public String getDefaultOrderByClause() {
		return defaultOrderByClause;
	}

	@Override
	public String getErrorMessage(int code) {
		return ERROR_UNKNOWN;
	}

	@SuppressWarnings("unchecked")
	public AppOptimizedMapper<QueryFormType, DetailType> getOptimizedAppListMapper() {
		if (getAppListMapper() instanceof AppOptimizedMapper) {
			return (AppOptimizedMapper<QueryFormType, DetailType>) getAppListMapper();
		}
		return null;
	}

	@Override
	public void select(WebListFormBase<KeyType, QueryFormType, DetailType> webForm) {
		QueryFormType queryForm = webForm.getQuery();
		IPageCtrl pageCtrl = webForm.getPageCtrl();
		Example example = new ExampleImpl();
		if (!prepareExample(queryForm, example)) {
			getLogger().trace("prepare example failed.....");
			PageCtrl.initPageCtrl(pageCtrl, 0);
			webForm.setData(new ArrayList<DetailType>());
			return;
		}
		List<DetailType> list;

		if (getOptimizedAppListMapper() != null) {
			getLogger().trace("use optimized select.....");
			if (pageCtrl.getTotal() < 0) {
				long total = getOptimizedAppListMapper().selectCountOptimized(queryForm);
				getLogger().trace("record count={}", total);
				PageCtrl.initPageCtrl(pageCtrl, total);
				pageCtrl.setPageCount(total / pageCtrl.getPageSize() + (total % pageCtrl.getPageSize() == 0 ? 0 : 1));
				queryForm.setQueryOrderByClause(getDefaultOrderByClause());
			} else {
				pageCtrl.setOffset(pageCtrl.getCurrent() * pageCtrl.getPageSize());
			}
			if (pageCtrl.getTotal() == 0) {
				
				list = new ArrayList<>();
			} else {
				list = getOptimizedAppListMapper().selectOptimized(queryForm, pageCtrl.getOffset(),
						pageCtrl.getPageSize());
			}
			onAfterListSelected(list);
			webForm.setData(list);
			return;
		}

		if (pageCtrl.getTotal() < 0) {
			long total = getAppListMapper().selectCountByExample(example);
			PageCtrl.initPageCtrl(pageCtrl, total);
			pageCtrl.setPageCount(total / pageCtrl.getPageSize() + (total % pageCtrl.getPageSize() == 0 ? 0 : 1));
		} else {
			pageCtrl.setOffset(pageCtrl.getCurrent() * pageCtrl.getPageSize());
		}
		setOrderByClause(example, queryForm);
		if (pageCtrl.getTotal() == 0) {
			list = new ArrayList<>();
		} else {
			list = getAppListMapper().selectByExample(example, pageCtrl.getOffset(), pageCtrl.getPageSize());
		}

		onAfterListSelected(list);
		webForm.setData(list);
	}

	@Override
	public List<DetailType> selectForExport(QueryFormType queryForm) {
		Example example = new ExampleImpl();
		if (prepareExample(queryForm, example)) {
			setOrderByClause(example, queryForm);			
			if (getOptimizedAppListMapper() != null) {
				return getOptimizedAppListMapper().selectOptimized(queryForm, 0, Exportor.MAX_ROW);
			}
			return getAppListMapper().selectByExample(example, 0, Exportor.MAX_ROW);
		}
		return new ArrayList<>();
	}

	public void setDefaultOrderByClause(String defaultOrderByClause) {
		this.defaultOrderByClause = defaultOrderByClause;
	}
	
	protected boolean isOrderBy(QueryFormType queryForm) {
		return !StringUtils.isEmpty(queryForm.getQueryOrderByClause());
	}

	protected void onAfterListSelected(List<DetailType> list) {
	}


	protected void setOrderByClause(Example example, QueryFormType queryForm) {
		if (isOrderBy(queryForm)) {
			example.setOrderByClause(queryForm.getQueryOrderByClause());
		} else {
			example.setOrderByClause(getDefaultOrderByClause());
		}
	}


}
