package com.dzbiao.springbootstrategy.controller;


import com.dzbiao.springbootstrategy.common.request.TransferFeeRequest;
import com.dzbiao.springbootstrategy.service.LogisticsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@RestController
public class LogisticsController {


    @Resource
    private List<LogisticsService> logisticsService;


    @PostMapping("/calculate")
    private BigDecimal calculateFee(@RequestBody TransferFeeRequest transferFeeRequest) {

        LogisticsService logisticsService = this.logisticsService.stream().filter(l -> l.isCurrentLogistics(transferFeeRequest.getType()))
                .findFirst().orElse(null);
        if (logisticsService != null) {
            return logisticsService.calculateFee(transferFeeRequest);
        }
        return null;
    }
}
