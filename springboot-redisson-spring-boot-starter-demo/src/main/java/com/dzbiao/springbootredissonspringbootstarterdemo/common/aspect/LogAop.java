package com.dzbiao.springbootredissonspringbootstarterdemo.common.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author: dzbiao
 * @CreateTime: 2023/03/28 22:43
 * @Description:
 */
@Aspect
@Component
@Slf4j
public class LogAop {

    /**
     * 切点，拦截被 @RedissonLockAnnotation 修饰的方法
     */
    @Pointcut("@annotation(com.dzbiao.springbootredissonspringbootstarterdemo.common.annotation.LogAnnotation)")
    public void logAnnotationPoint() {
    }


    @Before("logAnnotationPoint()")
    public void before(){
        log.info("方法前打印日志...........");
    }

    @After("logAnnotationPoint()")
    public void after(){
        log.info("方法后打印日志...........");
    }
}
