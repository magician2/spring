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
    Integer deleteByid(@Param("id") Integer id);

    @Select("SELECT * from employeedata limit #{pageNum},#{pageSize}")
    List <EmployeeData> selectPage(Integer pageNum,Integer pageSize);

    @Select("SELECT count(*) from employeedata")
    Integer selectTotal();

}
