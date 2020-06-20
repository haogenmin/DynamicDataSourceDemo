package com.haogenmin.demo.aspect;


import com.haogenmin.demo.handler.DynamicDataSourceHandler;
import com.haogenmin.demo.manager.DataSourceMap;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author ：HaoGenmin
 * @Title :MyAspect
 * @date ：Created in 2020/6/18 14:15
 * @description：
 */
@Component
@Aspect
public class MyAspect {
    //声明公共切入点
    @Pointcut("execution(* com.haogenmin.demo.mapper.*.*(..))")
    private void myPointCut(){
    }

    @Around(value = "myPointCut()")
    public Object myAround(ProceedingJoinPoint joinPoint) throws Throwable{
        DynamicDataSourceHandler.getInstance().set(DataSourceMap.getInstance().getCurrentDataSource());
        Object obj = joinPoint.proceed();
        return obj;
    }
}