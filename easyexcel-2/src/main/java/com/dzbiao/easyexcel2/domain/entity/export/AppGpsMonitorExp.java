package com.dzbiao.easyexcel2.domain.entity.export;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.Builder;
import lombok.Data;

/**
 * @Author: dzbiao
 * @CreateTime: 2023/01/20 23:09
 * @Description:
 */
@Builder
@Data
public class AppGpsMonitorExp {

    @ColumnWidth(value = 15)
    @ExcelProperty("类型")
    private String typeName;

    @ColumnWidth(value = 25)
    @ExcelProperty(value = "表名")
    private String name;

    @ColumnWidth(value = 15)
    @ExcelProperty(value = "渠道")
    private String channel;

    @ColumnWidth(value = 15)
    @ExcelProperty(value = "日期")
    private String indexDate;

    @ColumnWidth(value = 15)
    @ExcelProperty("数据量(万)")
    private String dataTotal;

    @ColumnWidth(value = 15)
    @ExcelProperty("数据量环比")
    private String dataTotalRate;


    @ColumnWidth(value = 15)
    @ExcelProperty("用户量(万)")
    private String userTotal;

    @ColumnWidth(value = 15)
    @ExcelProperty("用户量环比")
    private String userTotalRate;


    @ColumnWidth(value = 15)
    @ExcelProperty("是否异常")
    private String isException;

    @ColumnWidth(value = 20)
    @ExcelProperty("异常触发条件")
    private String triggerCondition;
}
