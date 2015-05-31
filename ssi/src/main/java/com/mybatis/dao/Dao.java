package com.mybatis.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class Dao {

	private static SqlSessionFactory sf;
	
	/**
	 * 初始化 加载数据源
	 */
	static{
		String resource = "mybits-config.xml";
		try {
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sf = new SqlSessionFactoryBuilder().build(inputStream,"development");//mybits数据源id
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public SqlSession getsession(){
		SqlSession s = sf.openSession();
		return  s;
	}
	/**
	 * 无参数sql查询操作 返回结果集
	 * @param id 映射到每一个具体sql查询
	 * @return List
	 */
	//@SuppressWarnings("unchecked")用来消除警告
	public <T> List<T> queryList(String id){
		List<T> list = null;
		SqlSession s =getsession();
		list = s.selectList(id);
		s.close();
		return list;
	}
}
