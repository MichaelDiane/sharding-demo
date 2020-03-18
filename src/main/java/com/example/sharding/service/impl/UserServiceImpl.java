package com.example.sharding.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.sharding.entity.User;
import com.example.sharding.mapper.UserMapper;
import com.example.sharding.service.UserService;

/**
 *@DATE Mar 16, 2020
 *@AUTHOR michael
 *@DESC  
 */
@Component
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper; 
	@Override
	public int addUser(User user) {
		return userMapper.insert(user);
	}
	
	@Override
	public List<User> queryUser() {
		return userMapper.queryUserList();
	}

}
