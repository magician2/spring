package com.spring.spring.controller.dto;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "admin")
public class UserDTO {

    private String user_name;
    private String pass_word;
}
