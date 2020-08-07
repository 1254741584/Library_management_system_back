package com.yis.lms.controller;

import com.yis.lms.exception.BadRequestException;
import com.yis.lms.result.RtnResult;
import com.yis.lms.utils.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yis.lms.entity.User;
import com.yis.lms.service.UserService;


@RestController
@RequestMapping(value = "/user")
public class UserController
{
    /**
     * 注入服务
     */
    @Autowired
    private UserService userService;

    /**
     * 查询用户信息
     * @param id id
     * @return 信息
     */
    @RequestMapping(value = "/id")
    public String getTeacherMessage(String id)
    {
        return userService.getUserById(id).toString();
    }

    /**
     * 用户登陆
     * @param user
     * @return
     */
    @PostMapping(value = "/login")
    public RtnResult<Object> userLogin(@RequestBody User user)
    {
    	if (user == null || StringUtils.isEmpty(user.getPhone()) || StringUtils.isEmpty(user.getPassword())) {
            throw new BadRequestException("用户名或者密码为空");
    	}
        user = userService.userLoginByPhone(user.getPhone(), user.getPassword());

    	if (user == null || user.getId() == null) {
            return RtnResult.failure("登陆失败，用户名或者密码不正确");
        }
    	return RtnResult.success("登录成功", user);
    }
    
}