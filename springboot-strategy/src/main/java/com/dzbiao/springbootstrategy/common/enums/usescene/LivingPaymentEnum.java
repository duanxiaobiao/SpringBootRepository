package com.dzbiao.springbootstrategy.common.enums.usescene;

import com.dzbiao.springbootstrategy.entity.XjSystemSearchParam;
import org.elasticsearch.index.query.QueryBuilder;

import java.util.Optional;

/**
 * @author: dzbiao
 * @CreateTime: 2023/02/25 11:56
 * @Description:使用场景下的 生活缴费 类型
 */
public enum LivingPaymentEnum {


    /**
     * 网点
     */
    NTWORK(1, "网点"){
        @Override
        public QueryBuilder buildSearchQueryBuilder(XjSystemSearchParam param) {
            System.out.println("APP场景-生活缴费-使用场景-网点：" + param.getQueryTargetType());
            return null;
        }

        @Override
        public Integer getSearchIndexType(XjSystemSearchParam param) {
            return null;
        }
    },

    /**
     * 小区
     */
    COMMUNITY(2, "小区"){
        @Override
        public QueryBuilder buildSearchQueryBuilder(XjSystemSearchParam param) {
            System.out.println("APP场景-生活缴费-使用场景-小区：" + param.getQueryTargetType());
            return null;
        }

        @Override
        public Integer getSearchIndexType(XjSystemSearchParam param) {
            return null;
        }
    },

    /**
     * 不限
     */
    NO_LIMIT(3, "其他"){
        @Override
        public QueryBuilder buildSearchQueryBuilder(XjSystemSearchParam param) {
            System.out.println("APP场景-生活缴费-使用场景-其他：" + param.getQueryTargetType());
            return null;
        }

        @Override
        public Integer getSearchIndexType(XjSystemSearchParam param) {
            return null;
        }
    };


    private Integer code;
    private String name;


    LivingPaymentEnum(Integer code, String name){
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

    public static Optional<LivingPaymentEnum> byCode(Integer code){
        for (LivingPaymentEnum enumItem : values()) {
            if (enumItem.getCode().equals(code)) {
                return Optional.of(enumItem);
            }
        }
        return Optional.empty();
    }


    public abstract QueryBuilder buildSearchQueryBuilder(XjSystemSearchParam param);

    public abstract Integer getSearchIndexType(XjSystemSearchParam param);
}
