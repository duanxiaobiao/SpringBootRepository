package com.dzbiao.springbootwebsocket.controller;

import com.dzbiao.springbootwebsocket.common.response.Result;
import com.dzbiao.springbootwebsocket.service.TaskService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: dzbiao
 * @CreateTime: 2023/11/26 18:40
 * @Description:
 */
@RestController
@RequestMapping("/task")
public class TaskController {

    @Resource
    private TaskService taskService;

    @GetMapping("/list")
    public Result task() {
        return taskService.list();
    }


    @PostMapping("/start")
    public Result start(String taskId, String currentUser) throws InterruptedException {
        System.out.println("taskId:" + taskId + ",currentUser: " + currentUser);
        return taskService.start(taskId, currentUser);
    }
}
