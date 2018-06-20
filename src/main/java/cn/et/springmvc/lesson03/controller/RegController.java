package cn.et.springmvc.lesson03.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.et.springmvc.lesson03.entity.UserInfo;

//注解扫描，自动生成bean
@Controller
public class RegController {

	/*@RequestMapping(value="/reg",method=RequestMethod.POST)
	public String queryFoodById(@Valid UserInfo user) {
		return "/lesson03/suc.jsp";
	}*/
	
	/**
	 * 后台验证步骤：
	 * 	  1.javabean添加验证注解
	 *    2.action中使用@value表示javabean使用Errors或则BindingResult判断是否验证失败
	 *    3.出现jar包冲突
	 */
/*	@RequestMapping(value="/reg",method=RequestMethod.POST)
	public String reg(@Valid UserInfo user,Errors error) {
		if(error.hasErrors()) {
			return "/lesson03/fail.jsp"; //有错跳到错误页面去
		}
		return "/lesson03/suc.jsp";
	}*/
	
	
	@RequestMapping(value="/reg",method=RequestMethod.POST)
	public String reg(@Valid UserInfo user,BindingResult error) {
	//使用@ModelAttribute("user")，就必须把UserInfo类中和本类中的所有userInfo. 改成 user.
//	public String reg(@ModelAttribute("user") @Valid UserInfo user,BindingResult error) {
		/**
		 * 编程式验证密码是否相同
		 */
		if(! user.getPassword().equals(user.getRepassword())) {
			error.addError(new FieldError("userInfo","repassword","两次密码不一致"));
		}
		
		/**
		 * 编程式验证年龄
		 */
	/*	Integer age;
		try {
			if(user.getAge()==null || "".equals(user.getAge().trim())) {
				error.addError(new FieldError("userInfo","age","年龄不能为空！"));
			}else {
				age = Integer.parseInt(user.getAge());
				if(age<1 || age>150) {
					error.addError(new FieldError("userInfo","age","年龄必须在1-150之间"));
				}
			}
		}catch(Exception e){
			error.addError(new FieldError("userInfo","age","年龄必须是数字！"));
		}
	 */
		
		if(error.hasErrors()) {
			return "/lesson03/reg.jsp"; //有错就跳回去
		}
		return "/lesson03/suc.jsp";
	}
	
}
