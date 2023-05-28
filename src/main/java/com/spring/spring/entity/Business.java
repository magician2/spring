package com.spring.spring.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("business")
public class Business {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String date;
    private String sales;
}
