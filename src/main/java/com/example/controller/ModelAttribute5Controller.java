package com.example.controller;

import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.Student;

/**
 * @ModelAttribute注释一个方法的参数时
 *  
 * 重要！！重要！！重要！！（重要的事情说3遍）
 * 
 * 这里如果访问 /request5,结果如文档说说，如你所想！！
 * 如果访问/request5?id=1,结果则不同！！[此时从form或者url参数中获取对象了]
 * 在url中使用id=1的参数输入时，这是会使用id=1生成新的student对象。
 * 而Model中最会被上面的@ModelAttribute("student")注解添加一个student属性对象
 * @author shentianping
 *
 */
@Controller
public class ModelAttribute5Controller {

	private Logger logger = LoggerFactory.getLogger("model attribte 3");
	
	
	@ModelAttribute("student")
	public Student addStudent() {
		logger.info("addStudent start .... ");
		Student student = new Student();
		student.setId(5);
		logger.info("addStudent's student:" + student);
		return student;
	}
	
	/**
	 * 重要！！重要！！重要！！（重要的事情说3遍）
	 * 
	 * 这里如果访问 /request5,结果如文档说说，如你所想！！
	 * 如果访问/request5?id=1,结果则不同！！
	 * 在url中使用id=1的参数输入时，这是会使用id=1生成新的student对象。
	 * 而Model中最会被上面的@ModelAttribute("student")注解添加一个student属性对象
	 */
	@RequestMapping(value = "/request5")
	public String request5(@ModelAttribute("student") Student student, Model model) {
		logger.info("request5 student "+student);
		
		student.setName("name "+student.getId());
		return "findStudent";
	}
	
	@RequestMapping(value = "/request5-1")
	public String request5_1(@ModelAttribute("student") Student student, Model model) {
		logger.info("request5-1 student "+student);
		
		logger.info("obj at model: --- ");
		Map<String, Object> map = model.asMap();
		
		Set<String> keys = map.keySet();
		for(String key : keys) {
			Object obj = map.get(key);
			logger.info("obj:"+obj);
		}
		
		student.setName("name "+student.getId());
		return "findStudent";
	}
}
