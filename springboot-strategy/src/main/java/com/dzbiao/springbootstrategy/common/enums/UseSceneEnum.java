package com.dzbiao.springbootstrategy.common.enums;

import com.dzbiao.springbootstrategy.common.enums.usescene.*;
import com.dzbiao.springbootstrategy.entity.XjSystemSearchParam;
import lombok.Getter;
import org.elasticsearch.index.query.QueryBuilder;

import java.util.Optional;

/**
 * @author: dzbiao
 * @CreateTime: 2023/02/24 23:21
 * @Description:
 */
@Getter
public enum UseSceneEnum {

    /**
     * 促MAU
     */
    C_MAU(1, "促MAU"){
        @Override
        public QueryBuilder buildSearchQueryBuilder(XjSystemSearchParam param) {
            System.out.println("APP场景-促MAU使用场景:" + param.getQueryPositionOrUseSceneType());
            CMAUEnum enumItem = CMAUEnum.byCode(param.getQueryTargetType()).get();
            return enumItem.buildSearchQueryBuilder(param);
        }

        @Override
        public Integer getSearchIndexType(XjSystemSearchParam param) {
            System.out.println("APP场景-促MAU使用场景:" + param.getQueryPositionOrUseSceneType());
            CMAUEnum enumItem = CMAUEnum.byCode(param.getQueryTargetType()).get();
            return enumItem.getSearchIndexType(param);
        }
    },

    /**
     * 大学生
     */
    UNIVERSITY_STUDENT(2, "大学生"){
        @Override
        public QueryBuilder buildSearchQueryBuilder(XjSystemSearchParam param) {
            System.out.println("APP场景-大学生-使用场景:" + param.getQueryPositionOrUseSceneType());
            UniversityStudentEnum enumItem = UniversityStudentEnum.byCode(param.getQueryTargetType()).get();
            return enumItem.buildSearchQueryBuilder(param);
        }

        @Override
        public Integer getSearchIndexType(XjSystemSearchParam param) {
            System.out.println("APP场景-大学生-使用场景:" + param.getQueryPositionOrUseSceneType());
            UniversityStudentEnum enumItem = UniversityStudentEnum.byCode(param.getQueryTargetType()).get();
            return enumItem.getSearchIndexType(param);
        }
    },

    /**
     * 两票
     */
    TWO_VOTES(3, "两票"){
        @Override
        public QueryBuilder buildSearchQueryBuilder(XjSystemSearchParam param) {
            System.out.println("APP场景-两票-使用场景:" + param.getQueryPositionOrUseSceneType());
            TwoVotesEnum enumItem = TwoVotesEnum.byCode(param.getQueryTargetType()).get();
            return enumItem.buildSearchQueryBuilder(param);
        }

        @Override
        public Integer getSearchIndexType(XjSystemSearchParam param) {
            System.out.println("APP场景-两票-使用场景:" + param.getQueryPositionOrUseSceneType());
            TwoVotesEnum enumItem = TwoVotesEnum.byCode(param.getQueryTargetType()).get();
            return enumItem.getSearchIndexType(param);
        }
    },
    /**
     * 出行
     */
    TRIP(4, "出行"){
        @Override
        public QueryBuilder buildSearchQueryBuilder(XjSystemSearchParam param) {
            System.out.println("APP场景-出行-使用场景:" + param.getQueryPositionOrUseSceneType());
            TripEnum enumItem = TripEnum.byCode(param.getQueryTargetType()).get();
            return enumItem.buildSearchQueryBuilder(param);
        }

        @Override
        public Integer getSearchIndexType(XjSystemSearchParam param) {
            System.out.println("APP场景-出行-使用场景:" + param.getQueryPositionOrUseSceneType());
            TripEnum enumItem = TripEnum.byCode(param.getQueryTargetType()).get();
            return enumItem.getSearchIndexType(param);
        }
    },
    /**
     * 生活缴费
     */
    LIVING_PAYMENT(5, "生活缴费"){
        @Override
        public QueryBuilder buildSearchQueryBuilder(XjSystemSearchParam param) {
            System.out.println("APP场景-生活缴费-使用场景:" + param.getQueryPositionOrUseSceneType());
            LivingPaymentEnum enumItem = LivingPaymentEnum.byCode(param.getQueryTargetType()).get();
            return enumItem.buildSearchQueryBuilder(param);
        }

        @Override
        public Integer getSearchIndexType(XjSystemSearchParam param) {
            System.out.println("APP场景-生活缴费-使用场景:" + param.getQueryPositionOrUseSceneType());
            LivingPaymentEnum enumItem = LivingPaymentEnum.byCode(param.getQueryTargetType()).get();
            return enumItem.getSearchIndexType(param);
        }
    },
    /**
     * 其他
     */
    OTHER(6, "其他"){
        @Override
        public QueryBuilder buildSearchQueryBuilder(XjSystemSearchParam param) {
            System.out.println("APP场景-其他-使用场景:" + param.getQueryPositionOrUseSceneType());
            OtherEnum enumItem = OtherEnum.byCode(param.getQueryTargetType()).get();
            return enumItem.buildSearchQueryBuilder(param);
        }

        @Override
        public Integer getSearchIndexType(XjSystemSearchParam param) {
            System.out.println("APP场景-其他-使用场景:" + param.getQueryPositionOrUseSceneType());
            OtherEnum enumItem = OtherEnum.byCode(param.getQueryTargetType()).get();
            return enumItem.getSearchIndexType(param);
        }
    };


    private Integer code;
    private String name;

    UseSceneEnum(Integer code, String name){
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


    public static Optional<UseSceneEnum> byCode(Integer code){
        for (UseSceneEnum useSceneEnum : UseSceneEnum.values()) {
            if (useSceneEnum.getCode().equals(code)) {
                return Optional.of(useSceneEnum);
            }
        }
        return Optional.empty();
    }

    public abstract QueryBuilder buildSearchQueryBuilder(XjSystemSearchParam param);

    public abstract Integer getSearchIndexType(XjSystemSearchParam param);
}
