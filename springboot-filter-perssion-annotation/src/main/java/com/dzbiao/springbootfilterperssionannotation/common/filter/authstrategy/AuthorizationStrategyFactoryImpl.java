package com.dzbiao.springbootfilterperssionannotation.common.filter.authstrategy;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.dzbiao.springbootfilterperssionannotation.common.filter.authstrategy.system.DefaultAuthStrategy;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: dzbiao
 * @CreateTime: 2023/07/21 23:01
 * @Description:
 */
@Component
public class AuthorizationStrategyFactoryImpl implements AuthorizationStrategyFactory {
    private static final String SYSTEM_INFO_FIELD = "system";
    private static final String INVALID_MESSAGE = "系统来源信息非法";
    @Resource
    DefaultAuthStrategy defaultAuthStrategy;
    @Resource
    List<AuthorizationStrategy> authorizationStrategies;


    @Override
    public AuthorizationStrategy createAuthorizationStrategy(String systemInfo) {
        try {
            JSONObject systemJson = JSON.parseObject(systemInfo);
            if (systemJson == null || StringUtils.isBlank(systemJson.getString(SYSTEM_INFO_FIELD))) {
                throw new IllegalArgumentException(INVALID_MESSAGE);
            }

            // 提取系统鉴权字段
            String system = systemJson.getString(SYSTEM_INFO_FIELD);
            return authorizationStrategies.stream()
                    .filter(x -> x.matchSystem(system))
                    .findAny()
                    .orElse(defaultAuthStrategy);
        } catch (JSONException e) {
            throw new IllegalArgumentException(INVALID_MESSAGE);
        }
    }
}

