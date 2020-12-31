package com.springboot.sharding.jdbc;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @desc 启动类
 * @author chay
 * @version 2.0.0
 * @date 2018-07-12
 *
 *  descripe:
 *  需要关闭Druid的自动加载类,由ShardingSpere来进行数据库的加载
 *  用Sharding-Jdbc来代替原有的jdbc
 */

@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
public class ShardingJdbcApplication {
	
	public static void main(String[] args ){
        SpringApplication.run(ShardingJdbcApplication.class, args);
    }


}
