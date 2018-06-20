package cn.et.springmvc.lesson07;

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

	/*
	 * 删除
	 */
	public void deleteFood(String id){
		jdbc.execute("delete from mymoney where id= "+id);
	}
	
	/*
	 * 添加
	 */
	public void saveFood(String username,String lostedmoney){
		jdbc.execute("insert into mymoney(username,lostedmoney) values('"+username+"','"+lostedmoney+"')");
	}
	
	/*
	 * 修改
	 */
	public void updateFood(String id,String username,String lostedmoney) {
		jdbc.execute("update mymoney set username='"+username+"',lostedmoney='"+lostedmoney+"' where id="+id);
	}
	
}
