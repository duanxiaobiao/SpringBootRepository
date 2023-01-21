package com.dzbiao.easyexcel2.service.impl.strategy;

import com.dzbiao.easyexcel2.common.enums.TableEnum;
import com.dzbiao.easyexcel2.domain.entity.WiseMapDataMonitorEntity;
import com.dzbiao.easyexcel2.domain.entity.export.FlashLoanEntpMonitorExp;
import com.dzbiao.easyexcel2.domain.entity.export.HomeOrWorkMonitorExp;
import com.dzbiao.easyexcel2.service.MonitorExportStrategy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: dzbiao
 * @CreateTime: 2023/01/20 18:13
 * @Description:
 */
@Service
public class HomeOrWorkMonitorStrategy extends MonitorStrategy implements MonitorExportStrategy {

    @Override
    public boolean monitorStrategy(Integer type) {
        return TableEnum.HOME_PLACE.getCode().equals(type) || TableEnum.WORK_PLACE.getCode().equals(type);
    }

    @Override
    public MonitorStrategy population(List<WiseMapDataMonitorEntity> list) {
        MonitorStrategy monitorStrategy = getMonitorStrategy();
        monitorStrategy.setList(populationList(list));
        // 覆盖率1，覆盖率2 列加批注
        monitorStrategy.setColumns(Arrays.asList(5,6));
        // 具体列的具体标注
        HashMap<Integer, String> annotationsMap = new HashMap<>();
        annotationsMap.put(5, "覆盖率1计算公式:\t 数据总量/GPS客户总量");
        annotationsMap.put(6, "覆盖率2计算公式:\t 数据总量/MAU客户总量");
        monitorStrategy.setAnnotationsMap(annotationsMap);
        monitorStrategy.setAnnotationsMap(annotationsMap);
        monitorStrategy.setAClass(HomeOrWorkMonitorExp.class);
        return monitorStrategy;
    }

    @Override
    public List<?> populationList(List<WiseMapDataMonitorEntity> list) {
        List<HomeOrWorkMonitorExp> expList = new ArrayList<>();
        for (WiseMapDataMonitorEntity entity : list) {
            HomeOrWorkMonitorExp build = HomeOrWorkMonitorExp.builder()
                    .typeName(TableEnum.byCode(entity.getType()))
                    .name(entity.getName() + "\t" + entity.getSourceName())
                    .indexDate(entity.getIndexDate())
                    .dataTotal(String.valueOf(entity.getDataTotal()))
                    .dataTotalRate(entity.getDataTotalRate() + "%")
                    .gpsCoverageRate(entity.getGpsCoverageRate() + "%")
                    .mauCoverageRate(entity.getMauCoverageRate() + "%")
                    .isException("1".equals(entity.getIsException()) ? "是" : "否")
                    .triggerCondition(entity.getTriggerCondition())
                    .build();
            expList.add(build);
        }
        return expList;
    }
}
