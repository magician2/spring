package com.spring.spring.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.log.Log;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.spring.spring.common.Constants;
import com.spring.spring.controller.dto.UserDTO;
import com.spring.spring.entity.User;
import com.spring.spring.exception.ServiceException;
import com.spring.spring.mapper.UserMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.spring.spring.service.IUserService;
import com.spring.spring.utils.TokenUtils;
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
    public UserDTO login(UserDTO userDTO) {
        User one = getUserInfo(userDTO);
        if( one != null){
            BeanUtil.copyProperties(one,userDTO,true);
            String token = TokenUtils.genToken(one.getId().toString(),one.getPassword());
            userDTO.setToken(token);
            return userDTO;
        }else {
            throw new ServiceException(Constants.CODE_400,"ユーザー名またはパスワードが間違ってます");
        }
    }

    private User getUserInfo(UserDTO userDTO){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",userDTO.getUsername());
        queryWrapper.eq("password",userDTO.getPassword());
        User one;
        try{
            one = getOne(queryWrapper);
        }
        catch (Exception e){
            LOG.error(e);
            throw new ServiceException(Constants.CODE_500,"システムエラー");
        }
        return one;
    }

}
