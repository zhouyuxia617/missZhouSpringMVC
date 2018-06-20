package cn.et.springmvc.lesson02.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.et.springmvc.lesson02.dao.FoodDao;

/**
 * 持久层，自动生成bean的
 */
@Repository
public class FoodDaoImpl implements FoodDao{

	//自动装配
	@Autowired
	JdbcTemplate template;
	
	/*
	 * 封装了get方法
	 * 
	 * 查询方法
	 */
	@Override
	public List<Map<String,Object>> getTableListPager(String name){
		
		String sql = " select * from food t where t.foodname like '%"+name+"%' ";
		
		List<Map<String,Object>> result = template.queryForList(sql);
		
		return result;
	}
	
	/*
	 * 新增方法
	 */
	@Override
	public void saveFood(String foodName,String price,String imagePath) {
		
		String sql = " insert into food values((select nvl(max(foodid),0)+1 from food),'"+foodName+"','"+price+"','"+imagePath+"') ";
	
		template.execute(sql);
	}
	
	/*
	 * 修改方法
	 */
	@Override
	public void updateFood(String foodid,String foodName,String price) {
		
		String sql = " update food set foodname='"+foodName+"',price='"+price+"' where foodid= "+foodid;
		
		template.execute(sql);
	}
	
	/*
	 * 删除方法
	 */
	@Override
	public void deleteFood(String foodid) {
		
		String sql = " delete from food where foodid= "+foodid;
		
		template.execute(sql);
	}
	
}
