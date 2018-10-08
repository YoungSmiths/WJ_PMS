package com.wj.pms.common.util;

import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.*;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HttpContext;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.*;
import java.util.Map.Entry;

/**
 * @describe HttpClient 请求工具类
 * @author YoungSmith
 * @date 2018年6月25日 下午2:54:09
 */
public class HttpClientUtil<T> {

	private static final Logger LOG = LogManager
			.getLogger(HttpClientUtil.class);

	private static final int CONNECT_TIMEOUT = 5000;// 设置超时毫秒数

	private static final int SOCKET_TIMEOUT = 10000;// 设置传输毫秒数

	private static final int REQUESTCONNECT_TIMEOUT = 3000;// 获取请求超时毫秒数

	private static final int CONNECT_TOTAL = 200;// 最大连接数

	private static final int CONNECT_ROUTE = 20;// 设置每个路由的基础连接数

	private static final int VALIDATE_TIME = 30000;// 设置重用连接时间

	private static final String RESPONSE_CONTENT = "Request Fail";// 通信失败

	private static PoolingHttpClientConnectionManager manager = null;

	private static CloseableHttpClient client = null;

	static {
		SSLContext sslContext;
		try {
			sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
				@Override
				public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
					return true;
				}
			}).build();
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext);
		
		ConnectionSocketFactory csf = PlainConnectionSocketFactory
				.getSocketFactory();
		// LayeredConnectionSocketFactory lsf = createSSLConnSocketFactory();
		Registry<ConnectionSocketFactory> registry = RegistryBuilder
				.<ConnectionSocketFactory> create().register("http", csf)
				 .register("https", sslsf)
				.build();
		manager = new PoolingHttpClientConnectionManager(registry);
		manager.setMaxTotal(CONNECT_TOTAL);
		manager.setDefaultMaxPerRoute(CONNECT_ROUTE);
		manager.setValidateAfterInactivity(VALIDATE_TIME);
		SocketConfig config = SocketConfig.custom()
				.setSoTimeout(SOCKET_TIMEOUT).build();
		manager.setDefaultSocketConfig(config);
		RequestConfig requestConf = RequestConfig.custom()
				.setConnectTimeout(CONNECT_TIMEOUT)
				.setConnectionRequestTimeout(REQUESTCONNECT_TIMEOUT)
				.setSocketTimeout(SOCKET_TIMEOUT).build();
		client = HttpClients.custom().setConnectionManager(manager)
				.setDefaultRequestConfig(requestConf)
				.setRetryHandler(new HttpRequestRetryHandler() {
					@Override
					public boolean retryRequest(IOException exception,
							int executionCount, HttpContext context) {
						if (executionCount >= 3)
							return false;
						if (exception instanceof NoHttpResponseException)// 如果服务器断掉了连接那么重试
							return true;
						if (exception instanceof SSLHandshakeException)// 不重试握手异常
							return false;
						if (exception instanceof InterruptedIOException)// IO传输中断重试
							return true;
						if (exception instanceof UnknownHostException)// 未知服务器
							return false;
						if (exception instanceof ConnectTimeoutException)// 超时就重试
							return true;
						if (exception instanceof SSLException)
							return false;
						HttpClientContext cliContext = HttpClientContext
								.adapt(context);
						HttpRequest request = cliContext.getRequest();
						if (!(request instanceof HttpEntityEnclosingRequest))
							return true;
						return false;
					}
				}).build();
		
		} catch (KeyManagementException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (KeyStoreException e) {
			e.printStackTrace();
		}
		if (manager != null && manager.getTotalStats() != null)
			LOG.info("客户池状态：" + manager.getTotalStats().toString());
	}

