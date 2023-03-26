package com.dzbiao.springbootdemo.controller;

import com.dzbiao.springbootdemo.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: DZBiao
 * @Date : 2021/5/7
 * @Description : 描述：
 **/

@RestController
@RequestMapping("api")
public class UserController {

    @RequestMapping("getOneUser")
    public User getOneUser(Integer uid){
        List<User> list = new ArrayList<>() ;
        User user1 = new User("段振彪","123456",23) ;
        User user2 = new User("张三","147852963",23);
        User user3 = new User("李四","753159",21);
        list.add(user1);
        list.add(user2);
        list.add(user3);
        if (uid == 0) {
            return list.get(0) ;
        }
        if (uid == 1) {
            return list.get(1) ;
        } else {
            return list.get(2) ;
        }
    }
}
