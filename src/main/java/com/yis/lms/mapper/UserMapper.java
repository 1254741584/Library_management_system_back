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

}
