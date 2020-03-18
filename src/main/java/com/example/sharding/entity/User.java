package com.example.sharding.entity;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

/**
 *@DATE Mar 16, 2020
 *@AUTHOR michael
 *@DESC  
 */

@TableName("tb_user")
@Data
public class User implements Serializable{
	private static final long serialVersionUID = -4016476269395366566L;
	private Long id;
	private String name;
	private Integer sex;
	private String code;
	private String phone;
}
