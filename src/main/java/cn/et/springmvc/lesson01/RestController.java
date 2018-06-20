package cn.et.springmvc.lesson01;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/*
 * 404：找不到路径
 * 500：服务器抛异常
 * 405：请求方式不匹配
 * 
 * GET:查询
 * POST:新增
 * PUT:修改
 * DELETE:删除
 * 
 * 浏览器的提交方式必须和@RequestMapping指定的资源动作必须一致，否则抛405
 */
@Controller
public class RestController {

	/**
	 * 标准http协议资源定义方式：http://localhost:8080/missZhouSpringMVC/deleteUser?id=1
	 * 
	 * rest是一种设计风格，设计资源的标识符：
	 * rest访问路径：http://localhost:8080/missZhouSpringMVC/user/1
	 *  
	 *  如同/user/2   ，{userId}随便传来的id
	 */
//	@RequestMapping("/user/{id}")
	@RequestMapping("/user/{userId}")
	/**
	 * @PathVariable:告诉取的那个参数是在路径上面的，
	 * ①并且/user/{userId}必须要和变量名String userId名字相同，
	 * ②/user/{id}和String userId不同的话使用注解@PathVariable(value="id")指定与变量名相同进行绑定
	 */
	public String index(@PathVariable String userId) {
		return "/lesson01/user.jsp";
	}
	
	
	/**
	 * method=RequestMethod.GET：限定资源类型
	 */
	@RequestMapping(value="/user2/{id}",method=RequestMethod.GET)
	public String queryUser(@PathVariable(value="id") String userId) {
		return "/lesson01/user.jsp";
	}
	
	
	//服务器限定用post提交
	@RequestMapping(value="/user3",method=RequestMethod.POST)
	public String addUser(String name,HttpServletResponse response) throws IOException {
		
		response.getWriter().println(name+"---add success");
		
		return null;
	}
	
	
	@RequestMapping(value="/user4/{id}",method=RequestMethod.PUT)
	public String updateUser(@PathVariable(value="id") String userId,String name,HttpServletResponse response) throws IOException {
		
		response.getWriter().println(userId+"---update success==="+name);
		
		return null;
	}
	
	
	@RequestMapping(value="/user5/{userId}",method=RequestMethod.DELETE)
	public String deleteUser(String userId,HttpServletResponse response) throws IOException {
		
		response.getWriter().println(userId+"---delete success");
		
		return null;
	}
	
}
