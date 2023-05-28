package com.spring.spring.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.spring.spring.common.Result;
import com.spring.spring.controller.dto.UserDTO;
import com.spring.spring.entity.User;
import com.spring.spring.utils.TokenUtils;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.List;
import com.spring.spring.service.IEmployeedataService;
import com.spring.spring.entity.Employeedata;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 朴雄権
 * @since 2023-05-16
 */
@RestController
@RequestMapping("/employeedata")
public class EmployeedataController {

@Resource
private IEmployeedataService employeedataService;

//新規とアップデート
@PostMapping
public Result save(@RequestBody Employeedata employeedata) {
        return Result.success(employeedataService.saveOrUpdate(employeedata));
        }

// 削除機能
@DeleteMapping("/{id}")
public Result delete(@PathVariable Integer id) {

        return Result.success(employeedataService.removeById(id));
        }

@GetMapping
public Result findAll() {
        return Result.success(employeedataService.list());
        }

//検索
@GetMapping("/{id}")
public Result findOne(@PathVariable Integer id) {

        return Result.success(employeedataService.getById(id));
        }

// ページネーション検索機能
@GetMapping("/page")
public Result findPage(@RequestParam Integer pageNum,
                                   @RequestParam Integer pageSize,
                                   @RequestParam(defaultValue = "") String search
                                   ) {
        QueryWrapper<Employeedata> queryWrapper = new QueryWrapper<>();
        if(!"".equals(search)){
                queryWrapper.like("name", search);
                queryWrapper.or();
                queryWrapper.like("department",search);
                queryWrapper.or();
                queryWrapper.like("phone",search);
                queryWrapper.or();
                queryWrapper.like("academic",search);
                queryWrapper.or();
                queryWrapper.like("address",search);
                queryWrapper.or();
                queryWrapper.like("mail",search);
        }
//        if(!"".equals(gender)){
//                queryWrapper.like("gender", gender);
//        }
//        if(!"".equals(department)){
//                queryWrapper.like("department", department);
//        }
//        if(!"".equals(date)){
//                queryWrapper.like("date", date);
//        }
//        if(!"".equals(academic)){
//                queryWrapper.like("academic", academic);
//        }
//        if(!"".equals(mail)){
//                queryWrapper.like("mail", mail);
//        }
//        if(!"".equals(hobby)){
//                queryWrapper.like("hobby", hobby);
//        }
//        if(!"".equals(phone)){
//                queryWrapper.like("phone", phone);
//        }
//        if(!"".equals(address)){
//                queryWrapper.like("address", address);
//        }
//        if(!"".equals(imgUrl)){
//                queryWrapper.like("imgUrl", imgUrl);
//        }
//        if(!"".equals(zipcode)){
//                queryWrapper.like("zipcode", zipcode);
//        }

        //ユーザーのデータ情報を抽出
        User currentUser = TokenUtils.getCurrentUser();
        System.out.println("現在のユーザー名 ++++++++++++" + currentUser.getName());


        return Result.success(employeedataService.page(new Page<>(pageNum, pageSize), queryWrapper));
}

@GetMapping("/getAddress/all")
public Result findAddressAll(){
        return Result.success(employeedataService.count());
        }
@GetMapping("/getAddress/tokyo")
public Result findAddressTokyo(){
        QueryWrapper<Employeedata> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("address","東京");
        return Result.success(employeedataService.count(queryWrapper));
}
@GetMapping("/getAddress/saitama")
public Result findAddressSaitama(){
        QueryWrapper<Employeedata> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("address","埼玉県");
        return Result.success(employeedataService.count(queryWrapper));
        }

@GetMapping("/getAddress/kanagawa")
public Result findAddressKanagawa(){
        QueryWrapper<Employeedata> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("address","神奈川県");
        return Result.success(employeedataService.count(queryWrapper));
        }
@GetMapping("/getAddress/tiba")
public Result findAddressTiba(){
        QueryWrapper<Employeedata> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("address","千葉県");
        return Result.success(employeedataService.count(queryWrapper));
        }
@GetMapping("/gender/man")
public Result findGender(){
        QueryWrapper<Employeedata> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("gender","男");
        return Result.success(employeedataService.count(queryWrapper));
        }
@GetMapping("/gender/woman")
public Result findGenderWoman(){
                QueryWrapper<Employeedata> queryWrapper = new QueryWrapper<>();
                queryWrapper.like("gender","女");
                return Result.success(employeedataService.count(queryWrapper));
        }
}

