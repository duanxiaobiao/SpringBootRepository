package com.dzbiao.springbootwebsocket.service;

/**
 * @author: dzbiao
 * @CreateTime: 2023/11/26 22:46
 * @Description:
 */
public interface AsyncService {


    void asyncStartTask(String taskId, String currentUser) throws InterruptedException;
}
