package cn.et.springmvc.lesson05.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MoneyDaoImpl {

	@Autowired
	JdbcTemplate jdbc;
	
	public void trasnateMoney(int money) {
		String sql = "update mymoney set lostedomoney=lostedmoney-"+money+"where id=2";
	
		jdbc.execute(sql);
	}
	
	
	public int selectMoney() {
		String sql ="select lostedmoney from mymoney where id=2 ";
		
		Integer lostedMoney = jdbc.queryForObject(sql,Integer.class);
		
		return lostedMoney;
	}
	
}
