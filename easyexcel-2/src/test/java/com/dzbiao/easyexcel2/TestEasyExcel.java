package com.dzbiao.easyexcel2;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.dzbiao.easyexcel2.common.handler.TitleHandler;
import com.dzbiao.easyexcel2.domain.entity.WiseMapDataMonitor;
import com.dzbiao.easyexcel2.utils.EasyExcelUtil;
import lombok.Data;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: dzbiao
 * @CreateTime: 2023/01/20 12:14
 * @Description:
 */
public class TestEasyExcel {


    /**
     * 测试导出模板
     * 1. 标题指定某列标红色字段
     * 2. 标题指定某列加批注
     */
    @Test
    public void testExport1() throws FileNotFoundException {
        // 输出流
        OutputStream outputStream = new FileOutputStream(new File("/Users/duanzhenbiao/workspace/Excel/1.xlsx"));
        // 导出的数据
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


        // 指定标红色的列
        List<Integer> columns = Arrays.asList(0, 1,7,8);
        // 指定批注
        HashMap<Integer, String> annotationsMap = new HashMap<>();
        annotationsMap.put(0,"第一列标题批注");
        annotationsMap.put(1,"第二列标题批注");
        annotationsMap.put(7,"第二列标题批注");
        annotationsMap.put(8,"第二列标题批注");
        TitleHandler titleHandler = new TitleHandler(columns, IndexedColors.RED.index,annotationsMap);
        EasyExcelUtil.writeExcelWithModel(outputStream, list, WiseMapDataMonitor.class, "sheetName", titleHandler);
    }
}

