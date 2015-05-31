package com.mybatis.test;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mybatis.dao.Dao;
import com.mybatis.dao.UserMapper;
import com.mybatis.entity.Users;

public class Usertest {
	
	public static void main(String[] args) {
		Dao dao = new Dao();
		//List<Users> list = ss.selectList("opeuser.selectUserAll");
		//基于注解错误
		//UserMapper um = ss.getMapper(UserMapper.class);//注解添加
		//um.insertuser(u);
		//s.commit();
		List<Users> list = dao.queryList("opeuser.selectUserAll");
		//List<Users> list = um.querylist();
		try {
			System.out.println(new String(list.get(0).getUsername().getBytes("utf-8"),"gbk"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(String.class.getSimpleName());
	}

}
