package com.dzbiao.springbootstrategy.common.enums.usescene;

import com.dzbiao.springbootstrategy.entity.XjSystemSearchParam;
import org.elasticsearch.index.query.QueryBuilder;

import java.util.Optional;

/**
 * @author: dzbiao
 * @CreateTime: 2023/02/25 11:56
 * @Description:使用场景下的 出行 类型
 */
public enum TripEnum {


    /**
     * 公交
     */
    BUS(1, "公交"){
        @Override
        public QueryBuilder buildSearchQueryBuilder(XjSystemSearchParam param) {
            System.out.println("APP场景-出行-使用场景-公交：" + param.getQueryTargetType());
            return null;
        }

        @Override
        public Integer getSearchIndexType(XjSystemSearchParam param) {
            return null;
        }
    },

    /**
     * 地铁
     */
    sUBWAY(2, "地铁"){
        @Override
        public QueryBuilder buildSearchQueryBuilder(XjSystemSearchParam param) {
            System.out.println("APP场景-出行-使用场景-地铁：" + param.getQueryTargetType());
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
    NO_LIMIT(3, "不限"){
        @Override
        public QueryBuilder buildSearchQueryBuilder(XjSystemSearchParam param) {
            System.out.println("APP场景-出行-使用场景-不限：" + param.getQueryTargetType());
            return null;
        }

        @Override
        public Integer getSearchIndexType(XjSystemSearchParam param) {
            return null;
        }
    };


    private Integer code;
    private String name;


    TripEnum(Integer code, String name){
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

    public static Optional<TripEnum> byCode(Integer code){
        for (TripEnum enumItem : values()) {
            if (enumItem.getCode().equals(code)) {
                return Optional.of(enumItem);
            }
        }
        return Optional.empty();
    }


    public abstract QueryBuilder buildSearchQueryBuilder(XjSystemSearchParam param);

    public abstract Integer getSearchIndexType(XjSystemSearchParam param);
}
