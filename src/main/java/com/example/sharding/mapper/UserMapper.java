package com.example.sharding.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.sharding.entity.User;

/**
 *@DATE Mar 16, 2020
 *@AUTHOR michael
 *@DESC  
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
	public List<User> queryUserList();
}
