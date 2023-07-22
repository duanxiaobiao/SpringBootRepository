package com.dzbiao.springbootfilterperssionannotation.common.filter.authstrategy;

/**
 * @author: dzbiao
 * @CreateTime: 2023/07/21 22:53
 * @Description:
 */
public interface AuthorizationStrategyFactory {

    AuthorizationStrategy createAuthorizationStrategy(String systemInfo) throws IllegalAccessException;
}
