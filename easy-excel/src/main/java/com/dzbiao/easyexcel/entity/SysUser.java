package com.dzbiao.easyexcel.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Author: DZBiao
 * @Date : 2022/2/10
 * @Description : 描述：
 **/

public class SysUser implements Serializable {

    @ColumnWidth(value = 28)
    @ExcelProperty("商品编号")
    private Integer id;

    @ColumnWidth(value = 20)
    @ExcelProperty("商品名称")
    private String goodName;

    @ColumnWidth(value = 20)
    @ExcelProperty("商品价格")
    private double goodPrice;

    @ColumnWidth(value = 20)
    @ExcelProperty("商品购买数量")
    private Integer buyNum;

    @ColumnWidth(value = 20)
    @ExcelProperty("商品库存")
    private Integer goodNum;

    @ColumnWidth(value = 20)
    @ExcelProperty("商品URL")
    private String goodUrl;

    public Integer getId() {
        return id;
    }

    public SysUser setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getGoodName() {
        return goodName;
    }

    public SysUser setGoodName(String goodName) {
        this.goodName = goodName;
        return this;
    }

    public double getGoodPrice() {
        return goodPrice;
    }

    public SysUser setGoodPrice(double goodPrice) {
        this.goodPrice = goodPrice;
        return this;
    }

    public Integer getBuyNum() {
        return buyNum;
    }

    public SysUser setBuyNum(Integer buyNum) {
        this.buyNum = buyNum;
        return this;
    }

    public Integer getGoodNum() {
        return goodNum;
    }

    public SysUser setGoodNum(Integer goodNum) {
        this.goodNum = goodNum;
        return this;
    }

    public String getGoodUrl() {
        return goodUrl;
    }

    public SysUser setGoodUrl(String goodUrl) {
        this.goodUrl = goodUrl;
        return this;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                "id=" + id +
                ", goodName='" + goodName + '\'' +
                ", goodPrice=" + goodPrice +
                ", buyNum=" + buyNum +
                ", goodNum=" + goodNum +
                ", goodUrl='" + goodUrl + '\'' +
                '}';
    }
}
