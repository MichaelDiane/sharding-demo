package com.example.sharding.mapper;

import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.sharding.entity.User;

/**
 *@DATE Mar 16, 2020
 *@AUTHOR michael
 *@DESC  
 */
public interface UserMapper extends BaseMapper<User> {
	public List<User> queryUserList();
}
