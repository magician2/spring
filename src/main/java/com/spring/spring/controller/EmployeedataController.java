package com.spring.spring.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import com.spring.spring.service.IEmployeedataService;
import com.spring.spring.entity.Employeedata;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 朴雄権
 * @since 2023-05-16
 */
@RestController
@RequestMapping("/employeedata")
public class EmployeedataController {

@Resource
private IEmployeedataService employeedataService;

//新規とアップデート
@PostMapping
public boolean save(@RequestBody Employeedata employeedata) {
        return employeedataService.saveOrUpdate(employeedata);
        }

// 削除機能
@DeleteMapping("/{id}")
public Boolean delete(@PathVariable Integer id) {
        return employeedataService.removeById(id);
        }

//複数削除
//@PostMapping("/del/batch")
//public boolean deleteBatch(@RequestBody List<Integer> ids) {
//        return employeedataService.removeByIds(ids);
//        }
//テータ抽出
@GetMapping
public List<Employeedata> findAll() {
        return employeedataService.list();
        }

//検索
@GetMapping("/{id}")
public Employeedata findOne(@PathVariable Integer id) {
        return employeedataService.getById(id);
        }

// ページネーション
@GetMapping("/page")
public Page<Employeedata> findPage(@RequestParam Integer pageNum,
                                   @RequestParam Integer pageSize,
                                   @RequestParam(defaultValue = "") String name,
                                   @RequestParam(defaultValue = "") String age,
                                   @RequestParam(defaultValue = "") String gender,
                                   @RequestParam(defaultValue = "") String department,
                                   @RequestParam(defaultValue = "") String date,
                                   @RequestParam(defaultValue = "") String academic,
                                   @RequestParam(defaultValue = "") String mail,
                                   @RequestParam(defaultValue = "") String hobby,
                                   @RequestParam(defaultValue = "") String phone,
                                   @RequestParam(defaultValue = "") String address,
                                   @RequestParam(defaultValue = "") String img_url
                                   ) {
        QueryWrapper<Employeedata> queryWrapper = new QueryWrapper<>();
        if(!"".equals(name)){
                queryWrapper.like("name", name);
        }
        if(!"".equals(age)){
                queryWrapper.like("age", age);
        }
        if(!"".equals(gender)){
                queryWrapper.like("gender", gender);
        }
        if(!"".equals(department)){
                queryWrapper.like("department", department);
        }
        if(!"".equals(date)){
                queryWrapper.like("date", date);
        }
        if(!"".equals(academic)){
                queryWrapper.like("academic", academic);
        }
        if(!"".equals(mail)){
                queryWrapper.like("mail", mail);
        }
        if(!"".equals(hobby)){
                queryWrapper.like("hobby", hobby);
        }
        if(!"".equals(phone)){
                queryWrapper.like("phone", phone);
        }
        if(!"".equals(address)){
                queryWrapper.like("address", address);
        }
        if(!"".equals(img_url)){
                queryWrapper.like("img_url", img_url);
        }
        queryWrapper.orderByAsc("id");
        return employeedataService.page(new Page<>(pageNum, pageSize), queryWrapper);
        }

}
