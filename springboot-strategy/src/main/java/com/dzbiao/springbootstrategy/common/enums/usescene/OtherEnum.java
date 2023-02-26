package com.dzbiao.springbootstrategy.common.enums.usescene;

import com.dzbiao.springbootstrategy.entity.XjSystemSearchParam;
import lombok.Getter;
import org.elasticsearch.index.query.QueryBuilder;

import java.util.Optional;

/**
 * @author: dzbiao
 * @CreateTime: 2023/02/25 11:48
 * @Description:
 */
@Getter
public enum OtherEnum {

    /**
     * 办学层次
     */
    SCHOOL_LEVEL(1, "POI类型和等级"){
        @Override
        public QueryBuilder buildSearchQueryBuilder(XjSystemSearchParam param) {
            System.out.println("APP场景-其他-使用场景-POI类型和等级：" + param.getQueryTargetType());
            return null;
        }

        @Override
        public Integer getSearchIndexType(XjSystemSearchParam param) {
            return null;
        }
    },

    /**
     * 学校名称
     */
    SCHOOL_NAME(2, "POI名称"){
        @Override
        public QueryBuilder buildSearchQueryBuilder(XjSystemSearchParam param) {
            System.out.println("APP场景-其他-使用场景-POI名称：" + param.getQueryTargetType());
            return null;
        }

        @Override
        public Integer getSearchIndexType(XjSystemSearchParam param) {
            return null;
        }
    };


    private Integer code;
    private String name;


    OtherEnum(Integer code, String name){
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

    public static Optional<OtherEnum> byCode(Integer code){
        for (OtherEnum enumItem : values()) {
            if (enumItem.getCode().equals(code)) {
                return Optional.of(enumItem);
            }
        }
        return Optional.empty();
    }


    public abstract QueryBuilder buildSearchQueryBuilder(XjSystemSearchParam param);

    public abstract Integer getSearchIndexType(XjSystemSearchParam param);
}
