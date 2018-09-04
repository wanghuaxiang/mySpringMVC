package com.wanghuaxiang.mvc.demo.mvc.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wanghuaxiang.mvc.demo.service.INamedService;
import com.wanghuaxiang.mvc.demo.service.IService;
import com.wanghuaxiang.mvc.framework.annotation.MyAutowired;
import com.wanghuaxiang.mvc.framework.annotation.MyController;
import com.wanghuaxiang.mvc.framework.annotation.MyRequestMapping;
import com.wanghuaxiang.mvc.framework.annotation.MyRequestParam;
import com.wanghuaxiang.mvc.framework.servlet.MyModelAndView;

@MyController
@MyRequestMapping("/web")
public class FirstAction {

	@MyAutowired
	private IService		service;

	@MyAutowired("myName")
	private INamedService	namedService;

	@MyRequestMapping("/query/.*.json")
	// @MyResponseBody
	public MyModelAndView query(HttpServletRequest request, HttpServletResponse response,
			@MyRequestParam(value = "name", required = false) String name, @MyRequestParam("addr") String addr) {
		// out(response,"get params name = " + name);
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("name", name);
		model.put("addr", addr);
		return new MyModelAndView("first.pgml", model);
	}

	@MyRequestMapping("/add.json")
	public MyModelAndView add(HttpServletRequest request, HttpServletResponse response) {
		out(response, "this is json string");
		return null;
	}

	public void out(HttpServletResponse response, String str) {
		try {
			response.getWriter().write(str);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
