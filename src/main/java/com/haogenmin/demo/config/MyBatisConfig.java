package com.haogenmin.demo.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author ：HaoGenmin
 * @Title :MyBatisConfig
 * @date ：Created in 2020/6/18 16:30
 * @description：
 */

@Configuration
public class MyBatisConfig {

    public MyBatisConfig(){
        System.out.println("MyBatisConfig加载");
    }

    @Autowired
    private DataSource dataSource;

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
        System.out.println("sqlSessionFactory加入的数据源："+dataSource);
        sqlSessionFactory.setDataSource(dataSource);
        sqlSessionFactory.getObject().getConfiguration().setMapUnderscoreToCamelCase(true);
        return sqlSessionFactory.getObject();
    }
}
