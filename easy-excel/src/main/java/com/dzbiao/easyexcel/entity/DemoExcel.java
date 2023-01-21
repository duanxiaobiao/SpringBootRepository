package com.dzbiao.easyexcel.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.Data;

import java.util.Date;

/**
 * @Author: DZBiao
 * @Date : 2022/2/13
 * @Description : 描述：
 **/


public class DemoExcel {

    @ExcelProperty(value = {"数字"}, index = 0)
    @ColumnWidth(20)
    private Double dData;

    @ExcelProperty(value = {"字符"}, index = 1)
    @ColumnWidth(20)
    private String string;

    /**
     * 自定义的时间格式
     */
    @DateTimeFormat("yyyy年MM月dd日 HH:mm:ss")
    @ExcelProperty(value = {"时间"}, index = 2)
    @ColumnWidth(30)
    private Date date;

    public Double getdData() {
        return dData;
    }

    public DemoExcel setdData(Double dData) {
        this.dData = dData;
        return this;
    }

    public String getString() {
        return string;
    }

    public DemoExcel setString(String string) {
        this.string = string;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public DemoExcel setDate(Date date) {
        this.date = date;
        return this;
    }

    @Override
    public String toString() {
        return "DemoExcel{" +
                "dData=" + dData +
                ", string='" + string + '\'' +
                ", date=" + date +
                '}';
    }
}
