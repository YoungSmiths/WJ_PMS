package com.wj.pms.common.utils;


import io.netty.handler.codec.http.HttpRequest;

/**
 * Created by YoungSmith on 2018/7/15.
 */
public class IPUtils {


    /**
     * 获取请求IP todo un implement
     *
     * @param request
     * @return
     */
//    public static String getIpAddress(HttpRequest request) {
//        return null;
////        HttpRequest
//////        String ip = request.getFirstHeader("x-forwarded-for").getValue();
//////        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//////            ip = request.getHeader("Proxy-Client-IP");
//////        }
//////        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//////            ip = request.getHeader("WL-Proxy-Client-IP");
//////        }
//////        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//////            ip = request.getHeader("HTTP_CLIENT_IP");
//////        }
//////        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//////            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
//////        }
//////        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//////            ip = request.getRemoteAddr();
//////        }
//////        return ip;
//    }

    /**
     * todo : 无端口
     *
     * @param request
     * @return
     */
    public static String getIpAddress(HttpRequest request) {
        String ip = request.headers().get("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.headers().get("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.headers().get("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.headers().get("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.headers().get("HTTP_X_FORWARDED_FOR");
        }
//        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
//            ip = request.get
//        }
        return ip;
    }
}
