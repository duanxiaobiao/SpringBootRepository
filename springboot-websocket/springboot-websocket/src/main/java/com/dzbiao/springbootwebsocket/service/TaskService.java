package com.dzbiao.springbootwebsocket.service;

import com.dzbiao.springbootwebsocket.common.response.Result;

/**
 * @author: dzbiao
 * @CreateTime: 2023/11/26 18:43
 * @Description:
 */
public interface TaskService {

    Result list();

    Result start(String taskId, String currentUser) throws InterruptedException;
}
