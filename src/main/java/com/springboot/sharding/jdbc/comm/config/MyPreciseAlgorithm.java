package com.springboot.sharding.jdbc.comm.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;
import org.springframework.util.Assert;

import java.util.Collection;

/**
 * Description：自动定义精确查找算法 用于处理 IN ,=
 *
 * @author zhichao.ding
 * @version 1.0
 * @date 2020/9/7 10:00
 */
@Slf4j
public class MyPreciseAlgorithm implements PreciseShardingAlgorithm<Integer> {

    /**
     *
     * @param collection
     * @param preciseShardingValue
     * @return
     */
    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Integer> preciseShardingValue) {
        log.info(collection+"-----"+preciseShardingValue+"");
        Assert.notNull(collection,"物理分表为空");
        Assert.notNull(preciseShardingValue,"匹配字段值为空");
        for (String actualTableName : collection) {
            String logicTableName = preciseShardingValue.getLogicTableName();
            Integer value = preciseShardingValue.getValue();
            if(value!=null){
                if(actualTableName.equals(logicTableName+"_"+value)){
                    return actualTableName;
                }
            }
        }
        return null;
    }
}
