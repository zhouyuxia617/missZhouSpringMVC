package cn.et.springmvc.lesson06.entity;

public class UserInfo {

	private String name = "BeJson";
	private String url = "http://www.bejson.com";
	private Address address;
	
	/*
	 * 在json中:
	 * 	普通的数据是使用--->键：值
	 *  对象使用--->键：{
	 *  
	 *  		 }
	 *  数组使用--->键：[{
	 *  				},{
	 *  			}]
	 * 
	 {
	 	"name": "BeJson",
	 	"url": "http://www.bejson.com",
	 	"address":[{
	 		"street": "科技园路",
	 		"city": "江苏苏州",
	 		"country": "中国"
	 	},{
	 		"street": "道县一中寇公璐",
	 		"city": "永州道县",
	 		"country": "中国"
	 	}]
	 }
	 */
}
