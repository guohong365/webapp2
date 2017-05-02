package com.uc.web.service.basic;

import com.uc.web.service.AbstractAppDetailService;

public class GenericIntegerKeyAppDetailService<DetailType> 
	extends AbstractAppDetailService<Long, DetailType> 
	implements IntegerKeyAppDetailService<DetailType>{
}
