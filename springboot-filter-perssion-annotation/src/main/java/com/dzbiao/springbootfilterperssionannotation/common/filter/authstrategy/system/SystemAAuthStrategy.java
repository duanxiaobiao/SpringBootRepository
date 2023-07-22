package com.dzbiao.springbootfilterperssionannotation.common.filter.authstrategy.system;

import com.dzbiao.springbootfilterperssionannotation.common.filter.authstrategy.AuthorizationStrategy;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: dzbiao
 * @CreateTime: 2023/07/21 23:02
 * @Description:
 */
@Component
public class SystemAAuthStrategy implements AuthorizationStrategy {

    public static final String SYSTEM_NAME = "AA";
    public static final String AUTHORIZATION = "authData";

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
        System.out.println("AA侧验证authData认证信息");
        return false;
    }
}
