package com.spring.spring.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spring.spring.common.Result;
import com.spring.spring.entity.Employeedata;
import com.spring.spring.service.IEmployeedataService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import com.spring.spring.service.IAttendanceService;
import com.spring.spring.entity.Attendance;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 朴雄権
 * @since 2023-05-29
 */
@RestController
@RequestMapping("/attendance")
public class AttendanceController {

@Resource
private IAttendanceService attendanceService;

@Resource
private IEmployeedataService employeedataService;
// 新增或者更新
@PostMapping
public boolean save(@RequestBody Attendance attendance) {
        return attendanceService.saveOrUpdate(attendance);
        }

@DeleteMapping("/{id}")
public Boolean delete(@PathVariable Integer id) {
        return attendanceService.removeById(id);
        }

@PostMapping("/del/batch")
public boolean deleteBatch(@RequestBody List<Integer> ids) {
        return attendanceService.removeByIds(ids);
        }

@GetMapping
public List<Attendance> findAll() {
        return attendanceService.list();
        }

@GetMapping("/{id}")
public Attendance findOne(@PathVariable Integer id) {
        return attendanceService.getById(id);
        }

@GetMapping("/page")
public Result findPage(@RequestParam Integer pageNum,
                       @RequestParam Integer pageSize) {
        QueryWrapper<Attendance> queryWrapper = new QueryWrapper<>();
        Page<Attendance> page= attendanceService.page(new Page<>(pageNum,pageSize),queryWrapper);
        List<Attendance> records  = page.getRecords();
        for(Attendance record: records){
                Employeedata employeedata = employeedataService.getById(record.getEmployeeId());
                if(employeedata !=null){
                        record.setName(employeedata.getName());
                }
        }
        return Result.success(records);
        }

}

