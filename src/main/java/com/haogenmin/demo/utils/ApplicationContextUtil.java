package com.haogenmin.demo.utils;

import org.springframework.context.ApplicationContext;

/**
 * @author ：HaoGenmin
 * @Title :ApplicationContextUtil
 * @date ：Created in 2020/9/16 9:34
 * @description：
 */
public class ApplicationContextUtil {

    private static ApplicationContext applicationContext = null;

    public static void setApplicationContext(ApplicationContext applicationContext) {
        if (ApplicationContextUtil.applicationContext == null) {
            ApplicationContextUtil.applicationContext = applicationContext;
        }

    }

    //获取applicationContext
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    //通过name获取 Bean
    public static Object getBean(String name) {
        if (applicationContext == null) return null;
        return getApplicationContext().getBean(name);

    }

    //通过class获取Bean
    public static Object  getBean(Class<?> clazz) {
        if (applicationContext == null) return null;
        return getApplicationContext().getBean(clazz);
    }

    //通过name,以及Clazz返回指定的Bean
    public static Object  getBean(String name, Class<?> clazz) {
        if (applicationContext == null) return null;
        return getApplicationContext().getBean(name, clazz);
    }

}