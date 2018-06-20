package cn.et.springmvc.lesson01;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 在springmvc中，一个路径和方法的映射叫做一个action（动作）
 * 一个控制层中可以有多个动作
 */
//创建一个类名首字母小写的bean
@Controller
public class HelloController {
	
	//目前返回值必须是String类型，参数可以任意多个
	@RequestMapping("/test")
	public String index(HttpServletResponse response) throws IOException {
		
		response.getWriter().println("hello 敌敌霞");
		
		return null;
	}
	
	//http://localhost:8080/missZhouSpringMVC/text2
	@RequestMapping("/text2")
	//加了参数就是耦合(可以降耦合)，Stringmvc是无侵入式的，不要用servlet的api里的东西
	public String index2(HttpServletRequest request,HttpServletResponse response) throws IOException {

		//获取参数id
		response.getWriter().println("hello springmvc="+request.getParameter("id"));
		
		return null;
	}
	
	/**
	 * http://localhost:8080/missZhouSpringMVC/param
	 * http://localhost:8080/missZhouSpringMVC/param.html?id=21&name=敌敌霞
	 * 访问与方法名无关，与路径有关，路径名必须不同
	 */
	@RequestMapping("/param")
	//参数是可以无限多个的，类型用String
	public String param(String id,String name,HttpServletResponse response) throws IOException {
		
		response.getWriter().println(id+"----"+name);
		
		return null;
	}
	
	
	/**
	 * 降耦合的方式：
	 * 参数多建议使用对象的方式，参数只有一个可以使用类型定义。
	 * 把需要的参数自动填充到实体类中，只要名字匹配上
	 */
	@RequestMapping("/param2")
	public String param2(User user,HttpServletResponse response) throws IOException{
		
		response.getWriter().println(user.getId()+"--"+user.getName());
		
		return null;
	}
	
	
	@RequestMapping("/mvc")
	public String mvc() {
		
		//如同跳转（请求转发）：request.getRequestDispatcher(null).forward("/index.jsp");
		return "/index.jsp";
	}
	
	@RequestMapping("/mvc2")
	public String mvc2(HttpServletRequest request) {
		
		request.setAttribute("name", "敌敌霞");
		
		return "/index.jsp";
	}
	
	
}
