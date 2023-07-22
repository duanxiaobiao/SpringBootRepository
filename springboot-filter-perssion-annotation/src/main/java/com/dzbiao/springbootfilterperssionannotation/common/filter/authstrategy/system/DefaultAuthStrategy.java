package com.dzbiao.springbootfilterperssionannotation.common.filter.authstrategy.system;

import com.dzbiao.springbootfilterperssionannotation.common.filter.authstrategy.AuthorizationStrategy;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: dzbiao
 * @CreateTime: 2023/07/21 23:03
 * @Description:
 */
@Component
public class DefaultAuthStrategy implements AuthorizationStrategy {

    public static final String SYSTEM_NAME = "WISE";
    public static final String AUTHORIZATION = "Authorization";

    @Override
    public String system() {
        return SYSTEM_NAME;
    }

    @Override
    public boolean matchSystem(String system) {
        return system().equals(system);
    }

    @Override
    public boolean authorize(HttpServletRequest request) {
        String authorization = request.getHeader(AUTHORIZATION);
        System.out.println("本系统侧认证Authorization信息");
        return false;
    }
}

