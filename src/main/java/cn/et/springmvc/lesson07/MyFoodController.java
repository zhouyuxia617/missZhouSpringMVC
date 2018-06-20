package cn.et.springmvc.lesson07;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import net.sf.json.JSONArray;

@Controller
public class MyFoodController {

	@Autowired
	MyFoodDaoImpl mdi;
	
	/**
	 * 查询mymoney
	 * @param username   用户名
	 * @param os
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	//拉数据用get，发送数据用post
	@RequestMapping(value="/queryFood",method={RequestMethod.GET,RequestMethod.POST})
	public String queryFood(String username,OutputStream os) throws UnsupportedEncodingException, IOException {
		
		List<Map<String,Object>> queryAllFood = mdi.queryAllFood(username);
		
		JSONArray arry = JSONArray.fromObject(queryAllFood);
		
		String jsonStr = arry.toString();
		
		os.write(jsonStr.getBytes("UTF-8"));
		
		return null;	
	}
	
	/**
	 * 删除mymoney
	 * @param id   用户id
	 * @param os
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	@RequestMapping(value="/food/{id}",method={RequestMethod.DELETE})
	public String deleteFood(@PathVariable String id,OutputStream os) throws UnsupportedEncodingException, IOException {
		try {
			mdi.deleteFood(id);
			os.write("1".getBytes("UTF-8"));
		}catch(Exception e) {
			e.printStackTrace();
			os.write("0".getBytes("UTF-8"));
		}
		
		return null;
	}
	
	/**
	 * 修改mymoney
	 * @param id   用户id
	 * @param username   用户名
	 * @param lostedmoney  余额
	 * @param os
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	@RequestMapping(value="/food/{id}",method={RequestMethod.PUT})
	public String updateFood(@PathVariable String id,String username,String lostedmoney,OutputStream os) throws UnsupportedEncodingException, IOException {
		try {
			mdi.updateFood(id, username, lostedmoney);
			os.write("1".getBytes("UTF-8"));
		}catch(Exception e) {
			e.printStackTrace();
			os.write("0".getBytes("UTF-8"));
		}
		
		return null;
	}
	
	/**
	 * 添加mymoney
	 * @param username  用户名
	 * @param lostedmoney  余额
	 * @param os
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws IOException
	 */
	@RequestMapping(value="/food",method={RequestMethod.POST})
	public String saveFood(String username,String lostedmoney,OutputStream os) throws UnsupportedEncodingException, IOException {
		try {
			mdi.saveFood(username, lostedmoney);
			os.write("1".getBytes("UTF-8"));
		}catch(Exception e) {
			e.printStackTrace();
			os.write("0".getBytes("UTF-8"));
		}
		
		return null;
	}
}
