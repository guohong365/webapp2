package com.uc.web.service.basic;

import com.uc.web.service.AbstractAppDetailService;

public class GenericStringKeyAppDetailService<DetailType>
	extends AbstractAppDetailService<String, DetailType> 
	implements StringKeyAppDetailService<DetailType>{

}
