package com.springboot.sharding.jdbc.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.springboot.sharding.jdbc.dao.ShardingJdbcMapper;
import com.springboot.sharding.jdbc.entity.OrderTaskModuleGroupProblem;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.shardingjdbc.jdbc.core.resultset.ShardingResultSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.Operation;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

/**
 * 
 * @desc FastDSF 服务
 * @author chay
 * @version 2.0.0
 * @date 2018-07-12
 */
@Service
@Slf4j
public class ShardingJdbcServiceImp implements ShardingJdbcService {

    @Resource
    private ShardingJdbcMapper shardingJdbcDao;


    private static Random  random = new Random();
    
    private  static  DateTimeFormatter DEFAULT_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public void insertProblem(OrderTaskModuleGroupProblem orderTaskModuleGroupProblem) {
        //orderTaskModuleGroupProblem.setCDatetime(LocalDateTime.now());
        orderTaskModuleGroupProblem.setTaskId(random.nextInt(10));
        shardingJdbcDao.insert(orderTaskModuleGroupProblem);
    }


    /**
     * 通过Mybatis-plus测试，通过任务单Id查询
     *
     * @param taskId
     * @return
     */
    @Override
    public List<OrderTaskModuleGroupProblem> getProblemByTaskId(Integer taskId) {
        //LocalDateTime localDateTime = LocalDateTime.parse("2020-09-08 01:25:21", DEFAULT_FORMATTER);
        LambdaQueryWrapper<OrderTaskModuleGroupProblem> queryWrapper= new QueryWrapper<OrderTaskModuleGroupProblem>().lambda();
        queryWrapper.select(OrderTaskModuleGroupProblem::getTaskId,OrderTaskModuleGroupProblem::getProductName);
        //return shardingJdbcDao.selectList(queryWrapper);


        List<OrderTaskModuleGroupProblem> problemList = shardingJdbcDao.getProblemByTaskId(taskId);

        Page<OrderTaskModuleGroupProblem> page = new Page<>();
        page.setCurrent(1);
        page.setSize(10);

        shardingJdbcDao.selectPage(page, queryWrapper);
        shardingJdbcDao.selectCount(null);

        return problemList;

    }


    /**
     * 通过Mybatis-plus测试，通过任务单Id查询
     *
     * @return
     */
    @Override
    public List<OrderTaskModuleGroupProblem> getProblemByRangeTime(String  startTime,String endTime) {
        LocalDateTime localDateStartTime = LocalDateTime.parse(startTime, DEFAULT_FORMATTER);
        LocalDateTime localDateEndTime = LocalDateTime.parse(endTime, DEFAULT_FORMATTER);
        LambdaQueryWrapper<OrderTaskModuleGroupProblem> queryWrapper= new QueryWrapper<OrderTaskModuleGroupProblem>().lambda().between(OrderTaskModuleGroupProblem::getCDatetime,localDateStartTime,localDateEndTime);
       // queryWrapper.select(OrderTaskModuleGroupProblem::getTaskId,OrderTaskModuleGroupProblem::getProductName);
        Optional<Object> empty = Optional.empty();

        return shardingJdbcDao.selectList(queryWrapper);
    }

    public static void main(String[] args) {
        OrderTaskModuleGroupProblem orderTaskModuleGroupProblem = null;
        Optional.of(orderTaskModuleGroupProblem);
    }

}