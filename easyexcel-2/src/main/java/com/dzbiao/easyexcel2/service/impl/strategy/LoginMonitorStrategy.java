package com.dzbiao.easyexcel2.service.impl.strategy;

import com.alibaba.fastjson.JSONObject;
import com.dzbiao.easyexcel2.common.enums.TableEnum;
import com.dzbiao.easyexcel2.domain.entity.WiseMapDataMonitorEntity;
import com.dzbiao.easyexcel2.domain.entity.export.LoginMonitorExp;
import com.dzbiao.easyexcel2.service.MonitorExportStrategy;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Author: dzbiao
 * @CreateTime: 2023/01/20 18:12
 * @Description:
 */
@Service
public class LoginMonitorStrategy extends MonitorStrategy implements MonitorExportStrategy {

    @Override
    public boolean monitorStrategy(Integer type) {
        return TableEnum.LOGIN_PLACE.getCode().equals(type);
    }


    @Override
    public MonitorStrategy population(List<WiseMapDataMonitorEntity> list) {
        MonitorStrategy monitorStrategy = getMonitorStrategy();
        monitorStrategy.setList(populationList(list));
        // 覆盖率1，覆盖率2 列加批注
        monitorStrategy.setColumns(Arrays.asList(17,18));
        // 具体列的具体标注
        HashMap<Integer, String> annotationsMap = new HashMap<>();
        annotationsMap.put(17, "覆盖率1计算公式:\t 数据总量/GPS客户总量");
        annotationsMap.put(18, "覆盖率2计算公式:\t 数据总量/MAU客户总量");
        monitorStrategy.setAnnotationsMap(annotationsMap);
        monitorStrategy.setAClass(LoginMonitorExp.class);
        return monitorStrategy;
    }


    @Override
    public List<?> populationList(List<WiseMapDataMonitorEntity> list) {
        List<LoginMonitorExp> expList = new ArrayList<>();
        JSONObject dataDetail, dataJson, userJson;
        for (WiseMapDataMonitorEntity entity : list) {
            dataDetail = entity.getDataDetail();
            dataJson = (JSONObject) dataDetail.get("data");
            userJson = (JSONObject) dataDetail.get("user");
            LoginMonitorExp build = LoginMonitorExp.builder()
                    .typeName(TableEnum.byCode(entity.getType()))
                    .name(entity.getName() + "\t" + entity.getSourceName())
                    .indexDate(entity.getIndexDate())
                    .dataTotal(String.valueOf(entity.getDataTotal()))
                    .dataTotalRate(entity.getDataTotalRate() + "%")
                    .userTotal(String.valueOf(entity.getUserTotal()))
                    .userTotalRate(entity.getUserTotalRate() + "%")
                    .dataRecent1Day(dataJson.getString("recent1Day") + "(" + dataJson.getString("recent1DayRate") + "%)")
                    .dataRecent7Day(dataJson.getString("recent7Day") + "(" + dataJson.getString("recent7DayRate") + "%)")
                    .dataRecent30Day(dataJson.getString("recent30Day") + "(" + dataJson.getString("recent30DayRate") + "%)")
                    .dataRecent90Day(dataJson.getString("recent90Day") + "(" + dataJson.getString("recent90DayRate") + "%)")
                    .dataRecent180Day(dataJson.getString("recent180Day") + "(" + dataJson.getString("recent180DayRate") + "%)")
                    .userRecent1Day(userJson.getString("recent1Day") + "(" + userJson.getString("recent1DayRate") + "%)")
                    .userRecent7Day(userJson.getString("recent7Day") + "(" + userJson.getString("recent7DayRate") + "%)")
                    .userRecent30Day(userJson.getString("recent30Day") + "(" + userJson.getString("recent30DayRate") + "%)")
                    .userRecent90Day(userJson.getString("recent90Day") + "(" + userJson.getString("recent90DayRate") + "%)")
                    .userRecent180Day(userJson.getString("recent180Day") + "(" + userJson.getString("recent180DayRate") + "%)")
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
