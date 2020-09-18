package com.haogenmin.demo.mapper;

import com.haogenmin.demo.model.DataSourceInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author ：HaoGenmin
 * @Title :DataSourceInfoMapper
 * @date ：Created in 2020/6/19 14:48
 * @description：
 */
@Mapper
@Component
public interface DataSourceInfoMapper {

    @Select("select * from datasource_info")
    List<DataSourceInfo> findAll();

    @Options(useGeneratedKeys = true ,keyProperty = "id")
    @Insert("insert into datasource_info(datasource_key,driver_class_name,jdbc_url,username,password) "+
            "values(#{datasourceKey},#{driverClassName},#{jdbcUrl},#{username},#{password})")
    int addDataSourceInfo(DataSourceInfo dataSourceInfo);

    @Select("select * from datasource_info where datasource_key = #{key}")
    DataSourceInfo selectDataSourceInfoByKey(String key);

}
