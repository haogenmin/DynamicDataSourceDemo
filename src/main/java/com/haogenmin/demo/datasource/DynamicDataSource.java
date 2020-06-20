package com.haogenmin.demo.datasource;

import com.haogenmin.demo.handler.DynamicDataSourceHandler;


/**
 * @author ：HaoGenmin
 * @Title :DynamicDataSource
 * @date ：Created in 2020/6/18 15:51
 * @description：
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceHandler.getInstance().get();
    }
}
