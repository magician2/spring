package com.spring.spring.service;

import com.spring.spring.controller.dto.UserDTO;
import com.spring.spring.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 朴雄権
 * @since 2023-05-16
 */
public interface IUserService extends IService<User> {

    boolean login(User user);

}
