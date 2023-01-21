package com.dzbiao.easyexcel2.service.impl.strategy;

import com.alibaba.fastjson.JSONObject;
import com.dzbiao.easyexcel2.common.enums.TableEnum;
import com.dzbiao.easyexcel2.domain.entity.WiseMapDataMonitorEntity;
import com.dzbiao.easyexcel2.domain.entity.export.FlashLoanEntpMonitorExp;
import com.dzbiao.easyexcel2.domain.entity.export.LoginMonitorExp;
import com.dzbiao.easyexcel2.service.MonitorExportStrategy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: dzbiao
 * @CreateTime: 2023/01/20 18:18
 * @Description:
 */
@Service
public class FlashLoanEntpMonitorStrategy extends MonitorStrategy implements MonitorExportStrategy {

    @Override
    public boolean monitorStrategy(Integer type) {
        return TableEnum.FLASH_LOAN_ENTP.getCode().equals(type);
    }

    @Override
    public MonitorStrategy population(List<WiseMapDataMonitorEntity> list) {
        MonitorStrategy monitorStrategy = getMonitorStrategy();
        monitorStrategy.setList(populationList(list));
        // 覆盖率1，覆盖率2 列加批注
        monitorStrategy.setColumns(Arrays.asList(4));
        // 具体列的具体标注
        HashMap<Integer, String> annotationsMap = new HashMap<>();
        annotationsMap.put(4, "企业量环比计算公式:\t 数据总量/GPS客户总量");
        monitorStrategy.setAnnotationsMap(annotationsMap);
        monitorStrategy.setAClass(FlashLoanEntpMonitorExp.class);
        return monitorStrategy;
    }


    @Override
    public List<?> populationList(List<WiseMapDataMonitorEntity> list) {
        List<FlashLoanEntpMonitorExp> expList = new ArrayList<>();
        for (WiseMapDataMonitorEntity entity : list) {
            FlashLoanEntpMonitorExp build = FlashLoanEntpMonitorExp.builder()
                    .typeName(TableEnum.byCode(entity.getType()))
                    .name(entity.getName() + "\t" + entity.getSourceName())
                    .indexDate(entity.getIndexDate())
                    .dataTotal(String.valueOf(entity.getDataTotal()))
                    .dataTotalRate(entity.getDataTotalRate() + "%")
                    .isException("1".equals(entity.getIsException()) ? "是" : "否")
                    .triggerCondition(entity.getTriggerCondition())
                    .build();
            expList.add(build);
        }
        return expList;
    }
}
