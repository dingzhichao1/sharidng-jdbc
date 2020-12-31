package com.springboot.sharding.jdbc.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.springboot.sharding.jdbc.entity.OrderTaskModuleGroupProblem;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Description：
 *
 * @author zhichao.ding
 * @version 1.0
 * @date 2020/9/3 11:40
 */
@Mapper
public interface ShardingJdbcMapper extends BaseMapper<OrderTaskModuleGroupProblem> {

    @Insert("INSERT INTO order_task_module_group_problem  task_id,name,c_datetime  VALUES (#{taskId},#{name},#{cDatetime})")
    void insertData(OrderTaskModuleGroupProblem  otmgp);

    List<OrderTaskModuleGroupProblem> getProblemByTaskId(@Param("taskId") Integer taskId);


    List<Map<String,Object>> getProblemByTaskId1(@Param("taskId") Integer taskId);



}
