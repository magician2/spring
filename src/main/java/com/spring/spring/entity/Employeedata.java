package com.spring.spring.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDate;

import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author 朴雄権
 * @since 2023-05-16
 */
@Getter
@Setter
  public class Employeedata implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

    private String name;

    private String gender;

    private String department;

    private LocalDate date;

    private String academic;

    private String mail;

    private String hobby;

    private String imgurl;

    private String phone;

    private String address;

    private String username;
    private String katakana;

    private String zipcode;
  @TableField(exist = false)
    private String password;

  @TableLogic
  private Integer del_flg;

  private Integer employeeId;

}
