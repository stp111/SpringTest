package com.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.Student;

/**
 * @ModelAttribute 中处理list数据
 * @author shentianping
 *
 */
@Controller
public class ModelAttribute3Controller {
	private Logger logger = LoggerFactory.getLogger("model attribte 3");
	
	/**
	 * 说明：
	 * 	1. @ModelAttribute 带value参数 -- 此参数作为model.addAttribute的attributeName。
	 *  2. 返回值: 返回了一个对象列表或数组，这个对应会被注入到此request的model中,attributeName是@ModelAttribute注解中的value参数。
	 */
	@ModelAttribute("myRequestObject")
	public List<Student> addStuffToRequestScope() {
		logger.info("Inside of addStuffToRequestScope");
		
		List<Student> students = new ArrayList<Student>();
		
		for (int i= 0; i<3; i++) {
			Student bean = new Student();
			
			int studentId = i;
			bean.setId(studentId);
			bean.setName("name"+studentId);
			
			students.add(bean);
		}
		
		return students;
	} 
	
	@RequestMapping("/request3")
	@ResponseBody
	public String request3(Model model) {
		logger.info("request 3 : -- model -- ");
		
		Map<String, Object> modelMap = model.asMap();
		for (Object modelKey : modelMap.keySet()) {
			
			Object modelValue = modelMap.get(modelKey);
			Class<? extends Object> className = modelValue.getClass();
			
			logger.info("object's class:"+className);
			
			logger.info(modelKey + " -- " + modelValue);
		}
		return "request 3 finished";
	}
}
