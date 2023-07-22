package com.dzbiao.springbootfilterperssionannotation.controller;

import com.dzbiao.springbootfilterperssionannotation.common.annotation.CustomPermission;
import com.dzbiao.springbootfilterperssionannotation.common.response.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: dzbiao
 * @CreateTime: 2023/03/28 23:26
 * @Description:
 */
@RestController
@RequestMapping
public class MyController {


    @CustomPermission
    @GetMapping("/api/secure")
    public Result secure() {
        return Result.SUCCESS("Secure API");
    }


    @GetMapping("/web/unsecure")
    public String unsecure() {
        return "Unsecure API";
    }
}

