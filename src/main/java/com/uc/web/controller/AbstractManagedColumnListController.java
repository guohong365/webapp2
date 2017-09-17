package com.uc.web.controller;

import org.springframework.ui.Model;

import com.uc.web.controller.AbstractListController;
import com.uc.web.domain.security.UserProfile;
import com.uc.web.forms.ColumnsManager;
import com.uc.web.forms.ListQueryForm;
import com.uc.web.forms.controller.factory.ColumnsManagerFactory;
import com.uc.web.forms.controller.factory.ColumnsManagerFactoryRepository;

public abstract class AbstractManagedColumnListController<QueryFormType extends ListQueryForm>
	extends AbstractListController<QueryFormType>
	implements ManagedColumnListController{
	protected static final String PAGE_PATH_COLUMN_SELECTION = "/util/columns-show";
	
	public ColumnsManager getColumnManager(String name){
		ColumnsManager manager =getUser().getSettings().get(name);
		if(manager==null && ColumnsManagerFactoryRepository.getInstance()!=null){
			ColumnsManagerFactory factory= ColumnsManagerFactoryRepository.getInstance().get(name);
			if(factory!=null){
				manager=factory.create();
				getUser().getSettings().put(name, manager);				
			}
		}
		return manager;
	}

	@Override
	protected void onSetListModel(UserProfile user, Model model) {
		getShowColumns(getModuleName(), model);
	}

	public String getShowColumns(String mode, Model model) {
		ColumnsManager manager = getColumnManager(mode);
		System.err.println(manager);
		if(manager!=null) {
			model.addAttribute(PARAM_NAME_COLUMNS, manager.getColumns());
		}
		return PAGE_PATH_COLUMN_SELECTION;
	}

	public String postSetShowColumns(String mode, String columns) {
		ColumnsManager manager = getColumnManager(mode);
		if (manager != null) {
			getLogger().trace("got user's ColumnsController for mode[" + mode + "] by ["+ columns +"], and update it.........");
			manager.setShowByFlagString(columns);
		}
		return "OK";
	}

}
