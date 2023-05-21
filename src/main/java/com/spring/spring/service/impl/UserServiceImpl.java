package com.spring.spring.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.log.Log;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.spring.spring.common.Constants;
import com.spring.spring.controller.dto.UserDTO;
import com.spring.spring.entity.Employeedata;
import com.spring.spring.entity.User;
import com.spring.spring.exception.ServiceException;
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

    private static final Log LOG = Log.get();
    @Override
    public User login(User user) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",user.getUsername());
        queryWrapper.eq("password",user.getPassword());
        User one;
        try{
            one = getOne(queryWrapper);
        }
        catch (Exception e){
            LOG.error(e);
            throw new ServiceException(Constants.CODE_500,"システムエラー");
        }
        if( one != null){
            BeanUtil.copyProperties(one,user,true);
            return user;
        }else {
            throw new ServiceException(Constants.CODE_400,"ユーザー名またはパスワードが間違ってます");
        }
    }



}
