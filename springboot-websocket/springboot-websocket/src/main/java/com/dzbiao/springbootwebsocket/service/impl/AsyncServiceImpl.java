package com.dzbiao.springbootwebsocket.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dzbiao.springbootwebsocket.common.websocket.OrderNotificationWebSocket;
import com.dzbiao.springbootwebsocket.entity.Task;
import com.dzbiao.springbootwebsocket.mapper.TaskMapper;
import com.dzbiao.springbootwebsocket.service.AsyncService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Random;

/**
 * @author: dzbiao
 * @CreateTime: 2023/11/26 22:46
 * @Description:
 */
@Service
public class AsyncServiceImpl implements AsyncService {

    private Random random = new Random();
    @Resource
    TaskMapper taskMapper;


    @Async
    @Override
    public void asyncStartTask(String taskId, String currentUser) throws InterruptedException {
        // 模拟执行任务的逻辑
        Task task = taskMapper.selectByTaskId(taskId);
        double progress = 100.0 - task.getProgress();
        double autoProgress = progress / 10;
        for (int i = 0; i < 10; i++) {
            taskMapper.updateAutoProgressByTaskId(taskId, autoProgress);
            int sleepTime = random.nextInt(5);
            Thread.sleep(sleepTime * 1000);
            System.out.println("随机睡眠时间：" + sleepTime + "秒");
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("type", "pageRefresh");
            jsonObject.put("merchantId", currentUser);
            jsonObject.put("taskId", taskId);
            jsonObject.put("message", "页面数据刷新");
            OrderNotificationWebSocket.sendMessage(jsonObject);
        }
        Task task2 = taskMapper.selectByTaskId(taskId);
        if (!task2.getProgress().equals(Double.valueOf(100))){
            taskMapper.updateProgressByTaskId(taskId, 100);
        }
        System.out.println("任务执行完毕,发送WebSocket到页面......");
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("type", "title");
        jsonObject.put("merchantId", currentUser);
        jsonObject.put("message", String.format("您的任务[%s]已经执行完毕啦~", task.getTaskName()));
        OrderNotificationWebSocket.sendMessage(jsonObject);
    }
}
