package com.dzbiao.springbootwebsocket.common.websocket;

/**
 * @author: dzbiao
 * @CreateTime: 2023/11/20 23:14
 * @Description:
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dzbiao.springbootwebsocket.entity.WebSocketClient;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Alan Chen
 * @description 订单通知
 * @date 2020-04-08 ：
 * TODO:参考文档： https://wsa.jianshu.io/p/3a5c58e921b7
 */
@Component
@ServerEndpoint("/webSocket/{merchantId}")
public class OrderNotificationWebSocket {

    static final ConcurrentHashMap<String, List<WebSocketClient>> webSocketClientMap = new ConcurrentHashMap<>();

    /**
     * 连接建立成功时触发，绑定参数
     * @param session 与某个客户端的连接会话，需要通过它来给客户端发送数据
     * @param merchantId 商户ID
     */
    @OnOpen
    public void onOpen(Session session, @PathParam("merchantId") String merchantId){
        WebSocketClient client = new WebSocketClient();
        client.setSession(session);
        client.setUri(session.getRequestURI().toString());

        List<WebSocketClient> webSocketClientList = webSocketClientMap.get(merchantId);
        if(webSocketClientList == null){
            webSocketClientList = new ArrayList<>();
        }
        webSocketClientList.add(client);
        webSocketClientMap.put(merchantId, webSocketClientList);
    }

    /**
     * 连接关闭时触发，注意不能向客户端发送消息了
     * @param merchantId
     */
    @OnClose
    public void onClose(@PathParam("merchantId") String merchantId){
        webSocketClientMap.remove(merchantId);
    }

    /**
     * 通信发生错误时触发
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }

    /**
     * 向客户端发送消息
     * @param message
     */
    public static void sendMessage(JSONObject message){
        try {
            String merchantId = message.getString("merchantId");
            List<WebSocketClient> webSocketClientList = webSocketClientMap.get(merchantId);
            if(webSocketClientList!= null){
                for(WebSocketClient webSocketServer : webSocketClientList){
                    webSocketServer.getSession().getBasicRemote().sendText(JSON.toJSONString(message));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

}
