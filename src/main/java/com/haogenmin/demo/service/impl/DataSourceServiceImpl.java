package com.haogenmin.demo.service.impl;

import com.haogenmin.demo.handler.DynamicDataSourceHandler;
import com.haogenmin.demo.mapper.DataSourceInfoMapper;
import com.haogenmin.demo.model.DataSourceInfo;
import com.haogenmin.demo.service.IDataSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

/**
 * @author ：HaoGenmin
 * @Title :DataSourceServiceImpl
 * @date ：Created in 2020/9/16 9:18
 * @description：
 */
@Service
public class DataSourceServiceImpl implements IDataSourceService {
    @Autowired
    DataSourceInfoMapper dataSourceInfoMapper;

    @Override
    public boolean verifyDataSource(String key) {
        DynamicDataSourceHandler dynamicDataSourceHandler = DynamicDataSourceHandler.getInstance();
        boolean hasKey = dynamicDataSourceHandler.containsKey(key);
        if(hasKey) {
            return true;
        }else {
            DataSourceInfo dataSourceInfo = dataSourceInfoMapper.selectDataSourceInfoByKey(key);
            if(dataSourceInfo == null) {
                return false;
            }else {
                dynamicDataSourceHandler.addDataSourceInfo(dataSourceInfo);
                DataSource dataSource_ = dynamicDataSourceHandler.getDataSource(key);
                System.out.println(dataSource_);
                return true;
            }
        }
    }
}
