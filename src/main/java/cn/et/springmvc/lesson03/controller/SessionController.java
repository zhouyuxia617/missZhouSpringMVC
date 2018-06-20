package cn.et.springmvc.lesson03.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import cn.et.springmvc.lesson03.entity.User;


@SessionAttributes("user")
//spring中默认的bean是单例的
@Controller
public class SessionController {

/** @RequestMapping(value="/s1",method=RequestMethod.GET)
	public String case1(Map map) {
		return "/s2";
	}

	@RequestMapping(value="/s2",method=RequestMethod.GET)
	public String case2() {
		return "/lesson03/res.jsp";
	}
	*/
	
	
	/*
	 * 模型不能共享
	 */
/**	@RequestMapping(value="/s1",method=RequestMethod.GET)
	public String case1(Map map) {
		map.put("age", 21);
		return "/s2";
	}

	@RequestMapping(value="/s2",method=RequestMethod.GET)
	public String case2(Map map,HttpServletResponse response) throws IOException {
		
		response.getWriter().println(map.get("age"));
		
		return "/lesson03/res.jsp";
	}
	*/
	
	
	/*
	 * http:localhost:8080/s/s1?id=1
	 * 请求转发（一次请求）：forward --- 参数不丢失，路径不改
	 * 请求重定向（两次请求）：redirect  --- 参数丢失，改路径
	 */
/**	@RequestMapping(value="/s1",method=RequestMethod.GET)
	public String case1(Map map) {
		return "forward:/s2";
	}*/
/**	@RequestMapping(value="/s1",method=RequestMethod.GET)
	public String case1(Map map) {
		return "redirect:/s2";
	}

	@RequestMapping(value="/s2",method=RequestMethod.GET)
	public String case2(String id,HttpServletResponse response) throws IOException {
		
		response.getWriter().println(id);
		
		return "/lesson03/res.jsp";
	}*/
	
	
	//用了SessionStatus必须要写这个，不然会报空null，一般不建议使用，只适合请求重定向
	@ModelAttribute("user")
	public User getUser() {
		User users = new User();
		return users;
	}
	
	@RequestMapping(value="/s1",method=RequestMethod.GET)
	public String case1(@ModelAttribute("user") User user) {
		return "redirect:/s2";
	}

	/**
	 * 请求转发forward：不需要任何处理
	 * 请求重定向redirect：使用SessionAttribute方式，用于在重定向中传至将值存储在session中，用完记住清除。
	 */
	@RequestMapping(value="/s2",method=RequestMethod.GET)
	public String case2(Map map,HttpServletResponse response,SessionStatus sessionStatus) throws IOException {
		
		User users = (User)map.get("user");
		response.getWriter().println(users.getId());
		
		//用完清除
		sessionStatus.setComplete();
		return null;
	}
	
}
