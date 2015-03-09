package com.greencloud.website;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.greencloud.website.model.HtHotel;

public class SysConstant {

	public static final String SEPARATE_FLAG = ",";
	public static final String T = "T";
	public static final String F = "F";
	public static final int PAGESIZE = 20;
	public static final String HTOTEL_IMG_TYPE_MAP = "MAP";
	public static final String HTOTEL_IMG_TYPE_ROOM = "ROOM";
	public static final String HTOTEL_IMG_TYPE_HOTEL = "HOTEL";
	public static final String SYNC_DATE_FORMATE = "yyyy-MM-dd HH:mm:ss";
	public static final String SYNC_TYPE_SAVE = "SAVE";
	public static final String SYNC_TYPE_DELETE = "DELETE";
	public static final String CHECK_DATE = "yyyy-MM-dd";
	public static final String OPEN_CITY_CODE = "open_city_code";
	public static final String SERVICE_PARENTCODE = "PARENT_CODE";
	public static final String MENU_PARENTCODE = "PARENT_CODE";
	
	public static final String HOTEL_PRODUCT_CODE = "001";
	public static final String OTHER_PRODUCT_CODE = "002";
	
	//刮刮乐
	public static final String LOCK = "LOCK";
	public static final String SUBMMIT_LOTTERY = "T";
	
	public static Map<String,String> priceMap = new TreeMap<String,String>();
	public static Map<String,String> pictureCodeMap = new TreeMap<String, String>();
	public static Map<String,String> categoryMap = new HashMap<String, String>();
	
	/***
	 * 普通内容文件所存放的大文件夹
	 */
	public static final String CONNECT_MANAGE_PATH = "/CONNECT_IMAGE/";
	
	/***
	 * 照片存放文件夹分类
	 */
	public static Map<String, String> CaretogryMap = new HashMap<String, String>();
	
	/***
	 * 预加载静态常量
	 */
	static{
		CaretogryMap.put("HOTEL_IMAGE","酒店图片目录");
		CaretogryMap.put("ROOM_IMAGE", "房型图片目录");
		CaretogryMap.put("EXCHANGE_IMAGE", "礼品图片目录");
		//微信营销图片目录名称
		CaretogryMap.put("WEIXIN_MARKET", "微信营销图片目录");
		
		priceMap.put("1", "5000以下");
		priceMap.put("2", "5000-20000");
		priceMap.put("3", "20000以上");
		pictureCodeMap.put("INDEXIMG", "首页轮播大图");
		categoryMap.put("001", "酒店产品");
		categoryMap.put("002", "其它产品");
		CaretogryMap.put("MAGAZINE_LOGO", "杂志LOGO目录");
		CaretogryMap.put("MAGAZINE_PDF", "杂志PDF目录");
	}
	
	/***
	 * 酒店列表
	 */
	public static Map<Long,HtHotel>  hotelMap= new TreeMap<Long,HtHotel>();
	
	/***
	 * 岷山客礼品酒店列表
	 */
	public static Map<Long,HtHotel> hotelPresentMap = new TreeMap<Long,HtHotel>();
}
