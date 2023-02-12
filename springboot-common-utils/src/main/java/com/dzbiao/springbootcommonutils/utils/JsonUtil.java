package com.dzbiao.springbootcommonutils.utils;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;

import java.util.Collection;

/**
 * @Author: dzbiao
 * @CreateTime: 2023/02/12 15:25
 * @Description:
 */
public class JsonUtil {

    public static JSONArray arraySerialize(Collection<?> c){
        return JSONArray.parseArray(JSONObject.toJSONString(c));
    }


    public static JsonObjectBuilder builder(){
        return new JsonObjectBuilder();
    }


    public static class JsonObjectBuilder {

        private final JSONObject jsonObject;

        public JsonObjectBuilder(){
            this.jsonObject = new JSONObject();
        }

        public <V> JsonObjectBuilder put(String key, V value){
            this.jsonObject.put(key,value);
            return this;
        }

        public JSONObject build(){
            return jsonObject;
        }
    }

    public static void main(String[] args) {

        // 适用于不想new JSONObject()和一行行填充put的情况
        JSONObject jsonObject = JsonUtil.builder().put("name", "张三").put("age", 15).put("sex", "男").build();
        System.out.println(jsonObject);
    }
}
