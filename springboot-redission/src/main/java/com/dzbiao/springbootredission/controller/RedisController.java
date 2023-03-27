package com.dzbiao.springbootredission.controller;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: dzbiao
 * @CreateTime: 2023/03/26 20:38
 * @Description:
 */
@RestController
@RequestMapping("/redis")
public class RedisController {

    @Resource
    private RedissonClient redisson;


    @GetMapping("/hello")
    public String hello() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        // 1.获取一把锁，只要锁的名字一样，就是同一把锁
        RLock lock = redisson.getLock("my-lock");
        lock.lock(); // 阻塞式等待。默认加的锁是30s时间   // 只有lock.lock()方式会有看门狗机制，lock.lock(10,TimeUnit.SECONDS);不存在看门狗机制.
        try {
            // 1、锁的自动续期，运行期间自动给锁续上新的30s，无需担心业务时间长，锁过期会自动被释放
            // 2、加锁的业务只要运行完成，就不会给当前锁续期，即使不手动释放锁，锁默认在30s后自动释放，避免死锁
            System.out.println("加锁成功，执行业务代码..."+Thread.currentThread().getId());
            Thread.sleep(30000 * 6);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println("释放锁..."+Thread.currentThread().getId());
            lock.unlock();
        }
        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeSeconds());
        return "Hello!";
    }


}
