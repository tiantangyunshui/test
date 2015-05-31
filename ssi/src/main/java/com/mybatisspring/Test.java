package com.mybatisspring;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;

import net.sf.json.JSONArray;

import org.apache.ibatis.session.SqlSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mybatis.dao.Dao;
import com.mybatis.entity.Users;
import com.mybatisspring.dao.UserDao;
import com.mybatisspring.domain.User;
import com.mybatisspring.service.UserService;

public class Test {

	public static void main(String[] args) {
		 
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans2.xml");
		UserService us = (UserService) ac.getBean("userService");
		User u = new User();
		u.setName("tom7");
		u.setAge(37);
		//us.saveUser(u);
		List<User> list = us.queryuser();
		for(int i = 0; i<list.size();i++){
		
			System.out.println(list.get(i).getName());
		}
		UserDao ud = (UserDao)ac.getBean("userDao2");
		List<HashMap<String,String>> list2 = ud.queryListLx();
		for(int i = 0; i<list2.size(); i++){
			System.out.println(list2.get(i).get("PertainEWCode"));
			
		}
		List<HashMap<String,String>> list3 = ud.queryListLd("G1");
		for(int i = 0; i<list3.size(); i++){
			System.out.println(list3.get(i).get("ROADNAME"));
		}
		 JSONArray jsonArray3 = JSONArray.fromObject(list);       
		 System.out.println( jsonArray3 );  
		 
		 Dao dao = (Dao)ac.getBean("dao");
		 SqlSession ss = dao.getsession();
		List<Users> list4 = ss.selectList("opeuser.selectUserAll");
		for(int i= 0; i<list4.size();i++){
			try {
				System.out.println(list4.get(i).getUsername());
				System.out.println(new String(list4.get(i).getUsername().getBytes("utf-8"),"gbk"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		 
	}
}
