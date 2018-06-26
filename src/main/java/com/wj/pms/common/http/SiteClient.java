package com.wj.pms.common.http;

import com.wj.pms.common.utils.Utils;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.config.SocketConfig;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class SiteClient {
    protected static final Logger LOGGER = LoggerFactory.getLogger(SiteClient.class);
    private CloseableHttpClient httpClient;

    private ObjectMapper objectMapper = new ObjectMapper();

    public SiteClient() {
        RequestConfig.Builder requestConfigBuilder = RequestConfig.custom()
                .setConnectionRequestTimeout(30000)
                .setConnectTimeout(30000)
                .setSocketTimeout(30000);

        // Connection control.
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setDefaultMaxPerRoute(300);
        cm.setMaxTotal(500);
        // Set soTimeout here to affect socketRead in the phase of ssl handshake. Note that
        // the RequestConfig.setSocketTimeout will take effect only after the ssl handshake completed.
        cm.setDefaultSocketConfig(SocketConfig.custom().setSoTimeout(30000).build());

        HttpClientBuilder httpClientBuilder = HttpClients.custom()
                .setDefaultRequestConfig(requestConfigBuilder.build())
                .setConnectionManager(cm);
        this.httpClient = httpClientBuilder.build();
    }

    public <T> T makeJsonRpc(String url, Object reqeust, Class<T> responseClass) throws IOException {
        JsonNode node = makeRequest(url, reqeust);
        T response = objectMapper.readValue(objectMapper.writeValueAsString(node), responseClass);
        LOGGER.info("Make json rpc, url={}, request={}, response={}", url,
                    Utils.formatObjectToJson(reqeust), Utils.formatObjectToJson(response));
        return response;
    }

    public JsonNode makeRequest(String url, Object postData) throws IOException {
        HttpUriRequest request;
        if (postData == null) {
            request = new HttpGet(url);
        } else {
            HttpPost post = new HttpPost(url);
            post.setEntity(new StringEntity(objectMapper.writeValueAsString(postData), ContentType.APPLICATION_JSON));
            request = post;
        }

        String body = httpClient.execute(request, new ResponseHandler<String>() {
            @Override
            public String handleResponse(HttpResponse response) throws IOException {
                int status = response.getStatusLine().getStatusCode();
                HttpEntity entity = response.getEntity();
                if (status == 200) {
                    return EntityUtils.toString(entity);
                } else {
                    LOGGER.error("Server response non ok status, url={}, status={}, response body: [{}]", url, status, EntityUtils.toString(entity));
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
            }
        });
        LOGGER.debug("Get response ok for url [{}], response is [[[\n{}\n]]]", url, body);

        JsonNode node = objectMapper.readTree(body);
        if (node.get("code").asInt() != 0) {
            String message = String.format("Remote response with non-zero code=%d, message=%s",
                    node.get("code").asInt(), node.get("message"));
            LOGGER.error("Request {} with error response: {}", url, message);
            throw new IOException(message);
        }
        return node.get("data");
    }
}

