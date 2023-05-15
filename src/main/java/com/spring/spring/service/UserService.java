package com.spring.spring.service;


import com.spring.spring.controller.dto.UserDTO;
import com.spring.spring.entity.EmployeeData;
import com.spring.spring.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    @Autowired
    private EmployeeMapper employeeMapper;
    public int save(EmployeeData employeeData){
        if(employeeData.getId() == null){
            //employeedataにIDがない場合 ,増加として動く
            return employeeMapper.insert(employeeData);
        }else{ //増加ではない場合はフレッシ  ュ
            return employeeMapper.update(employeeData);

        }
    }

//    public Integer login(UserDTO userDTO) {
//        boolean login(UserDTO)
//    }
}
