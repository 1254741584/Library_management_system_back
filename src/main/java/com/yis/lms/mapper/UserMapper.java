package com.yis.lms.mapper;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.yis.lms.entity.User;

@Mapper
public interface UserMapper {
	
	/*
	 * 获取用户信息
	 * */
	User getUserById(@Param("id") String id);
	
	/*
	 * 用户登陆 通过手机号
	 * */
	User userLoginByPhone(@Param("phone") String phone, @Param("password") String password);
	

}
