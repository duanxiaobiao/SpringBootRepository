package com.dzbiao.springbootstrategy.common.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: dzbiao
 * @CreateTime: 2023/02/26 09:41
 * @Description:
 */
public class Constant {

    public static final Map<Integer, String> INDEX_MAP = new HashMap();

    static {
        INDEX_MAP.put(1, "wisemap_cust_inf_flex");
        INDEX_MAP.put(2, "enterprise_inf_flex");
        INDEX_MAP.put(3, "mch_inf_flex");
        INDEX_MAP.put(4, "mall_dristrict_inf");
        INDEX_MAP.put(5, "poi_base_inf");
    }

}
