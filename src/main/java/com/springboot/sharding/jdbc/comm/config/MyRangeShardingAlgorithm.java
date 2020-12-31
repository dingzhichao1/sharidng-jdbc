package com.springboot.sharding.jdbc.comm.config;

import com.google.common.collect.Range;
import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Description：范围路由匹配 用于BETWEEN AND, >, <, >=, <=
 *
 * @author zhichao.ding
 * @version 1.0
 * @date 2020/9/8 10:55
 */
@Slf4j
public class MyRangeShardingAlgorithm implements RangeShardingAlgorithm<LocalDateTime>{


    @Override
    public Collection<String> doSharding(Collection<String> collection, RangeShardingValue<LocalDateTime> rangeShardingValue) {
        //路由分片表
        Set<String> routeTableNames = new HashSet<>();

        Range<LocalDateTime> valueRange = rangeShardingValue.getValueRange();
        rangeShardingValue.getColumnName();
        String logicTableName = rangeShardingValue.getLogicTableName();
        LocalDateTime lowerEndpoint = valueRange.lowerEndpoint();
        int lowerEndpointYear = lowerEndpoint.getYear();

        LocalDateTime upperEndpoint = valueRange.upperEndpoint();
        int upperEndpointYear = upperEndpoint.getYear();
        for (String actualTableName : collection) {
            for (int i = lowerEndpointYear; i <=upperEndpointYear; i++) {
                if(actualTableName.equals(logicTableName+"_"+i)){
                    routeTableNames.add(actualTableName);
                }
            }
        }
        log.info(collection+"----"+rangeShardingValue);
        return routeTableNames;
    }
}
