package cn.et.springmvc.lesson02.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.et.springmvc.lesson02.dao.FoodDao;
import cn.et.springmvc.lesson02.service.FoodService;

/**
 * 业务逻辑层，自动生成bean
 */
@Service
public class FoodServiceImpl implements FoodService{

	@Autowired
	FoodDao dao;
	
	/*
	 * 查询方法
	 */
	@Override
	public List<Map<String, Object>> getTableListPager(String name) {
		if(name == null) {
			name = "";
		}
		
		return dao.getTableListPager(name);
	}

	/*
	 * 新增方法
	 */
	@Override
	public void saveFood(String foodName, String price, String imagePath) {
		dao.saveFood(foodName, price, imagePath);
	}

	/*
	 * 修改方法
	 */
	@Override
	public void updateFood(String foodid, String foodName, String price) {
		dao.updateFood(foodid, foodName, price);
	}

	/*
	 * 删除方法
	 */
	@Override
	public void deleteFood(String foodid) {
		dao.deleteFood(foodid);
	}

}
