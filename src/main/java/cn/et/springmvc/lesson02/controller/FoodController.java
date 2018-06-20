package cn.et.springmvc.lesson02.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.et.springmvc.lesson02.service.FoodService;

/**
 * 控制层，自动生成bean
 */
@Controller
public class FoodController {

	//把service自动装配进来
	@Autowired
	FoodService service;
	
	//映射一个路径,并限定只能用来做查询GET
	@RequestMapping(value="/showFood",method=RequestMethod.GET)
	public String queryFood(Model model) {
		//null代表查询所有
		List<Map<String,Object>> tableListPager = service.getTableListPager(null);
	
		//等价于request.setAttribute("","")
		model.addAttribute("foodList",tableListPager);
	
		return "";
	}
}
