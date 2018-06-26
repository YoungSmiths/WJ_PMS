package com.wj.pms.common.utils;

import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.*;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpCoreContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.net.ssl.SSLContext;
import java.net.URI;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by YoungSmith on 2018/8/9.
 */
public class HttpClientUtils {
    private static final Logger logger = LoggerFactory.getLogger(HttpClientUtils.class);
    private static final String Charset = "utf-8";
    // 创建HttpClient上下文
    private static HttpClientContext context = HttpClientContext.create();
    // 创建cookie store的本地实例
    private static CookieStore cookieStore = new BasicCookieStore();

    public synchronized static CloseableHttpClient createSSLClientDefault(String scheme) {
        try {
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
                //信任所有
                public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                    return true;
                }
            }).build();
            SSLConnectionSocketFactory sslConnectionSocketFactory = new SSLConnectionSocketFactory(sslContext);
            // 全局请求设置
            RequestConfig globalConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).setRedirectsEnabled(true).setConnectTimeout(180 * 1000).
                    setSocketTimeout(180 * 1000).build();
            context.setCookieStore(cookieStore);
            HttpClientBuilder httpClientBuilder = HttpClients.custom()
                    .setDefaultRequestConfig(globalConfig)
                    .setRedirectStrategy(new LaxRedirectStrategy())
                    .setDefaultCookieStore(cookieStore);
            if (scheme.trim().startsWith("https")) {
                return httpClientBuilder.setSSLSocketFactory(sslConnectionSocketFactory)
                        .build();
            } else {
                return httpClientBuilder.build();
            }
        } catch (Exception e) {
            logger.error("Create the HttpClient has error : {}", e);
        }
        return HttpClients.createDefault();
    }

    public static Object post(String url, String body, ResponseHandler handler) throws Exception {
        return post(null, url, body, handler);
    }

    public static Object post(Map<String, String> headers, String url, String body, ResponseHandler handler) throws Exception {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(new StringEntity(body));
        if (headers != null && headers.size() > 0) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                httpPost.setHeader(entry.getKey(), entry.getValue());
            }
        }
        return execute(httpPost, handler);
    }

    public static Object postForm(Map<String, String> headers, String url, Map<String, String> formData, ResponseHandler handler) throws Exception {
        HttpPost httpPost = new HttpPost(url);
        List<NameValuePair> formParams = new ArrayList<>();
        if (formData != null && formData.size() > 0) {
            for (Map.Entry<String, String> entry : formData.entrySet()) {
                formParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }
        httpPost.setEntity(new UrlEncodedFormEntity(formParams, Charset));
        if (headers != null && headers.size() > 0) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                httpPost.setHeader(entry.getKey(), entry.getValue());
            }
        }
        return execute(httpPost, handler);
    }

    /**
     * @param url    必须是不带任何参数的url
     * @param params
     * @return
     */
    public static Object get(String url, Map<String, String> params, ResponseHandler handler) throws Exception {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            sb.append(entry.getKey() + "=" + entry.getValue() + "&");
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
            url += "?" + sb.toString();
        }
        return get(url, handler);
    }

    public static Object get(String url, ResponseHandler handler) throws Exception {
        return get(null, url, handler);
    }

    public static Object get(Map<String, String> headers, String url, ResponseHandler handler) throws Exception {
        HttpGet httpGet = new HttpGet(url);
        if (headers != null && headers.size() > 0) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                httpGet.setHeader(entry.getKey(), entry.getValue());
            }
        }
        return execute(httpGet, handler);
    }


    public static Object execute(HttpRequestBase requestBase, ResponseHandler handler) throws Exception {
        CloseableHttpClient client = createSSLClientDefault(requestBase.getURI().getScheme());
        logger.info("-----------------------------------------------------------------");
        logger.info("request url {}", requestBase.getURI().toURL());
        CloseableHttpResponse response = client.execute(requestBase, context);
        Object result = null;
        if (handler != null) {
            result = handler.handler(context, response);
        }
        response.close();
        return result;
    }

    public interface ResponseHandler<T> {
        /**
         * handler the response and the context after request, then close response auto.
         *
         * @param context
         * @param response
         */
        T handler(HttpClientContext context, HttpResponse response);
    }

    public static void defaultHandler(HttpClientContext context, HttpResponse response) {
        logger.info("handler log <<<<<<<<<<<<<<<<<<<<<<<<");
        List<URI> redirectLocations = context.getRedirectLocations();
        if (redirectLocations != null) {
            logger.info(redirectLocations.size() + "");
            logger.info("the redirect Location is: \n");
            for (URI uri : redirectLocations) {
                logger.info("\t" + uri.toASCIIString());
            }
        }
        HttpHost host = (HttpHost) context.getAttribute(HttpCoreContext.HTTP_TARGET_HOST);
        logger.info("the last reponse host is {}", "schemaName" + host.getSchemeName() + ",hostName:" + host.getHostName() + ",port:" + host.getPort());
        HttpRequest httpRequest = (HttpRequest) context.getAttribute(HttpCoreContext.HTTP_REQUEST);
        logger.info("the last request info is {}", "uri:" + httpRequest.getRequestLine().getUri() + ",method:" + httpRequest.getRequestLine().getMethod() + ",version:" + httpRequest.getRequestLine().getProtocolVersion());
        logger.info("resultCode:" + response.getStatusLine().getStatusCode());
        logger.info("the last whole request url is {}", host.getSchemeName() + "://" + host.getHostName() + httpRequest.getRequestLine().getUri() + "  ,and the method is " + httpRequest.getRequestLine().getMethod());
        logger.info(">>>>>>>>>>>>>>>>>>>>>>>>");
    }
}
