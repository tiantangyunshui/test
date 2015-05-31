package com.mybatisspring.service;

import java.util.List;

import com.mybatisspring.dao.UserDao;
import com.mybatisspring.domain.User;

/**
 * UserServiceImpl
 */
public class UserServiceImpl implements UserService {

	private UserDao userDao ;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void saveUser(User u) {
		userDao.insert(u);
	}

	@Override
	public List<User> queryuser() {
		// TODO Auto-generated method stub
		return userDao.queryListAll();
	}
}
