//package com.springboot.sharding.jdbc.comm.config;
//
//import com.baomidou.mybatisplus.extension.plugins.OptimisticLockerInterceptor;
//import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
//import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class MybatisPlusConfig {
//    /**
//     * 乐观锁插件
//     *
//     * @return
//     */
//
//    @Bean
//    public OptimisticLockerInterceptor optimisticLockerInterceptor() {
//        return new OptimisticLockerInterceptor();
//    }
//
//
//    /**
//     * 分页插件
//     *
//     * @return
//     */
//    @Bean
//    public PaginationInterceptor paginationInterceptor() {
//        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
//        // 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
//        // paginationInterceptor.setOverflow(false);
//        // 设置最大单页限制数量，默认 500 条，-1 不受限制
//        // paginationInterceptor.setLimit(500);
//        // 开启 count 的 join 优化,只针对部分 left join
//        paginationInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true));
////        DynamicTableNameParser dynamicTableNameParser = new DynamicTableNameParser();
////        dynamicTableNameParser.setTableNameHandlerMap(new HashMap<String, ITableNameHandler>(2) {{
////            put("user", (metaObject, sql, tableName) -> {
////                // metaObject 可以获取传入参数，这里实现你自己的动态规则
////                String year = "_2018";
////                int random = new Random().nextInt(10);
////                if (random % 2 == 1) {
////                    year = "_2019";
////                }
////                return tableName + year;
////            });
////        }});
////        paginationInterceptor.setSqlParserList(Collections.singletonList(dynamicTableNameParser));
//        return paginationInterceptor;
//    }
//
//
//
//
//
//}