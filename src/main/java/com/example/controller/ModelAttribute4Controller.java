package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ModelAttribute和@RequestMapping同时注释一个方法 
 *  这时这个方法的返回值并不是表示一个视图名称，而是model属性的值，视图名称由RequestToViewNameTranslator根据请求"url"转换为逻辑视图。
 *  Model属性名称有@ModelAttribute(value=””)指定，相当于在request中封装了key=attributeName，value=[方法返回值]。
 * @author shentianping
 *
 */
@Controller
public class ModelAttribute4Controller {

	private Logger logger = LoggerFactory.getLogger("model attribte 3");
	
	@RequestMapping(value = "/request4")
	@ModelAttribute("attributeName")
	public String request4() {
		logger.info("request4");
		return "Hi, this is from request4";
	}
}
