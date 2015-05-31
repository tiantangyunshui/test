package com.mybatisspring.dao;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import net.sf.json.JSONArray;

import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.mybatisspring.domain.User;

/**
 * UserDaoImpl
 */
@Service
public class UserDaoImpl implements UserDao {
	@Resource(name="session2")
	private SqlSessionTemplate sst ;
	
	//注入session模板
	public void setSst(SqlSessionTemplate sst) {
		this.sst = sst;
	}

	public void insert(User u) {
		sst.insert("com.mybatisspring.domain.User.insert", u);
	}

	@Override
	public <T> List<T> queryListAll() {
		// TODO Auto-generated method stub
		List<T> list = (List<T>)sst.selectList("map.queryListAll");
		return list;
	}

	@Override
	public <T> List<T> queryListLx() {
		// TODO Auto-generated method stub
		List<T> list = (List<T>)sst.selectList("map2.queryListLx");
		return list;
	}

	@Override
	public <T> List<T> queryListLd(String roadcode) {
		// TODO Auto-generated method stub
		List<T> list = (List<T>)sst.selectList("map2.queryListLd",roadcode);
		return list;
	}
	@Test
	public void test_lx(){
		UserDaoImpl ui = new UserDaoImpl();
		List<HashMap<String,String>> list = ui.queryListLx();
		JSONArray jsonArray = JSONArray.fromObject(list); 
		 System.out.println( jsonArray); 
	}
}
