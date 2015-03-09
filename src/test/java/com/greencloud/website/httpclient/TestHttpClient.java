package com.greencloud.website.httpclient;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.message.BasicNameValuePair;
import org.junit.Before;
import org.junit.Test;

import com.greencloud.website.util.HttpUtil;

public class TestHttpClient {
	HttpUtil httpUtil;
	
	@Before
	public void setUp() {
		httpUtil = new HttpUtil();
	}
	
	@Test
	public void test01() throws ClientProtocolException, IOException {
		List<NameValuePair> ps = post();
		String result = httpUtil.post(ps);
		System.out.println(result);
	}
	
	private List<NameValuePair> post2() {
		httpUtil.setHost("http://122.224.65.101:48090/ipms");
		httpUtil.setMethod("CRS/queryHotelList");
		List<NameValuePair> ps = new ArrayList<NameValuePair>();
		ps.add(new BasicNameValuePair("salesChannel","WEB"));
		ps.add(new BasicNameValuePair("date","2015-03-07"));
		ps.add(new BasicNameValuePair("dayCount","1"));
		ps.add(new BasicNameValuePair("cityCode",""));
		ps.add(new BasicNameValuePair("hotelIds","9"));
		
		Map constantParameterMap = new HashMap();
		constantParameterMap.put("hotelGroupId", "2");
		httpUtil.setConstantParameterMap(constantParameterMap);
		return ps;
	}
	
	private List<NameValuePair> post() {
		httpUtil.setHost("http://183.129.215.114:8090/ipms");
		httpUtil.setMethod("rsvn_man/check_login");
		List<NameValuePair> ps = new ArrayList<NameValuePair>();
		ps.add(new BasicNameValuePair("companyId","11090"));
		ps.add(new BasicNameValuePair("rsvnManMobile","15068526599"));
		ps.add(new BasicNameValuePair("rsvnManPassword","e10adc3949ba59abbe56e057f20f883e"));
		Map constantParameterMap = new HashMap();
		constantParameterMap.put("hotelGroupId", "1");
		httpUtil.setConstantParameterMap(constantParameterMap);
		return ps;
	}
	
	/**
	 * 该处存在多线程并发问题。
	 */
	public void testMultiThread() {
		setUp();
		for(int i=0,size=10;i<size;i++) {
			 new Thread() {
				 	@Override
					public void run() {
				 		try {
							List<NameValuePair> ps = post();
							String result = httpUtil.post(ps);
							System.out.println(result);
					 		}catch(Exception e) {
					 			e.printStackTrace();
					 		}
					}
			}.start();
		}
	}
	public static void main(String[] args) {
		new TestHttpClient().testMultiThread();
	}
}
