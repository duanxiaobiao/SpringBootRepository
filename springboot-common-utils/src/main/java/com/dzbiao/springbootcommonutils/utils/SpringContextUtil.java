package com.dzbiao.springbootcommonutils.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Author: dzbiao
 * @CreateTime: 2023/02/12 15:06
 * @Description: 可以在工具类中注入使用某一个服务.
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        setContext(applicationContext);
    }


    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }


    public static void setContext(ApplicationContext applicationContext){
        SpringContextUtil.applicationContext = applicationContext;
    }

    /**
     * 适用springbean使用注解@Service("XXXService")
     * 获取接口对象,参数传入 XXXService
     * @param beanName
     * @return
     */
    public static Object  getBean(String beanName){
        return applicationContext.getBean(beanName);
    }


    /**
     * 获取接口对象,参数传入 XXXService
     * @param beanNameClass
     * @return
     */
    public static <T> Object  getBean(Class<T> beanNameClass){
        return applicationContext.getBean(beanNameClass);
    }

}
