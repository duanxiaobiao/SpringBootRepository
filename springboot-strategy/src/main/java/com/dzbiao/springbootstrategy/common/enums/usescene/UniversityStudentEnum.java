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
public enum UniversityStudentEnum {

    /**
     * 办学层次
     */
    SCHOOL_LEVEL(1, "办学层次"){
        @Override
        public QueryBuilder buildSearchQueryBuilder(XjSystemSearchParam param) {
            System.out.println("APP场景-大学生-使用场景-办学层次：" + param.getQueryTargetType());
            return QueryBuilders.matchAllQuery();
        }

        @Override
        public Integer getSearchIndexType(XjSystemSearchParam param) {
            return IndexEnum.POI.getCode();
        }
    },

    /**
     * 学校名称
     */
    SCHOOL_NAME(2, "学校名称"){
        @Override
        public QueryBuilder buildSearchQueryBuilder(XjSystemSearchParam param) {
            System.out.println("APP场景-大学生-使用场景-学校名称：" + param.getQueryTargetType());
            return QueryBuilders.matchAllQuery();
        }

        @Override
        public Integer getSearchIndexType(XjSystemSearchParam param) {
            return IndexEnum.POI.getCode();
        }
    };


    private Integer code;
    private String name;


    UniversityStudentEnum(Integer code, String name){
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

    public static Optional<UniversityStudentEnum> byCode(Integer code){
        for (UniversityStudentEnum enumItem : values()) {
            if (enumItem.getCode().equals(code)) {
                return Optional.of(enumItem);
            }
        }
        return Optional.empty();
    }


    public abstract QueryBuilder buildSearchQueryBuilder(XjSystemSearchParam param);

    public abstract Integer getSearchIndexType(XjSystemSearchParam param);
}
