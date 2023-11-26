package com.dzbiao.springbootwebsocket.mapper;

import com.dzbiao.springbootwebsocket.entity.Task;

import java.util.List;

/**
 * @author: dzbiao
 * @CreateTime: 2023/11/26 18:45
 * @Description:
 */
public interface TaskMapper {


    List<Task> selectAll();

    int updateAutoProgressByTaskId(String taskId, double progress);

    Task selectByTaskId(String taskId);

    int updateProgressByTaskId(String taskId, int progress);
}