//	private static SSLConnectionSocketFactory createSSLConnSocketFactory() {
//		SSLConnectionSocketFactory sslsf = null;
//		SSLContext context;
//		try {
//			context = SSLContext.getInstance(SSLConnectionSocketFactory.TLS);
//			sslsf = new SSLConnectionSocketFactory(context,
//					NoopHostnameVerifier.INSTANCE);
//		} catch (NoSuchAlgorithmException e) {
//			LOG.error("SSL上下文创建失败，由于" + e.getLocalizedMessage());
//			e.printStackTrace();
//		}
//		return sslsf;
//	}

	private T res(HttpRequestBase method, Hander<T> hander) {
		HttpClientContext context = HttpClientContext.create();
		CloseableHttpResponse response = null;
		try {
			response = client.execute(method, context);// 执行GET/POST请求
			return hander.hander(response);
		} catch (ConnectTimeoutException cte) {
			LOG.error("请求连接超时，由于 " + cte.getLocalizedMessage());
			cte.printStackTrace();
		} catch (SocketTimeoutException ste) {
			LOG.error("请求通信超时，由于 " + ste.getLocalizedMessage());
			ste.printStackTrace();
		} catch (ClientProtocolException cpe) {
			LOG.error("协议错误（比如构造HttpGet对象时传入协议不对(将'http'写成'htp')or响应内容不符合），由于 "
					+ cpe.getLocalizedMessage());
			cpe.printStackTrace();
		} catch (IOException ie) {
			LOG.error("实体转换异常或者网络异常， 由于 " + ie.getLocalizedMessage());
			ie.printStackTrace();
		} catch (Exception ie) {
			LOG.error("实体转换异常或者网络异常， 由于 " + ie.getLocalizedMessage());
			ie.printStackTrace();
		} finally {
			try {
				if (response != null) {
					response.close();
				}
			} catch (IOException e) {
				LOG.error("响应关闭异常， 由于 " + e.getLocalizedMessage());
			}
			if (method != null) {
				method.releaseConnection();
			}
		}
		return null;
	}

	public static Hander<String> response2StrHander = new Hander<String>() {

		@Override
		public String hander(CloseableHttpResponse response) throws IOException {
			String content = RESPONSE_CONTENT;
			HttpEntity entity = response.getEntity();// 获取响应实体
			if (entity != null) {
				Charset charset = ContentType.getOrDefault(entity).getCharset();
				content = EntityUtils.toString(entity, charset);
				EntityUtils.consume(entity);
			}
			return content;
		}
	};

	public static Hander<byte[]> response2ByteArrayHander = new Hander<byte[]>() {

		@Override
		public byte[] hander(CloseableHttpResponse response) throws IOException {
			byte[] content = RESPONSE_CONTENT.getBytes();
			HttpEntity entity = response.getEntity();// 获取响应实体
			if (entity != null) {
				content = EntityUtils.toByteArray(entity);
				EntityUtils.consume(entity);
			}
			return content;
		}
	};

	interface Hander<T> {
		T hander(CloseableHttpResponse response) throws Exception;
	}
	
	public T get(String url, String cookie, Map<String, String> headers, Hander<T> hander) {
		HttpGet get = new HttpGet(url);
		if (headers != null){
			for (Entry<String, String> entry : headers.entrySet()) {
				get.addHeader(entry.getKey(), entry.getValue());
			}
		}
		if (!StringUtils.isEmpty(cookie))
			get.addHeader("cookie", cookie);
		return res(get, hander);
	}
	
	public static String get2Str(String url, String cookie, Map<String, String> headers) {
		return new HttpClientUtil<String>().get(url, cookie, headers, response2StrHander);
	}
	
	public static String get2Str(String url, String cookie) {
		return get2Str(url, cookie, null);
	}
	
	public static String get2Str(String url, Map<String, String> headers) {
		return get2Str(url, null, headers);
	}
	
	public static String get2Str(String url) {
		return get2Str(url, null, null);
	}
	
	public static byte[] get2byteArray(String url, String cookie, Map<String, String> headers) {
		return new HttpClientUtil<byte[]>().get(url, cookie, headers, response2ByteArrayHander);
	}
	
	public static byte[] get2byteArray(String url, String cookie) {
		return get2byteArray(url, cookie, null);
	}
	
	public static byte[] get2byteArray(String url, Map<String, String> headers) {
		return get2byteArray(url, null, headers);
	}
	
	public static byte[] get2byteArray(String url) {
		return get2byteArray(url, null, null);
	}
	
	public static Map<String, String> getWithRealHeader(String url) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("Accept",
				"text/html,application/xhtml+xml,application/xml;");
		map.put("Accept-Language", "zh-cn");
		map.put(
				"User-Agent",
				"Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.0.3) Gecko/2008092417 Firefox/3.0.3");
		map.put("Keep-Alive", "300");
		map.put("Connection", "Keep-Alive");
		map.put("Cache-Control", "no-cache");
		return map;
	}
	
	public T postJson(HttpPost post, String requestBody, String cookie,
			Map<String, String> headers, Hander<T> hander) {
		if (headers != null){
			for (Entry<String, String> entry : headers.entrySet()) {
				post.addHeader(entry.getKey(), entry.getValue());
			}
		}
		if(!StringUtils.isEmpty(requestBody)){
			post.addHeader("Content-Type", "application/json");
			post.setEntity(new StringEntity(requestBody, ContentType.create(
					"application/json", Consts.UTF_8)));
		}
		if (!StringUtils.isEmpty(cookie))
			post.addHeader("cookie", cookie);
		return res(post, hander);
	}
	
	public T postForm(HttpPost post, Map<String, String> forms, String cookie,
			Map<String, String> headers, Hander<T> hander) {
		if (headers != null){
			for (Entry<String, String> entry : headers.entrySet()) {
				post.addHeader(entry.getKey(), entry.getValue());
			}
		}
		 if (forms != null && !forms.isEmpty()) {  
             List<NameValuePair> formParams = new ArrayList<org.apache.http.NameValuePair>();  
             Set<Entry<String, String>> entrySet = forms.entrySet();  
             for (Entry<String, String> entry : entrySet) {  
                 formParams.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));  
             }  
             UrlEncodedFormEntity entity = new UrlEncodedFormEntity(formParams, Consts.UTF_8);  
             post.setEntity(entity);  
         }
		if (!StringUtils.isEmpty(cookie))
			post.addHeader("cookie", cookie);
		return res(post, hander);
	}

	public static String postJson(String url, String requestBody, String cookie,
			Map<String, String> headers) {
		HttpPost post = new HttpPost(url);
		return new HttpClientUtil<String>().postJson(post, requestBody, cookie, headers, response2StrHander);
	}
	
	public static String postJson(String url, String requestBody, String cookie) {
		return postJson(url, requestBody, cookie, null);
	}
	
	public static String postJson(String url, String requestBody, Map<String, String> headers) {
		return postJson(url, requestBody, null, headers);
	}
	
	public static String postJson(String url, String requestBody) {
		return postJson(url, requestBody, null, null);
	}
	
	public static String postForm(String url,  Map<String, String> forms, String cookie,
			Map<String, String> headers) {
		HttpPost post = new HttpPost(url);
		return new HttpClientUtil<String>().postForm(post, forms, cookie, headers, response2StrHander);
	}
	
	public static String postForm(String url,  Map<String, String> forms, String cookie) {
		return postForm(url, forms, cookie, null);
	}
	
	public static String postForm(String url,  Map<String, String> forms, Map<String, String> headers) {
		return postForm(url, forms, null, headers);
	}
	
	public static String postForm(String url,  Map<String, String> forms) {
		return postForm(url, forms, null, null);
	}

	public T delete(String url, String cookie,
					  Map<String, String> headers, Hander<T> hander) {
		HttpDelete delete = new HttpDelete(url);
		if (headers != null){
			for (Entry<String, String> entry : headers.entrySet()) {
				delete.addHeader(entry.getKey(), entry.getValue());
			}
		}
		if (!StringUtils.isEmpty(cookie))
			delete.addHeader("cookie", cookie);
		return res(delete, hander);
	}

	public static String delete2Str(String url, String cookie,
						Map<String, String> headers){
		return new HttpClientUtil<String>().delete(url, cookie, headers, response2StrHander);
	}

	public static String delete2Str(String url){
		return delete2Str(url, null, null);
	}
}
