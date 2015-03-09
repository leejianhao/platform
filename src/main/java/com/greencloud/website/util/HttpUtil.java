package com.greencloud.website.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.CodingErrorAction;
import java.util.List;
import java.util.Map;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.entity.BufferedHttpEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.mortbay.log.Log;

/**
 * 
 * Utility Class Over HTTP 
 * @author leejianhao
 *
 */
public class HttpUtil {
	
	private static final PoolingHttpClientConnectionManager poolConnectionManager = 
			new PoolingHttpClientConnectionManager();
	
	//設置編碼
	private static final ConnectionConfig connectionConfig = ConnectionConfig.custom()
			.setMalformedInputAction(CodingErrorAction.IGNORE)
			.setUnmappableInputAction(CodingErrorAction.IGNORE)
			.setCharset(Consts.UTF_8).build();
	
	private int maxTotal = 50;
	/*单条链路的最多并发数*/
	private int maxPerRoute = 20;
	/*链接超时*/
	private int connectTimeout = 5000;
	/*请求sockget链接超时*/
	private int socketTimeout = 5000;
	private Map<String, String> constantParameterMap;
	private String host;
	private String method;
	
	private CloseableHttpClient httpclient;

	public int getMaxTotal() {
		return maxTotal;
	}

	public void setMaxTotal(int maxTotal) {
		this.maxTotal = maxTotal;
	}

	public int getMaxPerRoute() {
		return maxPerRoute;
	}

	public void setMaxPerRoute(int maxPerRoute) {
		this.maxPerRoute = maxPerRoute;
	}

	public int getConnectTimeout() {
		return connectTimeout;
	}

	public void setConnectTimeout(int connectTimeout) {
		this.connectTimeout = connectTimeout;
	}

	public int getSocketTimeout() {
		return socketTimeout;
	}

	public void setSocketTimeout(int socketTimeout) {
		this.socketTimeout = socketTimeout;
	}

	public Map<String, String> getConstantParameterMap() {
		return constantParameterMap;
	}

	public void setConstantParameterMap(Map<String, String> constantParameterMap) {
		this.constantParameterMap = constantParameterMap;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public HttpUtil() {
		poolConnectionManager.setDefaultMaxPerRoute(maxPerRoute);
		poolConnectionManager.setMaxTotal(maxTotal);
		
		poolConnectionManager.setDefaultConnectionConfig(connectionConfig);
		
		httpclient =  HttpClients.custom()
				.setConnectionManager(poolConnectionManager)
				.build();
	}
	
	public String post(List<NameValuePair> ps) throws ClientProtocolException, IOException {
		if (ps == null) {
			return ""; //set to "" ,not null
		}

		for (String key : constantParameterMap.keySet()) {
			ps.add(new BasicNameValuePair(key, constantParameterMap.get(key)));
		}

		if (this.getHost() != null && !this.getHost().endsWith("/")) {
			this.setHost(this.getHost() + "/");
		}
		
		StringBuffer sb = new StringBuffer();
		HttpPost post = new HttpPost(this.getHost() + this.getMethod());
		
		RequestConfig requestConfig = RequestConfig.custom()
				.setSocketTimeout(socketTimeout)
				.setConnectTimeout(connectTimeout)
				.build();
		post.setConfig(requestConfig);
		
		UrlEncodedFormEntity uf = new UrlEncodedFormEntity(ps, Consts.UTF_8);
		
		post.setEntity(uf);
		Log.debug(post.getRequestLine().getUri()+"?"+URLEncodedUtils.format(ps, Consts.UTF_8));
		try {
			CloseableHttpResponse response = httpclient.execute(post);
			try {
				HttpEntity entity = response.getEntity();
				
				if (entity != null) {
					//read into a in-memory buffer. 
					entity = new BufferedHttpEntity(entity);
					InputStreamReader isr = new InputStreamReader(entity.getContent(), Consts.UTF_8);
					BufferedReader br = new BufferedReader(isr);
					try {
						String line = null;
						while ((line = br.readLine()) != null) {
							sb.append(line);
						}
					}catch(IOException ex) {
						throw ex;
					}finally {
						br.close(); 
						isr.close();
					}
				}
				// do something useful with the response body
			    // and ensure it is fully consumed
				EntityUtils.consume(entity);
			} finally {
				response.close();
			}
			
		}finally {
			//When a request fails, only shutdown the connection manager if it's
			//single use. If the connection manager is reusable, it should be left
			//open so that it can be used by subsequent requests.
			//httpclient.close();
		}
		return sb.toString();
	}
	
}
