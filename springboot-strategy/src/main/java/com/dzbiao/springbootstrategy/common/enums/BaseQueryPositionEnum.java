package com.dzbiao.springbootstrategy.common.enums;

import com.dzbiao.springbootstrategy.entity.XjSystemSearchParam;
import lombok.Getter;
import org.elasticsearch.index.query.QueryBuilder;

import java.util.Optional;

/**
 * @author: dzbiao
 * @CreateTime: 2023/02/24 23:10
 * @Description:基础客群场景的查询位置类型枚举
 */
@Getter
public enum BaseQueryPositionEnum {

    /**
     * 网点
     */
    NTWORK(1, "网点") {
        @Override
        public QueryBuilder buildSearchQueryBuilder(XjSystemSearchParam param) {
            System.out.println("基础客群场景-网点：" + param.getQueryPositionOrUseSceneType());
            return null;
        }

        @Override
        public Integer getSearchIndexType(XjSystemSearchParam param) {
            return IndexEnum.POI.getCode();
        }
    },

    /**
     * 小区
     */
    COMMUNITY(2, "小区"){
        @Override
        public QueryBuilder buildSearchQueryBuilder(XjSystemSearchParam param) {
            System.out.println("基础客群场景-小区：" + param.getQueryPositionOrUseSceneType());
            return null;
        }

        @Override
        public Integer getSearchIndexType(XjSystemSearchParam param) {
            return IndexEnum.POI.getCode();
        }
    },

    /**
     * 其他类型
     */
    OTHER_TYPE(3, "其他类型"){
        @Override
        public QueryBuilder buildSearchQueryBuilder(XjSystemSearchParam param) {
            System.out.println("基础客群场景-其他类型：" + param.getQueryPositionOrUseSceneType());
            return null;
        }

        @Override
        public Integer getSearchIndexType(XjSystemSearchParam param) {
            return IndexEnum.POI.getCode();
        }
    };


    private Integer code;
    private String name;

    BaseQueryPositionEnum(Integer code, String name){
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


    public static Optional<BaseQueryPositionEnum> byCode(Integer code){
        for (BaseQueryPositionEnum enumItem : BaseQueryPositionEnum.values()) {
            if (enumItem.getCode().equals(code)) {
                return Optional.of(enumItem);
            }
        }
        return Optional.empty();
    }

    public abstract QueryBuilder buildSearchQueryBuilder(XjSystemSearchParam param);

    public abstract Integer getSearchIndexType(XjSystemSearchParam param);
}
