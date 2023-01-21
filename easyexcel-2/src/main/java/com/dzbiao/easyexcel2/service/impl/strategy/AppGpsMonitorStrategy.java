package com.dzbiao.easyexcel2.service.impl.strategy;

import com.dzbiao.easyexcel2.common.enums.TableEnum;
import com.dzbiao.easyexcel2.domain.entity.WiseMapDataMonitorEntity;
import com.dzbiao.easyexcel2.domain.entity.export.AppGpsMonitorExp;
import com.dzbiao.easyexcel2.service.MonitorExportStrategy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: dzbiao
 * @CreateTime: 2023/01/20 18:12
 * @Description:
 */
@Service
public class AppGpsMonitorStrategy extends MonitorStrategy implements MonitorExportStrategy {

    @Override
    public boolean monitorStrategy(Integer type) {
        return TableEnum.APP_GPS.getCode().equals(type);
    }


    @Override
    public MonitorStrategy population(List<WiseMapDataMonitorEntity> list) {
        MonitorStrategy monitorStrategy = getMonitorStrategy();
        monitorStrategy.setList(populationList(list));
        monitorStrategy.setColumns(Arrays.asList());
        // 具体列的具体标注
        HashMap<Integer, String> annotationsMap = new HashMap<>();
        monitorStrategy.setAnnotationsMap(annotationsMap);
        monitorStrategy.setAClass(AppGpsMonitorExp.class);
        return monitorStrategy;
    }


    @Override
    public List<?> populationList(List<WiseMapDataMonitorEntity> list) {
        List<AppGpsMonitorExp> expList = new ArrayList<>();
        for (WiseMapDataMonitorEntity entity : list) {
            AppGpsMonitorExp build = AppGpsMonitorExp.builder()
                    .typeName(TableEnum.byCode(entity.getType()))
                    .name(entity.getName() + "\t" + entity.getSourceName())
                    .channel("0".equals(entity.getChannel()) ? "手机银行APP" : "掌上生活APP")
                    .indexDate(entity.getIndexDate())
                    .dataTotal(String.valueOf(entity.getDataTotal()))
                    .dataTotalRate(entity.getDataTotalRate() + "%")
                    .userTotal(String.valueOf(entity.getUserTotal()))
                    .userTotalRate(entity.getUserTotalRate() + "%")
                    .isException("1".equals(entity.getIsException()) ? "是" : "否")
                    .triggerCondition(entity.getTriggerCondition())
                    .build();
            expList.add(build);
        }
        return expList;
    }
}
