package com.springboot.sharding.jdbc.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 实体类
 * </p>
 *
 * @author zhichao.ding
 * @since 2020-08-21
 */
@Data
@TableName("order_task_module_group_problem")
public class OrderTaskModuleGroupProblem  {

    private static final long serialVersionUID = 1L;

//    @TableId(value = "id",type = ASSIGN_ID)
//    private Integer id;

    private Integer surveyProblemId;

    private Integer moduleGroupId;

    private Integer taskId;

    private Integer surveyModuleId;

    private Integer productId;

    private String productName;

    private Integer invalidFlag;

    @TableField(value="c_datetime", fill = FieldFill.INSERT_UPDATE)
   //@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime cDatetime;

    private Integer taskYear;



}