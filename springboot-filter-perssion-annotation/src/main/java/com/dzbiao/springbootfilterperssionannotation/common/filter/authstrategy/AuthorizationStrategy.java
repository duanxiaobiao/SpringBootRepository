package com.dzbiao.springbootfilterperssionannotation.common.filter.authstrategy;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: dzbiao
 * @CreateTime: 2023/07/21 22:59
 * @Description:
 */
public interface AuthorizationStrategy {

    abstract String system();

    boolean matchSystem(String system);

    boolean authorize(HttpServletRequest request);
}
