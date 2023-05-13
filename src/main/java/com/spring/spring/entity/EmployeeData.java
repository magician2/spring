package com.spring.spring.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//Mysqlへの接続
public class EmployeeData {
 private Integer id;
 private String name;
 private Integer age;
 private String gender;
 private String department;
 private String dateOfBirth;
 private String academic;
 private String mail;
 private String hobby;
 private String img_url;
 private String phone;
 private String address;
 private String katakana;
}
