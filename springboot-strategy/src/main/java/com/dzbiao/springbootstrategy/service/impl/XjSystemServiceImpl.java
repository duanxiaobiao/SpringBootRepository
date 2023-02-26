package com.dzbiao.springbootstrategy.service.impl;

import com.alibaba.fastjson.JSON;
import com.dzbiao.springbootstrategy.common.constant.Constant;
import com.dzbiao.springbootstrategy.common.enums.SceneEnum;
import com.dzbiao.springbootstrategy.entity.XjSystemSearchParam;
import com.dzbiao.springbootstrategy.service.XjSystemService;
import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.stereotype.Service;

/**
 * @author: dzbiao
 * @CreateTime: 2023/02/24 23:36
 * @Description:
 */
@Service
public class XjSystemServiceImpl implements XjSystemService {

    /**
     * 搜索
     * @param param
     * @return
     */
    @Override
    public String search(XjSystemSearchParam param) {
        SceneEnum sceneEnum = SceneEnum.byCode(param.getSceneType()).get();
        QueryBuilder queryBuilder = sceneEnum.buildSearchQueryBuilder(param);
        Integer indexCode = sceneEnum.getSearchIndexType(param);
        String indexName = Constant.INDEX_MAP.get(indexCode);
        // 真实情况下，还需要去数据库查一下.
        System.out.println(JSON.toJSONString(queryBuilder));
        System.out.println("索引名称：" + indexName);
        return "OK";
    }
}
