package com.haogenmin.demo.config;

import com.haogenmin.demo.datasource.DynamicDataSource;
import com.haogenmin.demo.handler.DynamicDataSourceHandler;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：HaoGenmin
 * @Title :DynamicDataSourceConfig
 * @date ：Created in 2020/6/18 16:02
 * @description：
 */

@Configuration
public class DynamicDataSourceConfig {
    public DynamicDataSourceConfig(){
        System.out.println("DynamicDataSourceConfig加载");
    }

    @Bean(name = "dynamicDataSource")
    @Primary
    public DataSource dynamicDataSource(@Qualifier(value = "defaultDataSource") DataSource defaultDataSource){
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        System.out.println("加入的数据源defaultDataSource------->"+defaultDataSource);
        dynamicDataSource.setDefaultTargetDataSource(defaultDataSource);
        DynamicDataSourceHandler.getInstance().initDynamicDataSource(dynamicDataSource);
        return dynamicDataSource;
    }
}
