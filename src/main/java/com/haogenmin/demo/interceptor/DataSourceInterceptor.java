package com.haogenmin.demo.interceptor;

import com.haogenmin.demo.handler.DynamicDataSourceHandler;
import com.haogenmin.demo.service.IDataSourceService;
import com.haogenmin.demo.utils.ApplicationContextUtil;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ：HaoGenmin
 * @Title :DataSourceInterceptor
 * @date ：Created in 2020/9/15 18:37
 * @description：
 */
public class DataSourceInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userId = request.getParameter("userId");
        System.out.println(userId);
        IDataSourceService dataSourceService = (IDataSourceService) ApplicationContextUtil.getBean(IDataSourceService.class);
        boolean hasUser = dataSourceService.verifyDataSource(userId);
        if(hasUser) {
            DynamicDataSourceHandler.getInstance().set(userId);
            System.out.println("数据源---"+DynamicDataSourceHandler.getInstance().dataSourceCount());
        }
        return true;
    }
}
