package com.springboot.sharding.jdbc.service;

import com.springboot.sharding.jdbc.entity.OrderTaskModuleGroupProblem;

import java.util.List;
import java.util.Map;

/**
 * Description：
 *
 * @author zhichao.ding
 * @version 1.0
 * @date 2020/9/3 11:40
 */
public interface ShardingJdbcService {

    void insertProblem(OrderTaskModuleGroupProblem  orderTaskModuleGroupProblem);

    List<OrderTaskModuleGroupProblem> getProblemByTaskId(Integer taskId);

    List<OrderTaskModuleGroupProblem> getProblemByRangeTime(String startTime, String endTime);

}
