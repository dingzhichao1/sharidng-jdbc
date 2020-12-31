package com.springboot.sharding.jdbc.comm.config;

import org.apache.ibatis.type.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Description：LocalDateTime 类型处理
 *
 * 3.5.0之后将LocalDateTime的实现下放至JDBC组件，Sharding-Jdbc最新版本4.1.0目前并不
 * 支持LocalDateTime的获取，所以通过重写Mybatis中的LocalDateTimeTypeHandler  来实现
 * 在Mybatis层进行数据类型处理
 *
 * @author zhichao.ding
 * @version 1.0
 * @date 2020/9/10 10:55
 */
@Component
//定义转换器支持的JAVA类型
//@MappedTypes(LocalDateTime.class)
//定义转换器支持的数据库类型
//@MappedJdbcTypes(value =JdbcType.TIMESTAMP, includeNullJdbcType = true)
public class MyLocalDateTimeTypeHandler extends LocalDateTimeTypeHandler {
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, LocalDateTime parameter, JdbcType jdbcType)
            throws SQLException {
        if (parameter != null) {
            ps.setString(i, dateTimeFormatter.format(parameter));
        }
    }

    @Override
    public LocalDateTime getNullableResult(ResultSet rs, String columnName) throws SQLException {
        String target = rs.getString(columnName);
        if (StringUtils.isEmpty(target)) {
            return null;
        }
        return LocalDateTime.parse(target, dateTimeFormatter);
    }

    @Override
    public LocalDateTime getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String target = rs.getString(columnIndex);
        if (StringUtils.isEmpty(target)) {
            return null;
        }
        return LocalDateTime.parse(target, dateTimeFormatter);
    }

    @Override
    public LocalDateTime getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        String target = cs.getString(columnIndex);
        if (StringUtils.isEmpty(target)) {
            return null;
        }
        return LocalDateTime.parse(target, dateTimeFormatter);
    }

}
