package com.example.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.model.Student;

/**
 * @SessionAttribute 注解使用
 * Spring 允许我们有选择地指定 ModelMap 中的哪些属性需要转存到 session 中，以便下一个请求属对应的ModelMap 的属性 列表中还能访问到这些属性。
 * 这一功能是通过类定义处标注 @SessionAttributes 注解来实现的。
 * @author shentianping
 *
 */
@Controller
@SessionAttributes("currentStudent")
public class SessionAttribute1Controller {

	//
	private Logger logger = LoggerFactory.getLogger("SessionAttribute 1 Controller");
	
	@RequestMapping("/sessionstart")
	public String sessionStart(Student student, Model model) {
		logger.info("start the session model .... ");
		
		// 
		if (null == student.getName()) {
			student.setName("name"+student.getId());
		}
		
		model.addAttribute("currentStudent", student);
		
		return "sessionmodel/start";
	}
	
	
	@RequestMapping("/sessioncheck")
	public String sessionCheck(HttpServletRequest request, Model model) {
		logger.info("session check...");
		
		//check model -- session attribute obj is here !!!
		Map<String, Object> modelMap = model.asMap();
		for (Object modelKey : modelMap.keySet()) {
			
			Object modelValue = modelMap.get(modelKey);
			Class<? extends Object> className = modelValue.getClass();
			
			logger.info("object's class:"+className);
			
			logger.info("model objs: " + modelKey + " -- " + modelValue);
		}
		
		
		// check session, OK... it's here!!
		HttpSession sess = request.getSession();
		Student std = (Student) sess.getAttribute("currentStudent");
		logger.info("session student:"+std);
		
		model.addAttribute("student",std);
		return "sessionmodel/check";
	}
}
