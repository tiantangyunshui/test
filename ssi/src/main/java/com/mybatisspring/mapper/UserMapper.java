package com.mybatisspring.mapper;

import org.apache.ibatis.annotations.Insert;

import com.mybatisspring.domain.User;

/**
 * UserMapper,相当于Dao
 */
public interface UserMapper {
	@Insert("insert into users(name,age) values(#{name},#{age})")
	public void insert(User u);
}
