package com.wj.pms.common.model;

import com.alibaba.fastjson.JSON;
import com.wj.pms.common.utils.*;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

/**
 * Created by YoungSmith on 2018/7/17.
 */
@Entity
@Table(indexes = {@Index(name = "user_access_record_normal_fk_module_id", columnList = "fkModuleId", unique = false)})
public class UserAccessRecord extends BaseEntity<UserAccessRecord> {
    private String userAddress; // 用户IP和端口
    private String userSessionId; // 用户session id；
    private String userName; // 用户名
    private String requestMethod;// 请求方式
    @Column(length = 16 * 1024 * 1024)
    private String requestUrl;

    @Column(length = 16 * 1024 * 1024)
    private String requestReferer; //
    private String requestRefererModuleId;
    private String requestRefererModuleName;

    private Date requestTime;

    private String responseCode;
    private Date responseTime;

    private Long timeDiff; // 时间差

    private Long fkModuleId;
    private String fkModuleName;


    @Column(length = 16 * 1024 * 1024)
    private String requestHeaders;
    @Column(length = 16 * 1024 * 1024)
    private String responseHeaders;

    @Column(length = 16 * 1024 * 1024)
    private String requestQuery;
////////////////////////

    @Column(length = 16 * 1024 * 1024)
    private String requestBody; //存储request body, todo drop column

    @Column(length = 16 * 1024 * 1024)
    private transient String cookieSessions; //  todo drop column
    @Column(length = 16 * 1024 * 1024)
    private transient String setCookieSessions; // todo drop column
    private transient String responseBody; //
    private transient String requestPath; //
    private transient String host;
    private transient FullHttpRequest request;
    private transient FullHttpResponse response;
    private transient String locationTicket; // 标识用户
    private transient String queryTicket; // 标识用户
    private String jsessionId; //{"JSESSIONID", "JSESSIONIDMINI", "ComtopSessionSID", "DWRSESSIONID"}
    private String jsessionIdMini; //{"jsessionId","jsessionIdMini","comtopSessionSid","dwrsessionId"}
    private String comtopSessionSid;
    private String dwrsessionId;

    private String setJsessionId; //{"JSESSIONID", "JSESSIONIDMINI", "ComtopSessionSID", "DWRSESSIONID"}
    private String setJsessionIdMini;
    private String setComtopSessionSid;
    private String setDwrsessionId;
    @Column(length = 16 * 1024 * 1024)
    private String responseLocation; // todo drop column

    public UserAccessRecord() {
    }

