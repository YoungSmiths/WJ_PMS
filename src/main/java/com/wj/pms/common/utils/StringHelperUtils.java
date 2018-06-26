package com.wj.pms.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class StringHelperUtils {

    private static Logger LOGGER = LoggerFactory.getLogger(StringHelperUtils.class);
    private static ObjectMapper mapper = new ObjectMapper();

    public static Map<String, String> parseStringForm(String form) {
        if (!form.contains("=")) {
//            LOGGER.warn("this string: {} is not form data", form);
            return null;
        }

        Map<String, String> map = new HashMap<>();

        if (form.contains("&")) {
            String[] s1 = form.split("&");
            for (String tmp : s1) {
                String[] s2 = tmp.split("=");
                if (s2.length == 2) {
                    map.put(s2[0], s2[1]);
                }
            }
        } else {
            String[] s2 = form.split("=");
            map.put(s2[0], s2[1]);
        }
        return map;
    }

    public static Map<String, String> parseStringJson(String json) {
        return JSON.parseObject(json, new TypeReference<Map<String, String>>() {
        });
    }

    public static JsonNode parseStringForm2JsonNode(String form) throws IOException {
        Map<String, String> map = parseStringForm(form);
        return mapper.readTree(mapper.writeValueAsString(map));
    }
}
