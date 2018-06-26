package com.wj.pms.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.multipart.DefaultHttpDataFactory;
import io.netty.handler.codec.http.multipart.HttpPostRequestDecoder;
import io.netty.handler.codec.http.multipart.InterfaceHttpData;
import io.netty.handler.codec.http.multipart.MemoryAttribute;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by YoungSmith on 2018/7/17.
 */
public class HandleUserInfoUtils {
    private static Logger LOGGER = LoggerFactory.getLogger(HandleUserInfoUtils.class);

    public static final String[] cookieSessionIdKey = {"JSESSIONID", "JSESSIONIDMINI", "ComtopSessionSID", "DWRSESSIONID"};

    /**
     * @param request
     * @return
     */
//    public static String getSessionFromHttpRequest(HttpRequest request) {
//
//        String cookies = request.headers().get("Cookie");
//        if (StringUtils.isEmpty(cookies)) return null;
//
//        String[] cookieFlag = {"JSESSIONID", "JSESSIONIDMINI", "ComtopSessionSID", "DWRSESSIONID"};
//
//        Map<String, String> cookieMap = parseSessionCookie2Map(cookies);
//
//        for (String f : cookieFlag) {
//            String value = cookieMap.get(f);
//            if (!StringUtils.isEmpty(value)) {
//                if (!f.equals("JSESSIONID")) LOGGER.warn("cookie:{},sessiontype:{},sessionId:{}", cookies, f, value);
//                return value;
//            }
//        }
//
//        return null;
//    }
    private static Map<String, String> parseSessionCookie2Map(String cookies) {
        String[] cookieAry = cookies.split(";");
        Map<String, String> cookieMap = new HashMap<>();
        for (String cookie : cookieAry) {
            String[] kv = cookie.split("=");
            if (kv.length == 2) {
                cookieMap.put(kv[0].trim(), kv[1].trim());
            } else if (kv.length == 1) {
                cookieMap.put(kv[0].trim(), "");
            }
        }
        return cookieMap;
    }

    public static String getSessionFromSetCookie(List<String> cookies) {
        if (cookies == null || cookies.size() == 0) return null;

        for (String c : cookies) {
            String val = getSessionFromCookies(c, "JSESSIONID");
            if (!StringUtils.isEmpty(val)) {
                return val;
            }
        }
        return null;

    }


    public static String getSessionFromCookies(String cookies, String... sessionKey) {
        if (StringUtils.isEmpty(cookies)) return null;

        String[] cookieFlag = sessionKey;

        Map<String, String> cookieMap = parseSessionCookie2Map(cookies);

        for (String f : cookieFlag) {
            String value = cookieMap.get(f);
            if (!StringUtils.isEmpty(value)) {
                return value;
            }
        }

        return null;
    }

    public static String getSessionFromCookies(String cookies) {
        if (StringUtils.isEmpty(cookies)) return null;

        String[] cookieFlag = {"JSESSIONID", "JSESSIONIDMINI", "ComtopSessionSID", "DWRSESSIONID"};

        Map<String, String> cookieMap = parseSessionCookie2Map(cookies);

        for (String f : cookieFlag) {
            String value = cookieMap.get(f);
            if (!StringUtils.isEmpty(value)) {
                return value;
            }
        }

        return null;
    }

    public static Map<String, String> getAllSessionsFromCookies(List<String> cookies) {
        Map<String, String> map = new HashMap<>();
        for (String c : cookies) {
            map.putAll(getAllSessionsFromCookies(c));
        }

        return map;
    }

    public static Map<String, String> getAllSessionsFromCookies(String cookies, String... keys) {
        if (StringUtils.isEmpty(cookies)) return null;

        String[] cookieFlag = keys;
        Map<String, String> cooMap = new HashMap<>();

        Map<String, String> cookieMap = parseSessionCookie2Map(cookies);

        for (String f : cookieFlag) {
            String value = cookieMap.get(f);
            if (!StringUtils.isEmpty(value)) {
                cooMap.put(f, value);
            }
        }

        return cooMap;
    }

    public static Map<String, String> getAllSessionsFromCookies(String cookies) {
        if (StringUtils.isEmpty(cookies)) return null;

        String[] cookieFlag = {"JSESSIONID", "JSESSIONIDMINI", "ComtopSessionSID", "DWRSESSIONID"};
        return getAllSessionsFromCookies(cookies, cookieFlag);
    }

    /**
     * user name
     *
     * @param request
     * @return
     */
    public static String getUserNameFromHttpRequest(HttpRequest request) {
        String[] usernamePattern = {"username", "user[login]"};

        if (request.getMethod().equals(HttpMethod.POST)) {

            HttpPostRequestDecoder decoder = new HttpPostRequestDecoder(new DefaultHttpDataFactory(false), request);
            try {
                List<InterfaceHttpData> postList = decoder.getBodyHttpDatas();
                // 读取从客户端传过来的参数
                for (InterfaceHttpData data : postList) {
                    String name = data.getName();
                    for (String u : usernamePattern) {
                        if (name.equals(u)) {
                            if (InterfaceHttpData.HttpDataType.Attribute == data.getHttpDataType()) {
                                MemoryAttribute attribute = (MemoryAttribute) data;
                                attribute.setCharset(CharsetUtil.UTF_8);
                                return attribute.getValue();
                            }
                        }
                    }

                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 有两种 1. form 2. json
     *
     * @param body
     * @return
     */
    public static String getUserNameFromBody(String body) {
        if (StringUtils.isEmpty(body)) return null;

        // 可能的存储用户名的key
        String[] usernamePattern = {"username", "user[login]"};

        Map<String, String> map = null;

        if (body.startsWith("{") && body.endsWith("}")) {
            // json
            map = JSON.parseObject(body, new TypeReference<Map<String, String>>() {
            });


        } else {
            // form 表单
            map = StringHelperUtils.parseStringForm(body);

        }

        if (map != null && map.size() > 0) {
            for (String s : usernamePattern) {
                if (!StringUtils.isEmpty(map.get(s))) {
                    try {
                        return URLDecoder.decode(map.get(s), "utf-8");
                    } catch (UnsupportedEncodingException e) {
                        LOGGER.error("can't decode string:{}", map.get(s));
                        return map.get(s);
                    }
                }
            }

        }

        return null;


    }
}
