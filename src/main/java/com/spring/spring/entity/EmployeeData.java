package com.spring.spring.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


@Data
//Mysqlへの接続
@TableName(value = "employeedata")
public class EmployeeData {

 @TableId("id")
 private Integer id;
 private String name;
 private Integer age;
 private String gender;
 private String department;
 private String date;
 private String academic;
 private String mail;
 private String hobby;
 private String img_url;
 private String phone;
 private String address;
 private String katakana;
}
