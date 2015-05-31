package com.mybatisspring.dao;

import java.util.List;

import com.mybatisspring.domain.User;

public interface UserDao {
	public void insert(User u);
	public <T> List<T> queryListAll();
	public <T> List<T> queryListLx();
	public <T> List<T> queryListLd(String roadcode);
	
}
