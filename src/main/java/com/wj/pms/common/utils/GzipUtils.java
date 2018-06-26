package com.wj.pms.common.utils;

import org.apache.http.client.entity.GzipDecompressingEntity;
import org.apache.http.entity.BufferedHttpEntity;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class GzipUtils {

    public static String uncompress(byte[] bytes) throws IOException {
        return uncompress(bytes,"utf-8");
    }

    public static String uncompress(byte[] bytes,String charSet) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        GZIPInputStream gunzip = new GZIPInputStream(in);
        byte[] buffer = new byte[256];
        int n;
        while ((n = gunzip.read(buffer)) >= 0) {
            out.write(buffer, 0, n);
        }
        return out.toString(charSet);
    }
}
