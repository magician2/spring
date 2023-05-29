package com.spring.spring.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.spring.spring.entity.Attendance;
import com.spring.spring.mapper.AttendanceMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AttendanceServiceImpl extends ServiceImpl<AttendanceMapper, Attendance> {
    private final AttendanceMapper attendanceMapper;
}
