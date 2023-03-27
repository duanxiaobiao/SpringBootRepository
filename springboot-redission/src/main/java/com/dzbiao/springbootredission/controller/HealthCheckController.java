package com.dzbiao.springbootredission.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: dzbiao
 * @CreateTime: 2023/03/26 19:36
 * @Description:
 */
@RestController
@RequestMapping
public class HealthCheckController {

    @GetMapping("/health")
    public String health(){
        return "health check is SUCCESS!";
    }
}
