package com.dzbiao.springbootstrategy.entity;

import lombok.Data;

import java.util.List;

/**
 * @Author: dzbiao
 * @CreateTime: 2023/02/24 23:05
 * @Description:
 */
@Data
public class XjSystemSearchParam {

    /**
     * 使用场景
     */
    private Integer sceneType;

    /**
     * 查询位置或者使用场景类型
     */
    private Integer queryPositionOrUseSceneType;

    /**
     * 查询目标类型
     */
    private Integer queryTargetType;

    private String keyWord;

    private List<String> entpTypes;
}
