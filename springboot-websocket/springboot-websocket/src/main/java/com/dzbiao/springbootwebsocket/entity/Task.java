package com.dzbiao.springbootwebsocket.entity;

import lombok.Data;

/**
 * @author: dzbiao
 * @CreateTime: 2023/11/26 18:46
 * @Description:
 */
@Data
public class Task {

    private Integer id;

    private String taskId;

    private  String taskName;

    private String total;

    private Integer status;

    private Double progress;

    private String createUserId;

    private String createTime;

    private String updateTime;

    private String fileUrl;

}
