package com.dzbiao.springbootstrategy.common.enums.usescene;

import com.dzbiao.springbootstrategy.common.enums.IndexEnum;
import com.dzbiao.springbootstrategy.entity.XjSystemSearchParam;
import lombok.Getter;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

import java.util.Optional;

/**
 * @author: dzbiao
 * @CreateTime: 2023/02/25 11:40
 * @Description: 使用场景下 促MAU 类型下的枚举类型
 */
@Getter
public enum CMAUEnum {

    /**
     * 商户周边
     */
    MCH(1, "商户周边"){
        @Override
        public QueryBuilder buildSearchQueryBuilder(XjSystemSearchParam param) {
            System.out.println("APP场景-促MAU-使用场景-商户周边：" + param.getQueryTargetType());
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
    MALL(2, "商圈周边"){
        @Override
        public QueryBuilder buildSearchQueryBuilder(XjSystemSearchParam param) {
            System.out.println("APP场景-促MAU-使用场景-商圈周边：" + param.getQueryTargetType());
            return QueryBuilders.matchAllQuery();
        }

        @Override
        public Integer getSearchIndexType(XjSystemSearchParam param) {
            return IndexEnum.MALL.getCode();
        }
    };


    private Integer code;
    private String name;


    CMAUEnum(Integer code, String name){
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

    public static Optional<CMAUEnum> byCode(Integer code){
        for (CMAUEnum enumItem : values()) {
            if (enumItem.getCode().equals(code)) {
                return Optional.of(enumItem);
            }
        }
        return Optional.empty();
    }


    public abstract QueryBuilder buildSearchQueryBuilder(XjSystemSearchParam param);

    public abstract Integer getSearchIndexType(XjSystemSearchParam param);
}
