package com.yis.lms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
     * 查询老师信息
     * @param id id
     * @return 信息
     */
    @RequestMapping(value = "/id")
    public String getTeacherMessage(String id)
    {
        return userService.getUserById(id).toString();
    }
}