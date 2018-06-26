package com.wj.pms.common.utils;

import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.multipart.DefaultHttpDataFactory;
import io.netty.handler.codec.http.multipart.HttpPostRequestDecoder;
import io.netty.handler.codec.http.multipart.InterfaceHttpData;
import io.netty.handler.codec.http.multipart.MemoryAttribute;
import io.netty.util.CharsetUtil;

import java.util.List;

/**
 * Created by YoungSmith on 2018/7/22.
 */
public class NettyUtils {


    /**
     * get value of request body
     *
     * @param request
     * @param key
     * @return
     */
    public static String getRequestBodyValue(HttpRequest request, String key) {
        if (request.getMethod().equals(HttpMethod.POST)) {

            HttpPostRequestDecoder decoder = new HttpPostRequestDecoder(new DefaultHttpDataFactory(false), request);
            try {
                List<InterfaceHttpData> postList = decoder.getBodyHttpDatas();
                // 读取从客户端传过来的参数
                for (InterfaceHttpData data : postList) {
                    String name = data.getName();
                    if (name.equals(key)) {
                        if (InterfaceHttpData.HttpDataType.Attribute == data.getHttpDataType()) {
                            MemoryAttribute attribute = (MemoryAttribute) data;
                            attribute.setCharset(CharsetUtil.UTF_8);
                            return attribute.getValue();
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
     *
     * @param response
     * @return
     */
    public static boolean requestSuccess(HttpResponse response){
        int statusCode = response.getStatus().code();
        if(statusCode >=200 && statusCode<400){
            return true;
        }else{
            return false;
        }
    }

}
