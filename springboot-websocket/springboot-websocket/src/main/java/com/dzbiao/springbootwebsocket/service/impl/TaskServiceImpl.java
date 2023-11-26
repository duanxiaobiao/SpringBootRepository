package com.dzbiao.springbootwebsocket.service.impl;

import com.dzbiao.springbootwebsocket.common.response.Result;
import com.dzbiao.springbootwebsocket.mapper.TaskMapper;
import com.dzbiao.springbootwebsocket.service.AsyncService;
import com.dzbiao.springbootwebsocket.service.TaskService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author: dzbiao
 * @CreateTime: 2023/11/26 18:44
 * @Description:
 */
@Service
public class TaskServiceImpl implements TaskService {

    @Resource
    TaskMapper taskMapper;

    @Resource
    AsyncService asyncService;


    @Override
    public Result list() {
        return Result.SUCCESS(taskMapper.selectAll());
    }


    @Override
    public Result start(String taskId, String currentUser) throws InterruptedException {
        taskMapper.updateProgressByTaskId(taskId, 0);
        asyncService.asyncStartTask(taskId, currentUser);
        return Result.SUCCESS("启动成功！", null);
    }
}
