package com.dzbiao.springbootwebsocket.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: dzbiao
 * @CreateTime: 2023/11/20 23:28
 * @Description:
 */
@RestController
@RequestMapping("/notification")
public class OrderNotificationWebSocketController {

    @GetMapping("/test")
    public void test(@RequestParam String merchantId){
//        OrderNotificationWebSocket.sendMessage(merchantId, "亲爱的用户" + merchantId + ",您有新订单啦！");
    }
}
