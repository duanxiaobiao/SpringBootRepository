package com.dzbiao.easyexcel2.common.enums;

import lombok.Getter;
import lombok.Setter;

/**
 * @Author: dzbiao
 * @CreateTime: 2023/01/20 18:25
 * @Description:
 */
@Getter
public enum TableEnum {

    LOGIN_PLACE(0, "登录地"),
    APP_GPS(1, "APP-GPS"),
    HOME_PLACE(2, "居住地"),
    WORK_PLACE(3, "工作地"),
    MCH(4, "商户"),
    MALL(5, "商圈"),
    FLASH_LOAN_ENTP(6, "闪电贷企业");


    private Integer code;
    private String name;

    TableEnum(Integer code, String name){
        this.code = code;
        this.name = name;
    }

    /**
     * 通过code 获取名称
     * @param code
     * @return
     */
    public static String byCode(Integer code){
        for (TableEnum value : values()) {
            if(value.getCode().equals(code)){
                return value.getName();
            }
        }
        return null;
    }
}
