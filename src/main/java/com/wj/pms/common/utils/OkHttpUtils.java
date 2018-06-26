package com.wj.pms.common.utils;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class OkHttpUtils {

    private static OkHttpClient client = new OkHttpClient();

    public static int get(String url) throws Exception {

        Request request = new Request.Builder().url(url).build();
        Response response = client.newCall(request).execute();
        return response.code();
    }
}
