package com.spring.spring.service;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.spring.spring.entity.EmployeeData;
import com.spring.spring.mapper.EmployeeMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceImpl<EmployeeMapper,EmployeeData> {


    public boolean saveEmployee(EmployeeData employeeData) {
        return saveOrUpdate(employeeData);


    }
}
