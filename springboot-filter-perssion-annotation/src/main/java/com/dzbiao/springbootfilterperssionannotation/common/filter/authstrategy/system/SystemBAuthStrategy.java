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
public class SystemBAuthStrategy implements AuthorizationStrategy {

    public static final String SYSTEM_NAME = "BB";
    public static final String AUTHORIZATION = "W_Authorization";

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
        System.out.println("BB侧验证W_Authorization验证信息.");
        return true;
    }
}
