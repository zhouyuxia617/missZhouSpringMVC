package cn.et.springmvc.lesson03.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * springmvc中Model相关对象是处理和数据相关的对象
 * @ModelAttribute:重命名参数数据
 * 
 * Model传递数据到视图(等价于request.setAttribute)
 * ModelMap也是传递数据到视图
 * Map也可以传递数据到视图
 * 
 * ModelAndView:绑定数据到视图(它里面有ModelMap:用于传递数据，View对象：用于跳转)
 */
@Controller
public class ModeController {
	
	@RequestMapping(value="/case",method=RequestMethod.GET)
	public String case1(Map map) {
		map.put("sex", "girl");
		
		return "/lesson03/res.jsp";
	}
	
	
	@RequestMapping(value="/case2",method=RequestMethod.GET)
	public ModelAndView case2() {
		ModelAndView mav = new ModelAndView("/lesson03/res.jsp");
		mav.addObject("sex","boy");
		mav.addObject("age","18");
		
		return mav;
	}
	
	
	@RequestMapping(value="/case3",method=RequestMethod.GET)
	public ModelAndView case3() {
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/lesson03/res.jsp");
		mav.addObject("sex","boy");
		
		return mav;
	}
	
}
