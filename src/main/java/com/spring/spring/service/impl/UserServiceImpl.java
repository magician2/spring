package com.spring.spring.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.spring.spring.controller.dto.UserDTO;
import com.spring.spring.entity.Employeedata;
import com.spring.spring.entity.User;
import com.spring.spring.mapper.EmployeedataMapper;
import com.spring.spring.mapper.UserMapper;
import com.spring.spring.service.IEmployeedataService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.spring.spring.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 朴雄権
 * @since 2023-05-16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public boolean login(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",user.getUsername());
        queryWrapper.eq("password",user.getPassword());
        User one = getOne(queryWrapper);
        return one != null;
    }



}
