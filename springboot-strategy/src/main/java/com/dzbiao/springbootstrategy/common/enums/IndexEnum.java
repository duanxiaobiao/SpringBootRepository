package com.dzbiao.springbootstrategy.common.enums;

import lombok.Getter;

import java.util.Optional;

/**
 * @author: dzbiao
 * @CreateTime: 2023/02/25 18:56
 * @Description:
 */
@Getter
public enum IndexEnum {

    /**
     * 大宽表
     */
    WISEMAP_CUST_INF_FLEX(1, "大宽表"),

    /**
     * 闪电贷企业
     */
    FLASH_LOAN_ENTP(2, "闪电贷企业"),

    /**
     * 商户表
     */
    MCH(3, "商户表"),

    /**
     * 商圈
     */
    MALL(4, "商圈"),

    /**
     * POI
     */
    POI(5, "POI");

    private Integer code ;

    private String name;

    IndexEnum(Integer code, String name){
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Optional<IndexEnum> byCode(Integer code){
        for (IndexEnum enumItem : values()) {
            if (enumItem.getCode().equals(code)) {
                return Optional.of(enumItem);
            }
        }
        return Optional.empty();
    }
}
