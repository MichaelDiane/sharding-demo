package com.example.sharding.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sharding.entity.User;
import com.example.sharding.service.UserService;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.json.JSONUtil;

/**
 *@DATE Mar 16, 2020
 *@AUTHOR michael
 *@DESC  
 */
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/add_user")
	public String addUser() {
		User user =  new User();
		user.setName("M"+RandomUtil.randomString("michaeldiane",3));
		user.setPhone(RandomUtil.randomLong(13000000000L, 13094808741L)+"");
		user.setCode(IdUtil.getSnowflake(1, 19).nextIdStr());
		user.setSex(1);
		int number = userService.addUser(user);
		return "add user : "+number;
	}
	
	
	@RequestMapping("/query_user_list")
	public String queryUser() {
		List<User> userList =  userService.queryUser();
		return JSONUtil.toJsonPrettyStr(userList);
	}
	
	
}
