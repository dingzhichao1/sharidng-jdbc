package com.springboot.sharding.jdbc.web;

import com.springboot.sharding.jdbc.entity.OrderTaskModuleGroupProblem;
import com.springboot.sharding.jdbc.service.ShardingJdbcService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Sharding-Jdbc Demo测试
 */
@RestController	//此注解定义此类下面的全部为@ResponseBody接口
@RequestMapping("sharding/jdbc")
@Api(tags = {"ShardingJdbc案例测试"})
public class ShardingJdbcWeb{

    @Autowired
    private ShardingJdbcService  shardingJdbcService;

    @PostMapping("v1/insertProblem")
    @ApiOperation(value = "创建")
    public String insertProblem(@RequestBody OrderTaskModuleGroupProblem vo) {

        shardingJdbcService.insertProblem(vo);
        return "插入成功";
    }


    @GetMapping("v2/getProblemByTaskId")
    @ApiOperation(value = "创建")
    public List<OrderTaskModuleGroupProblem> getProblemByTaskId(Integer taskId) {
        List<OrderTaskModuleGroupProblem> taskModuleGroupProblems= shardingJdbcService.getProblemByTaskId(taskId);
        return taskModuleGroupProblems;
    }



    @PostMapping("v2/getProblemByRangeTime")
    @ApiOperation(value = "创建")
    public List<OrderTaskModuleGroupProblem> getProblemByRangeTime(String startTime,String endTime ) {
        List<OrderTaskModuleGroupProblem> taskModuleGroupProblems= shardingJdbcService.getProblemByRangeTime(startTime,endTime);
        return taskModuleGroupProblems;
    }

}