    public UserAccessRecord(FullHttpRequest request,
                            FullHttpResponse response,
                            Date requestTime,
                            Date responseTime) {

        String fullUrl = request.headers().get("Host") + request.getUri();
        if (!fullUrl.startsWith("http")) fullUrl = "http://" + fullUrl;
        this.responseTime = responseTime;
        this.requestTime = new Timestamp(requestTime.getTime());
        this.timeDiff = responseTime.getTime() - requestTime.getTime();
        if (this.timeDiff < 0) this.timeDiff = 0 - this.timeDiff;

        this.requestMethod = request.getMethod().name();
        this.requestUrl = uRIDecoder(request.getUri());
        this.responseCode = String.valueOf(response.getStatus().code());
        this.userAddress = IPUtils.getIpAddress(request);
        this.userSessionId = HandleUserInfoUtils.getSessionFromCookies(request.headers().get("Cookie"));

        this.requestHeaders = uRIDecoder(JSON.toJSONString(request.headers().entries()));
        this.responseHeaders = uRIDecoder(JSON.toJSONString(response.headers().entries()));
        //++++++++++++++  not db column
        this.request = request;
        this.response = response;
        this.requestBody = uRIDecoder(new String(Utils.readByteBuf(request.content())));
        this.responseBody = parseResponseBody(request, response);
        this.host = request.headers().get("Host");
        this.parseAllCookie(request, response);  // todo delete
        Map c = HandleUserInfoUtils.getAllSessionsFromCookies(request.headers().get("Cookie"));
        if (c != null && c.size() > 0) this.cookieSessions = JSON.toJSONString(c);
        c = HandleUserInfoUtils.getAllSessionsFromCookies(response.headers().getAll("Set-Cookie"));
        if (c != null && c.size() > 0) this.setCookieSessions = JSON.toJSONString(c);
//        this.setCookieSessionId = HandleUserInfoUtils.getSessionFromSetCookie()


        String location = response.headers().get("Location");
        this.responseLocation = URIHelperUtils.uRIDecoder(response.headers().get("Location"));
        if (response.getStatus().code() >= 300 && response.getStatus().code() < 400) {
            this.locationTicket = this.parseQueryTicket(location);
        }
        this.queryTicket = parseQueryTicket(fullUrl);

        //+++++++++
        this.userName = HandleUserInfoUtils.getUserNameFromBody(this.requestBody);
        this.requestMethod = request.getMethod().name();

        String uriString = fullUrl;
        try {
            URI uri = new URI(uriString);
            this.requestQuery = uRIDecoder(uri.getQuery());
            this.requestUrl = uRIDecoder(uri.getHost() + uri.getPath());
            this.requestPath = uRIDecoder(uri.getPath());

        } catch (URISyntaxException e) {
            LOGGER.warn("{},parse url:({}) to uri error", e.getMessage(), uriString);
            this.requestUrl = uRIDecoder(URIHelperUtils.getUrlWithOutQuery(uriString));
            this.requestPath = uRIDecoder(request.getUri());
            this.requestQuery = uRIDecoder(URIHelperUtils.getQueryFromUrl(request.getUri()));
        }

        this.requestReferer = uRIDecoder(request.headers().get("Referer"));
        this.responseCode = String.valueOf(response.getStatus().code());
    }

    private String parseResponseBody(FullHttpRequest request, FullHttpResponse response) {
        String contentEncoding = response.headers().get("Content-Encoding");
        byte[] htmlbyte = Utils.readByteBuf(response.content());

        if (htmlbyte.length > 0 && !StringUtils.isEmpty(contentEncoding) && contentEncoding.contains("gzip")) {
            try {
                return GzipUtils.uncompress(htmlbyte, "gbk");
            } catch (IOException e) {
                LOGGER.warn("decode response body error: {} ,url: {} ,Content-Encoding: {},", e.getMessage(), request.getUri(), contentEncoding, e);
                return new String(htmlbyte);
            }
        } else {
            return new String(htmlbyte);
        }
    }

    private String parseQueryTicket(String url) {

        final String ticketKey = "ticket";
        Map<String, String> query = URIHelperUtils.parseUrlQueryParam(url);
        return query.get(ticketKey);
    }


    private void parseAllCookie(FullHttpRequest request, FullHttpResponse response) {  // todo anys
        final String[] ck = {"JSESSIONID", "JSESSIONIDMINI", "ComtopSessionSID", "DWRSESSIONID"};
        Map<String, String> cookies = HandleUserInfoUtils.getAllSessionsFromCookies(request.headers().get("Cookie"));
        if (cookies != null) {
            this.jsessionId = cookies.get(ck[0]);
            this.jsessionIdMini = cookies.get(ck[1]);
            this.comtopSessionSid = cookies.get(ck[2]);
            this.dwrsessionId = cookies.get(ck[3]);
        }


        Map<String, String> setCookies = HandleUserInfoUtils.getAllSessionsFromCookies(response.headers().getAll("Set-Cookie"));
        if (setCookies != null) {
            this.setJsessionId = setCookies.get(ck[0]);
            this.setJsessionIdMini = setCookies.get(ck[1]);
            this.setComtopSessionSid = setCookies.get(ck[2]);
            this.setDwrsessionId = setCookies.get(ck[3]);
        }


    }

    private transient Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    private String uRIDecoder(String s) {
        return URIHelperUtils.uRIDecoder(s);
    }


    public String getUserAddress() {
        return userAddress;
    }

    public UserAccessRecord setUserAddress(String userAddress) {
        this.userAddress = userAddress;
        return this;
    }

    public String getUserSessionId() {
        return userSessionId;
    }

