package com.uc.web.controller.basic;

import com.uc.web.controller.AbstractDetailControllerProxy;

public abstract class AbstractIntegerKeyDetailControllerProxy<DetailType> 
	extends AbstractDetailControllerProxy<Long, DetailType>
	implements IntegerKeyDetailControllerProxy<DetailType>{
}
