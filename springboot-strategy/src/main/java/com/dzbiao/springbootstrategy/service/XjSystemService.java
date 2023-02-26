package com.dzbiao.springbootstrategy.service;

import com.dzbiao.springbootstrategy.entity.XjSystemSearchParam;

/**
 * @author: dzbiao
 * @CreateTime: 2023/02/24 23:36
 * @Description:
 */
public interface XjSystemService {

    /**
     * 搜素
     * @param param
     * @return
     */
    String search(XjSystemSearchParam param);
}
