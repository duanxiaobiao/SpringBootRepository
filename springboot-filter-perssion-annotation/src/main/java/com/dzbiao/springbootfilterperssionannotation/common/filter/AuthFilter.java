package com.dzbiao.springbootfilterperssionannotation.common.filter;

import com.dzbiao.springbootfilterperssionannotation.common.exception.AuthException;
import com.dzbiao.springbootfilterperssionannotation.common.filter.authstrategy.AuthorizationStrategy;
import com.dzbiao.springbootfilterperssionannotation.common.filter.authstrategy.AuthorizationStrategyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.HandlerMapping;

import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

/**
 * @author: dzbiao
 * @CreateTime: 2023/03/28 23:27
 * @Description:
 */
@Component
public class AuthFilter implements Filter {
    private static final String AUTHORIZATION_SYSTEM = "AuthorizationSystem";

    @Resource
    private HandlerMapping handlerMapping;

    @Autowired
    @Qualifier("handlerExceptionResolver")
    private HandlerExceptionResolver resolver;

    @Resource
    private AuthorizationStrategyFactory strategyFactory;

    @Value("${url.whiteList:/web/getUserInfo,/web/ss/getOrgInfo}")
    private String whiteListUri;


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        String uri = httpRequest.getRequestURI();

        try {
            if (passUri(uri)) {
                chain.doFilter(httpRequest, httpResponse);
                return;
            }
            // 根据系统名创建相应的鉴权策略
            String systemInfo = httpRequest.getHeader(AUTHORIZATION_SYSTEM);
            AuthorizationStrategy authorizationStrategy = strategyFactory.createAuthorizationStrategy(systemInfo);
            if (!authorizationStrategy.authorize(httpRequest)) {
                throw new AuthException("1", "鉴权失败！");
            }
            // 鉴权通过，继续处理请求
            chain.doFilter(httpRequest, httpResponse);
        } catch (Exception e) {
            resolver.resolveException(httpRequest, httpResponse, null, e);
        }
    }


    /**
     * 放行的uri
     *
     * @param requestURI
     * @return
     */
    private boolean passUri(String requestURI) {
        // 放行以/api/*开头的接口
        if (requestURI.startsWith("/api/")) {
            return true;
        }

        // 放行Swagger的静态资源
        if (requestURI.startsWith("/swagger") || requestURI.startsWith("/webjars") || requestURI.startsWith("/v3/api-docs")) {
            return true;
        }

        // 检查是否存在自定义权限注解@IgnorePersimisson，存在则放行
        if (hasPermission()) {
            return true;
        }

        List<String> whiteList = Arrays.asList(whiteListUri.split(","));
        // 检查是否在白名单上，存在则放行
        if (whiteList.contains(requestURI)) {
            return true;
        }
        return false;
    }


    private boolean hasPermission() {
        // 进行权限验证的逻辑实现
        return false;
    }

}

