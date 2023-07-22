package com.dzbiao.springbootredission.controller;

import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

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
        CompletableFuture<Void> future = CompletableFuture.supplyAsync(() -> {
            try {
                if (lock.tryLock(30, 10, TimeUnit.SECONDS)) {
                    // 执行业务逻辑
                    sleep(3000);
                } else {
                    throw new RuntimeException("获取锁失败");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }
            return null;
        });
        future.join();


        stopWatch.stop();
        System.out.println(stopWatch.getTotalTimeSeconds());
        return "Hello!";
    }

    /**
     *RLock lock = redisson.getLock("my-lock");
     * try {
     *     executeWithLock(lock, () -> {
     *         // 执行业务逻辑
     *     });
     * } catch (InterruptedException e) {
     *     // 处理异常情况
     * } catch (RuntimeException e) {
     *     // 处理异常情况
     * }
     */

    public void executeWithLock(RLock lock, Runnable task) throws InterruptedException {
        if (lock.tryLock(30, 10, TimeUnit.SECONDS)) {
            try {
                task.run();
            } finally {
                lock.unlock();
            }
        } else {
            throw new RuntimeException("获取锁失败");
        }
    }

    private void sleep(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            System.out.println("e:" + e);
        }
    }
}
