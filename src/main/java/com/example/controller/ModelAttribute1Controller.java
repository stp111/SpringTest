package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.Student;


/**
 * 如果把@ModelAttribute放在方法的注解上时，代表的是：该Controller的所有方法在调用前，先执行此@ModelAttribute方法。
 * 在默认情况下，ModelMap 中的属性作用域是 request 级别是，也就是说，当本次请求结束后，ModelMap 中的属性将销毁。
 * 
 * 如果希望在多个请求中共享 ModelMap中的属性，必须将其属性转存到 session 中，这样ModelMap 的属性才可以被跨请求访问。
 * Spring 允许我们有选择地指定 ModelMap 中的哪些属性需要转存到 session 中，以便下一个请求属对应的ModelMap 的属性 列表中还能访问到这些属性。
 * 这一功能是通过类定义处标注 @SessionAttributes 注解来实现的。
 * @author shentianping
 *
 */
@Controller
public class ModelAttribute1Controller {

	private Logger logger = LoggerFactory.getLogger("StudentController");
	/**
	 * 参数说明： 
	 * 	1. 这里@RequestParam参数id会被注入。
	 * 	2. model对象也会被action对应的方法传递过来
	 * 返回值说明
	 * 	可以void -- 无需返回任何值。在这个request的生命周期内，model作为桥梁了。
	 */
	@ModelAttribute
	public void popModel(@RequestParam Long id, Model model) {
		logger.info("popModel for @ModelAttribute at "+this+"\t thread: "+Thread.currentThread());
		
		
		Student student = new Student();
		student.setId(id);
		student.setName("name"+id);
		
		model.addAttribute("student", student);
	}
	
	@RequestMapping(value="/find")
	@ResponseBody
	public String getStudent(long id) {
		logger.info("getStudent start");
		
		return "find the student....";
	}
	
	
	@RequestMapping(value="/findById")
	public String getStudentById(long id) {
		logger.info("getStudent start");
		/**
		 * 说明： 
		 * 这里方法没有声明model，但是在@ModelAttribute注解的方法中操作了model，所以在view中
		 * 可以访问model对象。
		 */
		return "findStudent";
	}
}
