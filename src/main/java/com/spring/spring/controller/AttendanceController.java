package com.spring.spring.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

//@GetMapping("/page")
//public Page<Attendance> findPage(@RequestParam Integer pageNum,
//                                @RequestParam Integer pageSize) {
//        QueryWrapper<Employeedata> queryWrapper = new QueryWrapper<>();
//        queryWrapper.orderByDesc("id");
//        return attendanceService.page(new Page<>(pageNum, pageSize), queryWrapper);
//        }

}

