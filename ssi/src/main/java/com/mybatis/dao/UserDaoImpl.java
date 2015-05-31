package com.mybatis.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mybatis.entity.Users;
@Service
public class UserDaoImpl extends Dao implements UsersDao {
	

	public UserDaoImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Users> queryUsers() {
		// TODO Auto-generated method stub
		return queryList("opeuser.selectUserAll");
	}

}
