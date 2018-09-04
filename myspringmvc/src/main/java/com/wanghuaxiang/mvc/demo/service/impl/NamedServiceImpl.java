package com.wanghuaxiang.mvc.demo.service.impl;

import com.wanghuaxiang.mvc.demo.service.INamedService;
import com.wanghuaxiang.mvc.demo.service.IService;
import com.wanghuaxiang.mvc.framework.annotation.MyAutowired;
import com.wanghuaxiang.mvc.framework.annotation.MyService;

@MyService("myName")
public class NamedServiceImpl implements INamedService{

	@MyAutowired IService service;
	
}
