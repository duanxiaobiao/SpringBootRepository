package com.dzbiao.springbootstrategy.service;



import com.dzbiao.springbootstrategy.common.request.TransferFeeRequest;

import java.math.BigDecimal;

public interface LogisticsService {

    boolean isCurrentLogistics(Integer type);

    BigDecimal calculateFee(TransferFeeRequest transferFeeRequest);
}
