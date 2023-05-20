package com.spring.spring.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.spring.spring.controller.dto.UserDTO;
import com.spring.spring.entity.Employeedata;
import com.spring.spring.mapper.EmployeedataMapper;
import com.spring.spring.service.IEmployeedataService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class EmployeedataServiceImpl extends ServiceImpl<EmployeedataMapper, Employeedata> implements IEmployeedataService {

    @Override
    public boolean login(UserDTO userDTO) {
        QueryWrapper<Employeedata> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",userDTO.getUsername());
        queryWrapper.eq("password",userDTO.getPassword());
        Employeedata one = getOne(queryWrapper);
        return one != null;
    }



}
