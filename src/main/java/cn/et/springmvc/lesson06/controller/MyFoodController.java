package cn.et.springmvc.lesson06.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.et.springmvc.lesson06.dao.MyFoodDaoImpl;
import net.sf.json.JSONArray;

@Controller
public class MyFoodController {

	@Autowired
	MyFoodDaoImpl mdi;
	
	@RequestMapping(value="/queryFood",method=RequestMethod.GET)
	public String queryFood(String username,OutputStream os) throws UnsupportedEncodingException, IOException {
		
		List<Map<String,Object>> queryAllFood = mdi.queryAllFood(username);
		
		JSONArray arry = JSONArray.fromObject(queryAllFood);
		
		String jsonStr = arry.toString();
		
		os.write(jsonStr.getBytes("UTF-8"));
		
		return null;	
	}
}
