package com.mybatisspring.service;

import java.util.List;

import com.mybatisspring.domain.User;

/**
 * UserService
 */
public interface UserService {
	public void saveUser(User u);
	public List<User> queryuser();
}
