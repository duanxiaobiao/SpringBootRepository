package com.dzbiao.springbootstrategy.common.enums;

import com.dzbiao.springbootstrategy.entity.XjSystemSearchParam;
import lombok.Getter;
import org.elasticsearch.index.query.QueryBuilder;

import javax.swing.text.html.Option;
import java.util.Optional;

/**
 * @Author: dzbiao
 * @CreateTime: 2023/02/24 22:55
 * @Description:
 */
@Getter
public enum SceneEnum {

    /**
     * 闪电贷场景
     */
    FLASH_LOAN(1, "闪电贷场景"){
        @Override
        public QueryBuilder buildSearchQueryBuilder(XjSystemSearchParam param) {
            System.out.println("闪电贷场景：" + param.getSceneType());
            FlashQueryPositionEnum enumItem = FlashQueryPositionEnum.byCode(param.getQueryPositionOrUseSceneType()).get();
            return enumItem.buildSearchQueryBuilder(param);
        }

        @Override
        public Integer getSearchIndexType(XjSystemSearchParam param) {
            System.out.println("闪电贷场景：" + param.getSceneType());
            FlashQueryPositionEnum enumItem = FlashQueryPositionEnum.byCode(param.getQueryPositionOrUseSceneType()).get();
            return enumItem.getSearchIndexType(param);
        }
    },

    /**
     * APP场景
     */
    APP(2, "APP场景"){
        @Override
        public QueryBuilder buildSearchQueryBuilder(XjSystemSearchParam param) {
            System.out.println("APP场景：" + param.getSceneType());
            UseSceneEnum enumItem = UseSceneEnum.byCode(param.getQueryPositionOrUseSceneType()).get();
            return enumItem.buildSearchQueryBuilder(param);
        }

        @Override
        public Integer getSearchIndexType(XjSystemSearchParam param) {
            System.out.println("APP场景：" + param.getSceneType());
            UseSceneEnum enumItem = UseSceneEnum.byCode(param.getQueryPositionOrUseSceneType()).get();
            return enumItem.getSearchIndexType(param);
        }
    },

    /**
     * 基础客群
     */
    BASE_CUSTGRP(3, "基础客群"){

        @Override
        public QueryBuilder buildSearchQueryBuilder(XjSystemSearchParam param) {
            System.out.println("基础客群：" + param.getSceneType());
            BaseQueryPositionEnum enumItem = BaseQueryPositionEnum.byCode(param.getQueryPositionOrUseSceneType()).get();
            return enumItem.buildSearchQueryBuilder(param);
        }

        @Override
        public Integer getSearchIndexType(XjSystemSearchParam param) {
            System.out.println("基础客群：" + param.getSceneType());
            BaseQueryPositionEnum enumItem = BaseQueryPositionEnum.byCode(param.getQueryPositionOrUseSceneType()).get();
            return enumItem.getSearchIndexType(param);
        }
    };

    private Integer code;

    private String name;

    SceneEnum(Integer code, String name){
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


    public static Optional<SceneEnum> byCode(Integer code){
        for (SceneEnum sceneEnum : SceneEnum.values()) {
            if (sceneEnum.getCode().equals(code)) {
                return Optional.of(sceneEnum);
            }
        }
        return Optional.empty();
    }


    public abstract QueryBuilder buildSearchQueryBuilder(XjSystemSearchParam param);

    public abstract Integer getSearchIndexType(XjSystemSearchParam param);
}
