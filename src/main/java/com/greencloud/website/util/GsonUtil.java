package com.greencloud.website.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonUtil {
	
	//read only
	private static final Gson gson = new Gson();
	//read only
	private static final Gson gson2 = new GsonBuilder().setDateFormat(DateUtil.webFormat).create();
	
	/**
	 * 调用该方法new Gson对象，可以解决日期格式不统一问题
	 * 
	 * @param resultString
	 * @return
	 */
	public static Gson getGson(String resultString) {
		String regEx = "Jan|Feb|Mar|Apr|May|Jun|Jul|Aug|Sep|Oct|Nov|Dec"; // 表示a或f
		Pattern p = Pattern.compile(regEx);
		Matcher m = p.matcher(resultString);
		boolean result = m.find();
		if (result) {
			return gson;
		} else {
			return gson2;
		}
	}
	
	public static Gson getGson() {
		return gson;
	}
	
	public static Gson getGsonWithDateFormat() {
		return gson2;
	}
}
