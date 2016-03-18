package com.example.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.Student;

@Controller
public class ModelAttribute2Controller {

	private Logger logger = LoggerFactory.getLogger("model attribte 2");
	
	/**
	 * 说明：
	 * 	1. @ModelAttribute 带value参数 -- 此参数作为model.addAttribute的attributeName。
	 *  2. 方法参数 -- 可以如controller 1 中，方法带参数。也可以如下，不使用参数。
	 *  3. 返回值: 返回了一个对象，这个对应会被注入到此request的model中,attributeName是@ModelAttribute注解中的value参数。
	 */
	@ModelAttribute("myRequestObject")
	public Student addStuffToRequestScope() {
		logger.info("Inside of addStuffToRequestScope");
		Student bean = new Student();
		
		int studentId = 6;
		bean.setId(studentId);
		bean.setName("name"+studentId);
		return bean;
	} 
	
	@RequestMapping("/request1")
	@ResponseBody
	public String request1(Model model) {
		logger.info("request 1 : -- model -- ");
		
		Map modelMap = model.asMap();
		for (Object modelKey : modelMap.keySet()) {
			Object modelValue = modelMap.get(modelKey);
			logger.info(modelKey + " -- " + modelValue);
		}
		return "request 1 finished";
	}
	
}
