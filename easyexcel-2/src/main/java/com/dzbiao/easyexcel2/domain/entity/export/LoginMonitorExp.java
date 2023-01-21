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
public class LoginMonitorExp {

    @ColumnWidth(value = 15)
    @ExcelProperty("类型")
    private String typeName;

    @ColumnWidth(value = 25)
    @ExcelProperty(value = "表名")
    private String name;

    @ColumnWidth(value = 15)
    @ExcelProperty(value = "日期")
    private String indexDate;

    @ColumnWidth(value = 15)
    @ExcelProperty("数据量(万)")
    private String dataTotal;

    @ColumnWidth(value = 15)
    @ExcelProperty("数据量环比")
    private String dataTotalRate;


    @ColumnWidth(value = 10)
    @ExcelProperty("数据量近1天")
    private String dataRecent1Day;

    @ColumnWidth(value = 10)
    @ExcelProperty("数据量近7天")
    private String dataRecent7Day;

    @ColumnWidth(value = 10)
    @ExcelProperty("数据量近30天")
    private String dataRecent30Day;

    @ColumnWidth(value = 10)
    @ExcelProperty("数据量近90天")
    private String dataRecent90Day;

    @ColumnWidth(value = 10)
    @ExcelProperty("数据量近180天")
    private String dataRecent180Day;


    @ColumnWidth(value = 15)
    @ExcelProperty("用户量(万)")
    private String userTotal;

    @ColumnWidth(value = 15)
    @ExcelProperty("用户量环比")
    private String userTotalRate;

    @ColumnWidth(value = 10)
    @ExcelProperty("用户量近1天")
    private String userRecent1Day;

    @ColumnWidth(value = 10)
    @ExcelProperty("用户量近7天")
    private String userRecent7Day;

    @ColumnWidth(value = 10)
    @ExcelProperty("用户量近30天")
    private String userRecent30Day;

    @ColumnWidth(value = 10)
    @ExcelProperty("用户量近90天")
    private String userRecent90Day;

    @ColumnWidth(value = 10)
    @ExcelProperty("用户量近180天")
    private String userRecent180Day;

    @ColumnWidth(value = 15)
    @ExcelProperty("覆盖率1")
    private String gpsCoverageRate;

    @ColumnWidth(value = 15)
    @ExcelProperty("覆盖率2")
    private String mauCoverageRate;

    @ColumnWidth(value = 15)
    @ExcelProperty("是否异常")
    private String isException;

    @ColumnWidth(value = 20)
    @ExcelProperty("异常触发条件")
    private String triggerCondition;

}
