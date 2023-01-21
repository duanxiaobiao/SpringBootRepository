package com.dzbiao.easyexcel;

import com.alibaba.excel.EasyExcel;
import com.dzbiao.easyexcel.entity.WiseMapDataMonitor;
import com.dzbiao.easyexcel.handler.ExcelRemarkHandler;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class EasyExcelApplicationTests {




    @Test
    void contextLoads() {
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

        String fileStr = System.currentTimeMillis() + ".xlsx";
        String fileName = "/Users/duanzhenbiao/workspace/Excel/" + fileStr;
        System.out.println("导出名称：" + fileName);
        EasyExcel.write(fileName, WiseMapDataMonitor.class)
                .registerWriteHandler(new ExcelRemarkHandler(WiseMapDataMonitor.class))
                .sheet("模板")
                .doWrite(list);

    }
}
