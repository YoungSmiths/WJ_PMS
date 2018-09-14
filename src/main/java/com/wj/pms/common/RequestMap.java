package com.wj.pms.common;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Describe:
 *
 * @author YoungSmith
 * 18-9-9 下午7:52
 */
public class RequestMap {
    private Map<String, Object> map = new HashMap<>();

    public RequestMap put(String key, Object value) {
        this.map.put(key, value);
        return this;
    }

    public Object get(String key) {
        return map.get(key);
    }

    public String toJson(){
        return JSONObject.toJSONString(map);
    }
}
