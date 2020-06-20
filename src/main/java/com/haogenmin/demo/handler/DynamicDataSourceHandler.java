package com.haogenmin.demo.handler;

import com.haogenmin.demo.datasource.DynamicDataSource;
import com.haogenmin.demo.model.DataSourceInfo;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.jdbc.DataSourceBuilder;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ：HaoGenmin
 * @Title :DynamicDataSourcehHandler
 * @date ：Created in 2020/6/18 15:53
 * @description：
 */
public class DynamicDataSourceHandler {
    private final Logger logger = LoggerFactory.getLogger(DynamicDataSourceHandler.class);

    private ThreadLocal<String> threadLocal;

    private Map<Object, DataSource> concurrentHashMap;

    private static final DynamicDataSourceHandler dataSourcehHandler = new DynamicDataSourceHandler();

    private DynamicDataSourceHandler() {
        this.threadLocal = new ThreadLocal<>();
        this.concurrentHashMap = new ConcurrentHashMap<>();
    }

    public static DynamicDataSourceHandler getInstance() {
        return dataSourcehHandler;
    }
    
    public void set(String dataSourceKey){
        if(dataSourceKey == null){
            throw new NullPointerException();
        }
        threadLocal.set(dataSourceKey);
    }

    public String get(){
        return threadLocal.get();
    }

    public void clear(){
        threadLocal.remove();
    }

    public void addDataSource(String key,DataSource value) {
        concurrentHashMap.put(key,value);
    }

    public int dataSourceCount(){
        return concurrentHashMap.size();
    }

    public DataSource getDataSource(String key) {
        return (DataSource) concurrentHashMap.get(key);
    }

    public DataSource removeDataSource(String key) {
        return (DataSource) concurrentHashMap.remove(key);
    }

    public void clearDataSource() {
        concurrentHashMap.clear();
    }

    public void addDataSourceInfo(DataSourceInfo dataSourceInfo) {
        DataSourceBuilder<HikariDataSource> hikariDataSourceBuilder = DataSourceBuilder.create().type(HikariDataSource.class);
        HikariDataSource hikariDataSource = hikariDataSourceBuilder.driverClassName(dataSourceInfo.getDriverClassName())
                                                            .url(dataSourceInfo.getJdbcUrl())
                                                            .username(dataSourceInfo.getUsername())
                                                            .password(dataSourceInfo.getPassword()).build();
        concurrentHashMap.put(dataSourceInfo.getDatasourceKey(),hikariDataSource);
    }
    public void addDataSourceInfoList(List<DataSourceInfo> list) {
        if(list == null){
            logger.warn("DataSourceInfoList 为空");
        }else {
            for (DataSourceInfo dataSourceInfo: list) {
                System.out.println(dataSourceInfo);
                addDataSourceInfo(dataSourceInfo);
            }
        }

    }

    public void initDynamicDataSource(DynamicDataSource dynamicDataSource) {
        dynamicDataSource.setTargetDataSources(concurrentHashMap);
    }

}
