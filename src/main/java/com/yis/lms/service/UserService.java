package com.yis.lms.service;

import com.yis.lms.entity.User;

public interface UserService {
	
	User getUserById(String id);
	
	User userLoginByPhone(String phone, String password);


}
