package com.spring.spring.mapper;

import com.spring.spring.entity.EmployeeData;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
//データベース　データ転送用
public interface EmployeeMapper {
    @Select("SELECT * FROM employeedata")
    List<EmployeeData> findAll();

    @Insert("INSERT into employeedata(name,age,katakana,gender,department,dateOfBirth,address,academic,mail,hobby,img_url,phone) values (#{name},#{age},#{katakana},#{gender},#{department},#{dateOfBirth},#{address},#{academic},#{mail},#{hobby},#{img_url},#{phone})" )
    int insert(EmployeeData employeedata);



    int update(EmployeeData employeedata);

    @Delete("Delete from employeedata where id = #{id} ")
    Integer deleteById(@Param("id") Integer id);

    @Select("SELECT * from employeedata where name like #{name} and department like #{department} limit #{pageNum},#{pageSize}")
    List <EmployeeData> selectPage(Integer pageNum,Integer pageSize,String name,String department);

    @Select("SELECT count(*) from employeedata where name like #{name} and department like #{department}")
    Integer selectTotal(String name,String department);

}
