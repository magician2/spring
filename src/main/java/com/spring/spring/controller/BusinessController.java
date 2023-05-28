package com.spring.spring.controller;

import com.spring.spring.common.Result;

import com.spring.spring.service.IBusinessService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/business")
public class BusinessController {

    @Resource
    private IBusinessService businessService;
    @GetMapping
    public Result findGenderWoman(){
        return Result.success(businessService.list());
    }
}
