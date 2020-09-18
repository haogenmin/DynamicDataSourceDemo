package com.haogenmin.demo.config;

import com.haogenmin.demo.interceptor.DataSourceInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ：HaoGenmin
 * @Title :StandardConfig
 * @date ：Created in 2020/9/15 18:46
 * @description：
 */
@Configuration
public class StandardConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new DataSourceInterceptor()).addPathPatterns("/**");
    }
}
