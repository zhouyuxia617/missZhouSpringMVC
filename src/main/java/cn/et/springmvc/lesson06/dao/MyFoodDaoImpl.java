package cn.et.springmvc.lesson06.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MyFoodDaoImpl {

	@Autowired
	JdbcTemplate jdbc;
	
	/*
	 * ajax的查询程序，第一次用刷新，后面的完全无刷新的
	 */
	public List<Map<String,Object>> queryAllFood(String username){
		return jdbc.queryForList("select * from mymoney where username like '%"+username+"%'");
	}
	
}
