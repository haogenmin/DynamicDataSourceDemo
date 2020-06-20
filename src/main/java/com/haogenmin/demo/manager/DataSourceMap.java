package com.haogenmin.demo.manager;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ：HaoGenmin
 * @Title :UserManager
 * @date ：Created in 2020/6/18 14:28
 * @description：
 */
public class DataSourceMap {
    private Map<Integer,String> map = new ConcurrentHashMap();
    private Integer currentUserId;
    private DataSourceMap(){
        map.put(1,"firstDataSource");
        map.put(2,"secondDataSource");
        map.put(3,"threeDataSource");
    }
    private static final DataSourceMap dataSourceMap= new DataSourceMap();

    public static DataSourceMap getInstance() {
        return dataSourceMap;
    }

    public String getCurrentDataSource() {
            return map.get(currentUserId);
    }

    public void setCurrentUserId(Integer currentUserId) {
        this.currentUserId = currentUserId;
    }
    public void setUserToDataSourceMap(Integer userId,String dataSourceKey) {
        map.put(userId,dataSourceKey);
    }
}
