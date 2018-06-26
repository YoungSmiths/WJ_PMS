package com.wj.pms.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.net.*;
import java.util.HashMap;
import java.util.Map;

public class URIHelperUtils {
    private static Logger LOGGER = LoggerFactory.getLogger(URIHelperUtils.class);

    public static Map<String, String> parseUrlQueryParam(String url) {
        Map<String, String> map = new HashMap<>();

        if (StringUtils.isEmpty(url)) {
            return map;
        }

        URL uRL = null;
        String query = null;
        try {
            uRL = new URL(url);
                query = uRL.getQuery();

        } catch (MalformedURLException e) {
            LOGGER.warn("{} , url:{} can't parse to class of URL ", e.getMessage(), url);
            query = getQueryFromUrl(url);
        }

        query = uRIDecoder(query);
        if (!StringUtils.isEmpty(query)) {
            String[] sq = query.split("&");
            for (String s : sq) {
                String[] kv = s.split("=");
                String k = uRIDecoder(kv[0]);
                if (kv.length == 2) map.put(k, uRIDecoder(kv[1]));
                else map.put(k, "");
            }
        }


        return map;
    }

    public static String getQueryFromUrl(String url) {
        if (StringUtils.isEmpty(url) || !url.contains("?")) return null;
        String[] ss = url.split("\\?");
        if (ss.length == 1) {
            return "";
        } else if (ss.length == 2) {
            return ss[1];
        } else if (ss.length > 2) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < ss.length; i++) {
                sb.append(ss[i] + "?");
            }
            return sb.deleteCharAt(sb.length() - 1).toString();
        }
        return null;
    }

    public static String getUrlWithOutQuery(String url) {
        if (StringUtils.isEmpty(url)) return null;
        String[] ss = url.split("\\?");
        return ss[0];
    }

    public static String getPathFromUrl(String fullUrl) {
        String url = getUrlWithOutQuery(fullUrl);
        return url;
    }


    public static String uRIDecoder(String s) {
        if (StringUtils.isEmpty(s)) return s;
        try {
            s = s.replaceAll("%(?![0-9a-fA-F]{2})", "%25");
            s = s.replaceAll("\\+", "%2B");

            return URLDecoder.decode(s, "utf-8");
        } catch (Exception e) {
            LOGGER.warn("the string({}) can't decoder ", s, e);
            return s;
        }

    }
}