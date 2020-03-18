package com.example.sharding.service;


import java.util.List;

import com.example.sharding.entity.User;

/**
 *@DATE Mar 16, 2020
 *@AUTHOR michael
 *@DESC  
 */
public interface UserService {
	public int addUser(User user);
	public List<User>  queryUser();
}
