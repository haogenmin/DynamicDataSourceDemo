package com.haogenmin.demo.config;

import com.haogenmin.demo.handler.DynamicDataSourceHandler;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author ：HaoGenmin
 * @Title :DataSourceConfig
 * @date ：Created in 2020/6/18 15:50
 * @description：
 */
@Configuration
public class DataSourceConfig {
    public DataSourceConfig(){
        System.out.println("DataSourceConfig加载");
    }

    @Bean(name = "defaultDataSource")
    @ConfigurationProperties(prefix = "datasource.default")
    public DataSource defaultDataSource(){
        DataSource dataSource = new HikariDataSource();
        System.out.println("defaultDataSource:"+dataSource.toString());
        return dataSource;
    }
}
