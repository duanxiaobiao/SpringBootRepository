package com.dzbiao.springbootfilterperssionannotation.common.filter;

import com.dzbiao.springbootfilterperssionannotation.common.annotation.CustomPermission;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExecutionChain;
import org.springframework.web.servlet.HandlerMapping;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author: dzbiao
 * @CreateTime: 2023/03/28 23:27
 * @Description:
 */
@Component
public class CustomPermissionFilter implements Filter {

    @Resource
    private HandlerMapping handlerMapping;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String uri = httpRequest.getRequestURI();

        // 如果请求的接口需要进行权限验证，则检查用户是否有权限访问
        Method method = getMethod(httpRequest);
        if (passUri(uri) || (method != null && method.isAnnotationPresent(CustomPermission.class))){
            chain.doFilter(request, response);
            return;
        }

        String token = httpRequest.getHeader("Authentication");
        if (StringUtils.isBlank(token)){
            httpResponse.sendError(HttpServletResponse.SC_FORBIDDEN);
            return;
        }
        // 有token，则直接放行
        chain.doFilter(request, response);
    }

    /**
     * 放行的uri
     * @param uri
     * @return
     */
    private boolean passUri(String uri) {
        return false;
    }


    private Method getMethod(HttpServletRequest request) {
        HandlerExecutionChain handler = null;
        try {
            handler = new HandlerExecutionChain(handlerMapping.getHandler(request).getHandler());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (handler != null && handler.getHandler() instanceof HandlerMethod) {
            return ((HandlerMethod) handler.getHandler()).getMethod();
        }
        return null;
    }

    private boolean hasPermission() {
        // 进行权限验证的逻辑实现
        return true;
    }

}

