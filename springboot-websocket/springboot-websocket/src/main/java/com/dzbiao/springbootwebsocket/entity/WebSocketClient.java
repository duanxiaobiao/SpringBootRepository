package com.dzbiao.springbootwebsocket.entity;

import lombok.Data;

import javax.websocket.Session;

/**
 * @author: dzbiao
 * @CreateTime: 2023/11/20 23:26
 * @Description:
 */
@Data
public class WebSocketClient {

    // 与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    //连接的uri
    private String uri;

}