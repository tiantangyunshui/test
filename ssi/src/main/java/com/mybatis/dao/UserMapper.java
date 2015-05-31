package com.mybatis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.mybatis.entity.Users;


public interface UserMapper {

	@Insert("insert into user(username,pwd,email,phone) values(#{username},#{pwd},#{email},#{phone})")
	public void insertuser(Users u);
	@Select("select id as 'id',	username,	pwd as 'pwd',email as 'email',phone as 'phone' from user")
	public List<Users> querylist();
}
