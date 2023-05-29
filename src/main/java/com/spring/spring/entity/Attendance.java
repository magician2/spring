package com.spring.spring.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("attendance")
public class Attendance {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String commencementTime;
    private String leavingTime;
    private String restTime;
}
