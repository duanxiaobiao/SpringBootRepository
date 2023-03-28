package com.dzbiao.springbootfilterperssionannotation.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * @author: dzbiao
 * @CreateTime: 2023/03/28 23:32
 * @Description:
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public HandlerMapping handlerMapping() {
        return new RequestMappingHandlerMapping();
    }


}