    public UserAccessRecord setUserSessionId(String userSessionId) {
        this.userSessionId = userSessionId;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public UserAccessRecord setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public FullHttpRequest getRequest() {
        return request;
    }

    public UserAccessRecord setRequest(FullHttpRequest request) {
        this.request = request;
        return this;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public UserAccessRecord setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
        return this;
    }

    public String getLocationTicket() {
        return locationTicket;
    }

    public String getQueryTicket() {
        return queryTicket;
    }

    public FullHttpResponse getResponse() {
        return response;
    }

    public UserAccessRecord setResponse(FullHttpResponse response) {
        this.response = response;
        return this;
    }

    public String getRequestHeaders() {
        return requestHeaders;
    }

    public UserAccessRecord setRequestHeaders(String requestHeaders) {
        this.requestHeaders = requestHeaders;
        return this;
    }

    public String getJsessionId() {
        return jsessionId;
    }

    public String getJsessionIdMini() {
        return jsessionIdMini;
    }

    public String getSetJsessionIdMini() {
        return setJsessionIdMini;
    }

    public String getResponseHeaders() {
        return responseHeaders;
    }

    public UserAccessRecord setResponseHeaders(String responseHeaders) {
        this.responseHeaders = responseHeaders;
        return this;
    }

    public String getSetComtopSessionSid() {
        return setComtopSessionSid;
    }

    public String getSetDwrsessionId() {
        return setDwrsessionId;
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public UserAccessRecord setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
        return this;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public UserAccessRecord setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
        return this;
    }

    public String getRequestReferer() {
        return requestReferer;
    }

    public UserAccessRecord setRequestReferer(String requestReferer) {
        this.requestReferer = requestReferer;
        return this;
    }

    public String getRequestRefererModuleId() {
        return requestRefererModuleId;
    }

    public UserAccessRecord setRequestRefererModuleId(String requestRefererModuleId) {
        this.requestRefererModuleId = requestRefererModuleId;
        return this;
    }

    public String getSetJsessionId() {
        return setJsessionId;
    }

    public String getRequestRefererModuleName() {
        return requestRefererModuleName;
    }

    public UserAccessRecord setRequestRefererModuleName(String requestRefererModuleName) {
        this.requestRefererModuleName = requestRefererModuleName;
        return this;
    }


    public String getResponseCode() {
        return responseCode;
    }

    public UserAccessRecord setResponseCode(String responseCode) {
        this.responseCode = responseCode;
        return this;
    }

    public Date getResponseTime() {
        return responseTime;
    }

    public UserAccessRecord setResponseTime(Date responseTime) {
        this.responseTime = responseTime;
        return this;
    }

    public Long getFkModuleId() {
        return fkModuleId;
    }

    public UserAccessRecord setFkModuleId(Long fkModuleId) {
        this.fkModuleId = fkModuleId;
        return this;
    }

    public String getFkModuleName() {
        return fkModuleName;
    }

    public UserAccessRecord setFkModuleName(String fkModuleName) {
        this.fkModuleName = fkModuleName;
        return this;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public UserAccessRecord setRequestBody(String requestBody) {
        this.requestBody = requestBody;
        return this;
    }

    public String getResponseBody() {
        return responseBody;
    }

    public UserAccessRecord setResponseBody(String responseBody) {
        this.responseBody = responseBody;
        return this;
    }

    public String getRequestPath() {
        return requestPath;
    }

    public UserAccessRecord setRequestPath(String requestPath) {
        this.requestPath = requestPath;
        return this;
    }

    public String getHost() {
        return host;
    }

    public UserAccessRecord setHost(String host) {
        this.host = host;
        return this;
    }

    class ParsedRequest {
        URI uri;
        String body;
        Map<String, String> headers;

        ParsedRequest(FullHttpRequest request) throws RuntimeException {
            try {

                this.uri = new URI(request.getUri());
            } catch (URISyntaxException e) {
                throw new RuntimeException(e.getMessage(), e);
            }
            body = uRIDecoder(new String(Utils.readByteBuf(request.content())));


        }
    }

    class ParsedResponse {
        int code;
        String body;
        Map<String, String> headers;

        ParsedResponse(FullHttpResponse response) {

        }
    }

    class MonitorHeader {

    }

}
