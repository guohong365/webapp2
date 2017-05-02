package com.uc.web.controller.basic;

import com.uc.web.controller.AbstractDetailController;

public abstract class AbstractIntegerKeyDetailController<DetailType> 
	extends AbstractDetailController<Long, DetailType>
	implements IntegerKeyDetailController<DetailType>{
}
