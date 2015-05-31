package com.mybatisspring.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.mybatis.dao.Dao;
import com.mybatis.dao.UsersDao;
import com.mybatis.entity.Users;

@Controller
@Scope("prototype")
public class TestAction2 {
	@Resource(name="userDaoImpl")
	public UsersDao userdao;

	 public UsersDao getUserdao() {
		return userdao;
	}

	public void setUserdao(UsersDao userdao) {
		this.userdao = userdao;
	}

	public void test(){
		 
		 List<Users> list = userdao.queryUsers();
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

}
