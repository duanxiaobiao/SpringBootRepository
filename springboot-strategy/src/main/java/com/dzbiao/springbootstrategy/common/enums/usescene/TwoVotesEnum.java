package com.dzbiao.springbootstrategy.common.enums.usescene;

import com.dzbiao.springbootstrategy.common.enums.IndexEnum;
import com.dzbiao.springbootstrategy.entity.XjSystemSearchParam;
import lombok.Getter;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

import java.util.Optional;

/**
 * @author: dzbiao
 * @CreateTime: 2023/02/25 11:48
 * @Description:
 */
@Getter
public enum TwoVotesEnum {

    /**
     * 饭店餐馆
     */
    RESTAURANT(1, "饭店餐馆"){
        @Override
        public QueryBuilder buildSearchQueryBuilder(XjSystemSearchParam param) {
            System.out.println("APP场景-两票-使用场景-饭店餐馆：" + param.getQueryTargetType());
            return QueryBuilders.matchAllQuery();
        }

        @Override
        public Integer getSearchIndexType(XjSystemSearchParam param) {
            return IndexEnum.POI.getCode();
        }
    },

    /**
     * 电影院
     */
    CINEMA(2, "电影院"){
        @Override
        public QueryBuilder buildSearchQueryBuilder(XjSystemSearchParam param) {
            System.out.println("APP场景-两票-使用场景-电影院：" + param.getQueryTargetType());
            return QueryBuilders.matchAllQuery();
        }

        @Override
        public Integer getSearchIndexType(XjSystemSearchParam param) {
            return IndexEnum.MCH.getCode();
        }
    },

    /**
     * 商圈周边
     */
    MALL(3, "商圈周边"){
        @Override
        public QueryBuilder buildSearchQueryBuilder(XjSystemSearchParam param) {
            System.out.println("APP场景-两票-使用场景-电影院：" + param.getQueryTargetType());
            return QueryBuilders.matchAllQuery();
        }

        @Override
        public Integer getSearchIndexType(XjSystemSearchParam param) {
            return IndexEnum.MALL.getCode();
        }
    };;


    private Integer code;
    private String name;


    TwoVotesEnum(Integer code, String name){
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

    public static Optional<TwoVotesEnum> byCode(Integer code){
        for (TwoVotesEnum enumItem : values()) {
            if (enumItem.getCode().equals(code)) {
                return Optional.of(enumItem);
            }
        }
        return Optional.empty();
    }


    public abstract QueryBuilder buildSearchQueryBuilder(XjSystemSearchParam param);

    public abstract Integer getSearchIndexType(XjSystemSearchParam param);
}
