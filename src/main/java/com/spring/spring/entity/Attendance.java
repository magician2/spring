package com.spring.spring.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author 朴雄権
 * @since 2023-05-29
 */
@Getter
@Setter
  public class Attendance implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "id", type = IdType.AUTO)
      private Integer id;

    private String commencementTime;

    private String leavingTime;

    private String restTime;

    private String date;

    private  Integer employeeId;
  @TableField(exist = false)
    private String name;
}
