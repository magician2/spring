package com.spring.spring.controller;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.spring.spring.entity.User;
import com.spring.spring.entity.Employeedata;
import com.spring.spring.service.IEmployeedataService;
import com.spring.spring.service.IUserService;
import com.spring.spring.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/login")
public class UserController {

    @Resource
    private IUserService userService;
    @PostMapping
    public boolean login(@RequestBody User user){
        String userName = user.getUsername();
        String passWord = user.getPassword();
        if(StrUtil.isBlank(userName) || StrUtil.isBlank(passWord)){
            return false;
        }
        return userService.login(user);
    }
}
