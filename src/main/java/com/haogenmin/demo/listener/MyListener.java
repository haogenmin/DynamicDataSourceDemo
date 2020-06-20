package com.haogenmin.demo.listener;

import com.haogenmin.demo.handler.DynamicDataSourceHandler;
import com.haogenmin.demo.mapper.DataSourceInfoMapper;
import com.haogenmin.demo.model.DataSourceInfo;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

import java.util.List;

/**
 * @author ：HaoGenmin
 * @Title :MyListener
 * @date ：Created in 2020/6/19 14:41
 * @description：上下文刷新之后执行监听器
 */

public class MyListener implements ApplicationListener<ApplicationStartedEvent> {
    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        DataSourceInfoMapper dataSourceInfoMapper = event.getApplicationContext().getBean(DataSourceInfoMapper.class);
        List<DataSourceInfo> list = dataSourceInfoMapper.findAll();
        DynamicDataSourceHandler.getInstance().addDataSourceInfoList(list);

    }
}
