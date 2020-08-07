package com.yis.lms.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yis.lms.entity.User;
import com.yis.lms.service.UserService;

import com.yis.lms.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper UserMapper;

	@Override
	public User getUserById(String id) {
		// TODO Auto-generated method stub
		return UserMapper.getUserById(id);
	}

	@Override
	public User userLoginByPhone(String phone, String password) {
		// TODO Auto-generated method stub
		return UserMapper.userLoginByPhone(phone, password);
	}

}
