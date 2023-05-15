package com.spring.spring.controller;

import com.spring.spring.entity.EmployeeData;
import com.spring.spring.mapper.EmployeeMapper;
import com.spring.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/employeePage")
public class EmployeeController {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private UserService userService;

    //編集と増加機能
    @PostMapping
    public  boolean save(@RequestBody EmployeeData employeeData){

        //増加もしくはフレッシュ
        return userService.saveEmployee(employeeData);
    }
    //検索機能(table[employeedata]の全てのデータを抽出)
    @GetMapping
    public List<EmployeeData> index(){
        List<EmployeeData> all = employeeMapper.findAll();
        return all;
    }

    //url後ろにidを追加することでidカラムを削除
    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable Integer id){
        return employeeMapper.deleteById(id);
    }

    //ページネーション
    //ページpath : /employeePage/page?pageNum=1&pageSize=10
    //@RequestParamでurlを受け取る
    //sql limit 二つのパラメータ持ち 0,2 1ページ2コンテンツの意味 (ページネーション計算式 limit = (ページ数 - 1) * コンテンツ数)
    @GetMapping("/page")
    public  Map<String, Object> findPage(@RequestParam Integer pageNum,
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
                                         @RequestParam(defaultValue = "") String address
                                        ){
        pageNum = (pageNum - 1) * pageSize;

        name= "%" + name + "%";
        department = '%' + department + '%';
        age = '%' + age + '%';
        gender = '%' + gender + '%';
        date = '%' + date + '%';
        academic ='%' + academic + '%';
        mail = '%' + mail + '%';
        hobby = '%' + hobby + '%';
        phone ='%' + phone + '%';
        address = '%' + address + '%';

        List<EmployeeData> data = employeeMapper.selectPage(pageNum, pageSize,name,department,age,gender,date,academic,mail,hobby,phone,address);
        Integer total = employeeMapper.selectTotal(name,department,age,gender,date,academic,mail,hobby,phone,address);
        //dataの中身選択されたページのコンテンツ
        //totalは全ページ数
        Map<String, Object> res = new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return res;
    }
}
