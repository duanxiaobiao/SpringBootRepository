package com.dzbiao.aop.common.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.StringJoiner;

/**
 * @author: dzbiao
 * @CreateTime: 2023/11/02 20:29
 * @Description:
 */
@Component
@Aspect
public class LogAspect {

    @Before("execution(* com.dzbiao.aop.service..*.*(..))")
    public void sysLog(JoinPoint jp){
        StringJoiner log = new StringJoiner("|","{","}");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MM-dd HH:mm:ss");
        log.add(formatter.format(LocalDateTime.now()));
        //当前执行的业务方法名称
        String methodName = jp.getSignature().getName();
        log.add(methodName);

        //方法的参数
        Object[] args = jp.getArgs();
        for(Object arg:args){
            log.add(arg == null ? "-" : arg.toString() );
        }
        System.out.println("AOP日志启动！" + log);
    }
}
