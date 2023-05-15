package com.spring.spring.mapper;

import com.spring.spring.entity.EmployeeData;
import org.apache.ibatis.annotations.*;

import java.util.List;

//@Mapper
//データベース　データ転送用
public interface EmployeeMapper {
    @Select("SELECT * FROM employeedata")
    List<EmployeeData> findAll();

    @Insert("INSERT into employeedata(name,age,katakana,gender,department,dateOfBirth,address,academic,mail,hobby,img_url,phone) values (#{name},#{age},#{katakana},#{gender},#{department},#{dateOfBirth},#{address},#{academic},#{mail},#{hobby},#{img_url},#{phone})" )
    int insert(EmployeeData employeedata);



    int update(EmployeeData employeedata);

    @Delete("Delete from employeedata where id = #{id} ")
    Integer deleteById(@Param("id") Integer id);

    @Select("SELECT * from employeedata where name like #{name}  and department  like #{department} and age like #{age} and " +
            "gender like #{gender} and dateOfBirth like #{dateOfBirth} and academic like #{academic} and mail like #{mail} " +
            "and hobby like #{hobby} and phone like #{phone} and address like #{address} limit #{pageNum},#{pageSize}")
    List <EmployeeData> selectPage(Integer pageNum,Integer pageSize,String name,String department,String age,String gender,String dateOfBirth,String academic,String mail,String hobby,String phone,String address);

    @Select("SELECT count(*) from employeedata where name  like #{name} and department like #{department} and age like #{age} and " +
            "gender like #{gender} and dateOfBirth like #{dateOfBirth} and academic like #{academic} and mail like #{mail} " +
            "and hobby like #{hobby} and phone like #{phone} and address like#{address} ")
    Integer selectTotal(String name,String department,String age,String gender,String dateOfBirth,String academic,String mail,String hobby,String phone,String address);
//カラムにnullが存在する場合　表示されない!!!
}
