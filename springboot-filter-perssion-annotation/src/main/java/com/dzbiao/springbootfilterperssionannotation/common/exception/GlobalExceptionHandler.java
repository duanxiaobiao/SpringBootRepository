package com.dzbiao.springbootfilterperssionannotation.common.exception;

import com.dzbiao.springbootfilterperssionannotation.common.response.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

/**
 * @author: dzbiao
 * @CreateTime: 2023/07/15 15:53
 * @Description:
 */

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(IOException.class)
    public Result handleException(IOException e) {
        // 这里可以编写自定义的异常处理逻辑，例如记录日志或返回错误响应
        return Result.ERROR(e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        log.error("Exception异常：", e);
        // 这里可以编写自定义的异常处理逻辑，例如记录日志或返回错误响应
        return Result.ERROR(e.getMessage());
    }
}
