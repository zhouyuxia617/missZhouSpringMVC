package cn.et.springmvc.lesson06.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class Test {
	
	/**
	 * {
	 * 	  id:1,
	 *    username:'A'
	 * }
	 * @param <JSONObject>
	 */
	public static void parseObject() {
		Map map = new HashMap();
		map.put("id", 1);
		map.put("username", 'A');
		
		JSONObject jo = JSONObject.fromObject(map);
		System.out.println(jo.toString());
	}
	
	/**
	 *注意：json字符串的键一定要带双引号“key”：1
	 * 	      值是数字不需要“”，字符串必须带
	 * 
	 [{
	 	id:3,
	 	username:"A",
	 	lostedmoney:80
	 },{
	 	id:4,
	 	username:"B",
	 	lostedmoney:100
	 }]
	 */
	public static void parseArray() {
		Map map = new HashMap();
		map.put("id",1);
		map.put("username","A");
		
		Map map2 = new HashMap();
		map2.put("id", 2);
		map2.put("username","B");
		
		List list = new ArrayList();
		list.add(map);
		list.add(map2);
		
		JSONArray ja = JSONArray.fromObject(list);
		System.out.println(ja.toString());
	}
	
	
	/*
		{
			"id":1,
			"address":{
				"stree":"gl",
				"city":"sz"
			},
			"username":"A"
		}
	 */
	public static void parseJsonArray() {
		Map map = new HashMap();
		map.put("id",1);
		map.put("username","A");
		
		Map address = new HashMap();
		address.put("city", "sz");
		address.put("stree", "gl");
		map.put("address", address);
		
		JSONObject jo = JSONObject.fromObject(map);
		System.out.println(jo.toString());
	}
	

	public static void main(String[] args) {
		/*Map map = new HashMap();
		map.put("id",1);
		map.put("username","A");
		
		Map map2 = new HashMap();
		map2.put("id", 2);
		map2.put("username","B");
		
		List list = new ArrayList();
		list.add(map);*/
		
		parseObject();
		
		parseArray();
		
		parseJsonArray();
	}
}
