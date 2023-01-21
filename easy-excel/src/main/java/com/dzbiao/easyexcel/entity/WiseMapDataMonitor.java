package com.dzbiao.easyexcel.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.dzbiao.easyexcel.annotation.ExcelRemark;
import lombok.Data;

/**
 * @Author: dzbiao
 * @CreateTime: 2023/01/19 23:51
 * @Description:
 */
@Data
public class WiseMapDataMonitor {

    @ColumnWidth(value = 15)
    @ExcelProperty("类型")
    private String typeName;

    @ColumnWidth(value = 25)
    @ExcelProperty(value = "表名")
    private String name;

    @ColumnWidth(value = 15)
    @ExcelRemark(value = "编号只能从下拉框中选择\n否则无法通过校验")
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
    @ExcelRemark(value = "计算公式:\n客户总量/GPS客户总量")
    @ExcelProperty("覆盖率1")
    private String gpsCoverageRate;

    @ColumnWidth(value = 15)
    @ExcelRemark(value = "计算公式:\n客户总量/MAU客户总量")
    @ExcelProperty("覆盖率2")
    private String mauCoverageRate;

    @ColumnWidth(value = 15)
    @ExcelProperty("是否异常")
    private String isException;

    @ColumnWidth(value = 20)
    @ExcelProperty("异常触发条件")
    private String triggerCondition;

}


