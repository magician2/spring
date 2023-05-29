package com.spring.spring.service.impl;

import com.spring.spring.entity.Attendance;
import com.spring.spring.mapper.AttendanceMapper;
import com.spring.spring.service.IAttendanceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 朴雄権
 * @since 2023-05-29
 */
@Service
public class AttendanceServiceImpl extends ServiceImpl<AttendanceMapper, Attendance> implements IAttendanceService {

}
