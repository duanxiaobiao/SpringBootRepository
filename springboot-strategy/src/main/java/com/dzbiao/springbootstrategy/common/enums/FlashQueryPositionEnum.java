package com.dzbiao.springbootstrategy.common.enums;

import com.dzbiao.springbootstrategy.entity.XjSystemSearchParam;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

/**
 * @author: dzbiao
 * @CreateTime: 2023/02/24 23:10
 * @Description:闪电贷场景的查询位置类型枚举
 */
@Getter
public enum FlashQueryPositionEnum {

    /**
     * 闪电贷企业
     */
    FLASH_LOAN_ENTP(1, "闪电贷企业") {
        @Override
        public QueryBuilder buildSearchQueryBuilder(XjSystemSearchParam param) {
            System.out.println("闪电贷场景-闪电贷企业：" + param.getQueryPositionOrUseSceneType());
            BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
            List<String> entpTypes = param.getEntpTypes();
            if (!CollectionUtils.isEmpty(entpTypes) && !entpTypes.contains(0)){
                // TODO: 企业闪电贷类型code需要转换一下.demo模式省略.
                boolQueryBuilder.filter(QueryBuilders.termsQuery("entp_type", entpTypes));
            }
            if (StringUtils.isNotBlank(param.getKeyWord())){
                boolQueryBuilder.filter(QueryBuilders.wildcardQuery("entp_name", "*" + param.getKeyWord() + "*"));
            }
            return boolQueryBuilder;
        }

        @Override
        public Integer getSearchIndexType(XjSystemSearchParam param) {
            return IndexEnum.FLASH_LOAN_ENTP.getCode();
        }
    },

    /**
     * 高端楼盘
     */
    HIGH_END_HOUSE(2, "高端楼盘"){
        @Override
        public QueryBuilder buildSearchQueryBuilder(XjSystemSearchParam param) {
            System.out.println("闪电贷场景-高端楼盘：" + param.getQueryPositionOrUseSceneType());
            return QueryBuilders.matchAllQuery();
        }

        @Override
        public Integer getSearchIndexType(XjSystemSearchParam param) {
            return IndexEnum.POI.getCode();
        }
    },

    /**
     * 高端公司
     */
    HIGH_END_COMPANY(3, "高端公司"){
        @Override
        public QueryBuilder buildSearchQueryBuilder(XjSystemSearchParam param) {
            System.out.println("闪电贷场景-高端公司：" + param.getQueryPositionOrUseSceneType());
            return QueryBuilders.matchAllQuery();
        }

        @Override
        public Integer getSearchIndexType(XjSystemSearchParam param) {
            return IndexEnum.POI.getCode();
        }
    },
    /**
     * 网点
     */
    NETWORK(4, "网点"){
        @Override
        public QueryBuilder buildSearchQueryBuilder(XjSystemSearchParam param) {
            System.out.println("闪电贷场景-网点：" + param.getQueryPositionOrUseSceneType());
            return QueryBuilders.matchAllQuery();
        }

        @Override
        public Integer getSearchIndexType(XjSystemSearchParam param) {
            return IndexEnum.POI.getCode();
        }
    },
    /**
     * 商圈
     */
    MALL(5, "商圈"){
        @Override
        public QueryBuilder buildSearchQueryBuilder(XjSystemSearchParam param) {
            System.out.println("闪电贷场景-商圈：" + param.getQueryPositionOrUseSceneType());
            return QueryBuilders.matchAllQuery();
        }

        @Override
        public Integer getSearchIndexType(XjSystemSearchParam param) {
            return IndexEnum.MALL.getCode();
        }
    },
    /**
     * 其他类型
     */
    OTHER_TYPE(6, "其他类型"){
        @Override
        public QueryBuilder buildSearchQueryBuilder(XjSystemSearchParam param) {
            System.out.println("闪电贷场景-其他类型：" + param.getQueryPositionOrUseSceneType());
            return QueryBuilders.matchAllQuery();
        }

        @Override
        public Integer getSearchIndexType(XjSystemSearchParam param) {
            return IndexEnum.POI.getCode();
        }
    };


    private Integer code;
    private String name;

    FlashQueryPositionEnum(Integer code, String name){
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


    public static Optional<FlashQueryPositionEnum> byCode(Integer code){
        for (FlashQueryPositionEnum enumItem : FlashQueryPositionEnum.values()) {
            if (enumItem.getCode().equals(code)) {
                return Optional.of(enumItem);
            }
        }
        return Optional.empty();
    }

    public abstract QueryBuilder buildSearchQueryBuilder(XjSystemSearchParam param);

    public abstract Integer getSearchIndexType(XjSystemSearchParam param);
}
