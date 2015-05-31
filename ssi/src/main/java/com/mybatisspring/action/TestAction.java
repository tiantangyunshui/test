package com.mybatisspring.action;


import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.junit.runner.Request;
import org.springframework.stereotype.Controller;

import net.sf.json.JSONArray;
import net.sf.json.util.JSONUtils;

import com.hdsx.webutil.struts.BaseActionSupport;
import com.mybatisspring.dao.UserDao;
import com.mybatisspring.domain.User;
import com.mybatisspring.service.UserService;
import com.opensymphony.xwork2.ActionContext;

public class TestAction extends BaseActionSupport {
	//@Resource(name="userDaoImpl")
	private UserDao userDao ;
	private String roadcode;
	

	public String getRoadcode() {
		return roadcode;
	}

	public void setRoadcode(String roadcode) {
		this.roadcode = roadcode;
	}

	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}



	public String test(){
		/*List<User> list = userService.queryuser();
		for(int i = 0; i<list.size();i++){
			System.out.println(list.get(i).getName());
		}*/
		return "ok";
	}
	public void lx(){
		List<HashMap<String,String>> list = userDao.queryListLx();
		JSONArray jsonArray = JSONArray.fromObject(list); 
		 System.out.println( jsonArray); 
		 HttpServletRequest request = ServletActionContext.getRequest();
	     ServletContext servletContext = ServletActionContext.getServletContext();
	     request.getSession();
	     HttpServletResponse response = ServletActionContext.getResponse();
	     PrintWriter pw = null;
		try {
			pw = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     pw.print(jsonArray);
	    		 
	 
	}
	public void ld(){
		List<HashMap<String,String>> list = userDao.queryListLd(roadcode);
		JSONArray jsonArray = JSONArray.fromObject(list); 
		String str = null;
		try {
			//str = new String(jsonArray.toString().getBytes(), "ISO8859-1");
			str = new String(jsonArray.toString().getBytes(), "UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}   
		 System.out.println(str); 
		 HttpServletRequest request = ServletActionContext.getRequest();
	     ServletContext servletContext = ServletActionContext.getServletContext();
	     request.getSession();
	     HttpServletResponse response = ServletActionContext.getResponse();
	     PrintWriter pw = null;
		try {
			pw = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	     pw.print(str);
	}
}
