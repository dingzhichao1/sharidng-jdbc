package com.springboot.sharding.jdbc.comm.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author zhichao
 */
@Component
public class MyBatisHandler implements MetaObjectHandler {
    
    @Resource
    private HttpServletRequest request;

    private  static  DateTimeFormatter DEFAULT_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    
    @Override
    public void insertFill(MetaObject metaObject) {
        // 字段必须声明TableField注解,属性fill选择对应策略
//        this.strictInsertFill(metaObject, "cDatetime", LocalDateTime.class, LocalDateTime.now());
//        this.strictInsertFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());
        LocalDateTime now = LocalDateTime.now();
      //  now.format(DEFAULT_FORMATTER);
        this.setFieldValByName("cDatetime", now,metaObject);

        
    }
    
    @Override
    public void updateFill(MetaObject metaObject) {
        // 字段必须声明TableField注解,属性fill选择对应策略
        //this.strictUpdateFill(metaObject, "updateTime", LocalDateTime.class, LocalDateTime.now());

    }

    
}