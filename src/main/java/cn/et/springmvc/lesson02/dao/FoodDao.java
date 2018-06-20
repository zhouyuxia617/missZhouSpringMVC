package cn.et.springmvc.lesson02.dao;

import java.util.List;
import java.util.Map;

public interface FoodDao {

	/*
	 * 查询
	 */
	public abstract List<Map<String,Object>> getTableListPager(String name);
	
	/*
	 * 新增
	 */
	public abstract void saveFood(String foodName,String price,String imagePath);
	
	/*
	 * 修改
	 */
	public abstract void updateFood(String foodid,String foodName,String price);
	
	/*
	 * 删除
	 */
	public abstract void deleteFood(String foodid);
	
}
