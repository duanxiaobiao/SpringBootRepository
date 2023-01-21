package com.dzbiao.easyexcel2.service.impl;

import com.dzbiao.easyexcel2.common.handler.TitleHandler;
import com.dzbiao.easyexcel2.dao.WiseMapMonitorMapper;
import com.dzbiao.easyexcel2.domain.entity.WiseMapDataMonitor;
import com.dzbiao.easyexcel2.domain.entity.WiseMapDataMonitorEntity;
import com.dzbiao.easyexcel2.domain.param.MonitorParam;
import com.dzbiao.easyexcel2.service.MonitorExportStrategy;
import com.dzbiao.easyexcel2.service.WiseMapMonitorService;
import com.dzbiao.easyexcel2.service.impl.strategy.MonitorStrategy;
import com.dzbiao.easyexcel2.utils.EasyExcelUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: dzbiao
 * @CreateTime: 2023/01/20 12:43
 * @Description:
 */
@Slf4j
@Service
public class WiseMapMonitorServiceImpl implements WiseMapMonitorService {

    @Resource
    private WiseMapMonitorMapper wiseMapMonitorMapper;

    @Resource
    private List<MonitorExportStrategy> monitorExportStrategies;

    /**
     * 下载报表
     * @param param
     */
    @Override
    public void download(MonitorParam param, HttpServletResponse httpServletResponse) {

        List<WiseMapDataMonitorEntity> list = wiseMapMonitorMapper.list(param);
        MonitorExportStrategy service = monitorExportStrategies.stream()
                .filter(x -> x.monitorStrategy(param.getType())).findFirst().orElse(null);
        // TODO: 使用项目中的lambda 表达式
        if (service == null){
            log.error("无服务可调用");
            return;
        }
        MonitorStrategy monitorStrategy = service.population(list);
        String filePath = "/Users/duanzhenbiao/workspace/Excel/1.xlsx";
        File file = new File(filePath);
        try(OutputStream outputStream = new FileOutputStream(file);){
            TitleHandler titleHandler = new TitleHandler(monitorStrategy.getColumns(), IndexedColors.RED.index,
                    monitorStrategy.getAnnotationsMap());
            EasyExcelUtil.writeExcelWithModel(outputStream, monitorStrategy.getList(),
                    monitorStrategy.getAClass(), "sheetName", titleHandler);
            log.info("导出报表成功！");
        }catch (Exception e){
            // TODO:
            log.error("导出报表异常！" , e);
        }finally {
            if (file.exists()){
                file.delete();
            }
        }
        // TODO: 需要更改为返回文件流形式。
    }









    private List<WiseMapDataMonitor> getData(){
        List<WiseMapDataMonitor> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            WiseMapDataMonitor w = new WiseMapDataMonitor();
            w.setTypeName("登录地");
            w.setName("客户登录地信息汇总表");
            w.setIndexDate("2023-01-2" + i);
            w.setDataTotal("2122223243" + i);
            w.setDataTotalRate("+1.01%");
            w.setUserTotal("2132323" + i);
            w.setUserTotalRate((i % 2 == 0 ? "-" : "+") + "2.03%");
            w.setGpsCoverageRate("70." + i + "%");
            w.setMauCoverageRate("61." + i + "%");
            w.setIsException(i % 2 == 0 ? " 是" : "否");
            w.setTriggerCondition("环比在[-10,+10]之外");
            list.add(w);
        }
        return list;
    }
}
